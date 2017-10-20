package cn.com.fri.axy.common.def.message.content.remoteconfig;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CameraConfigRecordTimeParamRequest
        extends ReqMessage {
    private String a;
    private Long b;
    private String c;
    private String[] d = {"", "", "", ""};
    private String[] e = {"", "", "", ""};
    private Long f;

    public CameraConfigRecordTimeParamRequest(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
        this.a = "";
        this.b = Long.valueOf(0L);
        this.c = "";
        this.f = Long.valueOf(0L);
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("<?xml version=\"1.0\"?>\n");
        localStringBuffer.append("<Query>\n");

        localStringBuffer.append("<CmdType>" + getCmdType() + "</CmdType>\n");

        localStringBuffer.append("<SN>" + getSn() + "</SN>\n");

        localStringBuffer.append("<DeviceID>" + getDeviceID() + "</DeviceID>\n");


        localStringBuffer.append("<RecordTimeParam>\n");
        if (this.b != null) {
            if (this.b.longValue() == 1L) {
                localStringBuffer.append("<Day>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");


                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin1>" + getStartTimes()[0] + "</Begin1>\n");
                localStringBuffer.append("<End1>" + getEndTimes()[0] + "</End1>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin2>" + getStartTimes()[1] + "</Begin2>\n");
                localStringBuffer.append("<End2>" + getEndTimes()[1] + "</End2>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin3>" + getStartTimes()[2] + "</Begin3>\n");
                localStringBuffer.append("<End3>" + getEndTimes()[2] + "</End3>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin4>" + getStartTimes()[3] + "</Begin4>\n");
                localStringBuffer.append("<End4>" + getEndTimes()[3] + "</End4>\n");
                localStringBuffer.append("</Item>\n");


                localStringBuffer.append("</Seq>\n");
                localStringBuffer.append("</Day>\n");


            } else if (this.b.longValue() == 2L) {
                localStringBuffer.append("<Week>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");
                localStringBuffer.append("<Time Day=\"" + getPeriodPara() + "\">\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin1>" + getStartTimes()[0] + "</Begin1>\n");
                localStringBuffer.append("<End1>" + getEndTimes()[0] + "</End1>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin2>" + getStartTimes()[1] + "</Begin2>\n");
                localStringBuffer.append("<End2>" + getEndTimes()[1] + "</End2>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin3>" + getStartTimes()[2] + "</Begin3>\n");
                localStringBuffer.append("<End3>" + getEndTimes()[2] + "</End3>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin4>" + getStartTimes()[3] + "</Begin4>\n");
                localStringBuffer.append("<End4>" + getEndTimes()[3] + "</End4>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("</Time>\n");
                localStringBuffer.append("</Seq>\n");
                localStringBuffer.append("</Week>\n");


            } else if (this.b.longValue() == 3L) {
                localStringBuffer.append("<Month>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");
                localStringBuffer.append("<Time Day=\"" + getPeriodPara() + "\">\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin1>" + getStartTimes()[0] + "</Begin1>\n");
                localStringBuffer.append("<End1>" + getEndTimes()[0] + "</End1>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin2>" + getStartTimes()[1] + "</Begin2>\n");
                localStringBuffer.append("<End2>" + getEndTimes()[1] + "</End2>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin3>" + getStartTimes()[2] + "</Begin3>\n");
                localStringBuffer.append("<End3>" + getEndTimes()[2] + "</End3>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin4>" + getStartTimes()[3] + "</Begin4>\n");
                localStringBuffer.append("<End4>" + getEndTimes()[3] + "</End4>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("</Time>\n");
                localStringBuffer.append("</Seq>\n");
                localStringBuffer.append("</Month>\n");


            } else if (this.b.longValue() == 0L) {
                localStringBuffer.append("<SpecialDate>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");
                localStringBuffer.append("<Time Date=\"" + getPeriodPara() + "\">\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin1>" + getStartTimes()[0] + "</Begin1>\n");
                localStringBuffer.append("<End1>" + getEndTimes()[0] + "</End1>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin2>" + getStartTimes()[1] + "</Begin2>\n");
                localStringBuffer.append("<End2>" + getEndTimes()[1] + "</End2>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin3>" + getStartTimes()[2] + "</Begin3>\n");
                localStringBuffer.append("<End3>" + getEndTimes()[2] + "</End3>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("<Item>\n");
                localStringBuffer.append("<Begin4>" + getStartTimes()[3] + "</Begin4>\n");
                localStringBuffer.append("<End4>" + getEndTimes()[3] + "</End4>\n");
                localStringBuffer.append("</Item>\n");

                localStringBuffer.append("</Time>\n");
                localStringBuffer.append("</Seq>\n");
                localStringBuffer.append("</SpecialDate>\n");
            }
        }

        localStringBuffer.append("</RecordTimeParam>\n");
        localStringBuffer.append("</Query>\n");
        String str = localStringBuffer.toString();
        try {
            str = new String(str.getBytes(), "gb2312");

        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            SysLogger.info(getClass() + ":\n字符串转换时编码方式有误！");
        }

        setXmlContent(str);

        SysLogger.info("摄像机时间配置信息：" + localStringBuffer.toString());
    }

    public String getDeviceID() {
        if (this.a == null) {
            this.a = "";
        }
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public Long getPeriodType() {
        return this.b;
    }

    public void setPeriodType(Long paramLong) {
        this.b = paramLong;
    }

    public String getPeriodPara() {
        if (this.c == null) {
            this.c = "";
        }
        return this.c;
    }

    public void setPeriodPara(String paramString) {
        this.c = paramString;
    }

    public String[] getStartTimes() {
        return this.d;
    }

    public void setStartTimes(String[] paramArrayOfString) {
        if (paramArrayOfString != null) {
            int i = paramArrayOfString.length > 4 ? 4 : paramArrayOfString.length;
            for (int j = 0; j < i; j++) {
                if ((paramArrayOfString[j] != null) && (!paramArrayOfString[j].equals(""))) {
                    this.d[j] = paramArrayOfString[j];
                }
            }
        }
    }

    public String[] getEndTimes() {
        return this.e;
    }

    public void setEndTimes(String[] paramArrayOfString) {
        if (paramArrayOfString != null) {
            int i = paramArrayOfString.length > 4 ? 4 : paramArrayOfString.length;
            for (int j = 0; j < i; j++) {
                if ((paramArrayOfString[j] != null) && (!paramArrayOfString[j].equals(""))) {
                    this.e[j] = paramArrayOfString[j];
                }
            }
        }
    }

    public Long getSeqNumber() {
        return this.f;
    }

    public void setSeqNumber(Long paramLong) {
        this.f = paramLong;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CameraConfigRecordTimeParamRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */