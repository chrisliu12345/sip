package com.git.wuqf.commonj.work;

public abstract interface WorkEvent {
    public static final int WORK_ACCEPTED = 1;
    public static final int WORK_REJECTED = 2;
    public static final int WORK_STARTED = 3;
    public static final int WORK_COMPLETED = 4;

    public abstract int getType();

    public abstract WorkItem getWorkItem();

    public abstract WorkException getException();
}


