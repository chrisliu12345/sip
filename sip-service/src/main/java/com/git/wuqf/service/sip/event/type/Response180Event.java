package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response180Event
        extends ProvisionResponseEvent {
    public Response180Event(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isResponse180() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response180Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */