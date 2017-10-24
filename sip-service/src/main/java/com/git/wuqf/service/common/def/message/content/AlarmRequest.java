package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.common.util.DateUtil;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;


public class AlarmRequest
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

    public String getSourceID() {
        return this.i;
    }

    public void setSourceID(String paramString) {
        this.i = paramString;
    }

    public AlarmRequest(String paramString, Observer paramObserver) {
        super(paramString, "Alarm", paramObserver);
    }


    public void genXmlContent() {
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));
        this.d = str.substring(str.indexOf("<AlarmTime>") + "<AlarmTime>".length(), str.indexOf("</AlarmTime>"));
        this.b = str.substring(str.indexOf("<AlarmPriority>") + "<AlarmPriority>".length(), str.indexOf("</AlarmPriority>"));
        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.c = str.substring(str.indexOf("<AlarmMethod>") + "<AlarmMethod>".length(), str.indexOf("</AlarmMethod>"));
        if (str.indexOf("<Longtitude>") > -1) {
            this.e = str.substring(str.indexOf("<Longtitude>") + "<Longtitude>".length(), str.indexOf("</Longtitude>"));
        } else {
            this.e = "0";
        }
        if (str.indexOf("<Latitude>") > -1) {
            this.f = str.substring(str.indexOf("<Latitude>") + "<Latitude>".length(), str.indexOf("</Latitude>"));
        } else {
            this.f = "0";
        }
        if (str.indexOf("<Info>") > -1) {
            this.g = str.substring(str.indexOf("<Info>") + "<Info>".length(), str.indexOf("</Info>"));
        } else {
            this.g = "";
        }
        if (str.indexOf("<AlarmType>") > -1) {
            this.h = str.substring(str.indexOf("<AlarmType>") + "<AlarmType>".length(), str.indexOf("</AlarmType>"));
        } else {
            this.h = "";
        }
        if (str.indexOf("<SourceID>") > -1) {
            this.i = str.substring(str.indexOf("<SourceID>") + "<SourceID>".length(), str.indexOf("</SourceID>"));
            return;
        }


        this.i = "";
    }


    public void update(Observable paramObservable, Object paramObject) {
    }


    public String getAlarmMethod() {
        return this.c;
    }

    public void setAlarmMethod(String paramString) {
        this.c = paramString;
    }

    public String getAlarmPriority() {
        return this.b;
    }

    public void setAlarmPriority(String paramString) {
        this.b = paramString;
    }

    public Date getAlarmTime() {
        return new DateUtil().XML_StringToDate(this.d);
    }

    public void setAlarmTime(String paramString) {
        this.d = paramString;
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getInfo() {
        return this.g;
    }

    public void setInfo(String paramString) {
        this.g = paramString;
    }

    public double getLatitude() {
        if ((this.f == null) || (this.f.length() == 0)) {
            this.f = "0";
        }
        return Double.parseDouble(this.f);
    }

    public void setLatitude(String paramString) {
        this.f = paramString;
    }

    public double getLongtitude() {
        if ((this.e == null) || (this.e.length() == 0)) {
            this.e = "0";
        }
        return Double.parseDouble(this.e);
    }

    public void setLongtitude(String paramString) {
        this.e = paramString;
    }

    public static void main(String[] paramArrayOfString) {
        String s =
                "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>\n<Notify>\n\t\t<CmdType>Alarm</CmdType>\n\t\t<SN>111111</SN>\n\t\t<DeviceID>a001</DeviceID>\n\t\t<AlarmPriority>high</AlarmPriority>\n\t\t<AlarmMethod>110</AlarmMethod>\n\t\t<AlarmTime>2007-07-01T09:30:10.5</AlarmTime>\n\t\t<Latitude>47</Latitude>\n<Info><AlarmType>1</AlarmType></Info>\t</Notify>\n";


        System.out.println(paramArrayOfString);
        AlarmRequest localAlarmRequest;
        (localAlarmRequest = new AlarmRequest("a001", null)).setXmlContent(s);
        localAlarmRequest.genParameters();
        System.out.println(localAlarmRequest.getAlarmMethod());
        System.out.println(localAlarmRequest.getAlarmPriority());
        System.out.println(localAlarmRequest.getDeviceID());
        System.out.println(localAlarmRequest.getInfo());
        System.out.println(localAlarmRequest.getLatitude());
        System.out.println(localAlarmRequest.getLongtitude());
        System.out.println(localAlarmRequest.getAlarmTime());
        System.out.println(localAlarmRequest.getAlarmType());
    }


    public String getAlarmType() {
        return this.h;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/AlarmRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */