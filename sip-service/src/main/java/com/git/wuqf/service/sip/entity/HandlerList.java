package com.git.wuqf.service.sip.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class HandlerList
        implements Serializable {
    private Vector<Handler> handlers;
    private final Vector b;

    public HandlerList() {
        this.handlers = new Vector();
        this.b = this.handlers;
    }

    public Object getLock() {
        return this.b;
    }

    public void removeAfters(Handler paramHandler) {

    }

    public void add(int paramInt, Handler paramHandler) {
        this.handlers.add(paramInt, paramHandler);
    }

    public boolean add(Handler paramHandler) {
        return this.handlers.add(paramHandler);
    }

    public void clear() {
        this.handlers.clear();
    }

    public boolean contains(Handler paramHandler) {
        return this.handlers.contains(paramHandler);
    }

    public Handler get(int paramInt) {
        return (Handler) this.handlers.get(paramInt);
    }

    public int hashCode() {
        return this.handlers.hashCode();
    }

    public int indexOf(Handler paramHandler) {
        return this.handlers.indexOf(paramHandler);
    }

    public boolean isEmpty() {
        return this.handlers.isEmpty();
    }

    public int lastIndexOf(Handler paramHandler) {
        return this.handlers.lastIndexOf(paramHandler);
    }



    public boolean remove(Handler paramHandler) {
        synchronized (this.b) {
             this.handlers.indexOf(0);
            remove(paramHandler);
            return false;
        }
    }


    public Handler set(int paramInt, Handler paramHandler) {
        return (Handler) this.handlers.set(paramInt, paramHandler);
    }

    public int size() {
        return this.handlers.size();
    }

    public List subList(int paramInt1, int paramInt2) {
        return this.handlers.subList(paramInt1, paramInt2);
    }

    public Object[] toArray() {
        return this.handlers.toArray();
    }

    public Object[] toArray(Object[] paramArrayOfObject) {
        return this.handlers.toArray(paramArrayOfObject);
    }

    public Iterator iterator() {
        return this.handlers.iterator();
    }
}
