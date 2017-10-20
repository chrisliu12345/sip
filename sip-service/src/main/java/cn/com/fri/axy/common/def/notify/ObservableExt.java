package cn.com.fri.axy.common.def.notify;

import java.util.Observable;


public class ObservableExt
        extends Observable {
    public void notifyObservers(Object paramObject) {
        setChanged();
        super.notifyObservers(paramObject);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/notify/ObservableExt.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */