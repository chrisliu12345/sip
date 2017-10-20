package cn.com.fri.axy.common.def.message.content.decoderremoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DecoderConfigSecurityParamRequest
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
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;

    public DecoderConfigSecurityParamRequest(String paramString, Observer paramObserver) {
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
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        (localObject = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        ((StringBuffer) localObject).append("<Query>\n");

        ((StringBuffer) localObject).append("<CmdType>" + getCmdType() + "</CmdType>\n");

        ((StringBuffer) localObject).append("<SN>" + getSn() + "</SN>\n");

        ((StringBuffer) localObject).append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");


        ((StringBuffer) localObject).append("<SecurityParam>\n");

        ((StringBuffer) localObject).append("<Expiration>" + (getExpiration() != null ? getExpiration() : "") + "</Expiration>\n");

        ((StringBuffer) localObject).append("<Scert>" + (getScert() != null ? getScert() : "") + "</Scert>\n");

        ((StringBuffer) localObject).append("<UserName>" + (getUserName() != null ? getUserName() : "") + "</UserName>\n");

        ((StringBuffer) localObject).append("<Password>" + (getPassword() != null ? getPassword() : "") + "</Password>\n");

        ((StringBuffer) localObject).append("<SIPSec>" + (getSipSec() != null ? getSipSec() : "") + "</SIPSec>\n");

        ((StringBuffer) localObject).append("<MediaSec>" + (getMediaSec() != null ? getMediaSec() : "") + "</MediaSec>\n");

        ((StringBuffer) localObject).append("<CredibleMedia>\n");

        ((StringBuffer) localObject).append("<Digest>" + (getDigest() != null ? getDigest() : "") + "</Digest>\n");

        ((StringBuffer) localObject).append("<Frame>" + (getFrame() != null ? getFrame() : "") + "</Frame>\n");

        ((StringBuffer) localObject).append("<AsyEncryption>" + (getAsyEncryption() != null ? getAsyEncryption() : "") + "</AsyEncryption>\n");

        ((StringBuffer) localObject).append("<SignData>" + (getMediaSec() != null ? getMediaSec() : "1") + "</SignData>\n");

        ((StringBuffer) localObject).append("</CredibleMedia>\n");

        ((StringBuffer) localObject).append("<EncryptionMedia>\n");

        ((StringBuffer) localObject).append("<AlgorithmPattern>" + (getAlgorithmPattern() != null ? getAlgorithmPattern() : "") + "</AlgorithmPattern>\n");

        ((StringBuffer) localObject).append("<Length>" + (getLength() != null ? getLength() : "") + "</Length>\n");

        ((StringBuffer) localObject).append("<KeyAlgorithmPattern>" + (getKeyAlgorithmPattern() != null ? getKeyAlgorithmPattern() : "") + "</KeyAlgorithmPattern>\n");

        ((StringBuffer) localObject).append("<Key>" + (getKey() != null ? getKey() : "") + "</Key>\n");
        ((StringBuffer) localObject).append("</EncryptionMedia>\n");

        ((StringBuffer) localObject).append("</SecurityParam>\n");
        ((StringBuffer) localObject).append("</Query>\n");

        Object localObject = ((StringBuffer) localObject).toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent((String) localObject);

        SysLogger.info(getClass() + "\n编码器安全参数信息：" + (String) localObject);
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getExpiration() {
        return this.b;
    }

    public void setExpiration(String paramString) {
        this.b = paramString;
    }

    public String getScert() {
        return this.c;
    }

    public void setScert(String paramString) {
        this.c = paramString;
    }

    public String getUserName() {
        return this.d;
    }

    public void setUserName(String paramString) {
        this.d = paramString;
    }

    public String getPassword() {
        return this.e;
    }

    public void setPassword(String paramString) {
        this.e = paramString;
    }

    public String getSipSec() {
        return this.f;
    }

    public void setSipSec(String paramString) {
        this.f = paramString;
    }

    public String getMediaSec() {
        return this.g;
    }

    public void setMediaSec(String paramString) {
        this.g = paramString;
    }

    public String getDigest() {
        return this.h;
    }

    public void setDigest(String paramString) {
        this.h = paramString;
    }

    public String getFrame() {
        return this.i;
    }

    public void setFrame(String paramString) {
        this.i = paramString;
    }

    public String getSignData() {
        return this.j;
    }

    public void setSignData(String paramString) {
        this.j = paramString;
    }

    public String getAsyEncryption() {
        return this.k;
    }

    public void setAsyEncryption(String paramString) {
        this.k = paramString;
    }

    public String getAlgorithmPattern() {
        return this.l;
    }

    public void setAlgorithmPattern(String paramString) {
        this.l = paramString;
    }

    public String getLength() {
        return this.m;
    }

    public void setLength(String paramString) {
        this.m = paramString;
    }

    public String getKeyAlgorithmPattern() {
        return this.n;
    }

    public void setKeyAlgorithmPattern(String paramString) {
        this.n = paramString;
    }

    public String getKey() {
        return this.o;
    }

    public void setKey(String paramString) {
        this.o = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderremoteconfig/DecoderConfigSecurityParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */