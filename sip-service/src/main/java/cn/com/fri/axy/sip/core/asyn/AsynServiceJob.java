package cn.com.fri.axy.sip.core.asyn;

import cn.com.fri.axy.common.util.SysLogger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;


public class AsynServiceJob
        implements Job {
    public void execute(JobExecutionContext paramJobExecutionContext) {
        this = (Service) paramJobExecutionContext.getMergedJobDataMap().get("Service");

        SysLogger.info("In SimpleQuartzJob - executing its JOB " + toString() + " start.");

        service();
        SysLogger.info("In SimpleQuartzJob - executing its JOB " + toString() + " end.");
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/AsynServiceJob.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */