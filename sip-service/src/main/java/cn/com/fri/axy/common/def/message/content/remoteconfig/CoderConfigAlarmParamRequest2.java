package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigAlarmParamRequest2
        extends ReqMessage {
    private String a;
    private Long[] b;
    private String[] c;
    private String[] d;
    private String[] e;
    private Long[] f;
    private int g;

    public CoderConfigAlarmParamRequest2(String paramString, Observer paramObserver) {
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


        localStringBuffer.append("<AlarmChannelParam>\n");
        for (int i = 0; i < this.g; i++) {
            localStringBuffer.append("<Item>\n");

            localStringBuffer.append("<Channel>" + (getAlarmChannels()[i] != null ? getAlarmChannels()[i] : "") + "</Channel>\n");

            localStringBuffer.append("<Name>" + (getDeviceNames()[i] != null ? getDeviceNames()[i] : "") + "</Name>\n");

            localStringBuffer.append("<DeviceID>" + (getAlarmIDs()[i] != null ? getAlarmIDs()[i] : "") + "</DeviceID>\n");

            localStringBuffer.append("<Description>" + (getDescriptions()[i] != null ? getDescriptions()[i] : "") + "</Description>\n");

            localStringBuffer.append("<AlarmLevel>" + (getAlarmLevels()[i] != null ? getAlarmLevels()[i] : "") + "</AlarmLevel>\n");
            localStringBuffer.append("</Item>\n");
        }

        localStringBuffer.append("</AlarmChannelParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("接入报警器基本参数信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public Long[] getAlarmChannels() {
        return this.b;
    }

    public void setAlarmChannels(Long[] paramArrayOfLong) {
        this.b = paramArrayOfLong;
    }

    public String[] getDeviceNames() {
        return this.c;
    }

    public void setDeviceNames(String[] paramArrayOfString) {
        this.c = paramArrayOfString;
    }

    public String[] getAlarmIDs() {
        return this.d;
    }

    public void setAlarmIDs(String[] paramArrayOfString) {
        this.d = paramArrayOfString;
    }

    public String[] getDescriptions() {
        return this.e;
    }

    public void setDescriptions(String[] paramArrayOfString) {
        this.e = paramArrayOfString;
    }

    public Long[] getAlarmLevels() {
        return this.f;
    }

    public void setAlarmLevels(Long[] paramArrayOfLong) {
        this.f = paramArrayOfLong;
    }

    public int getNum() {
        return this.g;
    }

    public void setNum(int paramInt) {
        this.g = paramInt;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigAlarmParamRequest2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */