package cn.com.fri.axy.sip.interfaces;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.Controller;
import cn.com.fri.axy.sip.init.SIPServerInitialization;
import cn.com.fri.axy.sip.init.SSDConfig;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import javax.naming.Context;
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
        super.init(paramServletConfig);


        try {
            localObject = new Properties();


            localObject = (SipFactory) (localObject = (Context) (localObject = new InitialContext((Hashtable) localObject)).lookup("java:comp/env")).lookup("sip/SIPStandardDebug/SipFactory");
            SysLogger.info("Sip Factory ref from JNDI : " + localObject);


            ServletContextHelper.setSipFactory((SipFactory) localObject);
        } catch (Exception localException) {
            Object localObject;
            SysLogger.printStackTrace(localObject = localException);
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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/interfaces/SipAccessServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */