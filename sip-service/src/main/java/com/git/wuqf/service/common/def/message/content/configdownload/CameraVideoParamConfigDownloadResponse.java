package com.git.wuqf.service.common.def.message.content.configdownload;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class CameraVideoParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public String getConfigType() {
        return this.j;
    }

    public void setConfigType(String paramString) {
        this.j = paramString;
    }

    public String getSEQ() {
        return this.k;
    }

    public void setSEQ(String paramString) {
        this.k = paramString;
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

    public String getFrameRate() {
        return this.d;
    }

    public void setFrameRate(String paramString) {
        this.d = paramString;
    }

    public String getBitRateType() {
        return this.e;
    }

    public void setBitRateType(String paramString) {
        this.e = paramString;
    }

    public String getVideoBitRate() {
        return this.f;
    }

    public void setVideoBitRate(String paramString) {
        this.f = paramString;
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


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.j + "\n" + "SEQ\t" + this.k + "\n" + "VideoFormat\t" + this.b + "\n" + "Resolution\t" + this.c + "\n" + "FrameRate\t" + this.d + "\n" + "BitRateType\t" + this.e + "\n" + "VideoBitRate\t" + this.f + "\n" + "AudioFormat\t" + this.g + "\n" + "AudioBitRate\t" + this.h + "\n" + "AudioSampleRate\t" + this.i + "\n";
    }


    public CameraVideoParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.j = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.k = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));
        this.b = str.substring(str.indexOf("<VideoFormat>") + "<VideoFormat>".length(), str.indexOf("</VideoFormat>"));
        this.c = str.substring(str.indexOf("<Resolution>") + "<Resolution>".length(), str.indexOf("</Resolution>"));
        this.d = str.substring(str.indexOf("<FrameRate>") + "<FrameRate>".length(), str.indexOf("</FrameRate>"));
        this.e = str.substring(str.indexOf("<BitRateType>") + "<BitRateType>".length(), str.indexOf("</BitRateType>"));
        this.f = str.substring(str.indexOf("<VideoBitRate>") + "<VideoBitRate>".length(), str.indexOf("</VideoBitRate>"));
        this.g = str.substring(str.indexOf("<AudioFormat>") + "<AudioFormat>".length(), str.indexOf("</AudioFormat>"));
        this.h = str.substring(str.indexOf("<AudioBitRate>") + "<AudioBitRate>".length(), str.indexOf("</AudioBitRate>"));
        this.i = str.substring(str.indexOf("<AudioSampleRate>") + "<AudioSampleRate>".length(), str.indexOf("</AudioSampleRate>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><VideoParam><VideoFormat>视频编码格式</VideoFormat><Resolution>分辨率</Resolution><FrameRate>帧率</FrameRate><BitRateType>码率类型</BitRateType><VideoBitRate>码率</VideoBitRate><AudioFormat>音频编码格式</AudioFormat><AudioBitRate>码率</AudioBitRate><AudioSampleRate>采样率</AudioSampleRate></VideoParam></Response>";


        CameraVideoParamConfigDownloadResponse localCameraVideoParamConfigDownloadResponse;


        (localCameraVideoParamConfigDownloadResponse = new CameraVideoParamConfigDownloadResponse("")).setXmlContent(s);
        localCameraVideoParamConfigDownloadResponse.genParameters();
        System.out.println(localCameraVideoParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CameraVideoParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */