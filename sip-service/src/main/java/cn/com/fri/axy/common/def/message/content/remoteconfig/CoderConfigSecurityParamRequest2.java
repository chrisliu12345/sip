package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigSecurityParamRequest2
        extends ReqMessage {
    private String a;
    private Long b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Long g;
    private String h;
    private String i;
    private String j;
    private Long k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;

    public CoderConfigSecurityParamRequest2(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = Long.valueOf(0L);
        this.c = "";
        this.g = Long.valueOf(0L);
        this.d = "";
        this.e = "";
        this.f = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = Long.valueOf(1L);
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
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

        ((StringBuffer) localObject).append("<SIPSec>" + (getlSIPSec() != null ? getlSIPSec() : "") + "</SIPSec>\n");

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

    public Long getExpiration() {
        return this.b;
    }

    public void setExpiration(Long paramLong) {
        this.b = paramLong;
    }

    public String getScert() {
        return this.c;
    }

    public void setScert(String paramString) {
        this.c = paramString;
    }

    public Long getlSIPSec() {
        return this.g;
    }

    public void setlSIPSec(Long paramLong) {
        this.g = paramLong;
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
        return this.h;
    }

    public void setMediaSec(String paramString) {
        this.h = paramString;
    }

    public String getDigest() {
        return this.i;
    }

    public void setDigest(String paramString) {
        this.i = paramString;
    }

    public String getFrame() {
        return this.j;
    }

    public void setFrame(String paramString) {
        this.j = paramString;
    }

    public Long getSignDataLen() {
        return this.k;
    }

    public void setSignDataLen(Long paramLong) {
        this.k = paramLong;
    }

    public String getAsyEncryption() {
        return this.l;
    }

    public void setAsyEncryption(String paramString) {
        this.l = paramString;
    }

    public String getAlgorithmPattern() {
        return this.m;
    }

    public void setAlgorithmPattern(String paramString) {
        this.m = paramString;
    }

    public String getLength() {
        return this.n;
    }

    public void setLength(String paramString) {
        this.n = paramString;
    }

    public String getKeyAlgorithmPattern() {
        return this.o;
    }

    public void setKeyAlgorithmPattern(String paramString) {
        this.o = paramString;
    }

    public String getKey() {
        return this.p;
    }

    public void setKey(String paramString) {
        this.p = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigSecurityParamRequest2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */