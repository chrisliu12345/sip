package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.common.util.DateUtil;
import com.git.wuqf.service.sip.message.content.ReqMessage;
import com.git.wuqf.service.sip.util.ServletContextHelper;

import java.util.Date;
import java.util.Observer;


public class TollgateConfigDefenceRequest
        extends ReqMessage {
    public static final String ConfigDefence = "true";
    public static final String UNConfigDefence = "false";
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public TollgateConfigDefenceRequest(String paramString, Observer paramObserver) {
        super(paramString, "ConfigDefence", paramObserver);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>\n");
        localStringBuffer.append("<Notify>\n");

        localStringBuffer.append("<CmdType>ConfigDefence</CmdType>\n");
        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<Type>" + this.a + "</Type>\n");

        localStringBuffer.append("<TollgateID>" + this.b + "</TollgateID>\n");

        localStringBuffer.append("<CarPlate>" + this.c + "</CarPlate>\n");

        if ((this.d != null) && (this.d.length() != 0)) {
            localStringBuffer.append("<PlateType>" + this.d + "</PlateType>\n");
        }


        if ((this.e != null) && (this.e.length() != 0)) {
            localStringBuffer.append("<DefenceType>" + this.e + "</DefenceType>\n");
        }

        if ((this.f != null) && (this.f.length() != 0)) {
            localStringBuffer.append("<DefenceTime>" + this.f + "</DefenceTime>\n");
        }
        if ((this.g != null) && (this.g.length() != 0)) {
            localStringBuffer.append("<DefenceEndTime>" + this.g + "</DefenceEndTime>\n");
        }
        localStringBuffer.append("</Notify>\n");

        setXmlContent(localStringBuffer.toString());
    }

    public String getCarPlate() {
        return this.c;
    }


    public void setCarPlate(String paramString) {
        this.c = paramString;
    }

    public String getDefenceTime() {
        return this.f;
    }


    public void setDefenceTime(Date paramDate) {
        if (ServletContextHelper.isShenxunTollgate()) {
            this.f = new DateUtil().TGS_DateToString(paramDate);
            return;
        }


        this.f = new DateUtil().XML_DateToString(paramDate);
    }


    public String getDefenceType() {
        return this.e;
    }

    public void setDefenceType(String paramString) {
        this.e = paramString;
    }

    public String getTollgateID() {
        return this.b;
    }

    public void setTollgateID(String paramString) {
        this.b = paramString;
    }

    public String getType() {
        return this.a;
    }

    public void setType(String paramString) {
        this.a = paramString;
    }

    public String getPlateType() {
        return this.d;
    }

    public void setPlateType(String paramString) {
        this.d = paramString;
    }

    public String getDefenceEndTime() {
        return this.g;
    }


    public void setDefenceEndTime(Date paramDate) {
        if (ServletContextHelper.isShenxunTollgate()) {
            this.g = new DateUtil().TGS_DateToString(paramDate);
            return;
        }


        this.g = new DateUtil().XML_DateToString(paramDate);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateConfigDefenceRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */