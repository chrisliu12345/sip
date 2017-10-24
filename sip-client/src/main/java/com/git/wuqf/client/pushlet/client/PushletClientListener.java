package com.git.wuqf.client.pushlet.client;

import com.git.wuqf.client.pushlet.core.Event;
import com.git.wuqf.client.pushlet.core.Protocol;

public abstract interface PushletClientListener
        extends Protocol {
    public abstract void onAbort(Event paramEvent);

    public abstract void onData(Event paramEvent);

    public abstract void onHeartbeat(Event paramEvent);

    public abstract void onError(String paramString);
}


