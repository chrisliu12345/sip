package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response202Event
        extends SuccessResponseEvent {
    public Response202Event(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isResponse200() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response202Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */