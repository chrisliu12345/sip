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
        if (( (EventListenerProps) this.a.get(paramInt)) == null) return null;
        return getEventListener(paramInt);
    }


    public EventFilter getEventFilter(int paramInt) {
        if (( (EventListenerProps) this.a.get(paramInt)) == null) return null;
        return getEventFilter(paramInt);
    }

    public EventListenerProps[] getAllEventListener() {
        return
                (EventListenerProps[]) this.a.toArray(new EventListenerProps[0]);
    }
}
