package cn.com.fri.axy.sip.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class HandlerList
        implements Serializable {
    private Vector a;
    private final Vector b;

    public HandlerList() {
        this.a = new Vector();
        this.b = this.a;
    }

    public Object getLock() {
        return this.b;
    }

    public void removeAfters(Handler paramHandler) {
        synchronized (this.b) {
            if ((paramHandler = indexOf(paramHandler)) != -1) {
                for (Handler localHandler = this.a.size() - 1; localHandler > paramHandler; localHandler--) {
                    remove(localHandler);
                }
            }
        }
    }

    public void add(int paramInt, Handler paramHandler) {
        this.a.add(paramInt, paramHandler);
    }

    public boolean add(Handler paramHandler) {
        return this.a.add(paramHandler);
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Handler paramHandler) {
        return this.a.contains(paramHandler);
    }

    public Handler get(int paramInt) {
        return (Handler) this.a.get(paramInt);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int indexOf(Handler paramHandler) {
        return this.a.indexOf(paramHandler);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public int lastIndexOf(Handler paramHandler) {
        return this.a.lastIndexOf(paramHandler);
    }

    /* Error */
    public Handler remove(int paramInt) {
        Byte code:
        0:aload_0
        1:getfield 7 cn / com / fri / axy / sip / entity / HandlerList:b Ljava/util / Vector;
        4:dup
        5:astore_2
        6:monitorenter
        7:aload_0
        8:getfield 6 cn / com / fri / axy / sip / entity / HandlerList:a Ljava/util / Vector;
        11:iload_1
        12:invokevirtual 16 java / util / Vector:get(I) Ljava / lang / Object;
        15:checkcast 1 cn / com / fri / axy / sip / entity / Handler
        18:dup
        19:astore_0
        20:aload_2
        21:monitorexit
        22:areturn
        23:aload_2
        24:monitorexit
        25:athrow
        Line number table:
        Java source line #87	->byte code offset #0
        Java source line #89	->byte code offset #7
        Java source line #91	->byte code offset #19
        Java source line #87	->byte code offset #23
        Local variable table:
        start length slot name signature
        0 26 0 this HandlerList
        0 26 1 paramInt	int
        5 19 2 Ljava / lang / Object;
        Object
        Exception table:
        from to target type
        7 22 23	finally
        23 25 23	finally
    }

    public boolean remove(Handler paramHandler) {
        synchronized (this.b) {
            paramHandler = this.a.indexOf(paramHandler);

            remove(paramHandler);

            return paramHandler == -1;
        }
    }


    public Handler set(int paramInt, Handler paramHandler) {
        return (Handler) this.a.set(paramInt, paramHandler);
    }

    public int size() {
        return this.a.size();
    }

    public List subList(int paramInt1, int paramInt2) {
        return this.a.subList(paramInt1, paramInt2);
    }

    public Object[] toArray() {
        return this.a.toArray();
    }

    public Object[] toArray(Object[] paramArrayOfObject) {
        return this.a.toArray(paramArrayOfObject);
    }

    public Iterator iterator() {
        return this.a.iterator();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/entity/HandlerList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */