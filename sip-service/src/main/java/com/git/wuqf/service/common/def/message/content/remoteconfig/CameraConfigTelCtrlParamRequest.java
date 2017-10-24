package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CameraConfigTelCtrlParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Long g;

    public CameraConfigTelCtrlParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = Long.valueOf(0L);
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


        localStringBuffer.append("<TelCtrlParam>\n");

        localStringBuffer.append("<Company>" + (getManufacturer() != null ? getManufacturer() : "") + "</Company>\n");

        localStringBuffer.append("<Model>" + (getModel() != null ? getModel() : "") + "</Model>\n");

        localStringBuffer.append("<ControlProtocol>" + (getControlProtocol() != null ? getControlProtocol() : "") + "</ControlProtocol>\n");

        localStringBuffer.append("<ControlType>" + (getControlType() != null ? getControlType() : "") + "</ControlType>\n");

        localStringBuffer.append("<BaudRate>" + (getBaudRate() != null ? getBaudRate() : "") + "</BaudRate>\n");

        localStringBuffer.append("<Interval>" + (getInterval() != null ? getInterval() : "") + "</Interval>\n");
        localStringBuffer.append("</TelCtrlParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("摄像机遥控设置信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getManufacturer() {
        return this.b;
    }

    public void setManufacturer(String paramString) {
        this.b = paramString;
    }

    public String getModel() {
        return this.c;
    }

    public void setModel(String paramString) {
        this.c = paramString;
    }

    public String getControlProtocol() {
        return this.e;
    }

    public void setControlProtocol(String paramString) {
        this.e = paramString;
    }

    public String getControlType() {
        return this.d;
    }

    public void setControlType(String paramString) {
        this.d = paramString;
    }

    public String getBaudRate() {
        return this.f;
    }

    public void setBaudRate(String paramString) {
        this.f = paramString;
    }

    public Long getInterval() {
        return this.g;
    }

    public void setInterval(Long paramLong) {
        this.g = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CameraConfigTelCtrlParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */