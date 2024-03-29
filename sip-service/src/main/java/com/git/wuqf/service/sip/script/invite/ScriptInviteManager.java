package com.git.wuqf.service.sip.script.invite;

import com.git.wuqf.service.common.util.SysLogger;

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

        Iterator localIterator = localVector.iterator();
        for (; localIterator.hasNext(); ) {
            str = (String) localIterator.next();

            endInviteSession(str);
        }
    }
}