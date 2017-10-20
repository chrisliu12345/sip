package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response100Event
        extends ProvisionResponseEvent {
    public Response100Event(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isResponse100() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response100Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */