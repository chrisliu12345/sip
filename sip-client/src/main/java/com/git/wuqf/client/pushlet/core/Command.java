package com.git.wuqf.client.pushlet.core;

import com.git.wuqf.client.pushlet.util.PushletException;
import com.git.wuqf.client.pushlet.util.Servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command implements Protocol {
    public final Event reqEvent;
    private Event rspEvent;
    public final HttpServletRequest httpReq;
    public final HttpServletResponse httpRsp;
    public final Session session;
    private ClientAdapter clientAdapter;

    private Command(Session aSession, Event aRequestEvent, HttpServletRequest aHTTPReq, HttpServletResponse aHTTPRsp) {
        this.session = aSession;
        this.reqEvent = aRequestEvent;
        this.httpReq = aHTTPReq;
        this.httpRsp = aHTTPRsp;
    }

    public static Command create(Session aSession, Event aReqEvent, HttpServletRequest aHTTPReq, HttpServletResponse aHTTPRsp) {
        return new Command(aSession, aReqEvent, aHTTPReq, aHTTPRsp);
    }

    public void setResponseEvent(Event aResponseEvent) {
        this.rspEvent = aResponseEvent;
    }

    public Event getResponseEvent() {
        return this.rspEvent;
    }

    public ClientAdapter getClientAdapter()
            throws PushletException {
        if (this.clientAdapter == null) {
            this.clientAdapter = createClientAdapter();
        }
        return this.clientAdapter;
    }

    protected ClientAdapter createClientAdapter()
            throws PushletException {
        String outputFormat = this.session.getFormat();
        if (outputFormat.equals("js")) {
            return new BrowserAdapter(this.httpRsp);
        }
        if (outputFormat.equals("ser")) {
            return new SerializedAdapter(this.httpRsp);
        }
        if (outputFormat.equals("xml")) {
            return new XMLAdapter(this.httpRsp);
        }
        if (outputFormat.equals("xml-strict")) {
            return new XMLAdapter(this.httpRsp, true);
        }
        throw new PushletException("Null or invalid output format: " + outputFormat);
    }

    protected void sendResponseHeaders() {
        Servlets.setNoCacheHeaders(this.httpRsp);
        if (this.session.getUserAgent().indexOf("java") > 0) {
            this.httpRsp.setHeader("Connection", "close");
        }
    }
}
