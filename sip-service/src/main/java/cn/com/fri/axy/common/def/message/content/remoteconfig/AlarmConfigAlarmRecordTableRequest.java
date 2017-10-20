package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class AlarmConfigAlarmRecordTableRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;

    public AlarmConfigAlarmRecordTableRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = "";
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


        localStringBuffer.append("<AlarmRecordTable>\n");
        localStringBuffer.append("<Item>\n");

        localStringBuffer.append("<DeviceID>" + getCameraID() + "</DeviceID>\n");

        localStringBuffer.append("<PreNum>" + getPreNumber() + "</PreNum>\n");
        localStringBuffer.append("</Item>\n");
        localStringBuffer.append("</AlarmRecordTable>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("报警联动录像设置信息：" + localStringBuffer.toString());
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

    public String getCameraID() {
        if (this.b == null) {
            this.b = "";
        }
        return this.b;
    }

    public void setCameraID(String paramString) {
        this.b = paramString;
    }

    public String getPreNumber() {
        if (this.c == null) {
            this.c = "";
        }
        return this.c;
    }

    public void setPreNumber(String paramString) {
        this.c = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/AlarmConfigAlarmRecordTableRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */