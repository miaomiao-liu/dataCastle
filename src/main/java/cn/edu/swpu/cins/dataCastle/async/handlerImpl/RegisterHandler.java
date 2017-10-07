package cn.edu.swpu.cins.dataCastle.async.handlerImpl;

import cn.edu.swpu.cins.dataCastle.async.EventHandler;
import cn.edu.swpu.cins.dataCastle.async.EventModel;
import cn.edu.swpu.cins.dataCastle.async.EventType;
import cn.edu.swpu.cins.dataCastle.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by miaomiao on 17-10-6.
 */
@Component
public class RegisterHandler implements EventHandler{

    @Autowired
    MailService mailService;

    @Override
    public void doHandle(EventModel eventModel) {
        String username = eventModel.getActor();
        String email = eventModel.getAccept();
        mailService.registerMail(username,email);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.REGISTER);
    }
}
