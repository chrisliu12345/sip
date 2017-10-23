package com.git.wuqf.commonj.work;

public abstract interface RemoteWorkItem
        extends WorkItem {
    public abstract void release();

    public abstract WorkManager getPinnedWorkManager();
}


