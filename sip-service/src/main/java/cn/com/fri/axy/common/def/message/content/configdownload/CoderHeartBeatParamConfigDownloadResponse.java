package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class CoderHeartBeatParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;

    public String getConfigType() {
        return this.c;
    }

    public void setConfigType(String paramString) {
        this.c = paramString;
    }

    public String getSEQ() {
        return this.d;
    }

    public void setSEQ(String paramString) {
        this.d = paramString;
    }

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


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.c + "\n" + "SEQ\t" + this.d + "\n" + "Interval\t" + this.b + "\n";
    }


    public CoderHeartBeatParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.c = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.d = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));
        this.b = str.substring(str.indexOf("<Interval>") + "<Interval>".length(), str.indexOf("</Interval>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型sf </ConfigType><SEQ>配置项序号 </SEQ><HeartBeatParam><Interval>心跳间隔</Interval></HeartBeatParam></Response>";


        CoderHeartBeatParamConfigDownloadResponse localCoderHeartBeatParamConfigDownloadResponse;


        (localCoderHeartBeatParamConfigDownloadResponse = new CoderHeartBeatParamConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localCoderHeartBeatParamConfigDownloadResponse.genParameters();
        System.out.println(localCoderHeartBeatParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CoderHeartBeatParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */