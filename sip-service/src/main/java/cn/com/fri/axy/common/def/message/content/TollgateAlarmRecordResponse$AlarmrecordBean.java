package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import java.util.Date;


public class TollgateAlarmRecordResponse$AlarmrecordBean {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public TollgateAlarmRecordResponse$AlarmrecordBean(TollgateAlarmRecordResponse paramTollgateAlarmRecordResponse) {
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

    public String getVehicleSpeed() {
        return this.h;
    }

    public void setVehicleSpeed(String paramString) {
        this.h = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateAlarmRecordResponse$AlarmrecordBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */