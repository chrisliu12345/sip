package com.git.wuqf.service.sip.util;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.MessageContext;

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
        } catch (IOException e) {
            SysLogger.error(SipUtil.class + "->sendSipMessage(SipServletMessage msg):" + e.getMessage());
            SysLogger.printStackTrace(e);
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

        } catch (Rel100Exception e) {
            SysLogger.printStackTrace(e);
            return;
        } catch (Exception e) {
            SysLogger.printStackTrace(e);
        }
    }


    public static int getByeReasonCode(MessageContext paramMessageContext) {
        String h = paramMessageContext.getHeader("Reason");
        int i = 120;
        if (paramMessageContext != null) {
            try {
                i = Integer.parseInt(h);
            } catch (Exception e) {
                SysLogger.printStackTrace(e);
            }
        }
        return i;
    }
}
