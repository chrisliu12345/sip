package com.git.wuqf.service.common.def.message.batchmessage;

import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.exception.MessageException;
import com.git.wuqf.service.sip.message.content.ReqMessage;
import com.git.wuqf.service.sip.message.entity.MessageHandler;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;


public class BatchMessageSender
        implements Observer {
    private Vector a;
    private Vector<Observable> observables;
    private int c;
    private AtomicInteger d;

    public static BatchMessageSender newInstance() {
        return new BatchMessageSender();
    }

    private BatchMessageSender() {
        this.a = new Vector();
        this.observables = new Vector();
        this.c = 0;
        this.d = new AtomicInteger();
    }


    public BatchMessageSender put(ReqMessage paramReqMessage) {
        this.a.add(paramReqMessage);
        return this;
    }


    public void send() {
        if (this.a.size() == 0) {
            throw new IllegalStateException();
        }


        for (Iterator localIterator = this.a.iterator(); localIterator.hasNext(); ) {
            ReqMessage reqMessage = (ReqMessage) localIterator.next();

            try {
                MessageHandler.getInstance().sendMessage(reqMessage);

            } catch (IllegalArgumentException localIllegalArgumentException) {
                localIllegalArgumentException.printStackTrace();

            } catch (MessageException e) {
                e.printStackTrace();
            }
        }
    }


    public void update(Observable paramObservable, Object paramObject) {
        if ((paramObject instanceof NotifyObject)) {
            paramObservable = (Observable) paramObject;

            observables.add(paramObservable);
            if (d.incrementAndGet() == 0) {
                SysLogger.info("do transaction");
                Iterator<Observable> s = observables.iterator();
                for (; s.hasNext(); ) {
//                    (( s.next()).getResponse()).dealNotify();
                }
                return;
            }
            SysLogger.info("do nothing");
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/batchmessage/BatchMessageSender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */