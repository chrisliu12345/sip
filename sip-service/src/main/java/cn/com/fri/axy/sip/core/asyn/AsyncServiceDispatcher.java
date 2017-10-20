package cn.com.fri.axy.sip.core.asyn;

import cn.com.fri.axy.common.util.SysLogger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.sql.Date;


public class AsyncServiceDispatcher
        extends ServiceDispatcher {
    public void callService(Service paramService) {
        try {
            this = (this = new StdSchedulerFactory()).getScheduler();


            long l = System.currentTimeMillis();


            JobDetail localJobDetail = new JobDetail("job-AsyncService-" + paramService.toString(),
                    "jobGroup-AsyncService-" + paramService.toString(), AsynServiceJob.class);

            JobDataMap localJobDataMap;
            (localJobDataMap = new JobDataMap()).put("Service", paramService);
            localJobDetail.setJobDataMap(localJobDataMap);


            (


                    paramService = new SimpleTrigger("trigger-AsyncService-" + paramService.toString(), "triggerGroup-AsyncService-" + paramService.toString())).setStartTime(new Date(l));
            scheduleJob(localJobDetail, paramService);


            start();
            return;

        } catch (Exception localException) {

            SysLogger.printStackTrace(this = localException);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/asyn/AsyncServiceDispatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */