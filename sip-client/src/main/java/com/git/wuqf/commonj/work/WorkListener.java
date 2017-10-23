package com.git.wuqf.commonj.work;

import java.util.EventListener;

public abstract interface WorkListener
        extends EventListener {
    public abstract void workAccepted(WorkEvent paramWorkEvent);

    public abstract void workRejected(WorkEvent paramWorkEvent);

    public abstract void workStarted(WorkEvent paramWorkEvent);

    public abstract void workCompleted(WorkEvent paramWorkEvent);
}


