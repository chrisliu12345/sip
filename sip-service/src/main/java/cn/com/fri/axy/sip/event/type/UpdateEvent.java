package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class UpdateEvent
        extends AbstractEvent {
    public UpdateEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isUpdate() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/UpdateEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */