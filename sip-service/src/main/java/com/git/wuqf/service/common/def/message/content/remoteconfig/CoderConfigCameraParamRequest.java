package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigCameraParamRequest
        extends ReqMessage {
    private String a;
    private Long b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;

    public CoderConfigCameraParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = Long.valueOf(0L);
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
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


        localStringBuffer.append("<CameraParam>\n");
        localStringBuffer.append("<Item>\n");

        localStringBuffer.append("<Channel>" + getChannel() + "</Channel>\n");

        localStringBuffer.append("<Name>" + getCameraName() + "</Name>\n");

        localStringBuffer.append("<DeviceID>" + getCameraID() + "</DeviceID>\n");

        localStringBuffer.append("<Description>" + getdeviceDecription() + "</Description>\n");

        localStringBuffer.append("<Osd>" + getOsd() + "</Osd>\n");
        localStringBuffer.append("</Item>\n");
        localStringBuffer.append("</CameraParam>\n");

        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("接入摄像机基本参数信息：" + localStringBuffer.toString());
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

    public Long getChannel() {
        return this.b;
    }

    public void setChannel(Long paramLong) {
        this.b = paramLong;
    }

    public String getCameraName() {
        if (this.c == null) {
            this.c = "";
        }
        return this.c;
    }

    public void setCameraName(String paramString) {
        this.c = paramString;
    }

    public String getCameraID() {
        if (this.d == null) {
            this.d = "";
        }
        return this.d;
    }

    public void setCameraID(String paramString) {
        this.d = paramString;
    }

    public String getdeviceDecription() {
        if (this.e == null) {
            this.e = "";
        }
        return this.e;
    }

    public void setdeviceDecription(String paramString) {
        this.e = paramString;
    }

    public String getOsd() {
        if (this.f == null) {
            this.f = "";
        }
        return this.f;
    }

    public void setOsd(String paramString) {
        this.f = paramString;
    }

    public int getNum() {
        return this.g;
    }

    public void setNum(int paramInt) {
        this.g = paramInt;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigCameraParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */