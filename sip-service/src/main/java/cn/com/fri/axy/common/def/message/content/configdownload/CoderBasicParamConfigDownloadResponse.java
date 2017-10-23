package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class CoderBasicParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public String getConfigType() {
        return this.g;
    }

    public void setConfigType(String paramString) {
        this.g = paramString;
    }

    public String getSEQ() {
        return this.h;
    }

    public void setSEQ(String paramString) {
        this.h = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.g + "\n" + "SEQ\t" + this.h + "\n" + "Name\t" + this.b + "\n" + "CoderDeviceID\t" + this.c + "\n" + "Description\t" + this.d + "\n" + "Inputs\t" + this.e + "\n" + "Alarms\t" + this.f + "\n";
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

    public String getInputs() {
        return this.e;
    }

    public void setInputs(String paramString) {
        this.e = paramString;
    }

    public String getAlarms() {
        return this.f;
    }

    public void setAlarms(String paramString) {
        this.f = paramString;
    }


    public CoderBasicParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.g = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.h = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));

        str = str.split("<BasicParam>")[1];
        this.b = str.substring(str.indexOf("<Name>") + "<Name>".length(), str.indexOf("</Name>"));
        this.c = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.d = str.substring(str.indexOf("<Description>") + "<Description>".length(), str.indexOf("</Description>"));
        this.e = str.substring(str.indexOf("<Inputs>") + "<Inputs>".length(), str.indexOf("</Inputs>"));
        this.f = str.substring(str.indexOf("<Alarms>") + "<Alarms>".length(), str.indexOf("</Alarms>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>DeviceConfig</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><BasicParam><Name>设备名称</Name><DeviceID>编码器ID </DeviceID><Description>设备描述</Description><Inputs>接入摄像机路数</Inputs><Alarms>接入报警路数</Alarms></Basicparam></Response>";


        CoderBasicParamConfigDownloadResponse localCoderBasicParamConfigDownloadResponse;


        (localCoderBasicParamConfigDownloadResponse = new CoderBasicParamConfigDownloadResponse("")).setXmlContent(s);
        localCoderBasicParamConfigDownloadResponse.genParameters();
        System.out.println(localCoderBasicParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CoderBasicParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */