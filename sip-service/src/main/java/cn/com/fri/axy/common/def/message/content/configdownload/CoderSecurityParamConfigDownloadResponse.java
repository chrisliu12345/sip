package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class CoderSecurityParamConfigDownloadResponse
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
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;

    public String getEncryptionMedia_KeyAlgorithmPattern() {
        return this.n;
    }


    public void setEncryptionMedia_KeyAlgorithmPattern(String paramString) {
        this.n = paramString;
    }

    public String getConfigType() {
        return this.p;
    }

    public void setConfigType(String paramString) {
        this.p = paramString;
    }

    public String getSEQ() {
        return this.q;
    }

    public void setSEQ(String paramString) {
        this.q = paramString;
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


    public String getSIPSec() {
        return this.f;
    }


    public void setSIPSec(String paramString) {
        this.f = paramString;
    }


    public String getMediaSec() {
        return this.g;
    }


    public void setMediaSec(String paramString) {
        this.g = paramString;
    }


    public String getCredibleMedia_Digest() {
        return this.h;
    }


    public void setCredibleMedia_Digest(String paramString) {
        this.h = paramString;
    }


    public String getCredibleMedia_Frame() {
        return this.i;
    }


    public void setCredibleMedia_Frame(String paramString) {
        this.i = paramString;
    }


    public String getCredibleMedia_AsyEncryption() {
        return this.j;
    }


    public void setCredibleMedia_AsyEncryption(String paramString) {
        this.j = paramString;
    }


    public String getCredibleMedia_SignData() {
        return this.k;
    }


    public void setCredibleMedia_SignData(String paramString) {
        this.k = paramString;
    }


    public String getEncryptionMedia_AlgorithmPattern() {
        return this.l;
    }


    public void setEncryptionMedia_AlgorithmPattern(String paramString) {
        this.l = paramString;
    }


    public String getEncryptionMedia_Length() {
        return this.m;
    }


    public void setEncryptionMedia_Length(String paramString) {
        this.m = paramString;
    }


    public String getEncryptionMedia_Key() {
        return this.o;
    }


    public void setEncryptionMedia_Key(String paramString) {
        this.o = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.p + "\n" + "SEQ\t" + this.q + "\n" + "Expiration\t" + this.b + "\n" + "Scert\t" + this.c + "\n" + "UserName\t" + this.d + "\n" + "Password\t" + this.e + "\n" + "SIPSec\t" + this.f + "\n" + "MediaSec\t" + this.g + "\n" + "CredibleMedia_Digest\t" + this.h + "\n" + "CredibleMedia_Frame\t" + this.i + "\n" + "CredibleMedia_AsyEncryption\t" + this.j + "\n" + "CredibleMedia_SignData\t" + this.k + "\n" + "EncryptionMedia_AlgorithmPattern\t" + this.l + "\n" + "EncryptionMedia_Length\t" + this.m + "\n" + "EncryptionMedia_KeyAlgorithmPattern\t" + this.n + "\n" + "EncryptionMedia_Key\t" + this.o + "\n";
    }


    public CoderSecurityParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.p = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.q = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));
        this.b = str.substring(str.indexOf("<Expiration>") + "<Expiration>".length(), str.indexOf("</Expiration>"));
        this.c = str.substring(str.indexOf("<Scert>") + "<Scert>".length(), str.indexOf("</Scert>"));
        this.d = str.substring(str.indexOf("<UserName>") + "<UserName>".length(), str.indexOf("</UserName>"));
        this.e = str.substring(str.indexOf("<Password>") + "<Password>".length(), str.indexOf("</Password>"));
        this.f = str.substring(str.indexOf("<SIPSec>") + "<SIPSec>".length(), str.indexOf("</SIPSec>"));
        this.g = str.substring(str.indexOf("<MediaSec>") + "<MediaSec>".length(), str.indexOf("</MediaSec>"));
        this.h = str.substring(str.indexOf("<Digest>") + "<Digest>".length(), str.indexOf("</Digest>"));
        this.i = str.substring(str.indexOf("<Frame>") + "<Frame>".length(), str.indexOf("</Frame>"));
        this.j = str.substring(str.indexOf("<AsyEncryption>") + "<AsyEncryption>".length(), str.indexOf("</AsyEncryption>"));
        this.k = str.substring(str.indexOf("<SignData>") + "<SignData>".length(), str.indexOf("</SignData>"));
        this.l = str.substring(str.indexOf("<AlgorithmPattern>") + "<AlgorithmPattern>".length(), str.indexOf("</AlgorithmPattern>"));
        this.m = str.substring(str.indexOf("<Length>") + "<Length>".length(), str.indexOf("</Length>"));
        this.n = str.substring(str.indexOf("<KeyAlgorithmPattern>") + "<KeyAlgorithmPattern>".length(), str.indexOf("</KeyAlgorithmPattern>"));
        this.o = str.substring(str.indexOf("<Key>") + "<Key>".length(), str.indexOf("</Key>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><SecurityParam><Expiration>1</Expiration><Scert>2</Scert><UserName>3</UserName><Password>4</Password><SIPSec>5</SIPSec><MediaSec>6</MediaSec><CredibleMedia><Digest>7</Digest><Frame>8</Frame><Signature>9</Signature><SignData>0</SignData></CredibleMedia><EncryptionMedia><AlgorithmPattern>11</AlgorithmPattern><Length>111</Length><Key>1111</Key></EncryptionMedia></SecurityParam></Response>";


        CoderSecurityParamConfigDownloadResponse localCoderSecurityParamConfigDownloadResponse;


        (localCoderSecurityParamConfigDownloadResponse = new CoderSecurityParamConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localCoderSecurityParamConfigDownloadResponse.genParameters();
        System.out.println(localCoderSecurityParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CoderSecurityParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */