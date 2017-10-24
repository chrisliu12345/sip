package com.git.wuqf.service.sip.core;

import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import javax.servlet.sip.SipURI;
import javax.servlet.sip.URI;


public class ResponseContext
        extends SipMessageContext {
    protected transient SipServletResponse response;

    ResponseContext(SipServletResponse paramSipServletResponse) {
        this.sipMessage = paramSipServletResponse;
        this.response = paramSipServletResponse;
    }

    public SipServletRequest getRequest() {
        return this.response.getRequest();
    }

    public SipServletResponse getResponse() {
        return this.response;
    }

    public boolean isRequest() {
        return false;
    }

    public boolean isResponse() {
        return true;
    }


    public boolean isProvisionalResponse() {
        return ( this.response.getStatus()) < 200;
    }


    public boolean isRedirectResponse() {
        int status=this.response.getStatus();
        return (status >= 300) && (status < 400);
    }


    public boolean isErrorResponse() {
        return ( this.response.getStatus()) >= 400;
    }


    public boolean isSuccessResponse() {
        int status=response.getStatus();
        return (status>= 200) && (status < 300);
    }

    public URI getOrigRequestURI() {
        return getRequestURI();
    }

    public URI getRequestURI() {
        return this.response.getRequest().getRequestURI();
    }

    public SipURI getRequestSipURI() {
        return (SipURI) getRequestURI();
    }


    public void setRequestURI(URI paramURI) {
    }


    public boolean isInitial() {
        return this.response.getRequest().isInitial();
    }

    public String getSipUser() {
        throw new UnsupportedOperationException();
    }

    public boolean isDialExtension() {
        throw new UnsupportedOperationException();
    }

    public boolean isDialFunctionKey() {
        throw new UnsupportedOperationException();
    }

    public int getStatus() {
        return this.response.getStatus();
    }

    public String getPhoneNumber() {
        throw new UnsupportedOperationException();
    }
}
