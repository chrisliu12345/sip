package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class SuccessResponseEvent
        extends AbstractEvent {
    public SuccessResponseEvent(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isSuccessResponse() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/SuccessResponseEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */