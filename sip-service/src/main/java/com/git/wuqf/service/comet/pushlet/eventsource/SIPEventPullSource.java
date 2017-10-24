package com.git.wuqf.service.comet.pushlet.eventsource;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.client.pushlet.core.Event;
import com.git.wuqf.client.pushlet.core.EventPullSource;
import com.git.wuqf.client.pushlet.util.Rand;

import java.util.Date;


public class SIPEventPullSource extends EventPullSource {
    protected long getSleepTime() {
        return Rand.randomLong(2000L, 4000L);
    }


    protected Event pullEvent() {
        Event event= Event.createDataEvent("/comet/sip");
        String str;
        SysLogger.info(str = "test" + new Date());
        event.setField("test", str);

        return event;
    }
}
