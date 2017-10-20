package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletResponse;


public class RedirectResponseEvent
        extends AbstractEvent {
    public RedirectResponseEvent(SipServletResponse paramSipServletResponse) {
        super(paramSipServletResponse);
    }

    public boolean isRedirectResponse() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/RedirectResponseEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */