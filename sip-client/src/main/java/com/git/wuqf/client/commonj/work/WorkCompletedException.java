package com.git.wuqf.client.commonj.work;

import java.util.ArrayList;
import java.util.List;

public class WorkCompletedException  extends WorkException {
    List exceptionList;

    public WorkCompletedException() {
    }

    public WorkCompletedException(String paramString) {
        super(paramString);
    }

    public WorkCompletedException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public WorkCompletedException(Throwable paramThrowable) {
        super(paramThrowable);
    }

    public WorkCompletedException(String paramString, List paramList) {
        super(paramString);
        this.exceptionList = paramList;
    }

    public List getExceptionList() {
        if ((this.exceptionList == null) && (getCause() != null)) {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(getCause());
            return localArrayList;
        }
        return this.exceptionList;
    }
}


