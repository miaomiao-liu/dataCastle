package cn.edu.swpu.cins.dataCastle.config.quartz;

import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by miaomiao on 17-8-5.
 */
@Component
public class MyJob implements Job,Serializable{

    private static final long serialVersionUID = 1L;
    private static final Logger logger= LoggerFactory.getLogger(MyJob.class);

    @Autowired
    UserDao userDao;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    try {
        userDao.updateFrequency();
    } catch (Exception e) {
        logger.error("更新失败！");
    }
}


}