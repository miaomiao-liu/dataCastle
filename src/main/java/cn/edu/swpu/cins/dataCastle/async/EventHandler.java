package cn.edu.swpu.cins.dataCastle.async;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by miaomiao on 17-9-25.
 */
public interface EventHandler {

    void doHandle(EventModel eventModel) throws MessagingException;

    List<EventType> getSupportEventTypes();
}
