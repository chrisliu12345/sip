package cn.com.fri.axy.sip.event;

import java.io.Serializable;

public abstract interface EventListener
        extends Serializable {
    public abstract void handleEvent(Event paramEvent);
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/EventListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */