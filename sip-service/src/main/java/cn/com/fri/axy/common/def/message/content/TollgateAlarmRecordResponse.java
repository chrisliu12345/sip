package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import java.util.Date;
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
//        int j =  localObject1.length;
//        for (int i = 0; i < j; i++) {
////            localObject1 = localObject2[i];
//
//            try {
//                if (((String) localObject1).indexOf("<AlarmTime>") > -1) {
//                    SysLogger.info(localObject1);
//
////                    TollgateAlarmRecordResponse.AlarmrecordBean.a( new TollgateAlarmRecordResponse.AlarmrecordBean(this), ((String) localObject1).substring(((String) localObject1).indexOf("<AlarmTime>") + "<AlarmTime>".length(), ((String) localObject1).indexOf("</AlarmTime>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.b((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<TollgateID>") + "<TollgateID>".length(), ((String) localObject1).indexOf("</TollgateID>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.c((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<CarPlate>") + "<CarPlate>".length(), ((String) localObject1).indexOf("</CarPlate>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.d((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<PlateType>") + "<PlateType>".length(), ((String) localObject1).indexOf("</PlateType>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.e((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<DefenceType>") + "<DefenceType>".length(), ((String) localObject1).indexOf("</DefenceType>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.f((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<ImageURL>") + "<ImageURL>".length(), ((String) localObject1).indexOf("</ImageURL>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.g((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<Direction>") + "<Direction>".length(), ((String) localObject1).indexOf("</Direction>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.h((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<VehicleSpeed>") + "<VehicleSpeed>".length(), ((String) localObject1).indexOf("</VehicleSpeed>")));
////                    TollgateAlarmRecordResponse.AlarmrecordBean.i((TollgateAlarmRecordResponse.AlarmrecordBean) localObject3, ((String) localObject1).substring(((String) localObject1).indexOf("<PassTime>") + "<PassTime>".length(), ((String) localObject1).indexOf("</PassTime>")));
////                    this.d.add(localObject3);
//                }
//            } catch (Exception localException) {
//                Object localObject3;
//                localException.printStackTrace();
//            }
//        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s =
                "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\"?><Response><CmdType>TGSAlarmRecordList</CmdType><SN>221</SN><Result>OK</Result><RealRecordNum>757383</RealRecordNum><SendRecordNum>200</SendRecordNum><RecordList><alarmrecord><AlarmTime>20070319135341</AlarmTime><TollgateID>113</TollgateID><CarPlate>粤S6G882</CarPlate><PlateType>02</PlateType><DefenceType>违法库</DefenceType><ImageURL>http://213.150.54.8/pic/07031907031136/070319135341021130L047b黑色粤S6G882.jpg</ImageURL><Direction>往虎门方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135341</PassTime></alarmrecord><alarmrecord><AlarmTime>20070319135348</AlarmTime><TollgateID>127</TollgateID><CarPlate>粤S10511</CarPlate><PlateType>02</PlateType><DefenceType>违法库</DefenceType><ImageURL>http://213.150.40.7/pic/07031907024067/070319135348011270L053b白色粤S10511.jpg</ImageURL><Direction>出东莞方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135348</PassTime></alarmrecord><alarmrecord><AlarmTime>20070319135355</AlarmTime><TollgateID>113</TollgateID><CarPlate>粤S34248</CarPlate><PlateType>02</PlateType><DefenceType>违法库</DefenceType><ImageURL>http://213.150.54.8/pic/07031907031136/070319135355021130L041b黑色粤S34248.jpg</ImageURL><Direction>往虎门方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135355</PassTime></alarmrecord></RecordList></Response>";


        TollgateAlarmRecordResponse localTollgateAlarmRecordResponse;


        (localTollgateAlarmRecordResponse = new TollgateAlarmRecordResponse(null)).setXmlContent(s);
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
            return  Integer.parseInt(this.b);
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return 0;
    }


    public int getRecordCurrent() {
        try {
            return  Integer.parseInt(this.c);
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return 0;
    }
    class AlarmrecordBean {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        public AlarmrecordBean(TollgateAlarmRecordResponse paramTollgateAlarmRecordResponse) {
        }

        public Date getAlarmTime() {
            if (ServletContextHelper.isShenxunTollgate()) {
                return new DateUtil().TGS_StringToDate(this.a);
            }


            return new DateUtil().XML_StringToDate(this.a);
        }

        public void setAlarmTime(String paramString) {
            this.a = paramString;
        }

        public String getCarPlate() {
            return this.c;
        }

        public void setCarPlate(String paramString) {
            this.c = paramString;
        }

        public String getDirection() {
            return this.g;
        }

        public void setDirection(String paramString) {
            this.g = paramString;
        }

        public String getImageURL() {
            return this.f;
        }

        public void setImageURL(String paramString) {
            this.f = paramString;
        }

        public Date getPassTime() {
            if (ServletContextHelper.isShenxunTollgate()) {
                return new DateUtil().TGS_StringToDate(this.i);
            }


            return new DateUtil().XML_StringToDate(this.i);
        }

        public void setPassTime(String paramString) {
            this.i = paramString;
        }

        public String getPlateType() {
            return this.d;
        }

        public void setPlateType(String paramString) {
            this.d = paramString;
        }

        public String getDefenceType() {
            return this.e;
        }

        public void setDefenceType(String paramString) {
            this.e = paramString;
        }

        public String getTollgateID() {
            return this.b;
        }

        public void setTollgateID(String paramString) {
            this.b = paramString;
        }

        public String getVehicleSpeed() {
            return this.h;
        }

        public void setVehicleSpeed(String paramString) {
            this.h = paramString;
        }
    }
    class CarrecordBean {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public CarrecordBean(TollgateCarRecordResponse paramTollgateCarRecordResponse) {
        }

        public String getCarPlate() {
            return this.b;
        }

        public void setCarPlate(String paramString) {
            this.b = paramString;
        }

        public String getDirection() {
            return this.e;
        }

        public void setDirection(String paramString) {
            this.e = paramString;
        }

        public String getImageURL() {
            return this.d;
        }

        public void setImageURL(String paramString) {
            this.d = paramString;
        }

        public Date getPassTime() {
            if (ServletContextHelper.isShenxunTollgate()) {
                return new DateUtil().TGS_StringToDate(this.g);
            }


            return new DateUtil().XML_StringToDate(this.g);
        }

        public void setPassTime(String paramString) {
            this.g = paramString;
        }

        public String getPlateType() {
            return this.c;
        }

        public void setPlateType(String paramString) {
            this.c = paramString;
        }

        public String getTollgateID() {
            return this.a;
        }

        public void setTollgateID(String paramString) {
            this.a = paramString;
        }

        public String getVehicleSpeed() {
            return this.f;
        }

        public void setVehicleSpeed(String paramString) {
            this.f = paramString;
        }

        public String toString() {
            StringBuilder localStringBuilder;
            (localStringBuilder = new StringBuilder()).append("TollgateID\t" + this.a + "\n");
            localStringBuilder.append("CarPlate\t" + this.b + "\n");
            localStringBuilder.append("PlateType\t" + this.c + "\n");
            localStringBuilder.append("ImageURL\t" + this.d + "\n");
            localStringBuilder.append("Direction\t" + this.e + "\n");
            localStringBuilder.append("VehicleSpeed\t" + this.f + "\n");
            localStringBuilder.append("PassTime\t" + this.g + "\n");

            return localStringBuilder.toString();
        }
    }

}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateAlarmRecordResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */