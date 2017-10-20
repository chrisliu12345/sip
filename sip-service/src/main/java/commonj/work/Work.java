package commonj.work;

public abstract interface Work
        extends Runnable {
    public abstract void release();

    public abstract boolean isDaemon();
}


