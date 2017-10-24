package com.git.wuqf.service.common.def.message.content.configdownload;

import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.util.Observer;


public class ConfigDownloadRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getConfigType() {
        return this.b;
    }

    public void setConfigType(String paramString) {
        this.b = paramString;
    }

    public String getSEQ() {
        return this.c;
    }

    public void setSEQ(String paramString) {
        this.c = paramString;
    }


    private ConfigDownloadRequest(String paramString, Observer paramObserver) {
        super(paramString, "ConfigDownload", paramObserver);
        setDeviceID(paramString);
    }


    public ConfigDownloadRequest(String paramString1, Observer paramObserver, String paramString2, String paramString3) {
        this(paramString1, paramObserver);
        this.b = paramString2;
        this.c = paramString3;
    }

    public ConfigDownloadRequest(String paramString1, Observer paramObserver, String paramString2) {
        this(paramString1, paramObserver, paramString2, "1");
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuilder localStringBuilder;


        (localStringBuilder = new StringBuilder()).append("<?xml version=\"1.0\"?>\n");
        localStringBuilder.append("<Query>\n");
        localStringBuilder.append("<CmdType>" + getCmdType() + "</CmdType>\n");
        localStringBuilder.append("<SN>" + getSn() + "</SN>\n");
        localStringBuilder.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");
        localStringBuilder.append("<ConfigType>" + getConfigType() + "</ConfigType>\n");
        localStringBuilder.append("<SEQ>" + getSEQ() + "</SEQ>\n");
        localStringBuilder.append("</Query>\n");

        setXmlContent(localStringBuilder.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/ConfigDownloadRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */