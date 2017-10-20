package cn.com.fri.axy.sip.core.asyn.service;

import cn.com.fri.axy.common.def.notify.NotifyObject;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.asyn.Service;

import java.util.Observer;


public class AsynObserverService
        extends Service {
    private Observer a;
    private NotifyObject b;

    public AsynObserverService(Observer paramObserver, NotifyObject paramNotifyObject) {
        this.a = paramObserver;
        this.b = paramNotifyObject;
    }

    public void service() {
        try {
            this.a.update(null, this.b);
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace(this = localException);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/service/AsynObserverService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */