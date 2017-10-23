package cn.com.fri.axy.sip.script;

import cn.com.fri.axy.sip.core.asyn.AsyncServiceDispatcher;

import java.util.Iterator;
import java.util.Vector;

import static org.apache.commons.collections.CollectionUtils.isEmpty;


public class CallEngine {
    private Vector a = new Vector();

    public Vector getV() {
        return this.a;
    }

    public void addCallParamBean(CallBean paramCallBean) {
        this.a.add(paramCallBean);
    }


    public void launch(String paramString) {
        Vector content = XMLParseHelper.readXMLFile(paramString);
        if ((content == null) || (isEmpty(content))) {
            throw new IllegalStateException("hava no element to start.");
        }
        Iterator i = content.iterator();

        for (; i.hasNext(); ) {
            CallBean c = (CallBean) i.next();

            new AsyncServiceDispatcher().callService(new CallService(c));
        }
    }

    public static void main(String[] paramArrayOfString) {
    }
}
