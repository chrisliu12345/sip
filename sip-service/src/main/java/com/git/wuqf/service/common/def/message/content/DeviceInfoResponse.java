package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.sip.message.content.ResMessage;


public class DeviceInfoResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private int l;

    public DeviceInfoResponse(String paramString) {
        super(paramString, "DeviceInfo");
    }


    public void genParameters() {
        String str = getXmlContent();
        this.b = str.substring(str.indexOf("<Result>") + "<Result>".length(), str.indexOf("</Result>"));
        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));

        if (str.indexOf("<AgentDeviceType>") > -1) {
            this.g = str.substring(str.indexOf("<AgentDeviceType>") + "<AgentDeviceType>".length(), str.indexOf("</AgentDeviceType>"));
        }
        if (str.indexOf("<AgentManufacturer>") > -1) {
            this.h = str.substring(str.indexOf("<AgentManufacturer>") + "<AgentManufacturer>".length(), str.indexOf("</AgentManufacturer>"));
        }
        if (str.indexOf("<AgentModel>") > -1) {
            this.i = str.substring(str.indexOf("<AgentModel>") + "<AgentModel>".length(), str.indexOf("</AgentModel>"));
        }
        if (str.indexOf("<DeviceType>") > -1) {
            this.c = str.substring(str.indexOf("<DeviceType>") + "<DeviceType>".length(), str.indexOf("</DeviceType>"));
        }
        if (str.indexOf("<Firmware>") > -1) {
            this.f = str.substring(str.indexOf("<Firmware>") + "<Firmware>".length(), str.indexOf("</Firmware>"));
        }
        if (str.indexOf("<Manufacturer>") > -1) {
            this.d = str.substring(str.indexOf("<Manufacturer>") + "<Manufacturer>".length(), str.indexOf("</Manufacturer>"));
        }
        if (str.indexOf("<Model>") > -1) {
            this.e = str.substring(str.indexOf("<Model>") + "<Model>".length(), str.indexOf("</Model>"));
        }
        if (str.indexOf("<MaxAlarm>") > -1) {
            this.k = Integer.parseInt(str.substring(str.indexOf("<MaxAlarm>") + "<MaxAlarm>".length(), str.indexOf("</MaxAlarm>")));
        }
        if (str.indexOf("<MaxCamera>") > -1) {
            this.j = Integer.parseInt(str.substring(str.indexOf("<MaxCamera>") + "<MaxCamera>".length(), str.indexOf("</MaxCamera>")));
        }
        if (str.indexOf("<MaxOut>") > -1) {
            this.l = Integer.parseInt(str.substring(str.indexOf("<MaxOut>") + "<MaxOut>".length(), str.indexOf("</MaxOut>")));
        }
    }


    public void genXmlContent() {
    }


    public String getAgentDeviceType() {
        return this.g;
    }

    public void setAgentDeviceType(String paramString) {
        this.g = paramString;
    }

    public String getAgentManufacturer() {
        return this.h;
    }

    public void setAgentManufacturer(String paramString) {
        this.h = paramString;
    }

    public String getAgentModel() {
        return this.i;
    }

    public void setAgentModel(String paramString) {
        this.i = paramString;
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getDeviceType() {
        return this.c;
    }

    public void setDeviceType(String paramString) {
        this.c = paramString;
    }

    public String getFirmware() {
        return this.f;
    }

    public void setFirmware(String paramString) {
        this.f = paramString;
    }

    public String getManufacturer() {
        return this.d;
    }

    public void setManufacturer(String paramString) {
        this.d = paramString;
    }

    public int getMaxAlarm() {
        return this.k;
    }

    public void setMaxAlarm(int paramInt) {
        this.k = paramInt;
    }

    public int getMaxCamera() {
        return this.j;
    }

    public void setMaxCamera(int paramInt) {
        this.j = paramInt;
    }

    public int getMaxOut() {
        return this.l;
    }

    public void setMaxOut(int paramInt) {
        this.l = paramInt;
    }

    public String getModel() {
        return this.e;
    }

    public void setModel(String paramString) {
        this.e = paramString;
    }

    public String getResult() {
        return this.b;
    }

    public void setResult(String paramString) {
        this.b = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/DeviceInfoResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */