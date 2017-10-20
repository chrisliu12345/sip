package cn.com.fri.axy.sip.util;


public class SIPConstants {
    public static final String HX_FILE_QUERY_TYPE_MANUAL = "manual";


    public static final String HX_FILE_QUERY_TYPE_ALARM = "alarm";


    public static final String HX_FILE_QUERY_TYPE_TIME = "time";


    public static final String HX_FILE_QUERY_TYPE_ALL = "all";


    public static final int HX_FILE_PD_TYPE_MANUAL = 1;


    public static final int HX_FILE_PD_TYPE_ALARM = 2;


    public static final int HX_FILE_PD_TYPE_TIME = 3;

    public static final int HX_FILE_PD_TYPE_DEFAULT = 1;


    public static String getMediaFileType(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {


            paramString = 1;
        } else if (!"manual".equalsIgnoreCase(paramString)) {
            if ("alarm".equalsIgnoreCase(paramString)) {


                paramString = 2;
            } else if ("time".equalsIgnoreCase(paramString)) {
                paramString = 3;
            } else
                "all".equalsIgnoreCase(paramString);
        } else {
            paramString = 1;
        }


        return Integer.toString(paramString);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/SIPConstants.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */