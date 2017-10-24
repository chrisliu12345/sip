package com.git.wuqf.service.sip.core.asyn.service;

import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.asyn.Service;

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
            SysLogger.printStackTrace( localException);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/service/AsynObserverService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */