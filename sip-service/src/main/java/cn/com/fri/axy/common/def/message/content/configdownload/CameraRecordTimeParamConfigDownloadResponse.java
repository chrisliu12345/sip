package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class CameraRecordTimeParamConfigDownloadResponse
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


    public CameraRecordTimeParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.b = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.c = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));

        this.d = OndutyTimeBean.newInstance(str);
    }

    public void genXmlContent() {
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CameraRecordTimeParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */