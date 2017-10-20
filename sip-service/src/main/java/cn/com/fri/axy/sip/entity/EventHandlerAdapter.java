package cn.com.fri.axy.sip.entity;

import cn.com.fri.axy.sip.event.Event;
import cn.com.fri.axy.sip.event.EventDispatcher;
import cn.com.fri.axy.sip.event.EventListener;
import cn.com.fri.axy.sip.event.EventListenerRegistry;


public class EventHandlerAdapter
        extends Handler {
    private EventListenerRegistry a = new EventListenerRegistry();

    protected boolean isSupportEvent() {
        return true;
    }


    public void postEvent(Event paramEvent) {
        if ((this = this.a.getAllEventListener()) != null) {
            int i = 0;
            for (int j = this.length; i < j; i++) {
                EventDispatcher.fireEvent(paramEvent, this[i].getEventListener(),
                        this[i].getEventFilter());
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