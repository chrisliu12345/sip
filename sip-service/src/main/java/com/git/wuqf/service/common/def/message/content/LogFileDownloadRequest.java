package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.common.util.DateUtil;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.util.Date;
import java.util.Observer;


public class LogFileDownloadRequest
        extends ReqMessage {
    private String a;
    private String b;

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getSTime() {
        return this.b;
    }

    public void setSTime(String paramString) {
        this.b = paramString;
    }

    public void setSTime(Date paramDate1, Date paramDate2) {
        this.b =
                (new DateUtil().TGS_DateToString(paramDate1) + " " + new DateUtil().TGS_DateToString(paramDate2));
    }


    public LogFileDownloadRequest(String paramString, Observer paramObserver) {
        super(paramString, "LogFileDownload", paramObserver);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Query>\n");

        localStringBuffer.append("<CmdType>LogFileDownload</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");
        localStringBuffer.append("<Datetime>" + getSTime() + "</Datetime>\n");
        localStringBuffer.append("</Query>\n");
        setXmlContent(localStringBuffer.toString());
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/LogFileDownloadRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */