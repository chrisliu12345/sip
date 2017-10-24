package com.git.wuqf.service.sip.message.entity;

import com.git.wuqf.service.comet.pushlet.MessageSender;
import cn.com.fri.axy.common.def.message.content.configdownload.*;
import cn.com.fri.axy.common.def.message.content.decoderconfigdownload.*;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.call.invite.InviteManager;
import com.git.wuqf.service.sip.core.MessageContext;
import com.git.wuqf.service.sip.entity.HandlerList;
import com.git.wuqf.service.sip.exception.MessageException;
import com.git.wuqf.service.sip.location.LocationService;
import com.git.wuqf.service.sip.message.content.Message;
import com.git.wuqf.service.sip.message.content.ReqResMessage;
import com.git.wuqf.service.sip.message.session.AppMessageManager;
import com.git.wuqf.service.sip.util.RegExUtil;
import com.git.wuqf.service.sip.util.ServletContextHelper;
import com.git.wuqf.service.sip.call.invite.InviteHandler;
import com.git.wuqf.service.sip.entity.Handler;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import javax.servlet.sip.Address;
import javax.servlet.sip.SipApplicationSession;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipSession;

public class MessageHandler extends Handler implements ResendInterface {
    private static MessageHandler a = new MessageHandler();


    public static MessageHandler getInstance() {
        return a;
    }


    public void sendMessage(Message paramMessage) throws MessageException {
        String id = paramMessage.getDestid();

        if (!RegExUtil.validateCode(paramMessage.getDestid())) {
            throw new IllegalArgumentException("destID:" + id);
        }


        if (paramMessage.isOnlyReqMessage()) {
            paramMessage = paramMessage;
            try {
                String sn = AppMessageManager.getInstance().genSN();
                paramMessage.setSn(sn);
                a(paramMessage);
            } catch (Exception localException1) {
                SysLogger.printStackTrace(localException1);
            }
        } else if (paramMessage.isReqResMessage()) {
            paramMessage = paramMessage;
            try {
                if (((ReqResMessage) paramMessage).isAppRequest()) {
                    String sn = AppMessageManager.getInstance().genSN();
                    paramMessage.setSn(sn);
                    ((ReqMessage) paramMessage).setHandler(this);
                }
                a(paramMessage);
                AppMessageManager.getInstance().sendReqResMessage((ReqResMessage) paramMessage);
                return;
            } catch (Exception localException2) {
                throw new MessageException(localException2);
            }
        }
    }


    public void resendMessage(Message paramMessage) {
        try {
            a(paramMessage);
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace(localException);
        }
    }


    private void a(Message paramMessage) {
        try {
            String str = paramMessage.getDestid();
            SysLogger.info(getClass() + "\ndestID：" + str);

            Address address = ServletContextHelper.getSipFactory().createAddress(
                    LocationService.getInstance().getDomainURI(str));
            Address localDomainURI = LocationService.getInstance().getLocalDomainURI();


            if (address == null) {
                SysLogger.info(getClass() + "\nto is null.");

                throw new MessageException("to is null");
            }
            if (localDomainURI == null) {
                SysLogger.info(getClass() + "\nmyAddress is null.");

                throw new MessageException("myAddress is null");
            }

            SipApplicationSession localSipApplicationSession = ServletContextHelper.getSipFactory().createApplicationSession();
            SysLogger.info("appSession id is " + localSipApplicationSession.getId());

            SipServletRequest req = ServletContextHelper.getSipFactory().createRequest(localSipApplicationSession, "MESSAGE", (Address) localDomainURI, address);
            SipSession session = req.getSession(true);
            session.setHandler("accessservlet");


            if (paramMessage.getClass().getName().indexOf("cn.com.fri.axy.business.common.jsonMessage") > -1) {
                req.setCharacterEncoding("GB2312");
                req.setContent(paramMessage.getXmlContent(), "text/html");

            } else {

                 String uri = paramMessage.getXmlContent().replaceFirst(" xmlns=\".*?\">", ">");

                req.setContentLength(uri.getBytes().length);
                req.setContent(uri, "Application/MANSCDP+xml");
            }

            HandlerList handlerList = new HandlerList();
            handlerList.add(this);
            ((SipServletRequest) handlerList).getSession().setAttribute("handlerList", localDomainURI);

            ((SipServletRequest) handlerList).pushRoute(LocationService.getInstance().getFullURIByID(str));

            if ((paramMessage.getPurviewBean()) != null) {

//                if (( ((PurviewBean) localDomainURI).getPurviewHeader()).length() > 0) {
//                    (req.addHeader("Monitor-User-Identity",
//                            (PurviewBean)localDomainURI).getPurviewHeader()));
//                }
            }

//            SysLogger.info(getClass() + "\nmessage to send:\n" + localObject1);
            req.send();


//            MessageSender.getInstance().send(localObject1.toString());
            return;
        } catch (Exception localException) {
            Object localObject1;
            SysLogger.printStackTrace(localException);

        }
    }


