package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class AlarmActiveOndutyTimeConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public String getDay() {
        return this.d;
    }

    public void setDay(String paramString) {
        this.d = paramString;
    }

    public String getWeek() {
        return this.e;
    }

    public void setWeek(String paramString) {
        this.e = paramString;
    }

    public String getMonth() {
        return this.f;
    }

    public void setMonth(String paramString) {
        this.f = paramString;
    }

    public String getSpecialDate() {
        return this.g;
    }

    public void setSpecialDate(String paramString) {
        this.g = paramString;
    }

    public String getConfigType() {
        return this.b;
    }

    public void setConfigType(String paramString) {
        this.b = paramString;
    }

    public String getSEQ() {
        return this.c;
    }

    public void setSEQ(String paramString) {
        this.c = paramString;
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.b + "\n" + "SEQ\t" + this.c + "\n" + "Day\t" + this.d + "\n" + "Week\t" + this.e + "\n" + "Month\t" + this.f + "\n" + "SpecialDate\t" + this.g + "\n";
    }


    public AlarmActiveOndutyTimeConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.b = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.c = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));

        this.d = str.substring(str.indexOf("<Day>") + "<Day>".length(), str.indexOf("</Day>"));
        this.e = str.substring(str.indexOf("<Week>") + "<Week>".length(), str.indexOf("</Week>"));
        this.f = str.substring(str.indexOf("<Month>") + "<Month>".length(), str.indexOf("</Month>"));
        this.g = str.substring(str.indexOf("<SpecialDate>") + "<SpecialDate>".length(), str.indexOf("</SpecialDate>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><ActiveOndutyTime><Day>TRUE</Day><Week>TRUE</Week><Month>TRUE</Month><SpecialDate>TRUE</SpecialDate></ActiveOndutyTime></Response>";


        AlarmActiveOndutyTimeConfigDownloadResponse localAlarmActiveOndutyTimeConfigDownloadResponse;


        (localAlarmActiveOndutyTimeConfigDownloadResponse = new AlarmActiveOndutyTimeConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localAlarmActiveOndutyTimeConfigDownloadResponse.genParameters();
        System.out.println(localAlarmActiveOndutyTimeConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/AlarmActiveOndutyTimeConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */