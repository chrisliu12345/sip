package com.git.wuqf.service.sip.event.type;

import javax.servlet.sip.SipServletRequest;

public class InviteEvent extends AbstractEvent {
    public InviteEvent(SipServletRequest paramSipServletRequest) {
/*  9 */
        super(paramSipServletRequest);
    }

    public boolean isInvite() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/InviteEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */