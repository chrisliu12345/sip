package com.git.wuqf.pushlet.client;

import com.git.wuqf.pushlet.core.Event;
import com.git.wuqf.pushlet.core.Protocol;

public abstract interface PushletClientListener
        extends Protocol {
    public abstract void onAbort(Event paramEvent);

    public abstract void onData(Event paramEvent);

    public abstract void onHeartbeat(Event paramEvent);

    public abstract void onError(String paramString);
}


