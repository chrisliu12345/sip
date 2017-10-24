package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigBasicParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private Long e;
    private Long f;

    public CoderConfigBasicParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.c = "";
        this.d = "";
        this.e = Long.valueOf(0L);
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

        localStringBuffer.append("<DeviceID>" + getDestDeviceID() + "</DeviceID>\n");


        localStringBuffer.append("<BasicParam>\n");

        localStringBuffer.append("<Name>" + (getDeviceName() != null ? getDeviceName() : "") + "</Name>\n");

        localStringBuffer.append("<DeviceID>" + (getDeviceID() != null ? getDeviceID() : "") + "</DeviceID>\n");

        localStringBuffer.append("<Description>" + (getDescription() != null ? getDescription() : "") + "</Description>\n");

        localStringBuffer.append("<Inputs>" + (getCameraNumber() != null ? getCameraNumber() : "") + "</Inputs>\n");


        localStringBuffer.append("<Alarms>" + (getAlarmNumber() != null ? getAlarmNumber() : "") + "</Alarms>\n");
        localStringBuffer.append("</BasicParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("编码器基本参数配置信息：" + localStringBuffer.toString());
    }

    public String getDeviceName() {
        return this.a;
    }

    public void setDeviceName(String paramString) {
        this.a = paramString;
    }

    public String getDeviceID() {
        return this.c;
    }

    public void setDeviceID(String paramString) {
        this.c = paramString;
    }

    public void setDestDeviceID(String paramString) {
        this.b = paramString;
    }

    public String getDestDeviceID() {
        return this.b;
    }

    public String getDescription() {
        return this.d;
    }

    public void setDescription(String paramString) {
        this.d = paramString;
    }

    public Long getCameraNumber() {
        return this.e;
    }

    public void setCameraNumber(Long paramLong) {
        this.e = paramLong;
    }

    public Long getAlarmNumber() {
        return this.f;
    }

    public void setAlarmNumber(Long paramLong) {
        this.f = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigBasicParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */