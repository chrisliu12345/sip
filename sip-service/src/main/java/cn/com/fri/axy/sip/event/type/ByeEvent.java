package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class ByeEvent
        extends AbstractEvent {
    public ByeEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isBye() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/ByeEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */