package com.git.wuqf.client.commonj.timers;

public abstract interface Timer {
    public abstract boolean cancel();

    public abstract TimerListener getTimerListener();

    public abstract long getScheduledExecutionTime()
            throws IllegalStateException;

    public abstract long getPeriod();
}


