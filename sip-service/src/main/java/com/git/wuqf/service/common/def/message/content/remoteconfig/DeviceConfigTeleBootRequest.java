package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DeviceConfigTeleBootRequest
        extends ReqMessage {
    private String a;

    public DeviceConfigTeleBootRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceControl", paramObserver);
        this.a = "";
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\"?>\n");
        sb.append("<Control>\n");

        sb.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        sb.append("<SN>" + getSn() + "</SN>\n");

        sb.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

        sb.append("<TeleBoot>Boot</TeleBoot>\n");
        sb.append("</Control>\n");

        Object localObject = sb.toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }
        SysLogger.info("设备复位\n" + (String) localObject);
        setXmlContent((String) localObject);
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
}
