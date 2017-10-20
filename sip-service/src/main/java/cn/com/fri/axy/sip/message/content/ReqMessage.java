package cn.com.fri.axy.sip.message.content;

import cn.com.fri.axy.common.def.notify.NotifyObject;
import cn.com.fri.axy.common.def.notify.ObservableExt;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.listener.SIPTimerService;
import cn.com.fri.axy.sip.message.entity.ResendInterface;
import cn.com.fri.axy.sip.message.session.AppMessageManager;
import cn.com.fri.axy.sip.util.ServletContextHelper;
import commonj.timers.Timer;
import commonj.timers.TimerListener;

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
            SysLogger.printStackTrace(this = localException);
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
            SysLogger.printStackTrace(this = localException);
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

        (
                paramTimer = new NotifyObject()).setCode(213);
        paramTimer.setRequset(this);
        fire(paramTimer);
    }


    public void setHandler(ResendInterface paramResendInterface) {
        this.b = paramResendInterface;
    }

    public String toString() {
        return "req message sn is:" + getSn();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/content/ReqMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */