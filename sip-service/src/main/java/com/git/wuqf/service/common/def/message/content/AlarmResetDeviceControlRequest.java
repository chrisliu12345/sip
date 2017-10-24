package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.util.Observer;


public class AlarmResetDeviceControlRequest
        extends ReqMessage {
    public static final String AlarmReset = "ResetAlarm";
    private String a;
    private String b;
    private String c;
    private String d;

    public String getAlarmMethod() {
        return this.b;
    }

    public void setAlarmMethod(String paramString) {
        this.b = paramString;
    }

    public String getAlarmType() {
        return this.c;
    }

    public void setAlarmType(String paramString) {
        this.c = paramString;
    }

    public String getSourceID() {
        return this.d;
    }

    public void setSourceID(String paramString) {
        this.d = paramString;
    }


    public AlarmResetDeviceControlRequest(String paramString, Observer paramObserver) {
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

        localStringBuffer.append("<AlarmCmd>ResetAlarm</AlarmCmd>\n");
        localStringBuffer.append("<Info>\n");
        localStringBuffer.append("<AlarmMethod>" + this.b + "</AlarmMethod>\n");
        if ((getAlarmType() != null) && (getAlarmType().length() > 0)) {
            localStringBuffer.append("<AlarmType>" + getAlarmType() + "</AlarmType>\n");
        }
        if ((getSourceID() != null) && (getSourceID().length() > 0)) {
            localStringBuffer.append("<SourceID>" + getSourceID() + "</SourceID>\n");
        }
        localStringBuffer.append("</Info>\n");
        localStringBuffer.append("</Control>\n");
        setXmlContent(localStringBuffer.toString());
    }


    public static void main(String[] paramArrayOfString) {
    }


    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/AlarmResetDeviceControlRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */