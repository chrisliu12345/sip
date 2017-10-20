package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DecoderConfigVideoOutputRequest2
        extends ReqMessage {
    private String a;
    private String[] b;
    private String[] c;
    private Long[] d;
    private String[] e;
    private int f;

    public DecoderConfigVideoOutputRequest2(String paramString, Observer paramObserver) {
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

        localStringBuffer.append("<DeviceID>" + getDecoderID() + "</DeviceID>\n");


        localStringBuffer.append("<CameraParam>\n");
        for (int i = 0; i < this.f; i++) {
            localStringBuffer.append("<Item>\n");

            localStringBuffer.append("<Channel>" + (getChannels()[i] != null ? getChannels()[i] : "") + "</Channel>\n");

            localStringBuffer.append("<Name>" + (getOutdeviceNames()[i] != null ? getOutdeviceNames()[i] : "") + "</Name>\n");

            localStringBuffer.append("<DeviceID>" + (getOutdeviceIDs()[i] != null ? getOutdeviceIDs()[i] : "") + "</DeviceID>\n");

            localStringBuffer.append("<Description>" + (getDescriptions()[i] != null ? getDescriptions()[i] : "") + "</Description>\n");
            localStringBuffer.append("</Item>\n");
        }

        localStringBuffer.append("</CameraParam>\n");
        localStringBuffer.append("</Query>\n");

        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        SysLogger.info("解码器与视频输出映射配置\n" + str);
        setXmlContent(str);
    }

    public String getDecoderID() {
        return this.a;
    }

    public void setDecoderID(String paramString) {
        this.a = paramString;
    }

    public String[] getOutdeviceIDs() {
        return this.b;
    }

    public void setOutdeviceIDs(String[] paramArrayOfString) {
        this.b = paramArrayOfString;
    }

    public String[] getOutdeviceNames() {
        return this.c;
    }

    public void setOutdeviceNames(String[] paramArrayOfString) {
        this.c = paramArrayOfString;
    }

    public String[] getDescriptions() {
        return this.e;
    }

    public void setDescriptions(String[] paramArrayOfString) {
        this.e = paramArrayOfString;
    }

    public Long[] getChannels() {
        return this.d;
    }

    public void setChannels(Long[] paramArrayOfLong) {
        this.d = paramArrayOfLong;
    }

    public int getNum() {
        return this.f;
    }

    public void setNum(int paramInt) {
        this.f = paramInt;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/DecoderConfigVideoOutputRequest2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */