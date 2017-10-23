package commonj.work;

public class WorkRejectedException
        extends WorkException {
    public WorkRejectedException() {
    }

    public WorkRejectedException(String paramString) {
        super(paramString);
    }

    public WorkRejectedException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public WorkRejectedException(Throwable paramThrowable) {
        super(paramThrowable);
    }
}


