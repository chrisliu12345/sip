package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class CameraMediaSecurityConfigDownloadResponse
        extends ResMessage {
    public static final String Security_COMMON = "COMMON";
    public static final String Security_SAFE = "SAFE";
    private String a;
    private String b;
    private String c;
    private String d;

    public String getMediaSecurity() {
        return this.d;
    }

    public void setMediaSecurity(String paramString) {
        this.d = paramString;
    }

    public String getConfigType() {
        return this.b;
    }

    public void setConfigType(String paramString) {
        this.b = paramString;
    }

    public String getSEQ() {
        return this.c;
    }

    public void setSEQ(String paramString) {
        this.c = paramString;
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.b + "\n" + "SEQ\t" + this.c + "\n" + "MediaSecurity\t" + this.d + "\n";
    }


    public CameraMediaSecurityConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.b = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.c = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));

        this.d = str.substring(str.indexOf("<MediaSecurity>") + "<MediaSecurity>".length(), str.indexOf("</MediaSecurity>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><MediaSecurity> COMMON </MediaSecurity></Response>";


        CameraMediaSecurityConfigDownloadResponse localCameraMediaSecurityConfigDownloadResponse;


        (localCameraMediaSecurityConfigDownloadResponse = new CameraMediaSecurityConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localCameraMediaSecurityConfigDownloadResponse.genParameters();
        System.out.println(localCameraMediaSecurityConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CameraMediaSecurityConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */