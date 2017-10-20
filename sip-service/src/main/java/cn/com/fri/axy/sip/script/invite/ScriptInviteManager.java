package cn.com.fri.axy.sip.script.invite;

import cn.com.fri.axy.common.util.SysLogger;

import java.util.*;


public class ScriptInviteManager {
    private static ScriptInviteManager a = new ScriptInviteManager();

    private Map b;


    private ScriptInviteManager() {
        init();
    }

    public void init() {
        SysLogger.info(getClass() + ":\n" + "do InviteManager init...");
        this.b = Collections.synchronizedMap(new HashMap());
    }

    public static synchronized ScriptInviteManager getInstance() {
        return a;
    }


    public void addInviteSession(String paramString, ScriptInviteHandler paramScriptInviteHandler) {
        this.b.put(paramString, paramScriptInviteHandler);
    }


    public Map getAllInviteSession() {
        return this.b;
    }


    public ScriptInviteHandler getInviteSession(String paramString) {
        return (ScriptInviteHandler) this.b.get(paramString);
    }


    public void removeInviteSession(String paramString) {
        SysLogger.info("delete " + paramString);
        this.b.remove(paramString);
    }


    public void endInviteSession(String paramString) {
        ((ScriptInviteHandler) this.b.remove(paramString)).sendBye();
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
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/script/invite/ScriptInviteManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */