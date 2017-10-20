package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

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
        (localObject = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        ((StringBuffer) localObject).append("<Query>\n");

        ((StringBuffer) localObject).append("<CmdType>" + getCmdType() + "</CmdType>\n");

        ((StringBuffer) localObject).append("<SN>" + getSn() + "</SN>\n");

        ((StringBuffer) localObject).append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");


        ((StringBuffer) localObject).append("<TimeParam>\n");

        ((StringBuffer) localObject).append("<Date>" + (getDate() != null ? getDate() : "") + "</Date>\n");

        ((StringBuffer) localObject).append("<Time>" + (getTime() != null ? getTime() : "") + "</Time>\n");

        ((StringBuffer) localObject).append("<AdjustTime>" + (getAdjustTime() != null ? getAdjustTime() : "") + "</AdjustTime>\n");
        ((StringBuffer) localObject).append("</TimeParam>\n");
        ((StringBuffer) localObject).append("</Query>\n");

        Object localObject = ((StringBuffer) localObject).toString();
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