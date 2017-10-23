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

        Iterator localIterator = getInstance().getAllInviteSession().values().iterator();
        for (; localIterator.hasNext(); ) {
            InviteHandler handler = (InviteHandler) localIterator.next();
            if (((InviteHandler) localIterator.next()).getCallType() == "回放") {
                return handler;
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

        Iterator localIterator = localVector.iterator();
        for (; localIterator.hasNext(); ) {
            str = (String) localIterator.next();
            endInviteSession(str);
        }
    }


    public InviteHandler getInviteHandlerByCallID(String paramString) {
        for (Iterator localIterator = getInstance().getAllInviteSession().values().iterator(); localIterator.hasNext(); ) {
            InviteHandler handler = (InviteHandler) localIterator.next();
            if (handler.getCallID().equalsIgnoreCase(paramString)) {
                return handler;
            }
        }
        return null;
    }


    public void checkSamePlayerIPandPort(String paramString1, String paramString2, int paramInt) {
        Object[] arrayOfObject2 = this.b.values().toArray();
        int j = arrayOfObject2.length;
        for (int i = 0; i < j; i++) {
            Object s = arrayOfObject2[i];
//            if ((s instanceof InviteHandler)) {
//                if ((!paramString1.equalsIgnoreCase((s).getLinkageID())) &&
//                        (((InviteHandler) arrayOfObject1).isSamePlayerIPandPort(paramString2, paramInt))) {
//                    endInviteSession(((InviteHandler) arrayOfObject1).getLinkageID());
//                }
//
//            } else {
//                SysLogger.info(arrayOfObject1.toString());
//            }
        }
    }
}
