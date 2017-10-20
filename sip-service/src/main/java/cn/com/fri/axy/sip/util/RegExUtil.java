package cn.com.fri.axy.sip.util;

import cn.com.fri.axy.common.util.SysLogger;

import java.util.regex.Pattern;


public class RegExUtil {
    public static boolean validateCode(String paramString) {
        try {
            return Pattern.matches("\\d{20}", paramString);
        } catch (Exception localException) {
            SysLogger.printStackTrace(paramString = localException);
        }
        return false;
    }


    public static boolean isMonitorDevice(String paramString) {
        return Pattern.matches("\\d{10}1\\d{9}", paramString);
    }


    public static boolean isCameraDevice(String paramString) {
        return Pattern.matches("\\d{10}131\\d{7}", paramString);
    }


    public static boolean isDisplayDevice(String paramString) {
        return Pattern.matches("\\d{10}133\\d{7}", paramString);
    }


    public static boolean isUserDevice(String paramString) {
        return Pattern.matches("\\d{10}[34]\\d{9}", paramString);
    }


    public static boolean isMediaDispenseServer(String paramString) {
        return Pattern.matches("\\d{10}202\\d{7}", paramString);
    }


    public static boolean isMediaStoreServer(String paramString) {
        return Pattern.matches("\\d{10}210\\d{7}", paramString);
    }


    public static boolean isSIPServer(String paramString) {
        return Pattern.matches("\\d{10}200\\d{7}", paramString);
    }


    public static boolean isCoderDevice(String paramString) {
        return Pattern.matches("\\d{10}113\\d{7}", paramString);
    }


    public static boolean isDecoderDevice(String paramString) {
        return Pattern.matches("\\d{10}114\\d{7}", paramString);
    }


    public static boolean isDVRDevice(String paramString) {
        return Pattern.matches("\\d{10}111\\d{7}", paramString);
    }


    public static boolean isAlarmInputDevice(String paramString) {
        return Pattern.matches("\\d{10}134\\d{7}", paramString);
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = validateCode("13030000001310000001");
        System.out.println(paramArrayOfString);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/RegExUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */