package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class DeviceConfigHeartBeatParamRequest
        extends ReqMessage {
    private String a;
    private Long b;

    public DeviceConfigHeartBeatParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = Long.valueOf(0L);
    }


    public void genParameters() {
    }


    public void genXmlContent() {

        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\"?>\n");
        sb.append("<Query>\n");

        sb.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        sb.append("<SN>" + getSn() + "</SN>\n");

        sb.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

        sb.append("<HeartBeatParam>\n");

        sb.append("<Interval>" + (getInterval() != null ? getInterval() : "") + "</Interval>\n");
        sb.append("</HeartBeatParam>\n");
        sb.append("</Query>\n");

        Object localObject = sb.toString();
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
