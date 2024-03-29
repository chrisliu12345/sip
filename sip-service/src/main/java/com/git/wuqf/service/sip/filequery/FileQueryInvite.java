package com.git.wuqf.service.sip.filequery;

import com.git.wuqf.service.comet.pushlet.MessageSender;
import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.MessageContext;
import com.git.wuqf.service.sip.core.asyn.AsyncServiceDispatcher;
import com.git.wuqf.service.sip.core.asyn.service.AsynObserverService;
import com.git.wuqf.service.sip.entity.Handler;
import com.git.wuqf.service.sip.exception.DeviceStateException;

import javax.servlet.sip.*;
import java.io.IOException;
import java.util.Observer;
import java.util.Vector;


public class FileQueryInvite
        extends Handler {
    private VideoQueryBean_SSD a;
    private Vector b;
    private Observer c;

    public FileQueryInvite(VideoQueryBean_SSD paramVideoQueryBean_SSD, Observer paramObserver) {
        this.a = paramVideoQueryBean_SSD;
        this.c = paramObserver;
        this.b = new Vector();
    }


    public void sendInvite() throws DeviceStateException {
//        String str = this.a.getDeviceID();
//
//        if (!LocationService.getInstance().isLocalDomainDeviceOnline(str)) {
//            throw new DeviceStateException();
//        }
//
//
//        try {
//            Object localObject2 = ( ServletContextHelper.getSipFactory()).createApplicationSession();
//
//            Address localAddress = ServletContextHelper.getSipFactory().createAddress(LocationService.getInstance().getDomainURI(str));
//
//
//            Object localObject3 = LocationService.getInstance().getLocalDomainURI();
//
//
//            (
//
//                    localObject1 = ((SipFactory) localObject1).createRequest((SipApplicationSession) localObject2, "INVITE", (Address) localObject3, localAddress)).setContent(this.a.getXmlContent().getBytes(), "application/MANSCDP+xml");
//
//
//            (
//                    localObject2 = new HandlerList()).add(this);
//            (
//                    localObject3 = ((SipServletRequest) localObject1).getSession(true)).setHandler("accessservlet");
//            ((SipSession) localObject3).setAttribute("handlerList", localObject2);
//
//
//            ((SipServletRequest) localObject1).pushRoute(LocationService.getInstance().getFullURIByID(str));
//
//            SysLogger.info(getClass() + "\nSending INVITE:" + "\n" + localObject1.toString());
//            ((SipServletRequest) localObject1).send();
//
//
//            MessageSender.getInstance().send(localObject1.toString());
//            return;
//        } catch (Exception localException) {
//            Object localObject1;
//            SysLogger.printStackTrace(localObject1 = localException);
//            throw new DeviceStateException((Throwable) localObject1);
//        }
    }


    public void doErrorResponse(MessageContext paramMessageContext) {
        SysLogger.info(
                getClass() + "\nGetting ErrorResponse:" + "\n" + paramMessageContext.getResponse().toString());
        if (paramMessageContext.isMethod("Invite")) {
            paramMessageContext.getApplicationSession().invalidate();

            a(213);
            return;
        }
        if (paramMessageContext.isMethod("Bye")) {
            paramMessageContext.getApplicationSession().invalidate();
            return;
        }

        paramMessageContext.isMethod("Cancel");
    }


    public void doProvisionalResponse(MessageContext paramMessageContext) {
        SysLogger.info(
                getClass() + "\nGetting ProvisionalResponse:" + "\n" + paramMessageContext.getResponse().toString());
    }


    public void doSuccessResponse(MessageContext paramMessageContext) {
        SysLogger.info(
                getClass() + "\nGetting SuccessResponse:" + "\n" + paramMessageContext.getResponse().toString());
        if (paramMessageContext.isMethod("Invite")) {

            SipServletRequest req = paramMessageContext.getResponse().createAck();

            SysLogger.info(getClass() + "\nSend ACK:" + "\n" +
                    paramMessageContext.toString());
            try {
                req.send();
            } catch (IOException e) {
                e.printStackTrace();
            }


            MessageSender.getInstance().send(paramMessageContext.toString());
            return;
        }
        if (paramMessageContext.isMethod("BYE")) {
            paramMessageContext.getApplicationSession().invalidate();

            return;
        }
    }


    public void doInfo(MessageContext paramMessageContext) {
//        SysLogger.info("do info");
//
//        (
//                localObject = paramMessageContext.getRequest().createResponse(200)).send();
//
//
//        MessageSender.getInstance().send(localObject.toString());
//
//        paramMessageContext = new String(paramMessageContext.getRawContent());
//
//        Object localObject = new Vector();
//        if (paramMessageContext.indexOf("</file>") > -1) {
//            String[] arrayOfString;
//            int j = (arrayOfString = paramMessageContext = paramMessageContext.split("</file>")).length;
//            for (int i = 0; i < j; i++) {
//
//                if ((paramMessageContext = arrayOfString[i]).indexOf("<file>") > -1) {
//                    paramMessageContext = new VideoSegmentBean(paramMessageContext);
//                    try {
//                        paramMessageContext.parseMessageSegment();
//                    } catch (Exception localException) {
//                        SysLogger.printStackTrace(paramMessageContext = localException);
//                        continue;
//                    }
//
//
//                    ((Vector) localObject).add(paramMessageContext);
//                }
//            }
//
//
//            a((Vector) localObject);
//            return;
//        }
//
//
//        SysLogger.info("error info message.");
    }


    public void doBye(MessageContext paramMessageContext) {
//        SipServletResponse localSipServletResponse;
//
//        (localSipServletResponse = paramMessageContext.getRequest().createResponse(200)).send();
//        paramMessageContext.getApplicationSession().invalidate();
//
//
//        MessageSender.getInstance().send(localSipServletResponse.toString());
//
//        a(212);
    }


    private synchronized void a(Vector paramVector) {
        this.b.addAll(paramVector);
    }


    private void a(int paramInt) {
        SysLogger.info("size:" + this.b.size());


        if (this.c == null) {
            SysLogger.info("observer is null");
            return;
        }

        NotifyObject localNotifyObject;

        (localNotifyObject = new NotifyObject()).setCode(paramInt);
        localNotifyObject.setResponse(this.b);


        new AsyncServiceDispatcher().callService(new AsynObserverService(this.c, localNotifyObject));
    }
}
