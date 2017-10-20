package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;
import cn.com.fri.axy.sip.util.ServletContextHelper;

import java.util.Date;
import java.util.Observer;


public class TollgateAlarmRecordRequest
        extends ReqMessage
        implements IRecordListRequest {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;

    public TollgateAlarmRecordRequest(String paramString, Observer paramObserver) {
        super(paramString, "TGSAlarmRecordList", paramObserver);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>\n");
        localStringBuffer.append("<Query>\n");

        localStringBuffer.append("<CmdType>TGSAlarmRecordList</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<BeginTime>" + this.a + "</BeginTime>\n");
        localStringBuffer.append("<EndTime>" + this.b + "</EndTime>\n");

        if (this.c != null) {
            localStringBuffer.append("<TollgateID>" + this.c + "</TollgateID>\n");
        }

        localStringBuffer.append("<CarPlate>" + this.d + "</CarPlate>\n");

        if (this.e != null) {
            localStringBuffer.append("<PlateType>" + this.e + "</PlateType>\n");
        }
        localStringBuffer.append("</Query>\n");

        setXmlContent(localStringBuffer.toString());
    }


    public String getBeginTime() {
        return this.a;
    }

    public void setBeginTime(Date paramDate) {
        SysLogger.info("setBeginTime");
        SysLogger.info("tollgate alarm list get Date param:" + paramDate.toString());
        if (ServletContextHelper.isShenxunTollgate()) {
            this.a = new DateUtil().TGS_DateToString(paramDate);
        } else {
            this.a = new DateUtil().XML_DateToString(paramDate);
        }
        SysLogger.info("tollgate alarm list trans Date to String:" + this.a);
    }

    public String getCarPlate() {
        return this.d;
    }

    public void setCarPlate(String paramString) {
        this.d = paramString;
    }


    public String getEndTime() {
        return this.b;
    }

    public void setEndTime(Date paramDate) {
        SysLogger.info("setEndTime");
        SysLogger.info("tollgate alarm list get Date param:" + paramDate.toString());
        if (ServletContextHelper.isShenxunTollgate()) {
            this.b = new DateUtil().TGS_DateToString(paramDate);
        } else {
            this.b = new DateUtil().XML_DateToString(paramDate);
        }
        SysLogger.info("tollgate alarm list trans Date to String:" + paramDate);
    }

    public String getPlateType() {
        return this.e;
    }

    public void setPlateType(String paramString) {
        this.e = paramString;
    }

    public String getTollgateID() {
        return this.c;
    }

    public void setTollgateID(String paramString) {
        this.c = paramString;
    }

    public boolean addRecordNum(int paramInt1, int paramInt2) {
        synchronized (this) {
            this.f += paramInt2;
            if (this.f >= paramInt1) {
                return true;
            }


            return false;
        }
    }


    public static void main(String[] paramArrayOfString) {
        System.out.println(new Date().toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/TollgateAlarmRecordRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */