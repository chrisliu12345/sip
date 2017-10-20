package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletRequest;

public class ReInviteEvent
        extends AbstractEvent {
    public ReInviteEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isReInvite() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/ReInviteEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */