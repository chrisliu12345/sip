package com.git.wuqf.service.sip.event;

import com.git.wuqf.service.sip.entity.Handler;

public abstract interface HandlerChangeEvent
        extends Event {
    public abstract Handler getSourceHandler();

    public abstract String getTargetHandlerName();

    public abstract Handler getTargetHandler();
}
