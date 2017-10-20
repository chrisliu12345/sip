package cn.com.fri.axy.sip.call.invite;

import cn.com.fri.axy.comet.pushlet.MessageSender;
import cn.com.fri.axy.common.def.message.content.DeviceControlResponse;
import cn.com.fri.axy.common.def.message.content.MediaStatusRequest;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.MessageContext;
import cn.com.fri.axy.sip.entity.Handler;
import cn.com.fri.axy.sip.entity.HandlerList;
import cn.com.fri.axy.sip.location.LocationService;
import cn.com.fri.axy.sip.message.content.ReqResMessage;
import cn.com.fri.axy.sip.message.entity.MessageHandler;
import cn.com.fri.axy.sip.message.session.AppMessageManager;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import javax.servlet.sip.*;
import java.util.Date;


public class InviteHandler
        extends Handler {
    public static final String RealTime = "实时";
    public static final String History = "回放";
    public static final String Download = "下载";
    public static final String UNKnown = "未知";
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private SipSession f;
    private String g;
    private long h;
    private String i;
    private String j;
    private SipServletRequest k;
    private int l;

    public String getLinkageID() {
        return this.i;
    }


    public String getCallID() {
        SysLogger.info("callid " + this.j);
        return this.j;
    }

    public String getState() {
        if (this.l == 2) {

            this = "已建立";
        } else if (this.l == 1) {
            this = "建立中";
        } else {
            this = "未知";
        }

        return this;
    }


    public void sendInvite(String paramString1, String paramString2, String paramString3) {
        this.a = paramString1;
        this.b = paramString3;

        Object localObject;

        try {
            paramString1 = paramString3.substring(paramString3.indexOf("c=IN IP4 ") + "c=IN IP4 ".length());
            if (paramString3.indexOf("\r\n") > -1) {

                localObject = "\r\n";
            } else {
                localObject = "\n";
            }
            this.c = paramString1.substring(0, paramString1.indexOf((String) localObject));
            this.d = Integer.parseInt(paramString3.substring(paramString3.indexOf("m=video ") + "m=video ".length(), paramString3.indexOf(" RTP/")));
            SysLogger.info("player_ip:" + this.c + ",player_port:" + this.d);

        } catch (Exception localException1) {
            SysLogger.printStackTrace(paramString1 = localException1);
        }

        if (paramString3.indexOf("Playback") > -1) {
            this.e = "回放";
            this.h = new Date().getTime();
        } else if (paramString3.indexOf("Download") > -1) {
            this.e = "下载";
            this.h = new Date().getTime();
        } else if (paramString3.indexOf("Play") > -1) {
            this.e = "实时";
            this.h = 0L;
        } else {
            this.e = "未知";
            this.h = new Date().getTime();
        }

        this.i = (paramString2 + ":" + this.h);


        if (InviteManager.getInstance().getInviteSession(this.i) != null) {
            InviteManager.getInstance().endInviteSession(this.i);
        }


        paramString1 = null;

        if (ServletContextHelper.isUsed_Router()) {
            try {
                paramString1 = (SipURI) ServletContextHelper.getSipFactory().createAddress(LocationService.getInstance().getDomainURI(paramString2)).getURI();

            } catch (ServletParseException localServletParseException) {
                SysLogger.printStackTrace(localObject = localServletParseException);
            }

        } else {
            paramString1 = LocationService.getInstance().getFullURIByID(paramString2);
        }

        if (paramString1 == null) {
            SysLogger.info(
                    getClass() + "\n" + paramString2 + " can not find in registration");
            return;
        }

        paramString1.getHost();
        paramString1.getPort();

        paramString2 = paramString3;
        paramString1 = paramString2;
        this = this;
        try {
            localObject = (paramString3 = ServletContextHelper.getSipFactory()).createApplicationSession();
            SysLogger.info("appSession id is " + ((SipApplicationSession) localObject).getId());
            Address localAddress2 = ServletContextHelper.getSipFactory().createAddress(LocationService.getInstance().getDomainURI(paramString1));
            Address localAddress1 = LocationService.getInstance().getLocalDomainURI();
            paramString3 = paramString3.createRequest((SipApplicationSession) localObject, "INVITE", localAddress1, localAddress2);
            if ("decoder".equalsIgnoreCase(this.a)) SysLogger.info("send INVITE to decoder without sdp.");
            else paramString3.setContent(paramString2.getBytes(), "application/sdp");
            (paramString2 = new HandlerList()).add(this);
            (localObject = paramString3.getSession(true)).setHandler("accessservlet");
            ((SipSession) localObject).setAttribute("handlerList", paramString2);
            paramString3.pushRoute(LocationService.getInstance().getFullURIByID(paramString1));
            SysLogger.info(getClass() + "\nSending INVITE:" + "\n" + paramString3.toString());
            this.k = paramString3;
            paramString3.send();
            MessageSender.getInstance().send(paramString3.toString());
            this.g = paramString1;
            this.f = ((SipSession) localObject);
            InviteManager.getInstance().addInviteSession(this.i, this);
            this.l = 1;
            this.j = paramString3.getCallId();
            return;
        } catch (Exception localException2) {
            SysLogger.printStackTrace(paramString3 = localException2);
        }
    }

    public void sendInfo(String paramString) {
        SipServletRequest localSipServletRequest = this.k.getSession().createRequest("INFO");
        try {
            localSipServletRequest.setContent(paramString.getBytes(), "Application/RTSP");
            localSipServletRequest.setContentLength(paramString.length());
            SysLogger.info(getClass() + "\nsend info\n" + localSipServletRequest.toString());
            localSipServletRequest.send();


            MessageSender.getInstance().send(localSipServletRequest.toString());
            return;

        } catch (Exception localException) {
            SysLogger.printStackTrace(this = localException);
        }
    }

    public String getCallType() {
        return this.e;
    }

    public String getCalleeID() {
        return this.g;
    }


    public void sendBye() {
        if (this.f == null) {
            return;
        }

        try {
            if (this.l == 2) {

                (localObject = this.f.createRequest("BYE")).send();


                MessageSender.getInstance().sendPlayNotify("stop", this.c, this.d);

                MessageSender.getInstance().send(localObject.toString());
                return;
            }


            (localObject = this.k.createCancel()).send();


            MessageSender.getInstance().send(localObject.toString());
            return;
        } catch (Exception localException) {
            Object localObject;


            SysLogger.printStackTrace(localObject = localException);
        }
    }


    public void doMessage(MessageContext paramMessageContext) {
        SysLogger.info(getClass() + ":\n" + "get message\n" + paramMessageContext.toString());


        SipServletResponse localSipServletResponse = paramMessageContext.getRequest().createResponse(200);
        SysLogger.info(getClass() + ":\n" + localSipServletResponse.toString());
        localSipServletResponse.send();


        MessageSender.getInstance().send(localSipServletResponse.toString());


        if (((paramMessageContext = MessageHandler.getInstance().parseMessage(paramMessageContext)) instanceof DeviceControlResponse)) {
            AppMessageManager.getInstance().doReqResMessage((ReqResMessage) paramMessageContext);
            return;
        }
        if ((paramMessageContext instanceof MediaStatusRequest)) {

            if ((paramMessageContext = ((MediaStatusRequest) paramMessageContext).getNotifyType()) == 121) {

                InviteManager.getInstance().endInviteSession(this.i);
            }

        } else {
            SysLogger.info(getClass() + ":\ndo nothing for message.");
        }
    }


    public void doBye(MessageContext paramMessageContext) {
        (paramMessageContext = paramMessageContext.getRequest().createResponse(200)).send();


        MessageSender.getInstance().send(paramMessageContext.toString());


        InviteManager.getInstance().removeInviteSession(this.i);
    }


    public void doErrorResponse(MessageContext paramMessageContext) {
        SysLogger.info(getClass() + "\nGetting ErrorResponse:" + "\n" + paramMessageContext.getResponse().toString());
        if (paramMessageContext.isMethod("Invite")) {
            SysLogger.info(this.i + " failed.");


            InviteManager.getInstance().removeInviteSession(this.i);
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

            if ("decoder".equalsIgnoreCase(this.a)) {
                SysLogger.info("send ack to decoder with sdp.");
                paramMessageContext.setContent(this.b.getBytes(), "application/sdp");
            }


            InviteManager.getInstance().checkSamePlayerIPandPort(this.i, this.c, this.d);

            MessageSender.getInstance().sendPlayNotify("start", this.c, this.d);

            SysLogger.info(getClass() + "\nSend ACK:" + "\n" + paramMessageContext.toString());
            paramMessageContext.send();


            MessageSender.getInstance().send(paramMessageContext.toString());

            this.l = 2;
            return;
        }


        if (paramMessageContext.isMethod("BYE")) {
        }
    }


    public boolean isSessionEstablished() {
        return this.l == 2;
    }

    public boolean isSamePlayerIPandPort(String paramString, int paramInt) {
        if ((this.c != null) && (this.c.equalsIgnoreCase(paramString)) && (this.d == paramInt)) {
            return true;
        }


        return false;
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "v=0\no=34020000002020000001 0 0 IN IP4 192.168.3.81\ns=Play\nc=IN IP4 192.168.3.81\nt=0 0\nm=video 600 RTP/AVP 96 98 97\na=recvonly\na=rtpmap:96 H264/90000\na=rtpmap:98 H264/90000\na=rtpmap:97 MPEG4/90000\ny=0100000001\nf=\n";


        String str1 = "";
        try {
            localObject = paramArrayOfString.substring(paramArrayOfString.indexOf("c=IN IP4 ") + "c=IN IP4 ".length());
            String str2;
            if (paramArrayOfString.indexOf("\r\n") > -1) {

                str2 = "\r\n";
            } else {
                str2 = "\n";
            }
            localObject = ((String) localObject).substring(0, ((String) localObject).indexOf(str2));
            paramArrayOfString = paramArrayOfString.substring(paramArrayOfString.indexOf("m=video ") + "m=video ".length(), paramArrayOfString.indexOf(" RTP/"));
            str1 = "udp://@" + (String) localObject + ":" + paramArrayOfString;
        } catch (Exception localException) {
            Object localObject;
            SysLogger.printStackTrace(localObject = localException);
        }

        System.out.println(str1);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/call/invite/InviteHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */