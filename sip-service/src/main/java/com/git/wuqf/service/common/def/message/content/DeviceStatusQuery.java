package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.util.Observer;


public class DeviceStatusQuery
        extends ReqMessage {
    private String a;

    public DeviceStatusQuery(String paramString, Observer paramObserver) {
        super(paramString, "DeviceStatus", paramObserver);
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
        localStringBuffer.append("</Query>\n");
        setXmlContent(localStringBuffer.toString());
    }


    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }
}
