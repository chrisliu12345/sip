package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigAlarmParamRequest
        extends ReqMessage {
    private String a;
    private Long b;
    private String c;
    private String d;
    private String e;
    private Long f;

    public CoderConfigAlarmParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = Long.valueOf(0L);
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = Long.valueOf(0L);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Query>\n");

        localStringBuffer.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");


        localStringBuffer.append("<AlarmChannelParam>\n");
        localStringBuffer.append("<Item>\n");

        localStringBuffer.append("<Channel>" + (getAlarmChannel() != null ? getAlarmChannel() : "") + "</Channel>\n");

        localStringBuffer.append("<Name>" + (getDeviceName() != null ? getDeviceName() : "") + "</Name>\n");

        localStringBuffer.append("<DeviceID>" + (getAlarmID() != null ? getAlarmID() : "") + "</DeviceID>\n");

        localStringBuffer.append("<Description>" + (getDescription() != null ? getDescription() : "") + "</Description>\n");

        localStringBuffer.append("<AlarmLevel>" + (getAlarmLevel() != null ? getAlarmLevel() : "") + "</AlarmLevel>\n");
        localStringBuffer.append("</Item>\n");
        localStringBuffer.append("</AlarmChannelParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("接入报警器基本参数信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public Long getAlarmChannel() {
        return this.b;
    }

    public void setAlarmChannel(Long paramLong) {
        this.b = paramLong;
    }

    public String getDeviceName() {
        return this.c;
    }

    public void setDeviceName(String paramString) {
        this.c = paramString;
    }

    public String getAlarmID() {
        return this.d;
    }

    public void setAlarmID(String paramString) {
        this.d = paramString;
    }

    public String getDescription() {
        return this.e;
    }

    public void setDescription(String paramString) {
        this.e = paramString;
    }

    public Long getAlarmLevel() {
        return this.f;
    }

    public void setAlarmLevel(Long paramLong) {
        this.f = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigAlarmParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */