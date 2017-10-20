package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.util.Observer;


public class RecordInfoQuery
        extends ReqMessage {
    private String a;

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }


    public RecordInfoQuery(String paramString, Observer paramObserver) {
        super(paramString, "RecordInfo", paramObserver);
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
        localStringBuilder.append("</Query>\n");

        setXmlContent(localStringBuilder.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/RecordInfoQuery.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */