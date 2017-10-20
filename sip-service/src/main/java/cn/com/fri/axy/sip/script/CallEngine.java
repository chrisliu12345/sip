package cn.com.fri.axy.sip.script;

import cn.com.fri.axy.sip.core.asyn.AsyncServiceDispatcher;

import java.util.Vector;


public class CallEngine {
    private Vector a = new Vector();

    public Vector getV() {
        return this.a;
    }

    public void addCallParamBean(CallBean paramCallBean) {
        this.a.add(paramCallBean);
    }


    public void launch(String paramString) {
        if (((this = XMLParseHelper.readXMLFile(paramString)) == null) || (isEmpty())) {
            throw new IllegalStateException("hava no element to start.");
        }


        for (paramString = iterator(); paramString.hasNext(); ) {
            this = (CallBean) paramString.next();

            new AsyncServiceDispatcher().callService(new CallService(this));
        }
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/script/CallEngine.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */