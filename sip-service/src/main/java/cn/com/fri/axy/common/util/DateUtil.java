package cn.com.fri.axy.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
    public static final String tgs_dateformat = "yyyyMMddHHmmss";
    public static final String xml_dateformat = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String threeinone_dateformat = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String user_dateformat = "yyyy-MM-dd HH:mm:ss";
    private static DateUtil a = new DateUtil();

    public static DateUtil getInstance() {
        return a;
    }


    public SimpleDateFormat getDateFormat(String paramString) {
        return new SimpleDateFormat(paramString);
    }


    public String TGS_DateToString(Date paramDate) {
        return getDateFormat("yyyyMMddHHmmss").format(paramDate);
    }


    public Date TGS_StringToDate(String paramString) {
        Date localDate = null;

        try {
            localDate = getDateFormat("yyyyMMddHHmmss").parse(paramString);

        } catch (ParseException localParseException) {
            SysLogger.printStackTrace(this = localParseException);
        }

        return localDate;
    }


    public String XML_DateToString(Date paramDate) {
        return getDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(paramDate);
    }


    public String ThreeInOne_DateToString(Date paramDate) {
        return getDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(paramDate);
    }

    public String User_DateToString(Date paramDate) {
        return getDateFormat("yyyy-MM-dd HH:mm:ss").format(paramDate);
    }


    public Date XML_StringToDate(String paramString) {
        Date localDate = null;

        if ((paramString == null) || (paramString.length() == 0)) {
            return null;
        }

        try {
            localDate = getDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(paramString);


        } catch (ParseException localParseException1) {


            if (paramString.indexOf('.') == -1) {
                try {
                    localDate = getDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(paramString + ".0");

                } catch (ParseException localParseException2) {
                    SysLogger.printStackTrace(this = localParseException2);
                }
            }
        }

        return localDate;
    }


    public static void main(String[] paramArrayOfString) {
        (paramArrayOfString = new Date()).setTime(1247472699000L);


        System.out.println(new DateUtil().ThreeInOne_DateToString(paramArrayOfString));
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/util/DateUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */