package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response486Event
        extends AbstractEvent {
    public Response486Event(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }


    public boolean isResponse486() {
        return true;
    }

    public boolean isErrorResponse() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response486Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */