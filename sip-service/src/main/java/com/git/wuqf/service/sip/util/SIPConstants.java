package com.git.wuqf.service.sip.util;


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
        Integer result=null;
        if ((paramString == null) || (paramString.length() == 0)) {
            result = 1;
        } else if (!"manual".equalsIgnoreCase(paramString)) {
            if ("alarm".equalsIgnoreCase(paramString)) {


                result = 2;
            } else if ("time".equalsIgnoreCase(paramString)) {
                result = 3;
            } else
                "all".equalsIgnoreCase(paramString);
        } else {
            result = 1;
        }
        return Integer.toString(result);
    }
}
