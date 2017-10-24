package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigCameraParamRequest2
        extends ReqMessage {
    private String a;
    private Long[] b;
    private String[] c;
    private String[] d;
    private String[] e;
    private String[] f;
    private int g;

    public CoderConfigCameraParamRequest2(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
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
        for (int i = 0; i < this.g; i++) {
            localStringBuffer.append("<Item>\n");

            localStringBuffer.append("<Channel>" + (getChannels()[i] != null ? getChannels()[i] : "") + "</Channel>\n");

            localStringBuffer.append("<Name>" + (getCameraNames()[i] != null ? getCameraNames()[i] : "") + "</Name>\n");

            localStringBuffer.append("<DeviceID>" + (getCameraIDs()[i] != null ? getCameraIDs()[i] : "") + "</DeviceID>\n");

            localStringBuffer.append("<Description>" + (getdeviceDecriptions()[i] != null ? getdeviceDecriptions()[i] : "") + "</Description>\n");

            localStringBuffer.append("<Osd>" + (getOsds()[i] != null ? getOsds()[i] : "") + "</Osd>\n");
            localStringBuffer.append("</Item>\n");
        }
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
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public Long[] getChannels() {
        return this.b;
    }

    public void setChannels(Long[] paramArrayOfLong) {
        this.b = paramArrayOfLong;
    }

    public String[] getCameraNames() {
        return this.c;
    }

    public void setCameraNames(String[] paramArrayOfString) {
        this.c = paramArrayOfString;
    }

    public String[] getCameraIDs() {
        return this.d;
    }

    public void setCameraIDs(String[] paramArrayOfString) {
        this.d = paramArrayOfString;
    }

    public String[] getdeviceDecriptions() {
        return this.e;
    }

    public void setdeviceDecriptions(String[] paramArrayOfString) {
        this.e = paramArrayOfString;
    }

    public String[] getOsds() {
        return this.f;
    }

    public void setOsds(String[] paramArrayOfString) {
        this.f = paramArrayOfString;
    }

    public int getNum() {
        return this.g;
    }

    public void setNum(int paramInt) {
        this.g = paramInt;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigCameraParamRequest2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */