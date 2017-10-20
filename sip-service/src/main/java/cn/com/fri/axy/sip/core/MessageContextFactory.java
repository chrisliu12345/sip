package cn.com.fri.axy.sip.core;

import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;


public class MessageContextFactory {
    private static MessageContextFactory a;

    public static MessageContextFactory getInstance() {
        if (a == null) {
            a = new MessageContextFactory();
        }
        return a;
    }


    public MessageContext createMessageContext(SipServletRequest paramSipServletRequest) {
        return new RequestContext(paramSipServletRequest);
    }

    public MessageContext createMessageContext(SipServletResponse paramSipServletResponse) {
        return new ResponseContext(paramSipServletResponse);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/MessageContextFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */