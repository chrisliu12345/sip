package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response183100RelEvent
        extends ProvisionResponseEvent {
    public Response183100RelEvent(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isResponse183100Rel() {
        return true;
    }

    public boolean isResponse183() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response183100RelEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */