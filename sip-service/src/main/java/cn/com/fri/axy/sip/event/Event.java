package cn.com.fri.axy.sip.event;

import javax.servlet.sip.SipApplicationSession;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import javax.servlet.sip.SipSession;

public abstract interface Event {
    public abstract SipSession getSession();

    public abstract SipApplicationSession getApplicationSession();

    public abstract SipServletRequest getSipServletRequest();

    public abstract SipServletResponse getSipServletResponse();

    public abstract void setAttribute(Object paramObject1, Object paramObject2);

    public abstract Object getAttribute(Object paramObject);

    public abstract Object removeAttribute(Object paramObject);

    public abstract boolean isRequest();

    public abstract boolean isResponse();

    public abstract boolean isInvite();

    public abstract boolean isReInvite();

    public abstract boolean isAck();

    public abstract boolean isPrack();

    public abstract boolean isBye();

    public abstract boolean isCancel();

    public abstract boolean isInfo();

    public abstract boolean isMessage();

    public abstract boolean isUpdate();

    public abstract boolean isRefer();

    public abstract boolean isResponse100();

    public abstract boolean isResponse180();

    public abstract boolean isResponse181();

    public abstract boolean isResponse183();

    public abstract boolean isResponse183100Rel();

    public abstract boolean isResponse486();

    public abstract boolean isResponse487();

    public abstract boolean isResponse408();

    public abstract boolean isResponse200();

    public abstract boolean isResponse202();

    public abstract boolean isProvisionResponse();

    public abstract boolean isSuccessResponse();

    public abstract boolean isErrorResponse();

    public abstract boolean isRedirectResponse();
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */