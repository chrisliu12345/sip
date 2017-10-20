package cn.com.fri.axy.sip.util;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.MessageContext;

import javax.servlet.sip.Rel100Exception;
import javax.servlet.sip.SipServletMessage;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import java.io.IOException;


public class SipUtil {
    public static void sendSipMessage(SipServletMessage paramSipServletMessage) {
        SysLogger.info("send out message:\n" + paramSipServletMessage);
        String str;
        if ((paramSipServletMessage instanceof SipServletRequest)) {
            str = "SIP Request-" + ((SipServletRequest) paramSipServletMessage).getMethod();
        } else {
            str = "SIP Response-" + ((SipServletResponse) paramSipServletMessage).getStatus();
        }

        SysLogger.info(SipUtil.class + str);
        try {
            paramSipServletMessage.send();
            return;
        } catch (IOException paramSipServletMessage) {
            SysLogger.error(SipUtil.class + "->sendSipMessage(SipServletMessage msg):" + paramSipServletMessage.getMessage());
            SysLogger.printStackTrace(paramSipServletMessage);
        }
    }


    public static void sendSipMessage(SipServletResponse paramSipServletResponse, boolean paramBoolean) {
        String str = "SIP Response-" + paramSipServletResponse.getStatus();

        try {
            if (!paramBoolean) {
                SysLogger.info(str + ",call SipServletResponse.send() to send response");
                paramSipServletResponse.send();
                return;
            }


            SysLogger.info(str + ",call SipServletResponse.sendReliably() to send response");
            paramSipServletResponse.sendReliably();
            return;

        } catch (Rel100Exception localRel100Exception) {
            SysLogger.printStackTrace(paramSipServletResponse = localRel100Exception);
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace(paramSipServletResponse = localException);
        }
    }


    public static int getByeReasonCode(MessageContext paramMessageContext) {
        paramMessageContext = paramMessageContext.getHeader("Reason");
        int i = 120;
        if (paramMessageContext != null) {
            try {
                i = Integer.parseInt(paramMessageContext);
            } catch (Exception localException) {
                SysLogger.printStackTrace(paramMessageContext = localException);
            }
        }


        return i;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/SipUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */