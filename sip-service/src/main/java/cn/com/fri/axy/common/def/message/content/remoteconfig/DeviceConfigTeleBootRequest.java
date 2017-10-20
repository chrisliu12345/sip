package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DeviceConfigTeleBootRequest
        extends ReqMessage {
    private String a;

    public DeviceConfigTeleBootRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceControl", paramObserver);
        this.a = "";
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        (localObject = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        ((StringBuffer) localObject).append("<Control>\n");

        ((StringBuffer) localObject).append("<CmdType>" + getCmdType() + "</CmdType>\n");

        ((StringBuffer) localObject).append("<SN>" + getSn() + "</SN>\n");

        ((StringBuffer) localObject).append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

        ((StringBuffer) localObject).append("<TeleBoot>Boot</TeleBoot>\n");
        ((StringBuffer) localObject).append("</Control>\n");

        Object localObject = ((StringBuffer) localObject).toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }
        SysLogger.info("设备复位\n" + (String) localObject);
        setXmlContent((String) localObject);
    }

    public String getDeviceID() {
        if (this.a == null) {
            this.a = "";
        }
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/DeviceConfigTeleBootRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */