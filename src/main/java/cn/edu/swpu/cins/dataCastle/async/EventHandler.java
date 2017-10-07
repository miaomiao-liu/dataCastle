package cn.edu.swpu.cins.dataCastle.async;

import java.util.List;

/**
 * Created by miaomiao on 17-9-25.
 */
public interface EventHandler {

    void doHandle(EventModel eventModel);

    List<EventType> getSupportEventTypes();
}
