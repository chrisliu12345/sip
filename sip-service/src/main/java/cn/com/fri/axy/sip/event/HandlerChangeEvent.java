package cn.com.fri.axy.sip.event;

import cn.com.fri.axy.sip.entity.Handler;

public abstract interface HandlerChangeEvent
        extends Event {
    public abstract Handler getSourceHandler();

    public abstract String getTargetHandlerName();

    public abstract Handler getTargetHandler();
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/HandlerChangeEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */