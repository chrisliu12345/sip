package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.sip.message.content.ResMessage;

public class AlarmResponse extends ResMessage {
    public String deviceID;
    public String result;

    public AlarmResponse(String paramString) {
        super(paramString, "Alarm");
    }

    public AlarmResponse(String paramString1, String paramString2) {
        super(paramString1, paramString2);
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;
        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Response>\n");

        localStringBuffer.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");
        localStringBuffer.append("<Result>" + getResult() + "</Result>\n");
        localStringBuffer.append("</Response>\n");
        setXmlContent(localStringBuffer.toString());
    }


    public void genParameters() {
    }


    public static void main(String[] paramArrayOfString) {
        AlarmResponse s = new AlarmResponse("sss");
        s.setDeviceID("sss");
        s.setResult("OK");
        s.setSn("111");
        s.genXmlContent();
        System.out.println(s.getXmlContent());
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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/AlarmResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */