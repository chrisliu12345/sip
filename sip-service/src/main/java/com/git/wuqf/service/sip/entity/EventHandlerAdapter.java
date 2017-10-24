package com.git.wuqf.service.sip.entity;

import com.git.wuqf.service.sip.event.Event;
import com.git.wuqf.service.sip.event.EventListener;
import com.git.wuqf.service.sip.event.EventListenerRegistry;


public class EventHandlerAdapter
        extends Handler {
    private EventListenerRegistry a = new EventListenerRegistry();

    protected boolean isSupportEvent() {
        return true;
    }


    public void postEvent(Event paramEvent) {
        if ((a.getAllEventListener()) != null) {
            int i = 0;
            for (int j = a.getAllEventListener().length; i < j; i++) {
//                EventDispatcher.fireEvent(paramEvent, a.getAllEventListener()。[i].getEventListener(),
//                        this[i].getEventFilter());
            }
        }
    }


    public synchronized void registerEventListener(EventListener paramEventListener) {
        this.a.addEventListener(paramEventListener);
    }

    public synchronized void removeEventListener(EventListener paramEventListener) {
        this.a.removeEventListener(paramEventListener);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/entity/EventHandlerAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */