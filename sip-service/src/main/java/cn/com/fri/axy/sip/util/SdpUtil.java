package cn.com.fri.axy.sip.util;


public class SdpUtil {
    public static String modifyRecordInviteSdp(String paramString) {
        paramString.replaceAll("RTP/AVP\\s34\\s31", "RTP/AVP 34 31\r\na=fmtp:34 QCIF=1");


        String str = paramString.substring(0, paramString.indexOf("t=0 0"));
        paramString = paramString.substring(paramString.indexOf("t=0 0"), paramString.length());


        return paramString = str + "b=CT:1000\n" + paramString;
    }

    public static String modifyReInviteSdp(String paramString) {
        String str1 = paramString.substring(0, paramString.indexOf("RTP/AVP 0") + "RTP/AVP 0".length());

        String str2 = paramString.substring(paramString.indexOf("RTP/AVP 0") + "RTP/AVP 0".length(),
                paramString.indexOf("RTP/AVP 34") + "RTP/AVP 34".length());
        paramString = paramString.substring(paramString.indexOf("RTP/AVP 34") + "RTP/AVP 34".length(), paramString.length());

        return paramString = str1 + " 8" + str2 + " 98" + paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/SdpUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */