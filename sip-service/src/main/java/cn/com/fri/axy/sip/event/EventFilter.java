package cn.com.fri.axy.sip.event;

import java.io.Serializable;

public abstract interface EventFilter
        extends Serializable {
    public abstract boolean isEventEnabled(Event paramEvent);
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/EventFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */