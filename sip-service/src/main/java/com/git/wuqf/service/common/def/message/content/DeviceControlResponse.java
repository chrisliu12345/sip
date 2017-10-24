package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class DeviceControlResponse
        extends ResMessage {
    public static final String ok = "OK";
    public static final String error = "ERROR";
    public String deviceID;
    public String result;

    public DeviceControlResponse(String paramString) {
        super(paramString, "DeviceControl");
    }


    public void genParameters() {
        String str = getXmlContent();
        this.result = str.substring(str.indexOf("<Result>") + "<Result>".length(), str.indexOf("</Result>"));
        this.deviceID = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));
    }


    public void genXmlContent() {
    }


    public String getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(String paramString) {
        this.deviceID = paramString;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String paramString) {
        this.result = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/DeviceControlResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */