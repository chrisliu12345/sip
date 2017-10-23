package cn.com.fri.axy.common.def.message.content.decoderremoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DecoderConfigNetParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public DecoderConfigNetParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\"?>\n");
        sb.append("<Query>\n");

        sb.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        sb.append("<SN>" + getSn() + "</SN>\n");

        sb.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");


        sb.append("<NetworkParam>\n");

        sb.append("<IP>" + (getIP() != null ? getIP() : "") + "</IP>\n");

        sb.append("<Port>" + (getPort() != null ? getPort() : "") + "</Port>\n");

        sb.append("<Mask>" + (getMask() != null ? getMask() : "") + "</Mask>\n");

        sb.append("<Gateway>" + (getGateway() != null ? getGateway() : "") + "</Gateway>\n");

        sb.append("<ProxyID>" + (getSipServerID() != null ? getSipServerID() : "") + "</ProxyID>\n");

        sb.append("<ProxyName>" + (getSipDomainName() != null ? getSipDomainName() : "") + "</ProxyName>\n");

        sb.append("<ProxyIP>" + (getSipserverIP() != null ? getSipserverIP() : "") + "</ProxyIP>\n");

        sb.append("<ProxyPort>" + (getSipServerPort() != null ? getSipServerPort() : "") + "</ProxyPort>\n");


        sb.append("</NetworkParam>\n");
        sb.append("</Query>\n");

        Object localObject = sb.toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent((String) localObject);

        SysLogger.info("编码器网络配置信息：" + (String) localObject);
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

    public String getSipServerID() {
        return this.f;
    }

    public void setSipServerID(String paramString) {
        this.f = paramString;
    }

    public String getSipDomainName() {
        return this.g;
    }

    public void setSipDomainName(String paramString) {
        this.g = paramString;
    }

    public String getSipserverIP() {
        return this.h;
    }

    public void setSipServerIP(String paramString) {
        this.h = paramString;
    }

    public String getSipServerPort() {
        return this.i;
    }

    public void setSipServerPort(String paramString) {
        this.i = paramString;
    }
}
