package cn.edu.swpu.cins.dataCastle.async;

import cn.edu.swpu.cins.dataCastle.util.JedisAdapter;
import cn.edu.swpu.cins.dataCastle.util.RedisKeyUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by miaomiao on 17-10-6.
 */
@Service
public class EventProducer {

    @Autowired
    JedisAdapter jedisAdapter;

    public boolean fireEvent(EventModel eventModel){
        try {
            String json = JSON.toJSONString(eventModel);
            String key = RedisKeyUtil.getBizEventqueue();
            jedisAdapter.lpush(key,json);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