    public void doMessage(MessageContext paramMessageContext) {
        SysLogger.info(
                getClass() + ":\n" + "get message\n" + paramMessageContext.toString());


        Object localObject = new String(paramMessageContext.getRawContent());

        String str = null;
        try {
            str = ((String) localObject).substring(((String) localObject).indexOf("<CmdType>") +
                    "<CmdType>".length(), ((String) localObject).indexOf("</CmdType>"));

        } catch (NullPointerException localNullPointerException) {
            SysLogger.info(
                    "catch NullPointerException when get type from\n" + paramMessageContext.getRequest().toString());
        }

        try {
            if ("Keepalive".equalsIgnoreCase(str)) {
                localObject =
                        ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") +
                                "<DeviceID>".length(), ((String) localObject)
                                .indexOf("</DeviceID>"));

                if (!LocationService.getInstance().isLocalDomainDeviceOnline(
                        (String) localObject)) {

                    paramMessageContext.getApplicationSession().invalidate();
                    return;
                }

            }
        } catch (Exception localException1) {
            SysLogger.printStackTrace(localException1);


            try {
                localObject = paramMessageContext.getRequest().createResponse(
                        200);
                SysLogger.info(getClass() + ":\n" + localObject.toString());
                ((javax.servlet.sip.SipServletResponse) localObject).send();
                paramMessageContext.getApplicationSession().invalidate();


                MessageSender.getInstance().send(localObject.toString());

            } catch (Exception localException2) {

                SysLogger.printStackTrace(localException2);
            }

            try {
                if ("MediaStatus".equalsIgnoreCase(str)) {
                    localObject = paramMessageContext.getCallId();


                    if ((localObject = InviteManager.getInstance().getInviteHandlerByCallID((String) localObject)) != null) {
                        InviteManager.getInstance().endInviteSession(((InviteHandler) localObject).getLinkageID());
                    }
                }
            } catch (Exception localException3) {
                SysLogger.printStackTrace(localException3);
            }


            if ((localObject = parseMessage(paramMessageContext)) == null) {
                SysLogger.info(
                        getClass() + ":\n" + "invalid message\n" + paramMessageContext.toString());
                return;
            }


//            if (((Message) localObject).isOnlyReqMessage()) {
//
//
//                paramMessageContext = (MessageContext) localObject;
//                if (paramMessageContext.getCmdType().equalsIgnoreCase("Keepalive")) {
//                    paramMessageContext = (KeepaliveRequest) paramMessageContext;
//                    SysLogger.info(getClass() + "\njump device：" + paramMessageContext.getDeviceID());
//                    if (paramMessageContext.getInfos() != null)
//                        SysLogger.info(getClass() + "\njump info：" + paramMessageContext.getInfos().size());
//                }
//                return;
//            }
//            if (((Message) localObject).isReqResMessage()) {
//                 (MessageHandler) localObject;
//                AppMessageManager.getInstance().doReqResMessage((ReqResMessage) this);
//            }
        }
    }


    public void doSuccessResponse(MessageContext paramMessageContext) {
        SysLogger.info(getClass() + "\nget 2XX response");
    }


    public void doErrorResponse(MessageContext paramMessageContext) {
        SysLogger.info(getClass() + "\nget 4XX response");
    }


    public Message parseMessage(MessageContext paramMessageContext) {
        Object localObject1 = null;

//        try {
//            localObject2 = new String(paramMessageContext.getRawContent());
//
//            String str1 = paramMessageContext = ((javax.servlet.sip.SipURI) paramMessageContext.getFrom().getURI()).getUser();
//            SysLogger.info(getClass() + "\nfromid\t" + paramMessageContext);
//            SysLogger.info(getClass() + "\ncontent\t" + (String) localObject2);
//
//            String str2;
//
//            if ((str2 = ((String) localObject2).substring(((String) localObject2).indexOf("<CmdType>") + "<CmdType>".length(), ((String) localObject2).indexOf("</CmdType>"))).equalsIgnoreCase("Keepalive")) {
//
//                (localObject1 = new KeepaliveRequest(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//                str1 = ((KeepaliveRequest) localObject1).getDeviceID();
//            } else if (str2.equalsIgnoreCase("Alarm")) {
//
//                (localObject1 = new AlarmRequest(null, null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//                str1 = ((AlarmRequest) localObject1).getDeviceID();
//            } else if (str2.equalsIgnoreCase("DeviceInfo")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.DeviceInfoResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//            } else if (str2.equalsIgnoreCase("Catalog")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.DeviceCatalogResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//            } else if (str2.equalsIgnoreCase("RecordInfo")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.RecordInfoResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//            } else if (str2.equalsIgnoreCase("DeviceControl")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.DeviceControlResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//
//            } else if (str2.equalsIgnoreCase("DeviceConfig")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.DeviceConfigResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//
//            } else if (str2.equalsIgnoreCase("ConfigDefence")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.TollgateConfigDefenceResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//
//            } else if (str2.equalsIgnoreCase("TGSAlarmRecordList")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.TollgateAlarmRecordResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//
//            } else if (str2.equalsIgnoreCase("TGSCarRecordList")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.TollgateCarRecordResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//
//            } else if (str2.equalsIgnoreCase("TGSAlarm")) {
//
//                (localObject1 = new cn.com.fri.axy.common.def.message.content.TollgateAlarmRequest(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//
//            } else if (str2.equalsIgnoreCase("DeviceStatus")) {
//
//                (localObject1 = new DeviceStatusResponse(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//                str1 = ((DeviceStatusResponse) localObject1).getDeviceID();
//            } else if (str2.equalsIgnoreCase("ConfigDownload")) {
//
//
//                if ((str2 = ((String) localObject2).substring(((String) localObject2).indexOf("<ConfigType>") + "<ConfigType>".length(), ((String) localObject2).indexOf("</ConfigType>"))) == null) {
//                    return null;
//                }
//
//                if ((RegExUtil.isCoderDevice(paramMessageContext)) ||
//                        (RegExUtil.isCameraDevice(paramMessageContext)) ||
//                        (RegExUtil.isAlarmInputDevice(paramMessageContext))) {
//
//                    if (str2.equals("BasicParam")) {
//
//                        (localObject1 = new CoderBasicParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CoderBasicParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("NetworkParam")) {
//
//                        (localObject1 = new CoderNetworkParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CoderNetworkParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("CameraParam")) {
//
//                        (localObject1 = new cn.com.fri.axy.common.def.message.content.configdownload.CoderCameraParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((cn.com.fri.axy.common.def.message.content.configdownload.CoderCameraParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("AlarmChannelParam")) {
//
//
//                        (localObject1 = new CoderAlarmChannelParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CoderAlarmChannelParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("SecurityParam")) {
//
//                        (localObject1 = new CoderSecurityParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CoderSecurityParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("TimeParam")) {
//
//                        (localObject1 = new CoderTimeParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CoderTimeParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("HeartBeatParam")) {
//
//
//                        (localObject1 = new CoderHeartBeatParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CoderHeartBeatParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("ExtensionParam")) {
//
//
//                        (localObject1 = new CoderExtensionParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CoderExtensionParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("VideoParam")) {
//
//                        (localObject1 = new CameraVideoParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CameraVideoParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("TelCtrlParam")) {
//
//                        (localObject1 = new CameraTelCtrlParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CameraTelCtrlParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("RecordParam")) {
//
//                        (localObject1 = new CameraRecordParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CameraRecordParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("RecordTimeParam")) {
//
//
//                        (localObject1 = new CameraRecordTimeParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CameraRecordTimeParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("ActiveRecordTime")) {
//
//
//                        (localObject1 = new CameraActiveRecordTimeConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CameraActiveRecordTimeConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("MediaSecurity")) {
//
//
//                        (localObject1 = new CameraMediaSecurityConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((CameraMediaSecurityConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("AlarmParam")) {
//
//                        (localObject1 = new AlarmAlarmParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((AlarmAlarmParamConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("ActiveOndutyTime")) {
//
//
//                        (localObject1 = new AlarmActiveOndutyTimeConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((AlarmActiveOndutyTimeConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//
//                    } else if (str2.equals("AlarmRecordTable")) {
//
//
//                        (localObject1 = new AlarmAlarmRecordTableConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                        ((Message) localObject1).genParameters();
//                        str1 = ((AlarmAlarmRecordTableConfigDownloadResponse) localObject1)
//                                .getDeviceID();
//                    } else {
//                        SysLogger.info(
//                                getClass() + "\nget subType " + str2 + " never parse.");
//
//                    }
//
//
//                } else if (str2.equals("BasicParam")) {
//
//                    (localObject1 = new DecoderBasicParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                    ((Message) localObject1).genParameters();
//                    str1 = ((DecoderBasicParamConfigDownloadResponse) localObject1)
//                            .getDeviceID();
//
//                } else if (str2.equals("NetworkParam")) {
//
//                    (localObject1 = new DecoderNetworkParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                    ((Message) localObject1).genParameters();
//                    str1 = ((DecoderNetworkParamConfigDownloadResponse) localObject1)
//                            .getDeviceID();
//
//                } else if (str2.equals("OutputParam")) {
//
//                    (localObject1 = new DecoderOutputParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                    ((Message) localObject1).genParameters();
//                    str1 = ((DecoderOutputParamConfigDownloadResponse) localObject1)
//                            .getDeviceID();
//
//                } else if (str2.equals("SecurityParam")) {
//
//                    (localObject1 = new DecoderSecurityParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                    ((Message) localObject1).genParameters();
//                    str1 = ((DecoderSecurityParamConfigDownloadResponse) localObject1)
//                            .getDeviceID();
//
//                } else if (str2.equals("TimeParam")) {
//
//                    (localObject1 = new DecoderTimeParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                    ((Message) localObject1).genParameters();
//                    str1 = ((DecoderTimeParamConfigDownloadResponse) localObject1)
//                            .getDeviceID();
//
//                } else if (str2.equals("HeartBeatParam")) {
//
//
//                    (localObject1 = new DecoderHeartBeatParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                    ((Message) localObject1).genParameters();
//                    str1 = ((DecoderHeartBeatParamConfigDownloadResponse) localObject1)
//                            .getDeviceID();
//
//                } else if (str2.equals("ExtensionParam")) {
//
//
//                    (localObject1 = new DecoderExtensionParamConfigDownloadResponse(null)).setXmlContent((String) localObject2);
//                    ((Message) localObject1).genParameters();
//                    str1 = ((DecoderExtensionParamConfigDownloadResponse) localObject1)
//                            .getDeviceID();
//                } else {
//                    SysLogger.info(
//                            getClass() + "\nget decoder subType " + str2 + " never parse.");
//
//                }
//
//
//            } else if (str2.equalsIgnoreCase("MediaStatus")) {
//
//                (localObject1 = new MediaStatusRequest(null)).setXmlContent((String) localObject2);
//                ((Message) localObject1).genParameters();
//                str1 = ((MediaStatusRequest) localObject1).getDeviceID();
//            } else if (str2.equalsIgnoreCase("Test")) {
//
//                (localObject1 = new cn.com.fri.axy.sip.message.content.TestMessage(null)).genParameters();
//            } else {
//                SysLogger.info(
//                        getClass() + "\nget type " + str2 + " never parse.");
//                return null;
//            }
//
//            if ((localObject1 instanceof ReqResMessage)) {
//                ((Message) localObject1).setDestid(paramMessageContext);
//                str1 = str1 + ":" + ((Message) localObject1).getSn();
//                ((ReqResMessage) localObject1).setKey(str1);
//                SysLogger.info(getClass() + "\nkey\t" + str1);
//            }
//        } catch (Exception localException) {
//            Object localObject2;
//            SysLogger.printStackTrace(localObject2 = localException);
//            return null;
//        }

        return (Message) localObject1;
    }


    public static void main(String[] paramArrayOfString) {
        String s =  ("<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?><Request xmlns=\"www.axy.fri.com.cn/sip/sipsessionservice/message/xmlparser/alarm\"><Notify><CmdType>Alarm</CmdType><DeviceID>alarmer01</DeviceID><AlarmPriority>high</AlarmPriority><AlarmMethod>110</AlarmMethod><AlarmTime>2007-07-01T09:30:10.5</AlarmTime><Longtitude>116</Longtitude><Latitude>47</Latitude><Info>no infomation!</Info></Notify></Request>").replaceFirst(" xmlns=\".*?\">", ">");        System.out.println(paramArrayOfString);
        System.out.println(paramArrayOfString.getClass().getName());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/entity/MessageHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */