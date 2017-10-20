package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class InfoEvent
        extends AbstractEvent {
    public InfoEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isInfo() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/InfoEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */