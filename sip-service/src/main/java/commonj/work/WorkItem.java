package commonj.work;

public abstract interface WorkItem
        extends Comparable {
    public abstract Work getResult()
            throws WorkException;

    public abstract int getStatus();
}


