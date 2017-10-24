package com.git.wuqf.service.common.def.message.content.configdownload;


public class ItemBean {
    private String a;


    private String b;


    public ItemBean(AlarmAlarmRecordTableConfigDownloadResponse paramAlarmAlarmRecordTableConfigDownloadResponse) {
    }


    public String getCameraDeviceID() {
        return this.a;
    }


    public void setCameraDeviceID(String paramString) {
        this.a = paramString;
    }


    public String getPreNum() {
        return this.b;
    }


    public void setPreNum(String paramString) {
        this.b = paramString;
    }


    public String toString() {
        return
                "CameraDeviceID\t" + this.a + "\n" + "PreNum\t" + this.b + "\n";
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/AlarmAlarmRecordTableConfigDownloadResponse$ItemBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */