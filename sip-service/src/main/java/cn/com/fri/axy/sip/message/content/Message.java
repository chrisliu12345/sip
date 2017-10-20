package cn.com.fri.axy.sip.message.content;

import cn.com.fri.axy.sip.util.purview.PurviewBean;


public abstract class Message {
    public static final int OnlyReqMessage = 1;
    public static final int ReqResMessage = 2;
    public static final int MediaSessionMessage = 3;
    public static final String TESTMESSAGE = "Test";
    public static final String KeepaliveRequest = "Keepalive";
    public static final String MediaStatusRequest = "MediaStatus";
    public static final String Alarm = "Alarm";
    public static final String DeviceInfoQuery = "DeviceInfo";
    public static final String DeviceInfoResponse = "DeviceInfo";
    public static final String DeviceStatusQuery = "DeviceStatus";
    public static final String DeviceStatusResponse = "DeviceStatus";
    public static final String DeviceControl = "DeviceControl";
    public static final String DeviceControlResponse = "DeviceControl";
    public static final String DeviceConfig = "DeviceConfig";
    public static final String DeviceConfigResponse = "DeviceConfig";
    public static final String ConfigDownload = "ConfigDownload";
    public static final String ConfigDownloadResponse = "ConfigDownload";
    public static final String ConfigDownloadResponse_BasicParam = "BasicParam";
    public static final String ConfigDownloadResponse_NetworkParam = "NetworkParam";
    public static final String ConfigDownloadResponse_CameraParam = "CameraParam";
    public static final String ConfigDownloadResponse_AlarmChannelParam = "AlarmChannelParam";
    public static final String ConfigDownloadResponse_SecurityParam = "SecurityParam";
    public static final String ConfigDownloadResponse_TimeParam = "TimeParam";
    public static final String ConfigDownloadResponse_HeartBeatParam = "HeartBeatParam";
    public static final String ConfigDownloadResponse_ExtensionParam = "ExtensionParam";
    public static final String ConfigDownloadResponse_VideoParam = "VideoParam";
    public static final String ConfigDownloadResponse_TelCtrlParam = "TelCtrlParam";
    public static final String ConfigDownloadResponse_RecordParam = "RecordParam";
    public static final String ConfigDownloadResponse_RecordTimeParam = "RecordTimeParam";
    public static final String ConfigDownloadResponse_ActiveRecordTime = "ActiveRecordTime";
    public static final String ConfigDownloadResponse_MediaSecurity = "MediaSecurity";
    public static final String ConfigDownloadResponse_AlarmParam = "AlarmParam";
    public static final String ConfigDownloadResponse_ActiveOndutyTime = "ActiveOndutyTime";
    public static final String ConfigDownloadResponse_AlarmRecordTable = "AlarmRecordTable";
    public static final String ConfigDownloadResponse_OutputParam = "OutputParam";
    public static final String DeviceCatalogQuery = "Catalog";
    public static final String DeviceCatalogResponse = "Catalog";
    public static final String RecordInfoQuery = "RecordInfo";
    public static final String RecordInfoResponse = "RecordInfo";
    public static final String ConfigDefence = "ConfigDefence";
    public static final String ConfigDefenceResponse = "ConfigDefence";
    public static final String TGSAlarm = "TGSAlarm";
    public static final String TGSAlarmResponse = "TGSAlarm";
    public static final String TGSAlarmRecordList = "TGSAlarmRecordList";
    public static final String TGSAlarmRecordListResponse = "TGSAlarmRecordList";
    public static final String TGSCarRecordList = "TGSCarRecordList";
    public static final String TGSCarRecordListResponse = "TGSCarRecordList";
    public static final String LogFileDownloadRequest = "LogFileDownload";
    public static final String LogFileDownloadResponse = "LogFileDownload";
    private String a;
    private int b;
    private String c;
    private String d;
    private String e;
    private PurviewBean f;

    public PurviewBean getPurviewBean() {
        return this.f;
    }

    public void setPurviewBean(PurviewBean paramPurviewBean) {
        this.f = paramPurviewBean;
    }

    public String getXmlContent() {
        return this.e;
    }

    public Message(String paramString1, int paramInt, String paramString2) {
        setDestid(paramString1);
        setSessionType(paramInt);
        setCmdType(paramString2);
    }

    public void setXmlContent(String paramString) {
        this.e = paramString.trim();
    }

    public String getCmdType() {
        return this.a;
    }

    protected void setCmdType(String paramString) {
        this.a = paramString;
    }


    public abstract void genXmlContent();


    public abstract void genParameters();


    public static void main(String[] paramArrayOfString) {
    }


    public int getSessionType() {
        return this.b;
    }

    protected void setSessionType(int paramInt) {
        this.b = paramInt;
    }


    public boolean isOnlyReqMessage() {
        return this.b == 1;
    }

    public boolean isReqResMessage() {
        return this.b == 2;
    }

    public boolean isMediaSessionMessage() {
        return this.b == 3;
    }

    public String getDestid() {
        return this.c;
    }

    public void setDestid(String paramString) {
        this.c = paramString;
    }

    public String getSn() {
        return this.d;
    }

    public void setSn(String paramString) {
        this.d = paramString;
    }


    public String toString() {
        return super.toString();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/content/Message.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */