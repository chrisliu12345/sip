package cn.com.fri.axy.common.def.message.content.decoderremoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Observer;
import java.util.Vector;


public class DecoderConfigVideoOutputRequest
        extends ReqMessage {
    private String a;
    private Vector b;

    public String getSDecoderID() {
        return this.a;
    }

    public void setSDecoderID(String paramString) {
        this.a = paramString;
    }

    public Vector getBeans() {
        return this.b;
    }

    public void setBeans(Vector paramVector) {
        this.b = paramVector;
    }

    public DecoderConfigVideoOutputRequest(String paramString, Observer paramObserver) {
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

        localStringBuffer.append("<DeviceID>" + getSDecoderID() + "</DeviceID>\n");


        localStringBuffer.append("<OutputParam>\n");
        for (Iterator localIterator = this.b.iterator(); localIterator.hasNext(); ) {
            OutputParamBean localObject = (OutputParamBean) localIterator.next();
            localStringBuffer.append("<Item>\n");
            localStringBuffer.append("<Channel>" + ((OutputParamBean) localObject).getChannel() + "</Channel>\n");
            localStringBuffer.append("<Name>" + ((OutputParamBean) localObject).getName() + "</Name>\n");
            localStringBuffer.append("<DeviceID>" + ((OutputParamBean) localObject).getDeviceID() + "</DeviceID>\n");
            localStringBuffer.append("<Description>" + ((OutputParamBean) localObject).getDescription() + "</Description>\n");
            localStringBuffer.append("<MediaSecurity>" + ((OutputParamBean) localObject).getMediaSecurity() + "</MediaSecurity>\n");
            localStringBuffer.append("</Item>\n");
        }

        localStringBuffer.append("</OutputParam>\n");
        localStringBuffer.append("</Query>\n");

        Object localObject = localStringBuffer.toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        SysLogger.info("解码器与视频输出映射配置\n" + (String) localObject);
        setXmlContent((String) localObject);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderremoteconfig/DecoderConfigVideoOutputRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */