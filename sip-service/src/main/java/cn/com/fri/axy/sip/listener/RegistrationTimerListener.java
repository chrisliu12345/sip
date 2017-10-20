package cn.com.fri.axy.sip.listener;

import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.register.entity.Registration;
import cn.com.fri.axy.sip.register.entity.RegistrationService;
import commonj.timers.Timer;
import commonj.timers.TimerListener;


public class RegistrationTimerListener
        implements TimerListener {
    private Registration a;

    public RegistrationTimerListener(Registration paramRegistration) {
        this.a = paramRegistration;
    }

    public void timerExpired(Timer paramTimer) {
        SysLogger.info(getClass() + ":\n" + this.a.getDeviceID() + " register info timeout");
        SysLogger.info(getClass() + ":\nregister time:" + new DateUtil().XML_DateToString(this.a.getCurrentDate()));
        SysLogger.info(getClass() + ":\nexpire message:\n" + this.a.originalRegister);


        RegistrationService.getInstance().deviceOffline(this.a);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/listener/RegistrationTimerListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */