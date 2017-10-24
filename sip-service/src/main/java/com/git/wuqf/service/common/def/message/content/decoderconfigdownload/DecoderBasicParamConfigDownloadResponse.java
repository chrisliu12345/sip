package com.git.wuqf.service.common.def.message.content.decoderconfigdownload;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class DecoderBasicParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "Name\t" + this.b + "\n" + "CoderDeviceID\t" + this.c + "\n" + "Description\t" + this.d + "\n" + "Outputs\t" + this.e + "\n";
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getName() {
        return this.b;
    }

    public void setName(String paramString) {
        this.b = paramString;
    }

    public String getCoderDeviceID() {
        return this.c;
    }

    public void setCoderDeviceID(String paramString) {
        this.c = paramString;
    }

    public String getDescription() {
        return this.d;
    }

    public void setDescription(String paramString) {
        this.d = paramString;
    }

    public String getOutputs() {
        return this.e;
    }

    public void setOutputs(String paramString) {
        this.e = paramString;
    }


    public DecoderBasicParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));

        str = str.split("<BasicParam>")[1];
        this.b = str.substring(str.indexOf("<Name>") + "<Name>".length(), str.indexOf("</Name>"));
        this.c = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.d = str.substring(str.indexOf("<Description>") + "<Description>".length(), str.indexOf("</Description>"));
        this.e = str.substring(str.indexOf("<Outputs>") + "<Outputs>".length(), str.indexOf("</Outputs>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>DeviceConfig</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><BasicParam><Name>设备名称</Name><DeviceID>编码器ID </DeviceID><Description>设备描述</Description><Outputs>接入摄像机路数</Outputs></Basicparam></Response>";

        DecoderBasicParamConfigDownloadResponse localDecoderBasicParamConfigDownloadResponse;

        (localDecoderBasicParamConfigDownloadResponse = new DecoderBasicParamConfigDownloadResponse("")).setXmlContent(s);
        localDecoderBasicParamConfigDownloadResponse.genParameters();
        System.out.println(localDecoderBasicParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderconfigdownload/DecoderBasicParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */