package com.git.wuqf.service.sip.interfaces;

import com.git.wuqf.service.common.def.message.content.PTZDeviceControlRequest;
import com.git.wuqf.service.common.def.message.content.remoteconfig.DeviceConfigTeleBootRequest;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.exception.MessageException;
import com.git.wuqf.service.sip.message.content.Message;
import com.git.wuqf.service.sip.message.entity.MessageHandler;
import com.git.wuqf.service.sip.util.purview.PurviewHelper;

import java.util.Observer;


public class DirectAccessBean {
    public static DirectAccessBean bean = new DirectAccessBean();


    public void sendMessage(Message paramMessage) {
        try {
            MessageHandler handler = new MessageHandler();
            try {
                handler.sendMessage(paramMessage);
            } catch (MessageException e) {
                e.printStackTrace();
            }
        } catch (IllegalArgumentException localIllegalArgumentException) {
            SysLogger.printStackTrace(localIllegalArgumentException);
        }
    }


    public void deviceReboot(String paramString, Observer paramObserver) {
        SysLogger.info("deviceReboot");
        DeviceConfigTeleBootRequest d = new DeviceConfigTeleBootRequest(paramString, paramObserver);
        d.setDeviceID(paramString);
        sendMessage(d);
    }


    public void sendPTZMessage(Message paramMessage, String paramString1, String paramString2, int paramInt) {
        SysLogger.info("start ptz control");

        if (!(paramMessage instanceof PTZDeviceControlRequest)) {
            return;
        }

        PurviewHelper.getInstance().getPurviewBeanFromParam(paramString1, paramString2, ((PTZDeviceControlRequest) paramMessage).getDeviceID(), "ptz", Integer.toString(paramInt));
        paramMessage.setPurviewBean(null);

        try {
            MessageHandler.getInstance().sendMessage(paramMessage);
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            SysLogger.printStackTrace(localIllegalArgumentException);
            return;
        } catch (MessageException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] paramArrayOfString) {
    }
}
