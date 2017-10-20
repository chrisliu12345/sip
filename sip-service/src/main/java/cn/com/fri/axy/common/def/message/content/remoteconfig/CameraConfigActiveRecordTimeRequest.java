package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CameraConfigActiveRecordTimeRequest
        extends ReqMessage {
    private String a;
    private String b;

    public CameraConfigActiveRecordTimeRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
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


        localStringBuffer.append("<ActiveRecordTime>\n");
        int i = 0;
        int j = 0;
        if ((this.b != null) && (!this.b.equals("")) && (this.b.length() == 2)) {
            i = Integer.parseInt(this.b.substring(0, 1));
            j = Integer.parseInt(this.b.substring(1, 2));
        }
        if (i == 1) {
            localStringBuffer.append("<Day>1</Day>\n");
        } else {
            localStringBuffer.append("<Day>0</Day>\n");
        }

        if (i == 2) {
            localStringBuffer.append("<Week>1</Week>\n");
        } else {
            localStringBuffer.append("<Week>0</Week>\n");
        }

        if (i == 3) {
            localStringBuffer.append("<Month>1</Month>\n");
        } else {
            localStringBuffer.append("<Month>0</Month>\n");
        }

        if (j == 1) {
            localStringBuffer.append("<SpecialDate>1</SpecialDate>\n");
        } else {
            localStringBuffer.append("<SpecialDate>0</SpecialDate>\n");
        }

        localStringBuffer.append("</ActiveRecordTime>\n");
        localStringBuffer.append("</Query>\n");
        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("摄像机的有效录像时间设置信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getActiveRecordTime() {
        return this.b;
    }

    public void setActiveRecordTime(String paramString) {
        this.b = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CameraConfigActiveRecordTimeRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */