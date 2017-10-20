package cn.com.fri.axy.sip.event.type;

import cn.com.fri.axy.sip.event.Event;

import javax.servlet.sip.SipApplicationSession;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import javax.servlet.sip.SipSession;
import java.util.Hashtable;


public abstract class AbstractEvent
        implements Event {
    protected SipServletRequest request;
    protected SipServletResponse response;
    private boolean a = true;

    private Hashtable b;

    private AbstractEvent() {
        this.b = new Hashtable();
    }

    public AbstractEvent(SipServletRequest paramSipServletRequest) {
        this();
        this.request = paramSipServletRequest;
    }

    public void setAttribute(Object paramObject1, Object paramObject2) {
        this.b.put(paramObject1, paramObject2);
    }

    public Object getAttribute(Object paramObject) {
        return this.b.get(paramObject);
    }

    public Object removeAttribute(Object paramObject) {
        return this.b.remove(paramObject);
    }

    public AbstractEvent(SipServletResponse paramSipServletResponse) {
        this();
        this.response = paramSipServletResponse;
    }


    public boolean isRequest() {
        return this.a;
    }

    public boolean isResponse() {
        return !this.a;
    }


    public SipApplicationSession getApplicationSession() {
        if ((this = getSession()) == null) return null;
        return getApplicationSession();
    }

    public String getId() {
        return null;
    }

    public SipSession getSession() {
        SipSession localSipSession = null;

        if (this.a) {
            if (this.request != null) {
                localSipSession = this.request.getSession();
            }
        } else if (this.response != null) {
            localSipSession = this.response.getSession();
        }

        return localSipSession;
    }

    public SipServletRequest getSipServletRequest() {
        return this.request;
    }

    public SipServletResponse getSipServletResponse() {
        return this.response;
    }

    public boolean isResponse100() {
        return false;
    }

    public boolean isResponse180() {
        return false;
    }

    public boolean isResponse181() {
        return false;
    }

    public boolean isResponse183() {
        return false;
    }

    public boolean isResponse200() {
        return false;
    }

    public boolean isResponse202() {
        return false;
    }

    public boolean isAck() {
        return false;
    }

    public boolean isBye() {
        return false;
    }

    public boolean isCancel() {
        return false;
    }

    public boolean isErrorResponse() {
        return false;
    }

    public boolean isInfo() {
        return false;
    }

    public boolean isInvite() {
        return false;
    }

    public boolean isMessage() {
        return false;
    }

    public boolean isPrack() {
        return false;
    }

    public boolean isProvisionResponse() {
        return false;
    }

    public boolean isSuccessResponse() {
        return false;
    }

    public boolean isRedirectResponse() {
        return false;
    }

    public boolean isRefer() {
        return false;
    }

    public boolean isReInvite() {
        return false;
    }

    public boolean isUpdate() {
        return false;
    }

    public boolean isResponse183100Rel() {
        return false;
    }

    public boolean isResponse486() {
        return false;
    }

    public boolean isResponse487() {
        return false;
    }

    public boolean isResponse408() {
        return false;
    }

    public boolean isB2BUAEstablishedSuccess() {
        return false;
    }

    public boolean isB2BUAEstablishedFailed() {
        return false;
    }

    public boolean isB2BUADisconnnectedSuccess() {
        return false;
    }

    public boolean isB2BUADisconnnectedFailed() {
        return false;
    }

    public boolean isB2BUABYE() {
        return false;
    }

    public String toString() {
        return "Event:[" + getClass().getName() + "]";
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/AbstractEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */