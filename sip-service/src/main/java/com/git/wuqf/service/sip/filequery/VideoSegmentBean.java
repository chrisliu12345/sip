package com.git.wuqf.service.sip.filequery;

import java.util.Calendar;
import java.util.Date;


public class VideoSegmentBean {
    private String a;
    private long b;
    private long c;
    private String d;

    public String toString() {
        return


                "messageSegment\t" + this.d + "\n" + "type\t" + this.a + "\n" + "starttime\t" + getStarttime() + "\n" + "endtime\t" + getEndtime() + "\n";
    }


    public VideoSegmentBean(String paramString) {
        this.d = paramString;
    }

    public void parseMessageSegment() {
        this.a = this.d.substring(this.d.indexOf("<type>") + "<type>".length(), this.d.indexOf("</type>"));
        this.b = a(this.d.substring(this.d.indexOf("<StartTime>") + "<StartTime>".length(), this.d.indexOf("</StartTime>")));
        this.c = a(this.d.substring(this.d.indexOf("<EndTime>") + "<EndTime>".length(), this.d.indexOf("</EndTime>")));
    }


    private static long a(String paramString) {
        int i = Integer.parseInt(paramString.substring(paramString.indexOf("<year>") + "<year>".length(), paramString.indexOf("</year>")));
        int j = Integer.parseInt(paramString.substring(paramString.indexOf("<month>") + "<month>".length(), paramString.indexOf("</month>")));
        int k = Integer.parseInt(paramString.substring(paramString.indexOf("<day>") + "<day>".length(), paramString.indexOf("</day>")));
        int m = Integer.parseInt(paramString.substring(paramString.indexOf("<hour>") + "<hour>".length(), paramString.indexOf("</hour>")));
        int n = Integer.parseInt(paramString.substring(paramString.indexOf("<minute>") + "<minute>".length(), paramString.indexOf("</minute>")));
        int s = Integer.parseInt(paramString.substring(paramString.indexOf("<second>") + "<second>".length(), paramString.indexOf("</second>")));

        Calendar localCalendar;
        (localCalendar = Calendar.getInstance()).set(i, j - 1, k, m, n, s);
        return localCalendar.getTimeInMillis();
    }


    public String getType() {
        return this.a;
    }

    public Date getStarttime() {
        Calendar localCalendar;
        (localCalendar = Calendar.getInstance()).setTimeInMillis(this.b);

        return localCalendar.getTime();
    }

    public Date getEndtime() {
        Calendar localCalendar;
        (localCalendar = Calendar.getInstance()).setTimeInMillis(this.c);

        return localCalendar.getTime();
    }

    public static void main(String[] paramArrayOfString) {
        String s = "<hisome><file><fid>fid</fid><index>index</index><type>type</type><starttime><year>2009</year><month>1</month><day>1</day><hour>1</hour><minute>1</minute><second>1</second></starttime><endtime><year>2009</year><month>2</month><day>1</day><hour>1</hour><minute>1</minute><second>1</second></endtime><locked>locked</locked>";


        VideoSegmentBean v = new VideoSegmentBean(s);
        v.parseMessageSegment();
        System.out.println(v.getType());
        System.out.println(v.getStarttime());
        System.out.println(v.getEndtime());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/filequery/VideoSegmentBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */