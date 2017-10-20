package cn.com.fri.axy.common.def.message.content.decoderconfigdownload;

import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.util.Observer;


public class DecoderConfigDownloadRequest
        extends ReqMessage {
    private String a;
    private String b;

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


    private DecoderConfigDownloadRequest(String paramString, Observer paramObserver) {
        super(paramString, "ConfigDownload", paramObserver);
        setDeviceID(paramString);
    }


    public DecoderConfigDownloadRequest(String paramString1, Observer paramObserver, String paramString2) {
        this(paramString1, paramObserver);
        this.b = paramString2;
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

        localStringBuilder.append("</Query>\n");

        setXmlContent(localStringBuilder.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderconfigdownload/DecoderConfigDownloadRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */