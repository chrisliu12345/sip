package cn.com.fri.axy.sip.script;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.listener.SIPTimerService;
import cn.com.fri.axy.sip.script.invite.ScriptInviteManager;
import commonj.timers.Timer;
import commonj.timers.TimerListener;


public abstract class CallBean
        implements TimerListener {
    public long startinterval;
    public String linkageID;
    public long stopinterval;

    public long getStartinterval() {
        return this.startinterval;
    }

    public void setStartinterval(long paramLong) {
        this.startinterval = paramLong;
    }

    public String getLinkageID() {
        return this.linkageID;
    }

    public void setLinkageID(String paramString) {
        this.linkageID = paramString;
    }

    public long getStopinterval() {
        return this.stopinterval;
    }

    public void setStopinterval(long paramLong) {
        this.stopinterval = paramLong;
    }

    public void link() {
        SysLogger.info(getClass() + ":\nlink sleep " + this.startinterval);

        if (this.startinterval > 0L) {
            try {
                Thread.sleep(this.startinterval);
            } catch (InterruptedException localInterruptedException2) {
                InterruptedException localInterruptedException1;
                SysLogger.printStackTrace(localInterruptedException1 = localInterruptedException2);
            }
        }

        this.linkageID = startLink();


        if (this.stopinterval > 0L) {
            SIPTimerService.getInstance().getTimerManager().schedule(this, this.stopinterval);
        }
    }


    public abstract String startLink();


    public void unlink() {
        try {
            ScriptInviteManager.getInstance().endInviteSession(this.linkageID);
            return;

        } catch (Exception localException) {
            (this = localException).printStackTrace();
        }
    }


    public void timerExpired(Timer paramTimer) {
        SysLogger.info(getClass() + ":\nunlink" + this.linkageID);
        unlink();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/script/CallBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */