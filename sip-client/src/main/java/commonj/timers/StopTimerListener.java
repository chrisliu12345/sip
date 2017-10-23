package commonj.timers;

public abstract interface StopTimerListener
        extends TimerListener {
    public abstract void timerStop(Timer paramTimer);
}


