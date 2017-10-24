package com.git.wuqf.client.pushlet.core;

public abstract interface EventSource {
    public abstract void activate();

    public abstract void passivate();

    public abstract void stop();
}


