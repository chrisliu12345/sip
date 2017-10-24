package com.git.wuqf.service.sip.util;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.init.SSDConfig;


public class ExtSIPApplicationSessionFactory {
    private int a;
    private String b;
    private static ExtSIPApplicationSessionFactory c = new ExtSIPApplicationSessionFactory();

    private ExtSIPApplicationSessionFactory() {
        this.a = 0;
        this.b = "SIPStandardDebug";
    }

    public static ExtSIPApplicationSessionFactory getInstance() {
        return c;
    }

    private synchronized int a() {
        return this.a++;
    }


    public String getNewSIPApplicationKey() {
        StringBuilder localStringBuilder;

        (localStringBuilder = new StringBuilder()).append("(");
        localStringBuilder.append(SSDConfig.getInstance().getSipServerID());
        localStringBuilder.append("-");
        localStringBuilder.append(System.nanoTime());
        localStringBuilder.append("-");
        localStringBuilder.append(a());
        localStringBuilder.append(":");
        localStringBuilder.append(this.b);
        localStringBuilder.append(")");
        SysLogger.info("create appid " + localStringBuilder.toString());
        return localStringBuilder.toString();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/ExtSIPApplicationSessionFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */