package com.git.wuqf.service.sip.interfaces;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.Controller;
import com.git.wuqf.service.sip.init.SIPServerInitialization;
import com.git.wuqf.service.sip.init.SSDConfig;

import javax.naming.InitialContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.sip.*;
import java.util.Hashtable;
import java.util.Properties;


public class SipAccessServlet
        extends SipServlet
        implements Servlet, SipErrorListener {
    private Controller a;

    public void init(ServletConfig paramServletConfig) {
        init(paramServletConfig);

        try {
            Properties properties = new Properties();
            InitialContext context= new InitialContext((Hashtable) properties);
//            localObject = (SipFactory) ( (context.lookup("java:comp/env")).lookup("sip/SIPStandardDebug/SipFactory");
//            SysLogger.info("Sip Factory ref from JNDI : " + localObject);
//
//
//            ServletContextHelper.setSipFactory((SipFactory) localObject);
        } catch (Exception localException) {
            Object localObject;
            SysLogger.printStackTrace(localException);
        }

        SSDConfig.getInstance();


        SIPServerInitialization.getInstance().sipServerInit(paramServletConfig.getServletContext());

        this.a = new Controller();
    }


    public void service(ServletRequest paramServletRequest, ServletResponse paramServletResponse) {
        this.a.process((SipServletRequest) paramServletRequest, (SipServletResponse) paramServletResponse);
    }

    public void destory() {
        this.a = null;
        super.destroy();
    }


    public void noAckReceived(SipErrorEvent paramSipErrorEvent) {
        SysLogger.info("SimpleProxyServlet: Error: noAckReceived.");
    }

    public void noPrackReceived(SipErrorEvent paramSipErrorEvent) {
        SysLogger.info("SimpleProxyServlet: Error: noPrackReceived.");
    }

    public static void main(String[] paramArrayOfString) {
    }
}
