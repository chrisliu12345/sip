package cn.com.fri.axy.sip.core.asyn.service;

import cn.com.fri.axy.common.def.notify.NotifyObject;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.asyn.Service;
import cn.com.fri.axy.sip.message.content.ReqMessage;


public class QueryResponseService
        extends Service {
    private ReqMessage a;
    private NotifyObject b;

    public QueryResponseService(ReqMessage paramReqMessage, NotifyObject paramNotifyObject) {
        this.a = paramReqMessage;
        this.b = paramNotifyObject;
    }

    public void service() {
        try {
            this.a.fire(this.b);
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace(this = localException);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/service/QueryResponseService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */