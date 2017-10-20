package cn.com.fri.axy.sip.core;

import cn.com.fri.axy.sip.util.ServletContextHelper;

import javax.servlet.sip.*;


public class RequestContext
        extends SipMessageContext {
    protected transient SipServletRequest request;

    RequestContext(SipServletRequest paramSipServletRequest) {
        this.sipMessage = paramSipServletRequest;
        this.request = paramSipServletRequest;
    }

    public SipServletRequest getRequest() {
        return this.request;
    }


    public SipServletResponse getResponse() {
        return null;
    }

    public URI getOrigRequestURI() {
        return this.request.getRequestURI();
    }

    public String getPhoneNumber() {
        URI localURI = getRequestURI();
        return getPhoneNumber(localURI);
    }

    public String getPhoneNumber(URI paramURI) {
        if (paramURI.isSipURI()) {
            return ((SipURI) paramURI).getUser();
        }
        return ((TelURL) paramURI).getPhoneNumber();
    }


    public URI getRequestURI() {
        String str;
        if ((str = (String) this.request.getAttribute("_attr.requri")) == null) {
            return getOrigRequestURI();
        }
        try {
            return ServletContextHelper.getSipFactory().createURI(str);
        } catch (ServletParseException localServletParseException) {
        }
        return null;
    }


    public SipURI getRequestSipURI() {
        return (SipURI) getRequestURI();
    }


    public void setRequestURI(URI paramURI) {
    }


    public boolean isRequest() {
        return true;
    }

    public boolean isResponse() {
        return false;
    }


    public boolean isProvisionalResponse() {
        return false;
    }


    public boolean isRedirectResponse() {
        return false;
    }


    public boolean isErrorResponse() {
        return false;
    }


    public boolean isSuccessResponse() {
        return false;
    }

    public boolean isInitial() {
        return this.request.isInitial();
    }

    public String getSipUser() {
        return getRequestSipURI().getUser();
    }


    public boolean isDialExtension() {
        this = this;
        return 4 <= getSipUser().length();
    }


    public boolean isDialFunctionKey() {
        return true;
    }

    public int getStatus() {
        throw new UnsupportedOperationException();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/RequestContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */