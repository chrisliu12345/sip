package cn.com.fri.axy.sip.script;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.asyn.Service;

public class CallService extends Service {
    private CallBean a;

    public CallService(CallBean paramCallBean) {
        this.a = paramCallBean;
    }

    public void service() {
        try {
            this.a.link();
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace( localException);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/script/CallService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */