package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CoderConfigHeartBeatParamRequest
        extends ReqMessage {
    private String a;
    private Long b;

    public CoderConfigHeartBeatParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = Long.valueOf(0L);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        (localObject = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        ((StringBuffer) localObject).append("<Query>\n");

        ((StringBuffer) localObject).append("<CmdType>" + getCmdType() + "</CmdType>\n");

        ((StringBuffer) localObject).append("<SN>" + getSn() + "</SN>\n");

        ((StringBuffer) localObject).append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

        ((StringBuffer) localObject).append("<HeartBeatParam>\n");

        ((StringBuffer) localObject).append("<Interval>" + (getInterval() != null ? getInterval() : "") + "</Interval>\n");
        ((StringBuffer) localObject).append("</HeartBeatParam>\n");
        ((StringBuffer) localObject).append("</Query>\n");

        Object localObject = ((StringBuffer) localObject).toString();
        try {
            localObject = new String(((String) localObject).getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent((String) localObject);

        SysLogger.info("编码器心跳配置信息：" + (String) localObject);
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public Long getInterval() {
        return this.b;
    }

    public void setInterval(Long paramLong) {
        this.b = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CoderConfigHeartBeatParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */