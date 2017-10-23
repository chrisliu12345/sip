package cn.com.fri.axy.common.def.message.content.decoderconfigdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class DecoderTimeParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getDate() {
        return this.b;
    }

    public void setDate(String paramString) {
        this.b = paramString;
    }

    public String getTime() {
        return this.c;
    }

    public void setTime(String paramString) {
        this.c = paramString;
    }

    public String getAdjustTime() {
        return this.d;
    }

    public void setAdjustTime(String paramString) {
        this.d = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "Date\t" + this.b + "\n" + "Time\t" + this.c + "\n" + "AdjustTime\t" + this.d + "\n";
    }


    public DecoderTimeParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.b = str.substring(str.indexOf("<Date>") + "<Date>".length(), str.indexOf("</Date>"));
        this.c = str.substring(str.indexOf("<Time>") + "<Time>".length(), str.indexOf("</Time>"));
        this.d = str.substring(str.indexOf("<AdjustTime>") + "<AdjustTime>".length(), str.indexOf("</AdjustTime>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><TimeParam><Date>日期</Date><Time>时间</Time><AdjustTime>校时方式</AdjustTime></TimeParam></Response>";
        DecoderTimeParamConfigDownloadResponse localDecoderTimeParamConfigDownloadResponse;
        (localDecoderTimeParamConfigDownloadResponse = new DecoderTimeParamConfigDownloadResponse("")).setXmlContent(s);
        localDecoderTimeParamConfigDownloadResponse.genParameters();
        System.out.println(localDecoderTimeParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderconfigdownload/DecoderTimeParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */