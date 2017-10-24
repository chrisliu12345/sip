package com.git.wuqf.service.sip.core;

import javax.servlet.sip.*;
import java.util.Iterator;
import java.util.ListIterator;

public abstract interface MessageContext {
    public abstract SipSession getSession();

    public abstract String getSessionId();

    public abstract SipApplicationSession getApplicationSession();

    public abstract String getApplicationSessionId();

    public abstract SipServletMessage getMessage();

    public abstract SipServletRequest getRequest();

    public abstract SipServletResponse getResponse();

    public abstract String getCallId();

    public abstract boolean isRequest();

    public abstract boolean isResponse();

    public abstract boolean isInitial();

    public abstract String getMethod();

    public abstract int getStatus();

    public abstract boolean isMethod(String paramString);

    public abstract Address getOrigFrom();

    public abstract Address getOrigTo();

    public abstract Address getFrom();

    public abstract Address getTo();

    public abstract Object getContent();

    public abstract void setContent(Object paramObject, String paramString);

    public abstract void setContentLength(int paramInt);

    public abstract void setContentType(String paramString);

    public abstract String getContentType();

    public abstract byte[] getRawContent();

    public abstract ListIterator getAddressHeaders(String paramString);

    public abstract void setAddressHeader(String paramString, Address paramAddress);

    public abstract void addAddressHeader(String paramString, Address paramAddress, boolean paramBoolean);

    public abstract URI getOrigRequestURI();

    public abstract URI getRequestURI();

    public abstract SipURI getRequestSipURI();

    public abstract String getSipUser();

    public abstract String getPhoneNumber();

    public abstract void setRequestURI(URI paramURI);

    public abstract void setFrom(String paramString);

    public abstract void setTo(String paramString);

    public abstract String getHeader(String paramString);

    public abstract ListIterator getHeaders(String paramString);

    public abstract Iterator getHeaderNames();

    public abstract void setHeader(String paramString1, String paramString2);

    public abstract void addHeader(String paramString1, String paramString2);

    public abstract void removeHeader(String paramString);

    public abstract boolean isInvite();

    public abstract boolean isAck();

    public abstract boolean isBye();

    public abstract boolean isCancel();

    public abstract boolean isOptions();

    public abstract boolean isRegister();

    public abstract boolean isSubscribe();

    public abstract boolean isNotify();

    public abstract boolean isMessage();

    public abstract boolean isInfo();

    public abstract boolean isPrack();

    public abstract boolean isRefer();

    public abstract boolean isPublish();

    public abstract boolean isUpdate();

    public abstract boolean isProvisionalResponse();

    public abstract boolean isRedirectResponse();

    public abstract boolean isErrorResponse();

    public abstract boolean isSuccessResponse();

    public abstract boolean containsSupported100rel();

    public abstract boolean containsRequire100rel();

    public abstract boolean isDialExtension();

    public abstract boolean isDialFunctionKey();
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/MessageContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */