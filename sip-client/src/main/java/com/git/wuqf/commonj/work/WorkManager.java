package com.git.wuqf.commonj.work;

import java.util.Collection;

public abstract interface WorkManager {
    public static final long IMMEDIATE = 0L;
    public static final long INDEFINITE = Long.MAX_VALUE;

    public abstract WorkItem schedule(Work paramWork)
            throws WorkException, IllegalArgumentException;

    public abstract WorkItem schedule(Work paramWork, WorkListener paramWorkListener)
            throws WorkException, IllegalArgumentException;

    public abstract boolean waitForAll(Collection paramCollection, long paramLong)
            throws InterruptedException, IllegalArgumentException;

    public abstract Collection waitForAny(Collection paramCollection, long paramLong)
            throws InterruptedException, IllegalArgumentException;
}


