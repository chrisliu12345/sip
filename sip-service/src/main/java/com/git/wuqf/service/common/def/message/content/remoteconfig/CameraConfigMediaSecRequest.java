package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CameraConfigMediaSecRequest
        extends ReqMessage {
    private String a;
    private String b;

    public CameraConfigMediaSecRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
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


        localStringBuffer.append("<MediaSecurity>" + (getMediaSecurity() != null ? getMediaSecurity() : "") + "</MediaSecurity>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(localStringBuffer.toString().getBytes(""), "utf-8");
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + "字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info(getClass() + "摄像机安全参数信息：" + str);
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getMediaSecurity() {
        return this.b;
    }

    public void setMediaSecurity(String paramString) {
        this.b = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CameraConfigMediaSecRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */