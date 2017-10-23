package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DecoderConfigBasicParamRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private Long e;

    public DecoderConfigBasicParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = "";
        this.d = "";
        this.e = Long.valueOf(0L);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\"?>\n");
        sb.append("<Query>\n");

        sb.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        sb.append("<SN>" + getSn() + "</SN>\n");

        sb.append("<DeviceID>" + getDestDeviceID() + "</DeviceID>\n");


        sb.append("<BasicParam>\n");

        sb.append("<Name>" + (getDeviceName() != null ? getDeviceName() : "") + "</Name>\n");

        sb.append("<DeviceID>" + (getDeviceID() != null ? getDeviceID() : "") + "</DeviceID>\n");

        sb.append("<Description>" + (getDescription() != null ? getDescription() : "") + "</Description>\n");

        sb.append("<Outputs>" + (getOutputs() != null ? getOutputs() : "") + "</Outputs>\n");
        sb.append("</BasicParam>\n");
        sb.append("</Query>\n");

        Object localObject = sb.toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        SysLogger.info("解码器基本参数配置\n" + (String) localObject);
        setXmlContent((String) localObject);
    }

    public String getDeviceName() {
        return this.a;
    }

    public void setDeviceName(String paramString) {
        this.a = paramString;
    }

    public String getDeviceID() {
        return this.b;
    }

    public void setDeviceID(String paramString) {
        this.b = paramString;
    }

    public String getDestDeviceID() {
        return this.c;
    }

    public void setDestDeviceID(String paramString) {
        this.c = paramString;
    }

    public String getDescription() {
        return this.d;
    }

    public void setDescription(String paramString) {
        this.d = paramString;
    }

    public Long getOutputs() {
        return this.e;
    }

    public void setOutputs(Long paramLong) {
        this.e = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/DecoderConfigBasicParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */