package com.git.wuqf.service.common.def.message.batchmessage;

import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.util.SysLogger;

import java.util.Observable;
import java.util.Observer;


public class SimpleObserver
        implements Observer {
    public void update(Observable paramObservable, Object paramObject) {
        if (( ((NotifyObject) paramObject).getResponse()) != null) {
            SysLogger.info(((NotifyObject) paramObject).getResponse().toString());
            return;
        }


        SysLogger.info("response is null.");
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/batchmessage/SimpleObserver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */