package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class NotifyEvent
        extends AbstractEvent {
    public NotifyEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isNotify() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/NotifyEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */