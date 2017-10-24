package com.git.wuqf.service.sip.core.asyn;

import com.git.wuqf.service.common.util.SysLogger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;


public class AsynServiceJob
        implements Job {
    public void execute(JobExecutionContext paramJobExecutionContext) {
          paramJobExecutionContext.getMergedJobDataMap().get("Service");

        SysLogger.info("In SimpleQuartzJob - executing its JOB " + toString() + " start.");

        SysLogger.info("In SimpleQuartzJob - executing its JOB " + toString() + " end.");
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/AsynServiceJob.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */