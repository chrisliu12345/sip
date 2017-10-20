package cn.com.fri.axy.sip.event;

import cn.com.fri.axy.common.util.SysLogger;

import javax.servlet.ServletException;
import java.io.IOException;


public final class EventDispatcher {
    public static void fireEvent(Event paramEvent, EventListener paramEventListener) {
        fireEvent(paramEvent, paramEventListener, null);
    }


    public static void fireEvent(Event paramEvent, EventListener paramEventListener, EventFilter paramEventFilter) {
        if ((paramEventFilter != null) && (!paramEventFilter.isEventEnabled(paramEvent))) {
            SysLogger.info("event filter is false");
            return;
        }

        try {
            paramEventListener.handleEvent(paramEvent);
            return;
        } catch (ServletException paramEvent) {
            throw new EventException(paramEvent);
        } catch (IOException paramEvent) {
            throw new EventException(paramEvent);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/EventDispatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */