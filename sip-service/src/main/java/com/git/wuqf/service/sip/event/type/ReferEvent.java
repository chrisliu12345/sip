package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class ReferEvent
        extends AbstractEvent {
    public ReferEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isRefer() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/ReferEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */