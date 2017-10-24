package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class CancelEvent
        extends AbstractEvent {
    public CancelEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isCancel() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/CancelEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */