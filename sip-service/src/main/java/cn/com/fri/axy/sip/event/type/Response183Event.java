package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class Response183Event
        extends ProvisionResponseEvent {
    public Response183Event(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isResponse183() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/Response183Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */