package com.git.wuqf.service.sip.event;

import java.io.Serializable;

public abstract interface EventListener
        extends Serializable {
    public abstract void handleEvent(Event paramEvent);
}
