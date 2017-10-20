package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response181Event
        extends ProvisionResponseEvent {
    public Response181Event(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isResponse181() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response181Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */