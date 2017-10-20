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
        (localObject = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        ((StringBuffer) localObject).append("<Query>\n");

        ((StringBuffer) localObject).append("<CmdType>" + getCmdType() + "</CmdType>\n");

        ((StringBuffer) localObject).append("<SN>" + getSn() + "</SN>\n");

        ((StringBuffer) localObject).append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");


        ((StringBuffer) localObject).append("<NetworkParam>\n");

        ((StringBuffer) localObject).append("<IP>" + (getIP() != null ? getIP() : "") + "</IP>\n");

        ((StringBuffer) localObject).append("<Port>" + (getPort() != null ? getPort() : "") + "</Port>\n");

        ((StringBuffer) localObject).append("<Mask>" + (getMask() != null ? getMask() : "") + "</Mask>\n");

        ((StringBuffer) localObject).append("<Gateway>" + (getGateway() != null ? getGateway() : "") + "</Gateway>\n");

        ((StringBuffer) localObject).append("<ProxyID>" + (getSipServerID() != null ? getSipServerID() : "") + "</ProxyID>\n");

        ((StringBuffer) localObject).append("<ProxyName>" + (getSipDomainName() != null ? getSipDomainName() : "") + "</ProxyName>\n");

        ((StringBuffer) localObject).append("<ProxyIP>" + (getSipserverIP() != null ? getSipserverIP() : "") + "</ProxyIP>\n");

        ((StringBuffer) localObject).append("<ProxyPort>" + (getSipServerPort() != null ? getSipServerPort() : "") + "</ProxyPort>\n");


        ((StringBuffer) localObject).append("</NetworkParam>\n");
        ((StringBuffer) localObject).append("</Query>\n");

        Object localObject = ((StringBuffer) localObject).toString();
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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderremoteconfig/DecoderConfigNetParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */