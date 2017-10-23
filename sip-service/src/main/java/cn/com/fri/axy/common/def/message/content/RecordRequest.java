package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.util.Date;
import java.util.Observer;


public class RecordRequest
        extends ReqMessage {
    public static final String start = "Record";
    public static final String stop = "StopRecord";
    public static final String delete = "DeleteRecord";
    public static final int type_normal_record = 1;
    public static final int type_alarm_record = 2;
    public static final int type_pre_record = 3;
    public static final int type_dvrhistory_record = 4;
    public static final int log_single_record = 0;
    public static final int log_multi_record = 1;
    private String a;
    private String b;
    private String c;
    private int d;
    private int e;
    private String f;

    public static String getTypeDescription(int paramInt) {
        String str = "未知";
        switch (paramInt) {
            case 1:
                str = "普通";
                break;
            case 2:
                str = "报警";
                break;
            case 3:
                str = "预录";
                break;
            case 4:
                str = "转录";
        }
        return str;
    }


    public String getSTime() {
        return this.f;
    }

    public void setSTime(Date paramDate1, Date paramDate2) {
        this.f = (paramDate1.getTime() / 1000L + "-" + paramDate2.getTime() / 1000L);
    }

    public int getILog() {
        return this.e;
    }

    public void setILog(int paramInt) {
        this.e = paramInt;
    }


    public RecordRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceControl", paramObserver);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Control>\n");

        localStringBuffer.append("<CmdType>DeviceControl</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");

        localStringBuffer.append("<RecordCmd>" + getRecordCmd() + "</RecordCmd>\n");

        if ((getSSourceDevice() != null) && (getSSourceDevice().length() > 0)) {
            localStringBuffer.append("<Info>DeviceID:" + getSSourceDevice() + "</Info>\n");
        }
        if (getIType() > 0) {
            localStringBuffer.append("<Info>Type:" + getIType() + "</Info>\n");
        }
        localStringBuffer.append("<Info>Log:" + getILog() + "</Info>\n");
        if ((getSTime() != null) && (getSTime().length() > 0)) {
            localStringBuffer.append("<Info>Time:" + getSTime() + "</Info>\n");
        }
        localStringBuffer.append("</Control>\n");
        setXmlContent(localStringBuffer.toString());
    }


    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getRecordCmd() {
        return this.b;
    }

    public void setRecordCmd(String paramString) {
        this.b = paramString;
    }

    public void setSSourceDevice(String paramString) {
        this.c = paramString;
    }

    public void setIType(int paramInt) {
        this.d = paramInt;
    }

    public String getSSourceDevice() {
        return this.c;
    }

    public int getIType() {
        return this.d;
    }


    public static void main(String[] paramArrayOfString) {
        RecordRequest r = new RecordRequest("test", null);
        r.setDeviceID("test");
        r.setRecordCmd("rec");

        r.setSn("ff");

        r.setIType(100);
        r.genXmlContent();
        System.out.println(r.getXmlContent());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/RecordRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */