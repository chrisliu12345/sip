package com.git.wuqf.service.common.def.message.content.configdownload;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class CoderNetworkParamConfigDownloadResponse
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


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.j + "\n" + "SEQ\t" + this.k + "\n" + "IP\t" + this.b + "\n" + "Port\t" + this.c + "\n" + "Mask\t" + this.d + "\n" + "Gateway\t" + this.e + "\n" + "ProxyID\t" + this.f + "\n" + "ProxyIP\t" + this.g + "\n" + "ProxyPort\t" + this.h + "\n" + "ProxyName\t" + this.i + "\n";
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getIP() {
        return this.b;
    }

    public void setIP(String paramString) {
        this.b = paramString;
    }

    public String getPort() {
        return this.c;
    }

    public void setPort(String paramString) {
        this.c = paramString;
    }

    public String getMask() {
        return this.d;
    }

    public void setMask(String paramString) {
        this.d = paramString;
    }

    public String getGateway() {
        return this.e;
    }

    public void setGateway(String paramString) {
        this.e = paramString;
    }

    public String getProxyID() {
        return this.f;
    }

    public void setProxyID(String paramString) {
        this.f = paramString;
    }

    public String getProxyIP() {
        return this.g;
    }

    public void setProxyIP(String paramString) {
        this.g = paramString;
    }

    public String getProxyPort() {
        return this.h;
    }

    public void setProxyPort(String paramString) {
        this.h = paramString;
    }

    public String getProxyName() {
        return this.i;
    }

    public void setProxyName(String paramString) {
        this.i = paramString;
    }


    public CoderNetworkParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.j = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.k = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));
        this.b = str.substring(str.indexOf("<IP>") + "<IP>".length(), str.indexOf("</IP>"));
        this.c = str.substring(str.indexOf("<Port>") + "<Port>".length(), str.indexOf("</Port>"));
        this.d = str.substring(str.indexOf("<Mask>") + "<Mask>".length(), str.indexOf("</Mask>"));
        this.e = str.substring(str.indexOf("<Gateway>") + "<Gateway>".length(), str.indexOf("</Gateway>"));
        this.f = str.substring(str.indexOf("<ProxyID>") + "<ProxyID>".length(), str.indexOf("</ProxyID>"));
        this.g = str.substring(str.indexOf("<ProxyIP>") + "<ProxyIP>".length(), str.indexOf("</ProxyIP>"));
        this.h = str.substring(str.indexOf("<ProxyPort>") + "<ProxyPort>".length(), str.indexOf("</ProxyPort>"));
        this.i = str.substring(str.indexOf("<ProxyName>") + "<ProxyName>".length(), str.indexOf("</ProxyName>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><NetworkParam><IP>IP地址</IP><Port>端口</Port><Mask>子网掩码</Mask><Gateway>网关</Gateway><ProxyID>SIP服务器ID</ProxyID><ProxyIP>SIP服务器的IP</ProxyIP><ProxyPort> SIP服务器的端口</ProxyPort><ProxyName>SIP服务器域名</ProxyName></NetworkParam></Response>";


        CoderNetworkParamConfigDownloadResponse localCoderNetworkParamConfigDownloadResponse;


        (localCoderNetworkParamConfigDownloadResponse = new CoderNetworkParamConfigDownloadResponse("")).setXmlContent(s);
        localCoderNetworkParamConfigDownloadResponse.genParameters();
        System.out.println(localCoderNetworkParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CoderNetworkParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */