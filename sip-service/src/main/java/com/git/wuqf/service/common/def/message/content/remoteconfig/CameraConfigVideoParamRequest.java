package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CameraConfigVideoParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private Long d;
    private String e;
    private Long f;
    private String g;
    private String h;
    private String i;
    private String j;

    public CameraConfigVideoParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = Long.valueOf(0L);
        this.e = "";
        this.f = Long.valueOf(0L);
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
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


        localStringBuffer.append("<VideoParam>\n");

        localStringBuffer.append("<VideoFormat>" + (getVideoFormat() != null ? getVideoFormat() : "") + "</VideoFormat>\n");

        localStringBuffer.append("<Resolution>" + (getResolution() != null ? getResolution() : "") + "</Resolution>\n");

        localStringBuffer.append("<FrameRate>" + (getFrameRate() != null ? getFrameRate() : "") + "</FrameRate>\n");

        localStringBuffer.append("<BitRateType>" + (getBitRateType() != null ? getBitRateType() : "") + "</BitRateType>\n");

        localStringBuffer.append("<VideoBitRate>" + (getVideoBitRate() != null ? getVideoBitRate() : "") + "</VideoBitRate>\n");

        localStringBuffer.append("<AudioBind>" + (getAudioBind() != null ? getAudioBind() : "") + "</AudioBind>\n");

        localStringBuffer.append("<AudioFormat>" + (getAudioFormat() != null ? getAudioFormat() : "") + "</AudioFormat>\n");

        localStringBuffer.append("<AudioBitRate>" + (getAudioBitRate() != null ? getAudioBitRate() : "") + "</AudioBitRate>\n");

        localStringBuffer.append("<AudioSampleRate>" + (getAudioSampleRate() != null ? getAudioSampleRate() : "") + "</AudioSampleRate>\n");
        localStringBuffer.append("</VideoParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("摄像机视频配置信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getVideoFormat() {
        return this.b;
    }

    public void setVideoFormat(String paramString) {
        this.b = paramString;
    }

    public String getResolution() {
        return this.c;
    }

    public void setResolution(String paramString) {
        this.c = paramString;
    }

    public Long getFrameRate() {
        return this.d;
    }

    public void setFrameRate(Long paramLong) {
        this.d = paramLong;
    }

    public String getBitRateType() {
        return this.e;
    }

    public void setBitRateType(String paramString) {
        this.e = paramString;
    }

    public Long getVideoBitRate() {
        return this.f;
    }

    public void setVideoBitRate(Long paramLong) {
        this.f = paramLong;
    }

    public String getAudioFormat() {
        return this.g;
    }

    public void setAudioFormat(String paramString) {
        this.g = paramString;
    }

    public String getAudioBitRate() {
        return this.h;
    }

    public void setAudioBitRate(String paramString) {
        this.h = paramString;
    }

    public String getAudioSampleRate() {
        return this.i;
    }

    public void setAudioSampleRate(String paramString) {
        this.i = paramString;
    }

    public String getAudioBind() {
        return this.j;
    }

    public void setAudioBind(String paramString) {
        this.j = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CameraConfigVideoParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */