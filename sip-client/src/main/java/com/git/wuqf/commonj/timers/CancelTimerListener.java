package com.git.wuqf.commonj.timers;

public abstract interface CancelTimerListener
        extends TimerListener {
    public abstract void timerCancel(Timer paramTimer);
}


