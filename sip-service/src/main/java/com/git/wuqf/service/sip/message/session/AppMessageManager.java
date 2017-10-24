package com.git.wuqf.service.sip.message.session;

import cn.com.fri.axy.common.def.message.content.*;
import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.asyn.AsyncServiceDispatcher;
import com.git.wuqf.service.sip.core.asyn.service.AlarmService;
import com.git.wuqf.service.sip.core.asyn.service.QueryResponseService;
import com.git.wuqf.service.sip.core.asyn.service.TGSAlarmService;
import com.git.wuqf.service.sip.message.content.Message;
import com.git.wuqf.service.sip.message.content.ReqMessage;
import com.git.wuqf.service.sip.message.content.ReqResMessage;
import com.git.wuqf.service.sip.message.entity.MessageHandler;
import com.git.wuqf.service.common.def.message.content.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class AppMessageManager {
    private static AppMessageManager a = new AppMessageManager();
    private Map b;
    private Map c;
    private int d;

    private AppMessageManager() {
        init();
    }


    public void init() {
        this.b = Collections.synchronizedMap(new HashMap());


        this.c = Collections.synchronizedMap(new HashMap());

        this.d = 0;
    }


    public static synchronized AppMessageManager getInstance() {
        return a;
    }


    public void sendReqResMessage(ReqResMessage paramReqResMessage) {
        SysLogger.info(getClass() + "\nsend ReqResMessage");
        if ((paramReqResMessage.isAppRequest()) && (!this.b.containsKey(paramReqResMessage.getSn()))) {
            SysLogger.info(getClass() + "\n发送请求消息");
            this.b.put(paramReqResMessage.getSn(), (ReqMessage) paramReqResMessage);


            ((ReqMessage) paramReqResMessage).startTimer();
            return;
        }

        if (paramReqResMessage.isAppResponse()) {
            SysLogger.info(getClass() + "\n发送响应消息");
            String str = paramReqResMessage.getDestid();
            if ((paramReqResMessage instanceof AlarmResponse)) {
                str = ((AlarmResponse) paramReqResMessage).getDeviceID();
            } else if ((paramReqResMessage instanceof TollgateAlarmResponse)) {
                str = ((TollgateAlarmResponse) paramReqResMessage).getDeviceID();
            }


            str = str + ":" + paramReqResMessage.getSn();
            paramReqResMessage.setKey(str);

            if (!this.c.containsKey(paramReqResMessage.getKey())) {
                SysLogger.info(getClass() + "\ncan not find request.");
                return;
            }

            this.c.remove(paramReqResMessage.getKey());
            SysLogger.info(getClass() + "\nremove ReqResMessage");
            return;
        }


        SysLogger.info(getClass() + "\ndo nothing for ReqResMessage");
    }


    public void doReqResMessage(ReqResMessage paramReqResMessage) {
        SysLogger.info(getClass() + "\ndo ReqResMessage");
        SysLogger.info(getClass() + "\nmessage is request " + paramReqResMessage.isAppRequest());
        SysLogger.info(getClass() + "\nsn " + paramReqResMessage.getSn());
        Object localObject1;
        Object localObject3;
        if (paramReqResMessage.isAppRequest()) {
            SysLogger.info(getClass() + "\n收到请求消息");


            if ((localObject1 = paramReqResMessage.getKey()) == null) {
                SysLogger.info(getClass() + "\nkey is null return");
            }


            SysLogger.info(getClass() + "income message\nkey:" + (String) localObject1);
            if (this.c.containsKey(localObject1)) {


                SysLogger.info(getClass() + "get resend message,return.\nkey:" + (String) localObject1 + ",\t" + "sn:" + this.d);
                return;
            }


            this.c.put(localObject1, (ReqMessage) paramReqResMessage);
            Object localObject2;
            if (paramReqResMessage.getCmdType().equalsIgnoreCase("Alarm")) {

                try {

                    localObject2 = (AlarmRequest) paramReqResMessage;

                    AlarmResponse a = new AlarmResponse(((AlarmRequest) localObject2).getDestid());
                    a.setSn(((AlarmRequest) localObject2).getSn());
                    ((AlarmResponse) a).setDeviceID(((AlarmRequest) localObject2).getDeviceID());
                    ((AlarmResponse) a).setResult("OK");
                    ((AlarmResponse) a).genXmlContent();
                    SysLogger.info(getClass() + "\nsend alarm response.");
                    new MessageHandler().sendMessage((Message) a);

                    new AsyncServiceDispatcher().callService(new AlarmService((AlarmRequest) localObject2));
                    return;

                } catch (Exception localException1) {
                    SysLogger.printStackTrace(localException1);
                    return;
                }
            }

            if (!paramReqResMessage.getCmdType().equalsIgnoreCase("TGSAlarm")) {
                return;
            }
            try {
                localObject2 = (TollgateAlarmRequest) paramReqResMessage;

                TollgateAlarmResponse t = new TollgateAlarmResponse(((TollgateAlarmRequest) localObject2).getDestid());
                t.setDeviceID(((TollgateAlarmRequest) localObject2).getDestid());
                t.setSn(((TollgateAlarmRequest) localObject2).getSn());
                t.setResult("OK");
                new MessageHandler().sendMessage((Message) t);

                new AsyncServiceDispatcher().callService(new TGSAlarmService((TollgateAlarmRequest) localObject2));
                return;

            } catch (Exception localException2) {
                SysLogger.printStackTrace(localException2);
                return;
            }
        }


        if ((paramReqResMessage.isAppResponse()) && (this.b.containsKey(paramReqResMessage.getSn()))) {
            SysLogger.info(getClass() + "\n收到响应消息");


            if ((((localObject1 = (ReqMessage) this.b.get(paramReqResMessage.getSn())) instanceof IRecordListRequest)) && ((paramReqResMessage instanceof IRecordListResponse))) {
                SysLogger.info("deal multi response message.");

                boolean bool;
                if ((bool = ((IRecordListRequest) localObject1).addRecordNum(((IRecordListResponse) paramReqResMessage).getRecordSum(), ((IRecordListResponse) paramReqResMessage).getRecordCurrent()))) {
                    this.b.remove(((ReqMessage) localObject1).getSn());


//                    ((ReqMessage) localObject1).sendOK();
//
//
//
//                            new NotifyObject().setCode(212);
//                    ((NotifyObject) localObject3).setRequset(localObject1);
//                    ((NotifyObject) localObject3).setResponse(paramReqResMessage);


//                    ((ReqMessage) localObject1).fire((NotifyObject) localObject3);
                    return;
                }


                new NotifyObject().setCode(212);
//                setRequset(localObject1);
//                ((NotifyObject) localObject3).setResponse(paramReqResMessage);


//                ((ReqMessage) localObject1).fire((NotifyObject) localObject3);
                return;
            }


            SysLogger.info("deal single response message.");
            this.b.remove(((ReqMessage) localObject1).getSn());


            ((ReqMessage) localObject1).sendOK();

            NotifyObject localNotifyObject;

            (localNotifyObject = new NotifyObject()).setCode(212);
            localNotifyObject.setRequset(localObject1);
            localNotifyObject.setResponse(paramReqResMessage);


            new AsyncServiceDispatcher().callService(new QueryResponseService((ReqMessage) localObject1, localNotifyObject));
            return;
        }


        SysLogger.info(getClass() + "\ndo nothing for ReqResMessage");
    }


    public void reqMessageTimeout(String paramString) {
        SysLogger.info(getClass() + "\ndelete ReqMessage");
        this.b.remove(paramString);
    }


    public synchronized String genSN() {
        if (this.d == Integer.MAX_VALUE) {
            this.d = 0;
        }
        this.d += 1;
        return Integer.toString(this.d);
    }


    public static void main(String[] paramArrayOfString) {
        Integer i = Integer.MAX_VALUE;
        System.out.println(paramArrayOfString);

        i++;
        System.out.println(paramArrayOfString);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/session/AppMessageManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */