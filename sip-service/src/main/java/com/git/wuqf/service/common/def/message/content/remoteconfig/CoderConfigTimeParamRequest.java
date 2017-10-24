package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigTimeParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private String d;

    public CoderConfigTimeParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
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


        localStringBuffer.append("<TimeParam>\n");

        localStringBuffer.append("<Date>" + (getDate() != null ? getDate() : "") + "</Date>\n");

        localStringBuffer.append("<Time>" + (getTime() != null ? getTime() : "") + "</Time>\n");

        localStringBuffer.append("<AdjustTime>" + (getAdjustTime() != null ? getAdjustTime() : "") + "</AdjustTime>\n");
        localStringBuffer.append("</TimeParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("编码器时间配置信息：" + localStringBuffer.toString());
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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigTimeParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */