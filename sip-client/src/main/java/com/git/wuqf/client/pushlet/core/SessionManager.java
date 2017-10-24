package com.git.wuqf.client.pushlet.core;

import com.git.wuqf.client.pushlet.util.Rand;
import com.git.wuqf.client.pushlet.util.Sys;
import com.git.wuqf.client.pushlet.util.PushletException;
import com.git.wuqf.client.pushlet.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.server.UID;
import java.util.*;

public class SessionManager
        implements ConfigDefs {
    private static SessionManager instance;
    private Timer timer;

    static {
        try {
            instance = (SessionManager) Config.getClass("sessionmanager.class", "nl.justobjects.com.git.wuqf.pushlet.core.SessionManager").newInstance();
            Log.info("SessionManager created className=" + instance.getClass());
        } catch (Throwable t) {
            Log.fatal("Cannot instantiate SessionManager from config", t);
        }
    }

    private final long TIMER_INTERVAL_MILLIS = 60000L;
    private Map sessions = new HashMap(13);
    private Session[] sessionCache = new Session[0];
    private boolean sessionCacheDirty = false;
    private final Object mutex = new Object();

    public void apply(Object visitor, Method method, Object[] args) {
        synchronized (this.mutex) {
            if (this.sessionCacheDirty) {
                for (int i = 0; i < this.sessionCache.length; i++) {
                    this.sessionCache[i] = null;
                }
                this.sessionCache = ((Session[]) this.sessions.values().toArray(this.sessionCache));
                this.sessionCacheDirty = false;
            }
            for (int i = 0; i < this.sessionCache.length; i++) {
                Session nextSession = this.sessionCache[i];
                if (nextSession == null) {
                    break;
                }
                try {
                    args[0] = nextSession;

                    method.invoke(visitor, args);
                } catch (IllegalAccessException e) {
                    Log.warn("apply: illegal method access: ", e);
                } catch (InvocationTargetException e) {
                    Log.warn("apply: method invoke: ", e);
                }
            }
        }
    }

    public Session createSession(Event anEvent)
            throws PushletException {
        return Session.create(createSessionId());
    }

    public static SessionManager getInstance() {
        return instance;
    }

    public String getStatus() {
        Session[] sessions = getSessions();
        StringBuffer statusBuffer = new StringBuffer();
        statusBuffer.append("SessionMgr: " + sessions.length + " sessions \\n");
        for (int i = 0; i < sessions.length; i++) {
            statusBuffer.append(sessions[i] + "\\n");
        }
        return statusBuffer.toString();
    }

    public void addSession(Session session) {
        synchronized (this.mutex) {
            this.sessions.put(session.getId(), session);
            this.sessionCacheDirty = true;
        }
        info(session.getId() + " at " + session.getAddress() + " added ");
    }

    public Session removeSession(Session aSession) {
        synchronized (this.mutex) {
            Session session = (Session) this.sessions.remove(aSession.getId());
            if (session != null) {
                info(session.getId() + " at " + session.getAddress() + " removed ");
            }
            this.sessionCacheDirty = true;
            return session;
        }
    }

    public void start()
            throws PushletException {
        if (this.timer != null) {
            stop();
        }
        this.timer = new Timer(false);
        this.timer.schedule(new AgingTimerTask(), 60000L, 60000L);
        info("started; interval=60000ms");
    }

    public void stop() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
        synchronized (this.mutex) {
            this.sessions.clear();
        }
        info("stopped");
    }

    protected String createSessionId() {
        if ((Config.hasProperty("session.id.generation")) && (Config.getProperty("session.id.generation").equals("uuid"))) {
            return new UID().toString();
        }
        synchronized (this.mutex) {
            String id;
            for (; ; ) {
                id = Rand.randomName(Config.getIntProperty("session.id.size"));
                if (!hasSession(id)) {
                    break;
                }
            }
            return id;
        }
    }

    protected void info(String s) {
        Log.info("SessionManager: " + new Date() + " " + s);
    }

    protected void warn(String s) {
        Log.warn("SessionManager: " + s);
    }

    protected void debug(String s) {
        Log.debug("SessionManager: " + s);
    }

    /* Error */
    public Session getSession(String anId) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:mutex	Ljava/lang/Object;
        //   4: dup
        //   5: astore_2
        //   6: monitorenter
        //   7: aload_0
        //   8: getfield 12	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:sessions	Ljava/util/Map;
        //   11: aload_1
        //   12: invokeinterface 30 2 0
        //   17: checkcast 13	nl/justobjects/com.git.wuqf.pushlet/core/Session
        //   20: aload_2
        //   21: monitorexit
        //   22: areturn
        //   23: astore_3
        //   24: aload_2
        //   25: monitorexit
        //   26: aload_3
        //   27: athrow
        // Line number table:
        //   Java source line #146	-> byte code offset #0
        //   Java source line #147	-> byte code offset #7
        //   Java source line #148	-> byte code offset #23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	28	0	this	SessionManager
        //   0	28	1	anId	String
        //   5	20	2	Ljava/lang/Object;	Object
        //   23	4	3	localObject1	Object
        // Exception table:
        //   from	to	target	type
        //   7	22	23	finally
        //   23	26	23	finally
        return null;
    }

    /* Error */
    public Session[] getSessions() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:mutex	Ljava/lang/Object;
        //   4: dup
        //   5: astore_1
        //   6: monitorenter
        //   7: aload_0
        //   8: getfield 12	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:sessions	Ljava/util/Map;
        //   11: invokeinterface 18 1 0
        //   16: iconst_0
        //   17: anewarray 13	nl/justobjects/com.git.wuqf.pushlet/core/Session
        //   20: invokeinterface 19 2 0
        //   25: checkcast 20	[Lnl/justobjects/com.git.wuqf.pushlet/core/Session;
        //   28: checkcast 20	[Lnl/justobjects/com.git.wuqf.pushlet/core/Session;
        //   31: aload_1
        //   32: monitorexit
        //   33: areturn
        //   34: astore_2
        //   35: aload_1
        //   36: monitorexit
        //   37: aload_2
        //   38: athrow
        // Line number table:
        //   Java source line #155	-> byte code offset #0
        //   Java source line #156	-> byte code offset #7
        //   Java source line #157	-> byte code offset #34
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	39	0	this	SessionManager
        //   5	31	1	Ljava/lang/Object;	Object
        //   34	4	2	localObject1	Object
        // Exception table:
        //   from	to	target	type
        //   7	33	34	finally
        //   34	37	34	finally
        return null;
    }

    /* Error */
    public int getSessionCount() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:mutex	Ljava/lang/Object;
        //   4: dup
        //   5: astore_1
        //   6: monitorenter
        //   7: aload_0
        //   8: getfield 12	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:sessions	Ljava/util/Map;
        //   11: invokeinterface 31 1 0
        //   16: aload_1
        //   17: monitorexit
        //   18: ireturn
        //   19: astore_2
        //   20: aload_1
        //   21: monitorexit
        //   22: aload_2
        //   23: athrow
        // Line number table:
        //   Java source line #164	-> byte code offset #0
        //   Java source line #165	-> byte code offset #7
        //   Java source line #166	-> byte code offset #19
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	24	0	this	SessionManager
        //   5	16	1	Ljava/lang/Object;	Object
        //   19	4	2	localObject1	Object
        // Exception table:
        //   from	to	target	type
        //   7	18	19	finally
        //   19	22	19	finally
        return 1;
    }

    /* Error */
    public boolean hasSession(String anId) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:mutex	Ljava/lang/Object;
        //   4: dup
        //   5: astore_2
        //   6: monitorenter
        //   7: aload_0
        //   8: getfield 12	nl/justobjects/com.git.wuqf.pushlet/core/SessionManager:sessions	Ljava/util/Map;
        //   11: aload_1
        //   12: invokeinterface 42 2 0
        //   17: aload_2
        //   18: monitorexit
        //   19: ireturn
        //   20: astore_3
        //   21: aload_2
        //   22: monitorexit
        //   23: aload_3
        //   24: athrow
        // Line number table:
        //   Java source line #186	-> byte code offset #0
        //   Java source line #187	-> byte code offset #7
        //   Java source line #188	-> byte code offset #20
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	25	0	this	SessionManager
        //   0	25	1	anId	String
        //   5	17	2	Ljava/lang/Object;	Object
        //   20	4	3	localObject1	Object
        // Exception table:
        //   from	to	target	type
        //   7	19	20	finally
        //   20	23	20	finally
        return false;
    }

    private class AgingTimerTask
            extends TimerTask {
        private long lastRun = Sys.now();
        private long delta;
        private Method visitMethod;

        public AgingTimerTask()
                throws PushletException {
            try {
                Class[] argsClasses = new Class[]{Session.class};
                this.visitMethod = getClass().getMethod("visit", argsClasses);
            } catch (NoSuchMethodException e) {
                Class[] argsClasses;
                throw new PushletException("Failed to setup AgingTimerTask", e);
            }
        }

        public void run() {
            long now = Sys.now();
            this.delta = (now - this.lastRun);
            this.lastRun = now;
            SessionManager.this.debug("AgingTimerTask: tick");

            SessionManager.getInstance().apply(this, this.visitMethod, new Object[1]);
        }

        public void visit(Session aSession) {
            try {
                aSession.age(this.delta);
                SessionManager.this.debug("AgingTimerTask: visit: " + aSession);
                if (aSession.isExpired()) {
                    SessionManager.this.info("AgingTimerTask: Session expired: " + aSession);
                    aSession.stop();
                }
            } catch (Throwable t) {
                SessionManager.this.warn("AgingTimerTask: Error in timer task : " + t);
            }
        }
    }
}
