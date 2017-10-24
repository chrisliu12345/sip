package com.git.wuqf.service.common.def.message.content.remoteconfig;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ReqMessage;

import java.io.UnsupportedEncodingException;
import java.util.Observer;


public class CameraConfigRecordTimeParamRequest2
        extends ReqMessage {
    private String a;
    private Long b;
    private String c;
    private String[] d;
    private String[] e;
    private Long f;
    private int g;

    public CameraConfigRecordTimeParamRequest2(String paramString, Observer paramObserver) {
        super(paramString, "DeviceConfig", paramObserver);
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
            int i;
            if (this.b.longValue() == 1L) {
                localStringBuffer.append("<Day>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");


                for (i = 0; i < this.g; i++) {
                    localStringBuffer.append("<Item>\n");
                    localStringBuffer.append("<Begin>" + (getStartTimes()[i] != null ? getStartTimes()[i] : "") + "</Begin>\n");
                    localStringBuffer.append("<End>" + (getEndTimes()[i] != null ? getEndTimes()[i] : "") + "</End>\n");
                    localStringBuffer.append("</Item>\n");
                }


                localStringBuffer.append("</Seq>\n");
                localStringBuffer.append("</Day>\n");


            } else if (this.b.longValue() == 2L) {
                localStringBuffer.append("<Week>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");
                localStringBuffer.append("<Time Day=\"" + getPeriodPara() + "\">\n");

                for (i = 0; i < this.g; i++) {
                    localStringBuffer.append("<Item>\n");
                    localStringBuffer.append("<Begin>" + (getStartTimes()[i] != null ? getStartTimes()[i] : "") + "</Begin>\n");
                    localStringBuffer.append("<End>" + (getEndTimes()[i] != null ? getEndTimes()[i] : "") + "</End>\n");
                    localStringBuffer.append("</Item>\n");
                }

                localStringBuffer.append("</Time>\n");
                localStringBuffer.append("</Seq>\n");
                localStringBuffer.append("</Week>\n");


            } else if (this.b.longValue() == 3L) {
                localStringBuffer.append("<Month>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");
                localStringBuffer.append("<Time Day=\"" + getPeriodPara() + "\">\n");

                for (i = 0; i < this.g; i++) {
                    localStringBuffer.append("<Item>\n");
                    localStringBuffer.append("<Begin>" + (getStartTimes()[i] != null ? getStartTimes()[i] : "") + "</Begin>\n");
                    localStringBuffer.append("<End>" + (getEndTimes()[i] != null ? getEndTimes()[i] : "") + "</End>\n");
                    localStringBuffer.append("</Item>\n");
                }

                localStringBuffer.append("</Time>\n");
                localStringBuffer.append("</Seq>\n");
                localStringBuffer.append("</Month>\n");


            } else if (this.b.longValue() == 0L) {
                localStringBuffer.append("<SpecialDate>\n");
                localStringBuffer.append("<Seq Num=\"" + getSeqNumber() + "\">\n");
                localStringBuffer.append("<Time Date=\"" + getPeriodPara() + "\">\n");

                for (i = 0; i < this.g; i++) {
                    localStringBuffer.append("<Item>\n");
                    localStringBuffer.append("<Begin>" + (getStartTimes()[i] != null ? getStartTimes()[i] : "") + "</Begin>\n");
                    localStringBuffer.append("<End>" + (getEndTimes()[i] != null ? getEndTimes()[i] : "") + "</End>\n");
                    localStringBuffer.append("</Item>\n");
                }

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
        return this.c;
    }

    public void setPeriodPara(String paramString) {
        this.c = paramString;
    }

    public String[] getStartTimes() {
        return this.d;
    }

    public void setStartTimes(String[] paramArrayOfString) {
        this.d = paramArrayOfString;
    }

    public String[] getEndTimes() {
        return this.e;
    }

    public void setEndTimes(String[] paramArrayOfString) {
        this.e = paramArrayOfString;
    }

    public Long getSeqNumber() {
        return this.f;
    }

    public void setSeqNumber(Long paramLong) {
        this.f = paramLong;
    }

    public int getNum() {
        return this.g;
    }

    public void setNum(int paramInt) {
        this.g = paramInt;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/remoteconfig/CameraConfigRecordTimeParamRequest2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */