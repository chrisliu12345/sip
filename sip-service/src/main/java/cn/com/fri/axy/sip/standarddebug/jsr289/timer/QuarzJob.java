package cn.com.fri.axy.sip.standarddebug.jsr289.timer;

import commonj.timers.Timer;
import commonj.timers.TimerListener;
import org.quartz.Job;
import org.quartz.JobExecutionContext;


public class QuarzJob
        implements Job {
    public void execute(JobExecutionContext paramJobExecutionContext) {
        this = (TimerListener) paramJobExecutionContext.getMergedJobDataMap().get("TimerListener");
        paramJobExecutionContext = (Timer) paramJobExecutionContext.getMergedJobDataMap().get("Timer");

        timerExpired(paramJobExecutionContext);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/standarddebug/jsr289/timer/QuarzJob.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */