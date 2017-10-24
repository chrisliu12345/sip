package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DeviceConfigTimeParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private String d;

    public DeviceConfigTimeParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
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


        sb.append("<TimeParam>\n");

        sb.append("<Date>" + (getDate() != null ? getDate() : "") + "</Date>\n");

        sb.append("<Time>" + (getTime() != null ? getTime() : "") + "</Time>\n");

        sb.append("<AdjustTime>" + (getAdjustTime() != null ? getAdjustTime() : "") + "</AdjustTime>\n");
        sb.append("</TimeParam>\n");
        sb.append("</Query>\n");

        Object localObject = sb.toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent((String) localObject);
    }


    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getDate() {
        return this.b;
    }

    public void setDate(String paramString) {
        this.b = paramString;
    }

    public String getTime() {
        return this.c;
    }

    public void setTime(String paramString) {
        this.c = paramString;
    }

    public String getAdjustTime() {
        return this.d;
    }

    public void setAdjustTime(String paramString) {
        this.d = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/DeviceConfigTimeParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */