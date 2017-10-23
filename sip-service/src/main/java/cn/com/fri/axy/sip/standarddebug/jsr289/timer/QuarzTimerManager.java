package cn.com.fri.axy.sip.standarddebug.jsr289.timer;

import cn.com.fri.axy.common.util.SysLogger;
import commonj.timers.Timer;
import commonj.timers.TimerListener;
import commonj.timers.TimerManager;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;


public class QuarzTimerManager
        implements TimerManager {
    public boolean isStopped() {
        return false;
    }


    public boolean isStopping() {
        return false;
    }


    public boolean isSuspended() {
        return false;
    }


    public boolean isSuspending() {
        return false;
    }


    public void resume() {
    }


    public Timer schedule(TimerListener paramTimerListener, Date paramDate) {
        return null;
    }


    public Timer schedule(TimerListener paramTimerListener, long paramLong) {
        try {
            Scheduler s = StdSchedulerFactory.getDefaultScheduler();
            SysLogger.info("scheduler:" + s.toString());
            Object o = "QuarzJob-" + paramTimerListener.toString();
            String str = "DEFAULT";
            //JobDetail localJobDetail = new JobDetail(o, str, QuarzJob.class);

            JobDataMap localJobDataMap;
            (localJobDataMap = new JobDataMap()).put("TimerListener", paramTimerListener);
            QuarzTimer q = new QuarzTimer(str, str);
            localJobDataMap.put("Timer", this);
//            localJobDetail.setJobDataMap(localJobDataMap);

//
//            Date d = new Date();
//                    d.setTime(((Date) localObject2).getTime() + paramLong);
//
//            paramTimerListener = new SimpleTrigger("QuarzTrigger-" + paramTimerListener.toString(), (Date) localObject2);
//            ((Scheduler) localObject1).scheduleJob(localJobDetail, paramTimerListener);
//            ((Scheduler) localObject1).start();
        } catch (Exception localException) {
            SysLogger.printStackTrace(localException);
        }

        return null;
    }


    public Timer schedule(TimerListener paramTimerListener, Date paramDate, long paramLong) {
        return null;
    }


    public Timer schedule(TimerListener paramTimerListener, long paramLong1, long paramLong2) {
        return null;
    }


    public Timer scheduleAtFixedRate(TimerListener paramTimerListener, Date paramDate, long paramLong) {
        return null;
    }


    public Timer scheduleAtFixedRate(TimerListener paramTimerListener, long paramLong1, long paramLong2) {
        return null;
    }


    public void stop() {
    }


    public void suspend() {
    }


    public boolean waitForStop(long paramLong) {
        return false;
    }


    public boolean waitForSuspend(long paramLong) {
        return false;
    }
}
