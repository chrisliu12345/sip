package com.git.wuqf.service.common.def.message.content.decoderconfigdownload;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class DecoderHeartBeatParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getInterval() {
        return this.b;
    }

    public void setInterval(String paramString) {
        this.b = paramString;
    }


    public String toString() {
        return

                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "Interval\t" + this.b + "\n";
    }


    public DecoderHeartBeatParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.b = str.substring(str.indexOf("<Interval>") + "<Interval>".length(), str.indexOf("</Interval>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><HeartBeatParam><Interval>心跳间隔</Interval></HeartBeatParam></Response>";
        DecoderHeartBeatParamConfigDownloadResponse localDecoderHeartBeatParamConfigDownloadResponse;
        (localDecoderHeartBeatParamConfigDownloadResponse = new DecoderHeartBeatParamConfigDownloadResponse("")).setXmlContent(s);
        localDecoderHeartBeatParamConfigDownloadResponse.genParameters();
        System.out.println(localDecoderHeartBeatParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderconfigdownload/DecoderHeartBeatParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */