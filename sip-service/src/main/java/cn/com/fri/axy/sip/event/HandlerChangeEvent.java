package cn.com.fri.axy.sip.event;

import cn.com.fri.axy.sip.entity.Handler;

public abstract interface HandlerChangeEvent
        extends Event {
    public abstract Handler getSourceHandler();

    public abstract String getTargetHandlerName();

    public abstract Handler getTargetHandler();
}
