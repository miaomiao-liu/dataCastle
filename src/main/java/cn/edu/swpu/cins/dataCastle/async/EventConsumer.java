package cn.edu.swpu.cins.dataCastle.async;

import cn.edu.swpu.cins.dataCastle.util.JedisAdapter;
import cn.edu.swpu.cins.dataCastle.util.RedisKeyUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miaomiao on 17-10-6.
 */
@Service
public class EventConsumer implements InitializingBean,ApplicationContextAware{

    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    Map<EventType,List<EventHandler>> config = new HashMap<>();
    ApplicationContext applicationContext;

    @Autowired
    JedisAdapter jedisAdapter;

    @Override
    public void afterPropertiesSet() throws Exception {

        Map<String , EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
        if(beans != null){
            for(Map.Entry<String,EventHandler> entry : beans.entrySet()){
                List<EventType> eventTypes = entry.getValue().getSupportEventTypes();
                for (EventType type : eventTypes){
                    if(!config.containsKey(type)){
                        config.put(type,new ArrayList<>());
                    }
                    config.get(type).add(entry.getValue());
                }

            }
        }

        //一直取redis中的任务
        java.lang.Thread thread = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String key = RedisKeyUtil.getBizEventqueue();
                    List<String> events = jedisAdapter.brpop(0, key);
                    for (String message : events) {
                        if (message.equals(key)) {
                            continue;
                        }
                        EventModel model = JSON.parseObject(message, EventModel.class);
                        if (!config.containsKey(model.getEventType())) {
                            logger.error("不能识别的事件");
                            continue;
                        }
                        for (EventHandler handler : config.get(model.getEventType())) {
                            try {
                                handler.doHandle(model);
                            } catch (MessagingException e) {
                                logger.error(e.getMessage());
                            }
                        }
                    }
                }
            }
        });
        thread.start();


    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
