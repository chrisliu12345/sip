package com.git.wuqf.service.sip.util;

import javax.servlet.ServletContext;
import javax.servlet.sip.Address;
import javax.servlet.sip.SipFactory;
import javax.servlet.sip.TimerService;


public class ServletContextHelper {
    private static ServletContext a;
    private static SipFactory b;
    private static TimerService c;
    private static String d;
    private static boolean e;
    private static Address f;
    private static String g;
    private static boolean h;
    private static int i = 60000;

    private static int j;
    private static boolean k;

    public static int getMessage_MaxResendCount() {
        return j;
    }

    public static void setMessage_MaxResendCount(int paramInt) {
        j = paramInt;
    }

    public static int getMessage_ExpireTime() {
        return i;
    }

    public static TimerService getTimerService() {
        return c;
    }

    public static void setTimerService(TimerService paramTimerService) {
        c = paramTimerService;
    }

    public static ServletContext getServletContext() {
        return a;
    }

    public static void setServletContext(ServletContext paramServletContext) {
        a = paramServletContext;
    }

    public static String getServletName() {
        return d;
    }

    public static void setServletName(String paramString) {
        d = paramString;
    }

    public static SipFactory getSipFactory() {
        return b;
    }

    public static void setSipFactory(SipFactory paramSipFactory) {
        b = paramSipFactory;
    }

    public static boolean isUsed_Router() {
        return e;
    }

    public static void setUsed_Router(boolean paramBoolean) {
        e = paramBoolean;
    }

    public static boolean isUsed_FluxControl() {
        return h;
    }

    public static void setUsed_FluxControl(boolean paramBoolean) {
        h = paramBoolean;
    }


    public static Address getRouterAddress() {
        return f;
    }

    public static void setRouterAddress(Address paramAddress) {
        f = paramAddress;
    }

    public static String getWs_deviceinfo_url() {
        return g;
    }

    public static void setWs_deviceinfo_url(String paramString) {
        g = paramString;
    }

    public static boolean isShenxunTollgate() {
        return k;
    }

    public static void setShenxunTollgate(boolean paramBoolean) {
        k = paramBoolean;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/ServletContextHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */