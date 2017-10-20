package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;

import java.util.Vector;


public class TollgateAlarmRecordResponse
        extends ResMessage
        implements IRecordListResponse {
    private String a;
    private String b;
    private String c;
    private Vector d;

    public TollgateAlarmRecordResponse(String paramString) {
        super(paramString, "TGSAlarmRecordList");
    }


    public void genParameters() {
        Object localObject1 = getXmlContent();
        setSn(((String) localObject1).substring(((String) localObject1).indexOf("<SN>") + "<SN>".length(), ((String) localObject1).indexOf("</SN>")));
        this.a = ((String) localObject1).substring(((String) localObject1).indexOf("<Result>") + "<Result>".length(), ((String) localObject1).indexOf("</Result>"));
        this.b = ((String) localObject1).substring(((String) localObject1).indexOf("<RealRecordNum>") + "<RealRecordNum>".length(), ((String) localObject1).indexOf("</RealRecordNum>"));
        this.c = ((String) localObject1).substring(((String) localObject1).indexOf("<SendRecordNum>") + "<SendRecordNum>".length(), ((String) localObject1).indexOf("</SendRecordNum>"));

        this.d = new Vector();
        if (((String) localObject1).indexOf("<alarmrecord>") > -1) {


            localObject1 = ((String) localObject1).split("<alarmrecord>");
        } else if (((String) localObject1).indexOf("<AlarmRecord>") > -1) {
            localObject1 = ((String) localObject1).split("<AlarmRecord>");
        } else {
            SysLogger.info("no record");
            return;
        }

        Object localObject2;
        int j = (localObject2 = localObject1).length;
        for (int i = 0; i < j; i++) {
            localObject1 = localObject2[i];

            try {
                if (((String) localObject1).indexOf("<AlarmTime>") > -1) {
                    SysLogger.info(localObject1);

                    TollgateAlarmRecordResponse.AlarmrecordBean.a(localObject3 = new TollgateAlarmRecordResponse.AlarmrecordBean(this), ((String) localObject1).substring(((String) localObject1).indexOf("<AlarmTime>") + "<AlarmTime>".length(), ((String) localObject1).indexOf("</AlarmTime>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.b((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<TollgateID>") + "<TollgateID>".length(), ((String) localObject1).indexOf("</TollgateID>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.c((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<CarPlate>") + "<CarPlate>".length(), ((String) localObject1).indexOf("</CarPlate>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.d((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<PlateType>") + "<PlateType>".length(), ((String) localObject1).indexOf("</PlateType>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.e((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<DefenceType>") + "<DefenceType>".length(), ((String) localObject1).indexOf("</DefenceType>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.f((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<ImageURL>") + "<ImageURL>".length(), ((String) localObject1).indexOf("</ImageURL>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.g((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<Direction>") + "<Direction>".length(), ((String) localObject1).indexOf("</Direction>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.h((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<VehicleSpeed>") + "<VehicleSpeed>".length(), ((String) localObject1).indexOf("</VehicleSpeed>")));
                    TollgateAlarmRecordResponse.AlarmrecordBean.i((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<PassTime>") + "<PassTime>".length(), ((String) localObject1).indexOf("</PassTime>")));
                    this.d.add(localObject3);
                }
            } catch (Exception localException) {
                Object localObject3;
                SysLogger.printStackTrace(localObject3 = localException);
            }
        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString =
                "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\"?><Response><CmdType>TGSAlarmRecordList</CmdType><SN>221</SN><Result>OK</Result><RealRecordNum>757383</RealRecordNum><SendRecordNum>200</SendRecordNum><RecordList><alarmrecord><AlarmTime>20070319135341</AlarmTime><TollgateID>113</TollgateID><CarPlate>粤S6G882</CarPlate><PlateType>02</PlateType><DefenceType>违法库</DefenceType><ImageURL>http://213.150.54.8/pic/07031907031136/070319135341021130L047b黑色粤S6G882.jpg</ImageURL><Direction>往虎门方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135341</PassTime></alarmrecord><alarmrecord><AlarmTime>20070319135348</AlarmTime><TollgateID>127</TollgateID><CarPlate>粤S10511</CarPlate><PlateType>02</PlateType><DefenceType>违法库</DefenceType><ImageURL>http://213.150.40.7/pic/07031907024067/070319135348011270L053b白色粤S10511.jpg</ImageURL><Direction>出东莞方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135348</PassTime></alarmrecord><alarmrecord><AlarmTime>20070319135355</AlarmTime><TollgateID>113</TollgateID><CarPlate>粤S34248</CarPlate><PlateType>02</PlateType><DefenceType>违法库</DefenceType><ImageURL>http://213.150.54.8/pic/07031907031136/070319135355021130L041b黑色粤S34248.jpg</ImageURL><Direction>往虎门方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135355</PassTime></alarmrecord></RecordList></Response>";


        TollgateAlarmRecordResponse localTollgateAlarmRecordResponse;


        (localTollgateAlarmRecordResponse = new TollgateAlarmRecordResponse(null)).setXmlContent(paramArrayOfString);
        localTollgateAlarmRecordResponse.genParameters();
    }


    public Vector getAlarmrecordBeans() {
        return this.d;
    }

    public void setAlarmrecordBeans(Vector paramVector) {
        this.d = paramVector;
    }

    public String getRealRecordNum() {
        return this.b;
    }

    public void setRealRecordNum(String paramString) {
        this.b = paramString;
    }

    public String getResult() {
        return this.a;
    }

    public void setResult(String paramString) {
        this.a = paramString;
    }

    public String getSendRecordNum() {
        return this.c;
    }

    public void setSendRecordNum(String paramString) {
        this.c = paramString;
    }


    public int getRecordSum() {
        try {
            return this = Integer.parseInt(this.b);
        } catch (Exception localException) {
            SysLogger.printStackTrace(this = localException);
        }
        return 0;
    }


    public int getRecordCurrent() {
        try {
            return this = Integer.parseInt(this.c);
        } catch (Exception localException) {
            SysLogger.printStackTrace(this = localException);
        }
        return 0;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateAlarmRecordResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */