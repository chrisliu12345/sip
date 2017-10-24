package com.git.wuqf.client.commonj.timers;

import java.util.Date;

public abstract interface TimerManager {
    public static final long IMMEDIATE = 0L;
    public static final long INDEFINITE = Long.MAX_VALUE;

    public abstract void suspend();

    public abstract boolean isSuspending()
            throws IllegalStateException;

    public abstract boolean isSuspended()
            throws IllegalStateException;

    public abstract boolean waitForSuspend(long paramLong)
            throws InterruptedException, IllegalStateException, IllegalArgumentException;

    public abstract void resume()
            throws IllegalStateException;

    public abstract void stop()
            throws IllegalStateException;

    public abstract boolean isStopped();

    public abstract boolean isStopping();

    public abstract boolean waitForStop(long paramLong)
            throws InterruptedException, IllegalArgumentException;

    public abstract Timer schedule(TimerListener paramTimerListener, Date paramDate)
            throws IllegalArgumentException, IllegalStateException;

    public abstract Timer schedule(TimerListener paramTimerListener, long paramLong)
            throws IllegalArgumentException, IllegalStateException;

    public abstract Timer schedule(TimerListener paramTimerListener, Date paramDate, long paramLong)
            throws IllegalArgumentException, IllegalStateException;

    public abstract Timer schedule(TimerListener paramTimerListener, long paramLong1, long paramLong2)
            throws IllegalArgumentException, IllegalStateException;

    public abstract Timer scheduleAtFixedRate(TimerListener paramTimerListener, Date paramDate, long paramLong)
            throws IllegalArgumentException, IllegalStateException;

    public abstract Timer scheduleAtFixedRate(TimerListener paramTimerListener, long paramLong1, long paramLong2)
            throws IllegalArgumentException, IllegalStateException;
}


