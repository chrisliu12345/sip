package cn.com.fri.axy.sip.interfaces;

import cn.com.fri.axy.common.def.message.content.PTZDeviceControlRequest;
import cn.com.fri.axy.common.def.message.content.remoteconfig.DeviceConfigTeleBootRequest;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.exception.MessageException;
import cn.com.fri.axy.sip.message.content.Message;
import cn.com.fri.axy.sip.message.entity.MessageHandler;
import cn.com.fri.axy.sip.util.purview.PurviewHelper;

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
