package cn.com.fri.axy.sip.standarddebug.jsr289.timer;

import cn.com.fri.axy.common.util.SysLogger;
import com.git.wuqf.commonj.timers.Timer;
import com.git.wuqf.commonj.timers.TimerListener;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;


public class QuarzTimer
        implements Timer {
    private String a;
    private String b;

    public QuarzTimer(String paramString1, String paramString2) {
        this.a = paramString1;
        this.b = paramString2;
    }


    public boolean cancel() {
        try {
            Scheduler s = StdSchedulerFactory.getDefaultScheduler();
//                    s.deleteJob(a, b);
            SysLogger.info("deleteJob " + this.a + " " + this.b);
            return true;
        } catch (Exception localException) {
            Object localObject;
            SysLogger.printStackTrace( localException);
        }

        return false;
    }


    public long getPeriod() {
        return 0L;
    }


    public long getScheduledExecutionTime() {
        return 0L;
    }


    public TimerListener getTimerListener() {
        return null;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/standarddebug/jsr289/timer/QuarzTimer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */