package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.sip.message.content.ResMessage;


public class CameraTelCtrlParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public String getConfigType() {
        return this.g;
    }

    public void setConfigType(String paramString) {
        this.g = paramString;
    }

    public String getSEQ() {
        return this.h;
    }

    public void setSEQ(String paramString) {
        this.h = paramString;
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getCompany() {
        return this.b;
    }

    public void setCompany(String paramString) {
        this.b = paramString;
    }

    public String getModel() {
        return this.c;
    }

    public void setModel(String paramString) {
        this.c = paramString;
    }

    public String getControlType() {
        return this.d;
    }

    public void setControlType(String paramString) {
        this.d = paramString;
    }

    public String getBaudRate() {
        return this.e;
    }

    public void setBaudRate(String paramString) {
        this.e = paramString;
    }

    public String getInterval() {
        return this.f;
    }

    public void setInterval(String paramString) {
        this.f = paramString;
    }


    public String toString() {
        return


                "SN\t" + getSn() + "\n" + "DeviceID\t" + this.a + "\n" + "ConfigType\t" + this.g + "\n" + "SEQ\t" + this.h + "\n" + "Company\t" + this.b + "\n" + "Model\t" + this.c + "\n" + "ControlType\t" + this.d + "\n" + "BaudRate\t" + this.e + "\n" + "Interval\t" + this.f + "\n";
    }


    public CameraTelCtrlParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.g = str.substring(str.indexOf("<ConfigType>") + "<ConfigType>".length(), str.indexOf("</ConfigType>"));
        this.h = str.substring(str.indexOf("<SEQ>") + "<SEQ>".length(), str.indexOf("</SEQ>"));
        this.b = str.substring(str.indexOf("<Company>") + "<Company>".length(), str.indexOf("</Company>"));
        this.c = str.substring(str.indexOf("<Model>") + "<Model>".length(), str.indexOf("</Model>"));
        this.d = str.substring(str.indexOf("<ControlType>") + "<ControlType>".length(), str.indexOf("</ControlType>"));
        this.e = str.substring(str.indexOf("<BaudRate>") + "<BaudRate>".length(), str.indexOf("</BaudRate>"));
        this.f = str.substring(str.indexOf("<Interval>") + "<Interval>".length(), str.indexOf("</Interval>"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><TelCtrlParam><Company>厂家</Company><Model>型号</Model><ControlType>控制类型</ControlType><BaudRate>波特率</BaudRate><Interval>控制信令间隔时间</Interval></TelcrtlParam></Response>";


        CameraTelCtrlParamConfigDownloadResponse localCameraTelCtrlParamConfigDownloadResponse;


        (localCameraTelCtrlParamConfigDownloadResponse = new CameraTelCtrlParamConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localCameraTelCtrlParamConfigDownloadResponse.genParameters();
        System.out.println(localCameraTelCtrlParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CameraTelCtrlParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */