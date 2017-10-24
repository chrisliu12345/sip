package com.git.wuqf.service.common.def.notify;

import java.util.Observable;


public class ObservableExt
        extends Observable {
    public void notifyObservers(Object paramObject) {
        setChanged();
        super.notifyObservers(paramObject);
    }
}

