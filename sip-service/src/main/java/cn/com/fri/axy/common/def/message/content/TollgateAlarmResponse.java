package cn.com.fri.axy.common.def.message.content;


public class TollgateAlarmResponse
        extends AlarmResponse {
    public TollgateAlarmResponse(String paramString) {
        super(paramString, "TGSAlarm");
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;
        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Response>\n");

        localStringBuffer.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");
        localStringBuffer.append("<Result>" + getResult() + "</Result>\n");
        localStringBuffer.append("</Response>\n");
        setXmlContent(localStringBuffer.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateAlarmResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */