package com.git.wuqf.service.sip.listener;

import com.git.wuqf.client.commonj.timers.Timer;
import com.git.wuqf.client.commonj.timers.TimerListener;
import com.git.wuqf.service.common.util.SysLogger;

import javax.servlet.sip.SipSession;

public class TestTimer implements TimerListener {
    private SipSession a;

    public TestTimer(SipSession paramSipSession) {
        this.a = paramSipSession;
    }


    public void timerExpired(Timer paramTimer) {
        SysLogger.info(
                getClass() + "\nSession CallId:" + this.a.getCallId() + "\nSession Id:" + this.a.getId());
        SIPTimerService.getInstance().getTimerManager().schedule(this, 10000L);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/listener/TestTimer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */