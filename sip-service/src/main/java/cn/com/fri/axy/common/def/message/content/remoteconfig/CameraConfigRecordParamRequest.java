package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CameraConfigRecordParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private Long c;
    private Long d;
    private String e;
    private String f;
    private Long g;
    private Long h;

    public CameraConfigRecordParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = Long.valueOf(0L);
        this.d = Long.valueOf(0L);
        this.e = "";
        this.f = "";
        this.g = Long.valueOf(0L);
        this.h = Long.valueOf(0L);
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


        localStringBuffer.append("<RecordParam>\n");

        localStringBuffer.append("<VideoResolution>" + (getVideoResolution() != null ? getVideoResolution() : "") + "</VideoResolution>\n");

        localStringBuffer.append("<VideoFrameRate>" + (getVideoFrameRate() != null ? getVideoFrameRate() : "") + "</VideoFrameRate>\n");

        localStringBuffer.append("<VideoBitRate>" + (getVideoBitRate() != null ? getVideoBitRate() : "") + "</VideoBitRate>\n");

        localStringBuffer.append("<AudioBitRate>" + (getAudioBitRate() != null ? getAudioBitRate() : "") + "</AudioBitRate>\n");

        localStringBuffer.append("<AudioSampleRate>" + (getAudioSampleRate() != null ? getAudioSampleRate() : "") + "</AudioSampleRate>\n");

        localStringBuffer.append("<Days>" + (getDays() != null ? getDays() : "") + "</Days>\n");

        localStringBuffer.append("<PreRecord>" + (getPreRecord() != null ? getPreRecord() : "") + "</PreRecord>\n");
        localStringBuffer.append("</RecordParam>\n");
        localStringBuffer.append("</Query>\n");
        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("摄像机录像参数信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getVideoResolution() {
        return this.b;
    }

    public void setVideoResolution(String paramString) {
        this.b = paramString;
    }

    public Long getVideoFrameRate() {
        return this.c;
    }

    public void setVideoFrameRate(Long paramLong) {
        this.c = paramLong;
    }

    public Long getVideoBitRate() {
        return this.d;
    }

    public void setVideoBitRate(Long paramLong) {
        this.d = paramLong;
    }

    public String getAudioBitRate() {
        return this.e;
    }

    public void setAudioBitRate(String paramString) {
        this.e = paramString;
    }

    public String getAudioSampleRate() {
        return this.f;
    }

    public void setAudioSampleRate(String paramString) {
        this.f = paramString;
    }

    public Long getDays() {
        return this.g;
    }

    public void setDays(Long paramLong) {
        this.g = paramLong;
    }

    public Long getPreRecord() {
        return this.h;
    }

    public void setPreRecord(Long paramLong) {
        this.h = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CameraConfigRecordParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */