package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.util.Observer;


public class GuardDeviceControlRequest
        extends ReqMessage {
    public static final String SetGuard = "SetGuard";
    public static final String ResetGuard = "ResetGuard";
    private String a;
    private String b;

    public GuardDeviceControlRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceControl", paramObserver);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Control>\n");

        localStringBuffer.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

        localStringBuffer.append("<GuardCmd>" + this.b + "</GuardCmd>\n");
        localStringBuffer.append("</Control>\n");
        setXmlContent(localStringBuffer.toString());
    }


    public String getGuardCmd() {
        return this.b;
    }

    public void setGuardCmd(String paramString) {
        this.b = paramString;
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/GuardDeviceControlRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */