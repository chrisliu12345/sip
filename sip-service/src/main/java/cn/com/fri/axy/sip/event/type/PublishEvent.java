package cn.com.fri.axy.sip.event.type;

import javax.servlet.sip.SipServletRequest;


public class PublishEvent
        extends AbstractEvent {
    public PublishEvent(SipServletRequest paramSipServletRequest) {
        super(paramSipServletRequest);
    }

    public boolean isPublish() {
        return true;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/PublishEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */