package cn.com.fri.axy.comet.pushlet.eventsource;

import cn.com.fri.axy.common.util.SysLogger;
import pushlet.core.Event;
import pushlet.core.EventPullSource;
import pushlet.util.Rand;

import java.util.Date;


public class SIPEventPullSource
        extends EventPullSource {
    protected long getSleepTime() {
        return Rand.randomLong(2000L, 4000L);
    }


    protected Event pullEvent() {
        this = Event.createDataEvent("/comet/sip");

        String str;
        SysLogger.info(str = "test" + new Date());
        setField("test", str);

        return this;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/comet/pushlet/eventsource/SIPEventPullSource.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */