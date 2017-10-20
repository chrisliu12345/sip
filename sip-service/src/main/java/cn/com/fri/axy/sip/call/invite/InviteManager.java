package cn.com.fri.axy.sip.call.invite;

import cn.com.fri.axy.common.util.SysLogger;

import java.util.*;


public class InviteManager {
    private static InviteManager a = new InviteManager();

    private Map b;


    private InviteManager() {
        init();
    }

    public void init() {
        SysLogger.info(getClass() + ":\n" + "do InviteManager init...");
        this.b = Collections.synchronizedMap(new HashMap());
    }

    public static synchronized InviteManager getInstance() {
        return a;
    }


    public void addInviteSession(String paramString, InviteHandler paramInviteHandler) {
        this.b.put(paramString, paramInviteHandler);
    }


    public Map getAllInviteSession() {
        return this.b;
    }


    public InviteHandler getInviteSession(String paramString) {
        return (InviteHandler) this.b.get(paramString);
    }


    public InviteHandler getPlaybackInviteSession() {
        for (Iterator localIterator = getInstance().getAllInviteSession().values().iterator(); localIterator.hasNext(); ) {
            if ((this = (InviteHandler) localIterator.next()).getCallType() == "回放") {
                return this;
            }
        }


        return null;
    }


    public void removeInviteSession(String paramString) {
        SysLogger.info("delete " + paramString);
        this.b.remove(paramString);
    }


    public void endInviteSession(String paramString) {
        ((InviteHandler) this.b.remove(paramString)).sendBye();
    }

    public void endAllInvite() {
        Vector localVector = new Vector();
        String str;
        for (Iterator localIterator = this.b.keySet().iterator(); localIterator.hasNext(); ) {
            str = (String) localIterator.next();

            localVector.add(str);
        }

        for (localIterator = localVector.iterator(); localIterator.hasNext(); ) {
            str = (String) localIterator.next();

            endInviteSession(str);
        }
    }


    public InviteHandler getInviteHandlerByCallID(String paramString) {
        for (Iterator localIterator = getInstance().getAllInviteSession().values().iterator(); localIterator.hasNext(); ) {
            if ((this = (InviteHandler) localIterator.next()).getCallID().equalsIgnoreCase(paramString)) {
                return this;
            }
        }


        return null;
    }


    public void checkSamePlayerIPandPort(String paramString1, String paramString2, int paramInt) {
        Object[] arrayOfObject1;


        Object[] arrayOfObject2;

        int j = (arrayOfObject2 = arrayOfObject1 = this.b.values().toArray()).length;
        for (int i = 0; i < j; i++) {
            if (((arrayOfObject1 = arrayOfObject2[i]) instanceof InviteHandler)) {
                if ((!paramString1.equalsIgnoreCase(((InviteHandler) arrayOfObject1).getLinkageID())) &&
                        (((InviteHandler) arrayOfObject1).isSamePlayerIPandPort(paramString2, paramInt))) {
                    endInviteSession(((InviteHandler) arrayOfObject1).getLinkageID());
                }

            } else {
                SysLogger.info(arrayOfObject1.toString());
            }
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/call/invite/InviteManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */