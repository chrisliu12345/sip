package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class CameraRecordParamConfigDownloadResponse
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

    public String getConfigType() {
        return this.i;
    }

    public void setConfigType(String paramString) {
        this.i = paramString;
    }

    public String getSEQ() {
        return this.j;
    }

    public void setSEQ(String paramString) {
        this.j = paramString;
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

    public String getVideoFrameRate() {
        return this.c;
    }

    public void setVideoFrameRate(String paramString) {
        this.c = paramString;
    }

    public String getVideoBitRate() {
        return this.d;
    }

    public void setVideoBitRate(String paramString) {
        this.d = paramString;
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

    public String getDays() {
        return this.g;
    }

    public void setDays(String paramString) {
        this.g = paramString;
    }

    public String getPreRecord() {
        return this.h;
    }

    public void setPreRecord(String paramString) {
        this.h = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.i + "\n" + "SEQ\t" + this.j + "\n" + "VideoResolution\t" + this.b + "\n" + "VideoFrameRate\t" + this.c + "\n" + "VideoBitRate\t" + this.d + "\n" + "AudioBitRate\t" + this.e + "\n" + "AudioSampleRate\t" + this.f + "\n" + "Days\t" + this.g + "\n" + "PreRecord\t" + this.h + "\n";
    }


    public CameraRecordParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.i = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.j = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));
        this.b = str.substring(str.indexOf("<VideoResolution>") + "<VideoResolution>".length(), str.indexOf("</VideoResolution>"));
        this.c = str.substring(str.indexOf("<VideoFrameRate>") + "<VideoFrameRate>".length(), str.indexOf("</VideoFrameRate>"));
        this.d = str.substring(str.indexOf("<VideoBitRate>") + "<VideoBitRate>".length(), str.indexOf("</VideoBitRate>"));
        this.e = str.substring(str.indexOf("<AudioBitRate>") + "<AudioBitRate>".length(), str.indexOf("</AudioBitRate>"));
        this.f = str.substring(str.indexOf("<AudioSampleRate>") + "<AudioSampleRate>".length(), str.indexOf("</AudioSampleRate>"));
        this.g = str.substring(str.indexOf("<Days>") + "<Days>".length(), str.indexOf("</Days>"));
        this.h = str.substring(str.indexOf("<PreRecord>") + "<PreRecord>".length(), str.indexOf("</PreRecord>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><RecordParam><VideoResolution>分辨率</VideoResolution><VideoFrameRate>帧率</VideoFrameRate><VideoBitRate>视频码率</VideoBitRate><AudioBitRate>音频码率</AudioBitRate><AudioSampleRate>音频采样率</AudioSampleRate><Days>保存天数</Days><PreRecord>预录时长</PreRecord></RecordParam></Response>";


        CameraRecordParamConfigDownloadResponse localCameraRecordParamConfigDownloadResponse;


        (localCameraRecordParamConfigDownloadResponse = new CameraRecordParamConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localCameraRecordParamConfigDownloadResponse.genParameters();
        System.out.println(localCameraRecordParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CameraRecordParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */