package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import java.util.Date;


public class TollgateCarRecordResponse$CarrecordBean {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public TollgateCarRecordResponse$CarrecordBean(TollgateCarRecordResponse paramTollgateCarRecordResponse) {
    }

    public String getCarPlate() {
        return this.b;
    }

    public void setCarPlate(String paramString) {
        this.b = paramString;
    }

    public String getDirection() {
        return this.e;
    }

    public void setDirection(String paramString) {
        this.e = paramString;
    }

    public String getImageURL() {
        return this.d;
    }

    public void setImageURL(String paramString) {
        this.d = paramString;
    }

    public Date getPassTime() {
        if (ServletContextHelper.isShenxunTollgate()) {
            return new DateUtil().TGS_StringToDate(this.g);
        }


        return new DateUtil().XML_StringToDate(this.g);
    }

    public void setPassTime(String paramString) {
        this.g = paramString;
    }

    public String getPlateType() {
        return this.c;
    }

    public void setPlateType(String paramString) {
        this.c = paramString;
    }

    public String getTollgateID() {
        return this.a;
    }

    public void setTollgateID(String paramString) {
        this.a = paramString;
    }

    public String getVehicleSpeed() {
        return this.f;
    }

    public void setVehicleSpeed(String paramString) {
        this.f = paramString;
    }

    public String toString() {
        StringBuilder localStringBuilder;
        (localStringBuilder = new StringBuilder()).append("TollgateID\t" + this.a + "\n");
        localStringBuilder.append("CarPlate\t" + this.b + "\n");
        localStringBuilder.append("PlateType\t" + this.c + "\n");
        localStringBuilder.append("ImageURL\t" + this.d + "\n");
        localStringBuilder.append("Direction\t" + this.e + "\n");
        localStringBuilder.append("VehicleSpeed\t" + this.f + "\n");
        localStringBuilder.append("PassTime\t" + this.g + "\n");

        return localStringBuilder.toString();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateCarRecordResponse$CarrecordBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */