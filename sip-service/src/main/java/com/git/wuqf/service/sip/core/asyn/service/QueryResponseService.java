package com.git.wuqf.service.sip.core.asyn.service;

import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.asyn.Service;
import com.git.wuqf.service.sip.message.content.ReqMessage;


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
            SysLogger.printStackTrace( localException);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/service/QueryResponseService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */