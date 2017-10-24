package com.git.wuqf.service.sip.message.content;

import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.def.notify.ObservableExt;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.listener.SIPTimerService;
import com.git.wuqf.service.sip.message.entity.ResendInterface;
import com.git.wuqf.service.sip.message.session.AppMessageManager;
import com.git.wuqf.service.sip.util.ServletContextHelper;
import com.git.wuqf.client.commonj.timers.Timer;
import com.git.wuqf.client.commonj.timers.TimerListener;

import java.util.Observer;


public abstract class ReqMessage
        extends ReqResMessage
        implements TimerListener {
    private ObservableExt a = new ObservableExt();

    private ResendInterface b;

    private Timer c;

    public ReqMessage(String paramString1, String paramString2, Observer paramObserver) {
        super(paramString1, paramString2);

        setAppRequest(true);
        if (paramObserver != null) {
            this.a.addObserver(paramObserver);
        }
    }

    public void addObserver(Observer paramObserver) {
        if (paramObserver != null) {
            this.a.addObserver(paramObserver);
        }
    }

    public void fire(NotifyObject paramNotifyObject) {
        SysLogger.info(getClass() + "\nobserve response.");
        try {
            this.a.notifyObservers(paramNotifyObject);
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace(localException);
        }
    }


    private int d = ServletContextHelper.getMessage_ExpireTime();
    private int e = 0;

    private int f = ServletContextHelper.getMessage_MaxResendCount();


    public void startTimer() {
        this.c = SIPTimerService.getInstance().getTimerManager().schedule(this, this.d);
    }


    public void resend() {
        this.c = SIPTimerService.getInstance().getTimerManager().schedule(this, this.d);

        try {
            this.b.resendMessage(this);
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace(localException);
        }
    }


    public void sendOK() {
        SysLogger.info(getClass() + "\n" + "request message timer cancel.");
        this.c.cancel();
    }


    public void timerExpired(Timer paramTimer) {
        SysLogger.info(getClass() + "\n" + "request message timeout.");

        if (++this.e < this.f) {
            resend();
            return;
        }


        SysLogger.info(getClass() + "\n" + "timeout for sn  \"<SN>" + getSn() + "</SN>\"  enough.");

        AppMessageManager.getInstance().reqMessageTimeout(getSn());

        NotifyObject no = new NotifyObject();
        no.setCode(213);
        no.setRequset(this);
        fire(no);
    }


    public void setHandler(ResendInterface paramResendInterface) {
        this.b = paramResendInterface;
    }

    public String toString() {
        return "req message sn is:" + getSn();
    }
}
