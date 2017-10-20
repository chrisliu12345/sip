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
            new MessageHandler().sendMessage(paramMessage);
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            SysLogger.printStackTrace(this = localIllegalArgumentException);
            return;
        } catch (MessageException localMessageException) {
            SysLogger.printStackTrace(this = localMessageException);
        }
    }


    public void deviceReboot(String paramString, Observer paramObserver) {
        SysLogger.info("deviceReboot");


        (
                paramObserver = new DeviceConfigTeleBootRequest(paramString, paramObserver)).setDeviceID(paramString);

        sendMessage(paramObserver);
    }


    public void sendPTZMessage(Message paramMessage, String paramString1, String paramString2, int paramInt) {
        SysLogger.info("start ptz control");

        if (!(paramMessage instanceof PTZDeviceControlRequest)) {
            return;
        }

        this = PurviewHelper.getInstance().getPurviewBeanFromParam(paramString1, paramString2, ((PTZDeviceControlRequest) paramMessage).getDeviceID(), "ptz", Integer.toString(paramInt));
        paramMessage.setPurviewBean(this);

        try {
            MessageHandler.getInstance().sendMessage(paramMessage);
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            SysLogger.printStackTrace(this = localIllegalArgumentException);
            return;
        } catch (MessageException localMessageException) {
            SysLogger.printStackTrace(this = localMessageException);
        }
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/interfaces/DirectAccessBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */