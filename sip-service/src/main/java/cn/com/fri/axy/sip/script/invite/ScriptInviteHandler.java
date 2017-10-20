package cn.com.fri.axy.sip.script.invite;

import cn.com.fri.axy.comet.pushlet.MessageSender;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.MessageContext;
import cn.com.fri.axy.sip.entity.Handler;
import cn.com.fri.axy.sip.entity.HandlerList;
import cn.com.fri.axy.sip.init.SSDConfig;
import cn.com.fri.axy.sip.location.LocationService;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import javax.servlet.sip.*;


public class ScriptInviteHandler
        extends Handler {
    private SipSession a;
    private String b;
    private SipServletRequest c;
    private int d;

    public String getLinkageID() {
        return this.b;
    }


    public String sendInvite(String paramString1, int paramInt1, String paramString2, int paramInt2) {
        try {
            paramInt1 = paramString1 + ":" + paramInt1 + "-" + 0;
            Object localObject = paramString2 + ":" + paramInt2;
            this.b = (paramInt1 + "," + (String) localObject);


            localObject = (paramInt1 = ServletContextHelper.getSipFactory()).createApplicationSession();


            Address localAddress2 = ServletContextHelper.getSipFactory().createAddress(
                    LocationService.getInstance().getDomainURI(paramString1));
            Address localAddress1 = ServletContextHelper.getSipFactory().createAddress(
                    LocationService.getInstance().getDomainURI(paramString2));

            (


                    paramInt1 = paramInt1.createRequest((SipApplicationSession) localObject, "INVITE", localAddress1, localAddress2)).setHeader("Subject", this.b);


            paramString2 = "v=0\no=" +
                    paramString2 + " 0 0 IN IP4 " + SSDConfig.getInstance().getMediaDestIP() + "\n" +
                    "s=Play\n" +
                    "c=IN IP4 " + SSDConfig.getInstance().getMediaDestIP() + "\n" +
                    "t=0 0\n" +
                    "m=video " + paramInt2 + " RTP/AVP 96\n" +
                    "a=recvonly\n" +
                    "a=rtpmap:96 H264/90000\n";

            paramInt1.setContent(paramString2.getBytes(), "application/sdp");


            (
                    paramString2 = new HandlerList()).add(this);
            (
                    paramInt2 = paramInt1.getSession(true)).setHandler("accessservlet");
            paramInt2.setAttribute("handlerList", paramString2);


            paramString1 = ServletContextHelper.getSipFactory().createAddress("sip:" + paramString1 + "@" +
                    SSDConfig.getInstance().getOtherSystemIP() + ":" + SSDConfig.getInstance().getOtherSystemPort());

            paramInt1.pushRoute((SipURI) paramString1.getURI());


            SysLogger.info(getClass() + "\nSending INVITE:" + "\n" + paramInt1.toString());
            this.c = paramInt1;
            paramInt1.send();


            this.a = paramInt2;
            ScriptInviteManager.getInstance().addInviteSession(this.b, this);

            this.d = 1;

            return this.b;
        } catch (Exception localException) {
            SysLogger.printStackTrace(paramInt1 = localException);
        }
        return this.b;
    }


    public String getState() {
        if (this.d == 2) {

            this = "已建立";
        } else if (this.d == 1) {
            this = "建立中";
        } else {
            this = "未知";
        }

        return this;
    }


    public void sendBye() {
        if (this.a == null) {
            return;
        }

        try {
            if (this.d == 2) {

                (this = this.a.createRequest("BYE")).send();
                return;
            }


            (this = this.c.createCancel()).send();


            MessageSender.getInstance().send(toString());
            return;


        } catch (Exception localException) {


            SysLogger.printStackTrace(this = localException);
        }
    }


    public void doBye(MessageContext paramMessageContext) {
        (paramMessageContext = paramMessageContext.getRequest().createResponse(200)).send();


        MessageSender.getInstance().send(paramMessageContext.toString());


        ScriptInviteManager.getInstance().removeInviteSession(this.b);
    }


    public void doErrorResponse(MessageContext paramMessageContext) {
        SysLogger.info(getClass() + "\nGetting ErrorResponse:" + "\n" + paramMessageContext.getResponse().toString());
        if (paramMessageContext.isMethod("Invite")) {
            SysLogger.info(this.b + " failed.");


            ScriptInviteManager.getInstance().removeInviteSession(this.b);
            return;
        }
        if (!paramMessageContext.isMethod("Bye")) {


            paramMessageContext.isMethod("Cancel");
        }
    }


    public void doProvisionalResponse(MessageContext paramMessageContext) {
        SysLogger.info(getClass() + "\nGetting ProvisionalResponse:" + "\n" + paramMessageContext.getResponse().toString());
    }


    public void doSuccessResponse(MessageContext paramMessageContext) {
        SysLogger.info(getClass() + "\nGetting SuccessResponse:" + "\n" + paramMessageContext.getResponse().toString());
        if (paramMessageContext.isMethod("Invite")) {

            paramMessageContext = paramMessageContext.getResponse().createAck();

            SysLogger.info(getClass() + "\nSend ACK:" + "\n" + paramMessageContext.toString());
            paramMessageContext.send();

            this.d = 2;
            return;
        }


        if (paramMessageContext.isMethod("BYE")) {
        }
    }


    public boolean isSessionEstablished() {
        return this.d == 2;
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/script/invite/ScriptInviteHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */