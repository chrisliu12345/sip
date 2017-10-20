package cn.com.fri.axy.sip.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EventListenerRegistry
        implements Serializable {
    private List a;

    public EventListenerRegistry() {
        this.a = Collections.synchronizedList(new ArrayList());
    }


    public void addEventListener(EventListener paramEventListener) {
        this.a.add(0, new EventListenerProps(paramEventListener));
    }

    public void removeEventListener(EventListener paramEventListener) {
        this.a.remove(new EventListenerProps(paramEventListener));
    }

    public void addEventListener(EventListener paramEventListener, EventFilter paramEventFilter) {
        this.a.add(new EventListenerProps(paramEventListener, paramEventFilter));
    }


    public void removeEventListener(EventListener paramEventListener, EventFilter paramEventFilter) {
        this.a.remove(new EventListenerProps(paramEventListener, paramEventFilter));
    }

    public void removeAllEventListeners() {
        this.a.clear();
    }

    public EventListenerProps getEventListenerProps(int paramInt) {
        return (EventListenerProps) this.a.get(paramInt);
    }


    public EventListener getEventListener(int paramInt) {
        if ((this = (EventListenerProps) this.a.get(paramInt)) == null) return null;
        return getEventListener();
    }


    public EventFilter getEventFilter(int paramInt) {
        if ((this = (EventListenerProps) this.a.get(paramInt)) == null) return null;
        return getEventFilter();
    }

    public EventListenerProps[] getAllEventListener() {
        return
                (EventListenerProps[]) this.a.toArray(new EventListenerProps[0]);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/EventListenerRegistry.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */