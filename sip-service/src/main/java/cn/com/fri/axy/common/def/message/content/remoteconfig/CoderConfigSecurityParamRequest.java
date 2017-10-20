package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigSecurityParamRequest
        extends ReqMessage {
    private String a;
    private Long b;
    private Long c;
    private String d;
    private String e;

    public CoderConfigSecurityParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = Long.valueOf(0L);
        this.c = Long.valueOf(0L);
        this.d = "";
        this.e = "";
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Query>\n");

        localStringBuffer.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");


        localStringBuffer.append("<SecParam>\n");

        localStringBuffer.append("<Expires>" + (getExpires() != null ? getExpires() : "") + "</Expires>\n");

        localStringBuffer.append("<CmdParam>" + (getCmdParam() != null ? getCmdParam() : "") + "</CmdParam>\n");

        localStringBuffer.append("<UserName>" + getUserName() + "</UserName>\n");

        localStringBuffer.append("<Password>" + getPassword() + "</Password>\n");
        localStringBuffer.append("</SecParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("编码器安全配置信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        if (this.a == null) {
            this.a = "";
        }
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public Long getExpires() {
        return this.b;
    }

    public void setExpires(Long paramLong) {
        this.b = paramLong;
    }

    public Long getCmdParam() {
        return this.c;
    }

    public void setCmdParam(Long paramLong) {
        this.c = paramLong;
    }

    public String getUserName() {
        if (this.d == null) {
            this.d = "";
        }
        return this.d;
    }

    public void setUserName(String paramString) {
        this.d = paramString;
    }

    public String getPassword() {
        if (this.e == null) {
            this.e = "";
        }
        return this.e;
    }

    public void setPassword(String paramString) {
        this.e = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigSecurityParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */