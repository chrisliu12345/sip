package com.git.wuqf.service.common.def.message.content;


public class AlarmstatusBean {
    private String a;


    private String b;


    public AlarmstatusBean(DeviceStatusResponse paramDeviceStatusResponse) {
    }


    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getDutyStatus() {
        return this.b;
    }

    public void setDutyStatus(String paramString) {
        this.b = paramString;
    }

    public String toString() {
        return
                "DeviceID\t" + this.a + "\n" + "DutyStatus\t" + this.b + "\n";
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/DeviceStatusResponse$AlarmstatusBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */