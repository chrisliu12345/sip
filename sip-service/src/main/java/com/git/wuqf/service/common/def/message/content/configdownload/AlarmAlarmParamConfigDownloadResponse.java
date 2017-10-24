package com.git.wuqf.service.common.def.message.content.configdownload;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class AlarmAlarmParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private OndutyTimeBean d;

    public OndutyTimeBean getBean() {
        return this.d;
    }

    public void setBean(OndutyTimeBean paramOndutyTimeBean) {
        this.d = paramOndutyTimeBean;
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

                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.b + "\n" + "SEQ\t" + this.c + "\n" + this.d.toString();
    }


    public AlarmAlarmParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str
                .substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str
                .substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.b = str
                .substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.c = str
                .substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));

        this.d = OndutyTimeBean.newInstance(str);
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>摄像机ID</DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><AlarmParam><Month><Seq=\"9\"><Time Day=\"31\"><Item><Begin>开始时间1</Begin><End>结束时间1</End></Item><Item><Begin>开始时间2</Begin><End>结束时间2</End></Item><Item><Begin>开始时间3</Begin><End>结束时间3</End></Item><Item><Begin>开始时间4</Begin><End>结束时间4</End></Item></Time></Seq></Month></AlarmParam></Response>";


        AlarmAlarmParamConfigDownloadResponse localAlarmAlarmParamConfigDownloadResponse;


        (localAlarmAlarmParamConfigDownloadResponse = new AlarmAlarmParamConfigDownloadResponse("")).setXmlContent(s);
        localAlarmAlarmParamConfigDownloadResponse.genParameters();
        System.out.println(localAlarmAlarmParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/AlarmAlarmParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */