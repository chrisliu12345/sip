package cn.com.fri.axy.common.def.message.content;


public class TollgateConfigDefenceResponse
        extends DeviceControlResponse {
    public TollgateConfigDefenceResponse(String paramString) {
        super(paramString);
    }


    public void genParameters() {
        String str = getXmlContent();
        this.result = str.substring(str.indexOf("<Result>") + "<Result>".length(), str.indexOf("</Result>"));
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateConfigDefenceResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */