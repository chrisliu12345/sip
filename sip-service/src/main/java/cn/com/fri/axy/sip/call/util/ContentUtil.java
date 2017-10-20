package cn.com.fri.axy.sip.call.util;

import javax.servlet.sip.SipServletMessage;
import java.io.UnsupportedEncodingException;


public final class ContentUtil {
    public static void copyContent(SipServletMessage paramSipServletMessage1, SipServletMessage paramSipServletMessage2) {
        byte[] arrayOfByte;
        if (((arrayOfByte = paramSipServletMessage1.getRawContent()) == null) || (arrayOfByte.length == 0)) {
            return;
        }
        paramSipServletMessage1 = paramSipServletMessage1.getContentType();
        try {
            paramSipServletMessage2.setContent(arrayOfByte, paramSipServletMessage1);
            return;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/call/util/ContentUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */