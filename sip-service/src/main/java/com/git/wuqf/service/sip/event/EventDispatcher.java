package com.git.wuqf.service.sip.event;

import com.git.wuqf.service.common.util.SysLogger;


public final class EventDispatcher {
    public static void fireEvent(Event paramEvent, EventListener paramEventListener) {
        fireEvent(paramEvent, paramEventListener, null);
    }


    public static void fireEvent(Event paramEvent, EventListener paramEventListener, EventFilter paramEventFilter) {
        if ((paramEventFilter != null) && (!paramEventFilter.isEventEnabled(paramEvent))) {
            SysLogger.info("event filter is false");
            return;
        }
        paramEventListener.handleEvent(paramEvent);
        return;

    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/EventDispatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */