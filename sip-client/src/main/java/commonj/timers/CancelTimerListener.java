package commonj.timers;

public abstract interface CancelTimerListener
        extends TimerListener {
    public abstract void timerCancel(Timer paramTimer);
}

