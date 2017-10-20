package cn.com.fri.axy.common.def.message.content.decoderremoteconfig;

import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.util.List;
import java.util.Observer;


public class DecoderConfigExtensionParamRequest
        extends ReqMessage {
    private String a;
    private List b;

    public DecoderConfigExtensionParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer = new StringBuffer();

        if ((this.b != null) && (this.b.size() > 0)) {
            localStringBuffer.append("<?xml version=\"1.0\"?>\n");
            localStringBuffer.append("<Query>\n");

            localStringBuffer.append("<CmdType>" + getCmdType() + "</CmdType>\n");

            localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

            localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

            localStringBuffer.append("<ExtensionParam>\n");
            localStringBuffer.append("<Item>\n");
            for (int i = 0; i <= this.b.size(); i++) {
                localStringBuffer.append("<ExtensionItem>" + this.b.get(i) + "</ExtensionItem>\n");
            }
            localStringBuffer.append("</Item>\n");
            localStringBuffer.append("</ExtensionParam>\n");
            localStringBuffer.append("</Query>\n");
        }
        setXmlContent(localStringBuffer.toString());
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        if ((paramString != null) && (!paramString.equals(""))) {
            this.a = paramString;
        }
    }

    public List getExtensionList() {
        return this.b;
    }

    public void setExtensionList(List paramList) {
        this.b = paramList;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderremoteconfig/DecoderConfigExtensionParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */