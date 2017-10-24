package cn.com.fri.axy.sip.event;

import java.io.Serializable;

public abstract interface EventListener
        extends Serializable {
    public abstract void handleEvent(Event paramEvent);
}
