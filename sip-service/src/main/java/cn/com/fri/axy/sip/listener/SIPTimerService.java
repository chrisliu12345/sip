package cn.com.fri.axy.sip.listener;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.standarddebug.jsr289.timer.QuarzTimerManager;
import com.git.wuqf.commonj.timers.TimerManager;


public class SIPTimerService {
    private static SIPTimerService a = new SIPTimerService();


    private TimerManager b = null;


    public static synchronized SIPTimerService getInstance() {
        return a;
    }


    public TimerManager getTimerManager() {
        if (this.b == null) {
            try {

                this.b = new QuarzTimerManager();
                SysLogger.info(getClass() + ":\n" + "got TimerManager...");
            } catch (Exception localException2) {
                Exception localException1;
                SysLogger.printStackTrace(localException1 = localException2);
            }
        }

        return this.b;
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/listener/SIPTimerService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */