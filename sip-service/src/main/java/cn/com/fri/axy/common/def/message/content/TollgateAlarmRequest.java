package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.sip.message.content.ReqMessage;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import java.util.Date;


public class TollgateAlarmRequest
        extends ReqMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public TollgateAlarmRequest(String paramString) {
        super(paramString, "TGSAlarm", null);
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));
        this.a = str.substring(str.indexOf("<AlarmTime>") + "<AlarmTime>".length(), str.indexOf("</AlarmTime>"));
        this.b = str.substring(str.indexOf("<TollgateID>") + "<TollgateID>".length(), str.indexOf("</TollgateID>"));
        this.c = str.substring(str.indexOf("<CarPlate>") + "<CarPlate>".length(), str.indexOf("</CarPlate>"));
        this.d = str.substring(str.indexOf("<PlateType>") + "<PlateType>".length(), str.indexOf("</PlateType>"));
        this.e = str.substring(str.indexOf("<DefenceType>") + "<DefenceType>".length(), str.indexOf("</DefenceType>"));
        this.f = str.substring(str.indexOf("<ImageURL>") + "<ImageURL>".length(), str.indexOf("</ImageURL>"));
        this.g = str.substring(str.indexOf("<Direction>") + "<Direction>".length(), str.indexOf("</Direction>"));
        this.h = str.substring(str.indexOf("<VehicleSpeed>") + "<VehicleSpeed>".length(), str.indexOf("</VehicleSpeed>"));
        this.i = str.substring(str.indexOf("<PassTime>") + "<PassTime>".length(), str.indexOf("</PassTime>"));
    }


    public void genXmlContent() {
    }


    public Date getAlarmTime() {
        if (ServletContextHelper.isShenxunTollgate()) {
            return new DateUtil().TGS_StringToDate(this.a);
        }


        return new DateUtil().XML_StringToDate(this.a);
    }


    public void setAlarmTime(String paramString) {
        this.a = paramString;
    }

    public String getCarPlate() {
        return this.c;
    }

    public void setCarPlate(String paramString) {
        this.c = paramString;
    }

    public String getDefenceType() {
        return this.e;
    }

    public void setDefenceType(String paramString) {
        this.e = paramString;
    }

    public String getDirection() {
        return this.g;
    }

    public void setDirection(String paramString) {
        this.g = paramString;
    }

    public String getImageURL() {
        return this.f;
    }

    public void setImageURL(String paramString) {
        this.f = paramString;
    }


    public Date getPassTime() {
        if (ServletContextHelper.isShenxunTollgate()) {
            return new DateUtil().TGS_StringToDate(this.i);
        }


        return new DateUtil().XML_StringToDate(this.i);
    }


    public void setPassTime(String paramString) {
        this.i = paramString;
    }

    public String getPlateType() {
        return this.d;
    }

    public void setPlateType(String paramString) {
        this.d = paramString;
    }

    public String getTollgateID() {
        return this.b;
    }

    public void setTollgateID(String paramString) {
        this.b = paramString;
    }

    public String getVehicleSpeed() {
        return this.h;
    }

    public void setVehicleSpeed(String paramString) {
        this.h = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateAlarmRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */