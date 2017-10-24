package com.git.wuqf.service.sip.event;

import java.io.Serializable;


public class EventListenerProps
        implements Serializable {
    private EventListener a;
    private EventFilter b;

    EventListenerProps(EventListener paramEventListener) {
        this.a = paramEventListener;
    }

    EventListenerProps(EventListener paramEventListener, EventFilter paramEventFilter) {
        this.a = paramEventListener;
        this.b = paramEventFilter;
    }

    public EventFilter getEventFilter() {
        return this.b;
    }

    public EventListener getEventListener() {
        return this.a;
    }


    public boolean equals(Object paramObject) {
        if (this== paramObject) {
            return true;
        }
        if (paramObject == null) {
            return false;
        }
        if (!(paramObject instanceof EventListenerProps)) {
            return false;
        }

        paramObject = (EventListenerProps) paramObject;

        return this.a == ((EventListenerProps) paramObject).getEventListener();
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/EventListenerProps.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */