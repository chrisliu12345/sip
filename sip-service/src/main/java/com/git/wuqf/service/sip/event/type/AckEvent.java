package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class AckEvent
        extends AbstractEvent {
    public AckEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isAck() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/AckEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */