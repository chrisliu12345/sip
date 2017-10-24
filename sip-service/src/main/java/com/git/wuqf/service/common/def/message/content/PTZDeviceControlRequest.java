package com.git.wuqf.service.common.def.message.content;


public class PTZDeviceControlRequest
        extends com.git.wuqf.service.sip.message.content.OnlyReqMessage {
    private String a;
    private String b;
    private String c;

    public String getControlPriority() {
        return this.c;
    }

    public void setControlPriority(String paramString) {
        this.c = paramString;
    }


    public PTZDeviceControlRequest(String paramString) {
        super(paramString, "DeviceControl");
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer1;


        (localStringBuffer1 = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer1.append("<Control>\n");

        localStringBuffer1.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        localStringBuffer1.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer1.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

        localStringBuffer1.append("<PTZCmd>" + this.b + "</PTZCmd>\n");


        StringBuffer localStringBuffer2 = new StringBuffer();
        if ((getControlPriority() != null) && (getControlPriority().length() > 0)) {
            localStringBuffer2.append("<ControlPriority>" + getControlPriority() + "</ControlPriority>\n");
        }


        if (localStringBuffer2.length() > 0) {
            localStringBuffer1.append("<Info>\n");
            localStringBuffer1.append(localStringBuffer2);
            localStringBuffer1.append("</Info>\n");
        }

        localStringBuffer1.append("</Control>\n");
        setXmlContent(localStringBuffer1.toString());
    }


    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getPtzCmd() {
        return this.b;
    }

    public void setPtzCmd(String paramString) {
        this.b = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "deviceID\t" + this.a + "\n" + "ptzCmd\t" + this.b + "\n" + "ControlPriority\t" + this.c + "\n";
    }


    public static void main(String[] paramArrayOfString) {
        PTZDeviceControlRequest s = new PTZDeviceControlRequest("123");
        s.setPtzCmd("111");
        s.setControlPriority("10");
        s.genXmlContent();
        System.out.println(s.getXmlContent());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/PTZDeviceControlRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */