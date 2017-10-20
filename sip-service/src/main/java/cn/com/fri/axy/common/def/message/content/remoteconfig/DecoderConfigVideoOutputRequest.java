package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DecoderConfigVideoOutputRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private Long d;
    private String e;

    public DecoderConfigVideoOutputRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.c = "";
        this.e = "";
        this.d = Long.valueOf(0L);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        (localObject = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        ((StringBuffer) localObject).append("<Query>\n");

        ((StringBuffer) localObject).append("<CmdType>" + getCmdType() + "</CmdType>\n");

        ((StringBuffer) localObject).append("<SN>" + getSn() + "</SN>\n");

        ((StringBuffer) localObject).append("<DeviceID>" + getDecoderID() + "</DeviceID>\n");


        ((StringBuffer) localObject).append("<CameraParam>\n");
        ((StringBuffer) localObject).append("<Item>\n");

        ((StringBuffer) localObject).append("<Channel>" + (getChannel() != null ? getChannel() : "") + "</Channel>\n");

        ((StringBuffer) localObject).append("<Name>" + (getOutdeviceName() != null ? getOutdeviceName() : "") + "</Name>\n");

        ((StringBuffer) localObject).append("<DeviceID >" + (getOutdeviceID() != null ? getOutdeviceID() : "") + "</DeviceID >\n");

        ((StringBuffer) localObject).append("<Description>" + (getDescription() != null ? getDescription() : "") + "</Description>\n");
        ((StringBuffer) localObject).append("</Item>\n");
        ((StringBuffer) localObject).append("</CameraParam>\n");
        ((StringBuffer) localObject).append("</Query>\n");

        Object localObject = ((StringBuffer) localObject).toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        SysLogger.info("解码器与视频输出映射配置\n" + (String) localObject);
        setXmlContent((String) localObject);
    }

    public String getDecoderID() {
        return this.a;
    }

    public void setDecoderID(String paramString) {
        this.a = paramString;
    }

    public String getOutdeviceID() {
        return this.b;
    }

    public void setOutdeviceID(String paramString) {
        this.b = paramString;
    }

    public String getOutdeviceName() {
        return this.c;
    }

    public void setOutdeviceName(String paramString) {
        this.c = paramString;
    }

    public String getDescription() {
        return this.e;
    }

    public void setDescription(String paramString) {
        this.e = paramString;
    }

    public Long getChannel() {
        return this.d;
    }

    public void setChannel(Long paramLong) {
        this.d = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/DecoderConfigVideoOutputRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */