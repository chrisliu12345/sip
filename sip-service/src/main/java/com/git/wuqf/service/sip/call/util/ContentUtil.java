package com.git.wuqf.service.sip.call.util;

import javax.servlet.sip.SipServletMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public final class ContentUtil {
    public static void copyContent(SipServletMessage paramSipServletMessage1, SipServletMessage paramSipServletMessage2) {
        byte[] arrayOfByte= new byte[0];
        try {
            arrayOfByte = paramSipServletMessage1.getRawContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ((arrayOfByte  == null) || (arrayOfByte.length == 0)) {
            return;
        }
        String s = paramSipServletMessage1.getContentType();
        try {
            paramSipServletMessage2.setContent(arrayOfByte, s);
            return;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
    }
}
