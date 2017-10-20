package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;


public class DeviceStatusResponse
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
    private String j;
    private Vector k;

    public String toString() {
        StringBuilder localStringBuilder;
        (localStringBuilder = new StringBuilder()).append("SN\t" + getSn() + "\n");
        localStringBuilder.append("DeviceID\t" + this.a + "\n");
        localStringBuilder.append("Result\t" + this.b + "\n");
        localStringBuilder.append("Online\t" + this.c + "\n");
        localStringBuilder.append("Status\t" + this.d + "\n");
        localStringBuilder.append("Encode\t" + this.e + "\n");
        localStringBuilder.append("Record\t" + this.f + "\n");
        localStringBuilder.append("Decode\t" + this.g + "\n");
        localStringBuilder.append("DeviceTime\t" + this.h + "\n");
        localStringBuilder.append("AgentDeviceStatus\t" + this.i + "\n");
        localStringBuilder.append("num\t" + this.j + "\n");
        if ((this.k != null) && (this.k.size() > 0)) {
            for (Iterator localIterator = this.k.iterator(); localIterator.hasNext(); ) {
                this = (DeviceStatusResponse.AlarmstatusBean) localIterator.next();

                localStringBuilder.append(toString());
            }
        }

        return localStringBuilder.toString();
    }


    public DeviceStatusResponse(String paramString) {
        super(paramString, "DeviceStatus");
    }


    public void genParameters() {
        Object localObject = getXmlContent();
        this.b = ((String) localObject).substring(((String) localObject).indexOf("<Result>") + "<Result>".length(), ((String) localObject).indexOf("</Result>"));
        this.a = ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));
        this.c = ((String) localObject).substring(((String) localObject).indexOf("<Online>") + "<Online>".length(), ((String) localObject).indexOf("</Online>"));
        this.d = ((String) localObject).substring(((String) localObject).indexOf("<Status>") + "<Status>".length(), ((String) localObject).indexOf("</Status>"));
        setSn(((String) localObject).substring(((String) localObject).indexOf("<SN>") + "<SN>".length(), ((String) localObject).indexOf("</SN>")));


        if (((String) localObject).indexOf("<AgentDeviceStatus>") > -1) {
            this.i = ((String) localObject).substring(((String) localObject).indexOf("<AgentDeviceStatus>") + "<AgentDeviceStatus>".length(), ((String) localObject).indexOf("</AgentDeviceStatus>"));
        }
        if (((String) localObject).indexOf("<Encode>") > -1) {
            this.e = ((String) localObject).substring(((String) localObject).indexOf("<Encode>") + "<Encode>".length(), ((String) localObject).indexOf("</Encode>"));
        }
        if (((String) localObject).indexOf("<Record>") > -1) {
            this.f = ((String) localObject).substring(((String) localObject).indexOf("<Record>") + "<Record>".length(), ((String) localObject).indexOf("</Record>"));
        }
        if (((String) localObject).indexOf("<Decode>") > -1) {
            this.g = ((String) localObject).substring(((String) localObject).indexOf("<Decode>") + "<Decode>".length(), ((String) localObject).indexOf("</Decode>"));
        }
        if (((String) localObject).indexOf("<DeviceTime>") > -1) {
            this.h = ((String) localObject).substring(((String) localObject).indexOf("<DeviceTime>") + "<DeviceTime>".length(), ((String) localObject).indexOf("</DeviceTime>"));
        }
        if (((String) localObject).indexOf("<Alarmstatus ") > -1) {
            localObject = ((String) localObject).substring(((String) localObject).indexOf("<Alarmstatus "));
            this.j = ((String) localObject).substring(((String) localObject).indexOf("<Alarmstatus Num=") + "<Alarmstatus Num=".length(), ((String) localObject).indexOf(">"));

            this.k = new Vector();
            String[] arrayOfString;
            int n = (arrayOfString = localObject = ((String) localObject).split("<Item>")).length;
            for (int m = 0; m < n; m++) {
                if ((localObject = arrayOfString[m]).indexOf("<DutyStatus>") > -1) {
                    SysLogger.info(localObject);
                    DeviceStatusResponse.AlarmstatusBean localAlarmstatusBean;
                    DeviceStatusResponse.AlarmstatusBean.a(localAlarmstatusBean = new DeviceStatusResponse.AlarmstatusBean(this), ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>")));
                    DeviceStatusResponse.AlarmstatusBean.b(localAlarmstatusBean, ((String) localObject).substring(((String) localObject).indexOf("<DutyStatus>") + "<DutyStatus>".length(), ((String) localObject).indexOf("</DutyStatus>")));
                    this.k.add(localAlarmstatusBean);
                }
            }
        }
    }


    public void genXmlContent() {
    }


    public String getAgentDeviceStatus() {
        return this.i;
    }

    public void setAgentDeviceStatus(String paramString) {
        this.i = paramString;
    }

    public String getDecode() {
        return this.g;
    }

    public void setDecode(String paramString) {
        this.g = paramString;
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getEncode() {
        return this.e;
    }

    public void setEncode(String paramString) {
        this.e = paramString;
    }

    public String getOnline() {
        return this.c;
    }

    public void setOnline(String paramString) {
        this.c = paramString;
    }

    public String getRecord() {
        return this.f;
    }

    public void setRecord(String paramString) {
        this.f = paramString;
    }

    public String getResult() {
        return this.b;
    }

    public void setResult(String paramString) {
        this.b = paramString;
    }

    public Date getDeviceTime() {
        return new DateUtil().XML_StringToDate(this.h);
    }

    public void setDeviceTime(String paramString) {
        this.h = paramString;
    }

    public String getStatus() {
        return this.d;
    }

    public void setStatus(String paramString) {
        this.d = paramString;
    }

    public Vector getAlarmstatusBeans() {
        return this.k;
    }

    public void setAlarmstatusBeans(Vector paramVector) {
        this.k = paramVector;
    }

    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<Response><CmdType>DeviceStatus</CmdType><SN>2</SN><DeviceID>13030000001130000002</DeviceID><Result>OK</Result><Online>ONLINE</Online><Status>OK</Status><Encode>ON</Encode><Record>OFF</Record><DeviceTime></DeviceTime><Alarmstatus Num=2><Item><DeviceID>13030000001340000003</DeviceID><DutyStatus>Onduty</DutyStatus></Item><Item><DeviceID>13030000001340000004</DeviceID><DutyStatus>Onduty</DutyStatus></Item></Alarmstatus></Response>";


        DeviceStatusResponse localDeviceStatusResponse;


        (localDeviceStatusResponse = new DeviceStatusResponse("")).setXmlContent(paramArrayOfString);
        localDeviceStatusResponse.genParameters();
        System.out.println(localDeviceStatusResponse.getDeviceTime());
        System.out.println();
        System.out.println(localDeviceStatusResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/DeviceStatusResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */