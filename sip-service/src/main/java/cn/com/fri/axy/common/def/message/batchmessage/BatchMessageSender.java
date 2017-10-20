package cn.com.fri.axy.common.def.message.batchmessage;

import cn.com.fri.axy.common.def.notify.NotifyObject;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ReqMessage;
import cn.com.fri.axy.sip.message.content.ResMessage;
import cn.com.fri.axy.sip.message.entity.MessageHandler;

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
             ReqMessage reqMessage =(ReqMessage)localIterator.next();

            try {
                MessageHandler.getInstance().sendMessage(reqMessage);

            } catch (IllegalArgumentException localIllegalArgumentException) {
                localIllegalArgumentException.printStackTrace();

            }
        }
    }


    public void update(Observable paramObservable, Object paramObject) {
        if ((paramObject instanceof NotifyObject)) {
            paramObservable = (Observable) paramObject;

            observables.add(paramObservable);
            if (d.incrementAndGet() == 0) {
                SysLogger.info("do transaction");
                for (paramObservable = this.observables.iterator();
                     paramObservable.hasNext(); ((ResMessage) (this = (NotifyObject) paramObservable.next()).getResponse()).dealNotify()) {
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