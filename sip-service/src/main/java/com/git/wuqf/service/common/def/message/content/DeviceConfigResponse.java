package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class DeviceConfigResponse
        extends ResMessage {
    public static final String ok = "OK";
    public static final String error = "ERROR";
    public String deviceID;
    public String result;

    public DeviceConfigResponse(String paramString) {
        super(paramString, "DeviceConfig");
    }


    public void genParameters() {
        String str = getXmlContent();
        this.result = str.substring(str.indexOf("<Result>") + "<Result>".length(), str.indexOf("</Result>"));
        this.deviceID = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));
    }

    public void genXmlContent() {
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/DeviceConfigResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */