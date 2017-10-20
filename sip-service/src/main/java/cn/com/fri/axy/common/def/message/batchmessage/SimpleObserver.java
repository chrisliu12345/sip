package cn.com.fri.axy.common.def.message.batchmessage;

import cn.com.fri.axy.common.def.notify.NotifyObject;
import cn.com.fri.axy.common.util.SysLogger;

import java.util.Observable;
import java.util.Observer;


public class SimpleObserver
        implements Observer {
    public void update(Observable paramObservable, Object paramObject) {
        if ((this = ((NotifyObject) paramObject).getResponse()) != null) {
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