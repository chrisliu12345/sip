package com.git.wuqf.service.common.def.message.content;


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

