package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class AlarmConfigAlarmRecordTableRequest2
        extends ReqMessage {
    private String a;
    private String[] b;
    private String[] c;
    private int d;

    public AlarmConfigAlarmRecordTableRequest2(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
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
        for (int i = 0; i < this.d; i++) {
            localStringBuffer.append("<Item>\n");

            localStringBuffer.append("<DeviceID>" + (getCameraIDs()[i] != null ? getCameraIDs()[i] : "") + "</DeviceID>\n");

            localStringBuffer.append("<PreNum>" + (getPreNumbers()[i] != null ? getPreNumbers()[i] : "") + "</PreNum>\n");
            localStringBuffer.append("</Item>\n");
        }

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
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String[] getCameraIDs() {
        return this.b;
    }

    public void setCameraIDs(String[] paramArrayOfString) {
        this.b = paramArrayOfString;
    }

    public String[] getPreNumbers() {
        return this.c;
    }

    public void setPreNumbers(String[] paramArrayOfString) {
        this.c = paramArrayOfString;
    }

    public void setNum(int paramInt) {
        this.d = paramInt;
    }

    public int getNum() {
        return this.d;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/AlarmConfigAlarmRecordTableRequest2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */