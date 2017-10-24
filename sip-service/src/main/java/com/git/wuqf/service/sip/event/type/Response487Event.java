package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response487Event
        extends AbstractEvent {
    public Response487Event(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isResponse487() {
        return true;
    }

    public boolean isErrorResponse() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response487Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */