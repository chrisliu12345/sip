package com.git.wuqf.service.sip.script.invite;

import com.git.wuqf.service.comet.pushlet.MessageSender;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.MessageContext;
import com.git.wuqf.service.sip.entity.Handler;

import javax.servlet.sip.*;
import java.io.IOException;


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
//        try {
//            String s = paramString1 + ":" + paramInt1 + "-" + 0;
//            Object localObject = paramString2 + ":" + paramInt2;
//            this.b = (paramInt1 + "," + (String) localObject);
//
//
//            localObject = ( ServletContextHelper.getSipFactory()).createApplicationSession();


//            Address localAddress2 = ServletContextHelper.getSipFactory().createAddress(
//                    LocationService.getInstance().getDomainURI(paramString1));
//            Address localAddress1 = ServletContextHelper.getSipFactory().createAddress(
//                    LocationService.getInstance().getDomainURI(paramString2));
//
//


//                    paramInt1 = createRequest((SipApplicationSession) localObject, "INVITE", localAddress1, localAddress2);
//            .setHeader("Subject", this.b);


//            paramString2 = "v=0\no=" +
//                    paramString2 + " 0 0 IN IP4 " + SSDConfig.getInstance().getMediaDestIP() + "\n" +
//                    "s=Play\n" +
//                    "c=IN IP4 " + SSDConfig.getInstance().getMediaDestIP() + "\n" +
//                    "t=0 0\n" +
//                    "m=video " + paramInt2 + " RTP/AVP 96\n" +
//                    "a=recvonly\n" +
//                    "a=rtpmap:96 H264/90000\n";

//            paramInt1.setContent(paramString2.getBytes(), "application/sdp");
//
//
//            (
//                    paramString2 = new HandlerList()).add(this);
//            (
//                    paramInt2 = paramInt1.getSession(true)).setHandler("accessservlet");
//            paramInt2.setAttribute("handlerList", paramString2);
//
//
//            paramString1 = ServletContextHelper.getSipFactory().createAddress("sip:" + paramString1 + "@" +
//                    SSDConfig.getInstance().getOtherSystemIP() + ":" + SSDConfig.getInstance().getOtherSystemPort());
//
//            paramInt1.pushRoute((SipURI) paramString1.getURI());
//
//
//            SysLogger.info(getClass() + "\nSending INVITE:" + "\n" + paramInt1.toString());
//            this.c = paramInt1;
//            paramInt1.send();
//
//
//            this.a = paramInt2;
//            ScriptInviteManager.getInstance().addInviteSession(this.b, this);
//
//            this.d = 1;
//
//            return this.b;
//        } catch (Exception localException) {
//            SysLogger.printStackTrace(paramInt1 = localException);
//        }
        return this.b;
    }


    public String getState() {
        if (d == 2) {

            return  "已建立";
        } else if (d == 1) {
            return "建立中";
        } else {
            return "未知";
        }
    }


    public void sendBye() {
        if (this.a == null) {
            return;
        }

        try {
            if (this.d == 2) {

                (a.createRequest("BYE")).send();
                return;
            }


            (c.createCancel()).send();


            MessageSender.getInstance().send(toString());
            return;


        } catch (Exception localException) {


            SysLogger.printStackTrace( localException);
        }
    }


    public void doBye(MessageContext paramMessageContext) {
        SipServletResponse s = paramMessageContext.getRequest().createResponse(200);
        try {
            s.send();
        } catch (IOException e) {
            e.printStackTrace();
        }


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

            SipServletRequest s = paramMessageContext.getResponse().createAck();

            SysLogger.info(getClass() + "\nSend ACK:" + "\n" + paramMessageContext.toString());
            try {
                s.send();
            } catch (IOException e) {
                e.printStackTrace();
            }

            d = 2;
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
