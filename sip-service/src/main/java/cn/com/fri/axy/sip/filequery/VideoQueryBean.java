package cn.com.fri.axy.sip.filequery;

import cn.com.fri.axy.common.util.DateUtil;

import java.util.Calendar;
import java.util.Date;


public class VideoQueryBean {
    private String a;
    private String b;
    private long c;
    private long d;

    public VideoQueryBean(String paramString1, String paramString2, long paramLong1, long paramLong2) {
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramLong1;
        this.d = paramLong2;
    }


    public String getXmlContent() {
        StringBuilder localStringBuilder;
        (localStringBuilder = new StringBuilder()).append("<?xml version=\"1.0\"?>\n");
        localStringBuilder.append("<Query>\n");
        localStringBuilder.append("<CmdType>HX_FILE_QUERY</CmdType>\n");
        localStringBuilder.append("<DeviceAddress>" + this.a + "</DeviceAddress>\n");
        localStringBuilder.append("<arg>\n");
        localStringBuilder.append("<type>" + this.b + "</type>\n");
        localStringBuilder.append("<StartTime>\n");

        Calendar localCalendar;
        (localCalendar = Calendar.getInstance()).setTimeInMillis(this.c);
        localStringBuilder.append("<year>" + localCalendar.get(1) + "</year>\n");
        localStringBuilder.append("<month>" + (localCalendar.get(2) + 1) + "</month>\n");
        localStringBuilder.append("<day>" + localCalendar.get(5) + "</day>\n");
        localStringBuilder.append("<hour>" + localCalendar.get(11) + "</hour>\n");
        localStringBuilder.append("<minute>" + localCalendar.get(12) + "</minute>\n");
        localStringBuilder.append("<second>" + localCalendar.get(13) + "</second>\n");
        localStringBuilder.append("</StartTime>\n");
        localStringBuilder.append("<EndTime>\n");

        localCalendar.setTimeInMillis(this.d);
        localStringBuilder.append("<year>" + localCalendar.get(1) + "</year>\n");
        localStringBuilder.append("<month>" + (localCalendar.get(2) + 1) + "</month>\n");
        localStringBuilder.append("<day>" + localCalendar.get(5) + "</day>\n");
        localStringBuilder.append("<hour>" + localCalendar.get(11) + "</hour>\n");
        localStringBuilder.append("<minute>" + localCalendar.get(12) + "</minute>\n");
        localStringBuilder.append("<second>" + localCalendar.get(13) + "</second>\n");
        localStringBuilder.append("</EndTime>\n");
        localStringBuilder.append("<locked>both</locked>\n");
        localStringBuilder.append("</arg>\n");
        localStringBuilder.append("</Query>\n");

        return localStringBuilder.toString();
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "11111111112222222222";
        String str = "alarm";
        Date localDate1 = new DateUtil().TGS_StringToDate("20090610141000");
        Date localDate2 = new DateUtil().TGS_StringToDate("20090612141000");

        paramArrayOfString = new VideoQueryBean(paramArrayOfString, str, localDate1.getTime(), localDate2.getTime());

        System.out.println(paramArrayOfString.getXmlContent());
    }

    public String getDeviceID() {
        return this.a;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/filequery/VideoQueryBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */