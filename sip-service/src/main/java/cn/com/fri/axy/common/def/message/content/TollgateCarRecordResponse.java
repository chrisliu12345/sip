package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;

import java.util.Iterator;
import java.util.Vector;


public class TollgateCarRecordResponse
        extends ResMessage
        implements IRecordListResponse {
    private String a;
    private String b;
    private String c;
    private Vector d;

    public String toString() {
        StringBuilder localStringBuilder;
        (localStringBuilder = new StringBuilder()).append("SN\t" + getSn() + "\n");
        localStringBuilder.append("Result\t" + this.a + "\n");
        localStringBuilder.append("RealRecordNum\t" + this.b + "\n");
        localStringBuilder.append("SendRecordNum\t" + this.c + "\n");

        for (Iterator localIterator = this.d.iterator(); localIterator.hasNext(); ) {
             localIterator.next();

            localStringBuilder.append(toString());
        }

        return localStringBuilder.toString();
    }


    public TollgateCarRecordResponse(String paramString) {
        super(paramString, "TGSCarRecordList");
    }


    public void genParameters() {
        Object localObject1 = getXmlContent();
        setSn(((String) localObject1).substring(((String) localObject1).indexOf("<SN>") + "<SN>".length(), ((String) localObject1).indexOf("</SN>")));
        this.a = ((String) localObject1).substring(((String) localObject1).indexOf("<Result>") + "<Result>".length(), ((String) localObject1).indexOf("</Result>"));
        this.b = ((String) localObject1).substring(((String) localObject1).indexOf("<RealRecordNum>") + "<RealRecordNum>".length(), ((String) localObject1).indexOf("</RealRecordNum>"));
        this.c = ((String) localObject1).substring(((String) localObject1).indexOf("<SendRecordNum>") + "<SendRecordNum>".length(), ((String) localObject1).indexOf("</SendRecordNum>"));

        this.d = new Vector();
        if (((String) localObject1).indexOf("<CarRecord>") > -1) {


            localObject1 = ((String) localObject1).split("<CarRecord>");
        } else {
            SysLogger.info("no record");
            return;
        }

//        Object localObject2;
//        int j = ( localObject1).length;
//        for (int i = 0; i < j; i++) {
//            if ((localObject1 = localObject2[i]).indexOf("<TollgateID>") > -1) {
//                SysLogger.info(localObject1);
//                TollgateCarRecordResponse.CarrecordBean localCarrecordBean;
//                TollgateCarRecordResponse.CarrecordBean.a(localCarrecordBean = new TollgateCarRecordResponse.CarrecordBean(this), ((String) localObject1).substring(((String) localObject1).indexOf("<TollgateID>") + "<TollgateID>".length(), ((String) localObject1).indexOf("</TollgateID>")));
//                TollgateCarRecordResponse.CarrecordBean.b(localCarrecordBean, ((String) localObject1).substring(((String) localObject1).indexOf("<CarPlate>") + "<CarPlate>".length(), ((String) localObject1).indexOf("</CarPlate>")));
//                TollgateCarRecordResponse.CarrecordBean.c(localCarrecordBean, ((String) localObject1).substring(((String) localObject1).indexOf("<PlateType>") + "<PlateType>".length(), ((String) localObject1).indexOf("</PlateType>")));
//                TollgateCarRecordResponse.CarrecordBean.d(localCarrecordBean, ((String) localObject1).substring(((String) localObject1).indexOf("<ImageURL>") + "<ImageURL>".length(), ((String) localObject1).indexOf("</ImageURL>")));
//                TollgateCarRecordResponse.CarrecordBean.e(localCarrecordBean, ((String) localObject1).substring(((String) localObject1).indexOf("<Direction>") + "<Direction>".length(), ((String) localObject1).indexOf("</Direction>")));
//                TollgateCarRecordResponse.CarrecordBean.f(localCarrecordBean, ((String) localObject1).substring(((String) localObject1).indexOf("<VehicleSpeed>") + "<VehicleSpeed>".length(), ((String) localObject1).indexOf("</VehicleSpeed>")));
//                TollgateCarRecordResponse.CarrecordBean.g(localCarrecordBean, ((String) localObject1).substring(((String) localObject1).indexOf("<PassTime>") + "<PassTime>".length(), ((String) localObject1).indexOf("</PassTime>")));
//                this.d.add(localCarrecordBean);
//            }
//        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s =
                "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\"?><Response><CmdType>TGSCarRecordList</CmdType><SN>221</SN><Result>OK</Result><RealRecordNum>757383</RealRecordNum><SendRecordNum>200</SendRecordNum><RecordList><CarRecord><TollgateID>113</TollgateID><CarPlate>粤S6G882</CarPlate><PlateType>02</PlateType><ImageURL>http://213.150.54.8/pic/07031907031136/070319135341021130L047b黑色粤S6G882.jpg</ImageURL><Direction>往虎门方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135341</PassTime></CarRecord><CarRecord><TollgateID>127</TollgateID><CarPlate>粤S10511</CarPlate><PlateType>02</PlateType><ImageURL>http://213.150.40.7/pic/07031907024067/070319135348011270L053b白色粤S10511.jpg</ImageURL><Direction>出东莞方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135348</PassTime></CarRecord><CarRecord><TollgateID>113</TollgateID><CarPlate>粤S34248</CarPlate><PlateType>02</PlateType><ImageURL>http://213.150.54.8/pic/07031907031136/070319135355021130L041b黑色粤S34248.jpg</ImageURL><Direction>往虎门方向</Direction><VehicleSpeed>-1</VehicleSpeed><PassTime>20070319135355</PassTime></CarRecord></RecordList></Response>";


        TollgateCarRecordResponse localTollgateCarRecordResponse;


        (localTollgateCarRecordResponse = new TollgateCarRecordResponse(null)).setXmlContent(s);
        localTollgateCarRecordResponse.genParameters();
        System.out.println(localTollgateCarRecordResponse.toString());
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

    public Vector getCarrecordBeans() {
        return this.d;
    }


    public int getRecordSum() {
        try {
            return  Integer.parseInt(this.b);
        } catch (Exception localException) {
            SysLogger.printStackTrace( localException);
        }
        return 0;
    }


    public int getRecordCurrent() {
        try {
            return  Integer.parseInt(this.c);
        } catch (Exception localException) {
            SysLogger.printStackTrace( localException);
        }
        return 0;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateCarRecordResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */