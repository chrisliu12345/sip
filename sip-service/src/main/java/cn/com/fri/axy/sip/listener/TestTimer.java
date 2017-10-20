package cn.com.fri.axy.sip.listener;

import commonj.timers.Timer;
import commonj.timers.TimerListener;

import javax.servlet.sip.SipSession;

public class TestTimer implements TimerListener {
    private SipSession a;

    public TestTimer(SipSession paramSipSession) {
        this.a = paramSipSession;
    }


    public void timerExpired(Timer paramTimer) {
        cn.com.fri.axy.common.util.SysLogger.info(
                getClass() + "\nSession CallId:" + this.a.getCallId() + "\nSession Id:" + this.a.getId());
        SIPTimerService.getInstance().getTimerManager().schedule(this, 10000L);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/listener/TestTimer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */