package cn.com.fri.axy.sip.core.asyn.service;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.asyn.Service;

public class TestService
        extends Service {
    public void service() {
        SysLogger.info(getClass() + "\n" + "begin testservice.");
        try {
            Thread.sleep(60000L);
        } catch (Exception localException2) {
            Exception localException1;
            SysLogger.printStackTrace(localException1 = localException2);
        }
        SysLogger.info(getClass() + "\n" + "end testservice.");
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/service/TestService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */