package cn.com.fri.axy.sip.core;

import cn.com.fri.axy.sip.util.ServletContextHelper;

import javax.servlet.sip.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;


public abstract class SipMessageContext
        implements MessageContext, Serializable {
    protected static final String ATTR_FROM = "_attr.from";
    protected static final String ATTR_TO = "_attr.to";
    protected static final String ATTR_REQURI = "_attr.requri";
    protected transient SipServletMessage sipMessage;

    public SipSession getSession() {
        return this.sipMessage.getSession();
    }

    public String getSessionId() {
        return this.sipMessage.getSession().getId();
    }

    public SipApplicationSession getApplicationSession() {
        return this.sipMessage.getApplicationSession();
    }

    public String getApplicationSessionId() {
        return this.sipMessage.getApplicationSession().getId();
    }

    public String getMethod() {
        return this.sipMessage.getMethod();
    }


    public boolean isMethod(String paramString) {
        return paramString.equalsIgnoreCase(getMethod());
    }

    public Address getOrigFrom() {
        return this.sipMessage.getFrom();
    }

    public Address getOrigTo() {
        return this.sipMessage.getTo();
    }

    public Address getFrom() {
        String str;
        if ((str = (String) this.sipMessage.getAttribute("_attr.from")) == null) {
            return getOrigFrom();
        }
        try {
            return ServletContextHelper.getSipFactory().createAddress(str);
        } catch (ServletParseException localServletParseException) {
        }
        return null;
    }


    public Address getTo() {
        String str;
        if ((str = (String) this.sipMessage.getAttribute("_attr.to")) == null) {
            return getOrigTo();
        }
        try {
            return ServletContextHelper.getSipFactory().createAddress(str);
        } catch (ServletParseException localServletParseException) {
        }
        return null;
    }


    public void setFrom(String paramString) {
        this.sipMessage.setAttribute("_attr.from", paramString);
    }

    public void setTo(String paramString) {
        this.sipMessage.setAttribute("_attr.to", paramString);
    }

    public String getCallId() {
        return this.sipMessage.getCallId();
    }

    public void removeHeader(String paramString) {
        this.sipMessage.removeHeader(paramString);
    }

    public String getHeader(String paramString) {
        return this.sipMessage.getHeader(paramString);
    }

    public ListIterator getHeaders(String paramString) {
        return this.sipMessage.getHeaders(paramString);
    }

    public void addHeader(String paramString1, String paramString2) {
        this.sipMessage.addHeader(paramString1, paramString2);
    }

    public boolean isInvite() {
        return isMethod("INVITE");
    }

    public boolean isAck() {
        return isMethod("ACK");
    }

    public boolean isBye() {
        return isMethod("BYE");
    }

    public boolean isCancel() {
        return isMethod("CANCEL");
    }

    public boolean isOptions() {
        return isMethod("OPTIONS");
    }

    public boolean isRegister() {
        return isMethod("REGISTER");
    }

    public boolean isSubscribe() {
        return isMethod("SUBSCRIBE");
    }

    public boolean isNotify() {
        return isMethod("NOTIFY");
    }

    public boolean isMessage() {
        return isMethod("MESSAGE");
    }

    public boolean isInfo() {
        return isMethod("INFO");
    }

    public boolean isPrack() {
        return isMethod("PRACK");
    }

    public boolean isRefer() {
        return isMethod("REFER");
    }

    public boolean isPublish() {
        return isMethod("PUBLISH");
    }

    public boolean isUpdate() {
        return isMethod("UPDATE");
    }


    public boolean containsRequire100rel() {
        this = this.sipMessage.getHeaders("Require");
        while (hasNext()) {
            if (((String) next()).indexOf("100rel") >= 0) {
                return true;
            }
        }
        return false;
    }


    public boolean containsSupported100rel() {
        this = this.sipMessage.getHeaders("Supported");
        while (hasNext()) {
            if (((String) next()).indexOf("100rel") >= 0) {
                return true;
            }
        }
        return false;
    }

    public void addAddressHeader(String paramString, Address paramAddress, boolean paramBoolean) {
        this.sipMessage.addAddressHeader(paramString, paramAddress, paramBoolean);
    }

    public ListIterator getAddressHeaders(String paramString) {
        return this.sipMessage.getAddressHeaders(paramString);
    }

    public Object getContent() {
        return this.sipMessage.getContent();
    }

    public String getContentType() {
        return this.sipMessage.getContentType();
    }

    public Iterator getHeaderNames() {
        return this.sipMessage.getHeaderNames();
    }

    public byte[] getRawContent() {
        return this.sipMessage.getRawContent();
    }

    public void setAddressHeader(String paramString, Address paramAddress) {
        this.sipMessage.setAddressHeader(paramString, paramAddress);
    }

    public void setContent(Object paramObject, String paramString) {
        this.sipMessage.setContent(paramObject, paramString);
    }

    public void setContentLength(int paramInt) {
        this.sipMessage.setContentLength(paramInt);
    }

    public void setContentType(String paramString) {
        this.sipMessage.setContentType(paramString);
    }

    public void setHeader(String paramString1, String paramString2) {
        this.sipMessage.setHeader(paramString1, paramString2);
    }

    public SipServletMessage getMessage() {
        return this.sipMessage;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/SipMessageContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */