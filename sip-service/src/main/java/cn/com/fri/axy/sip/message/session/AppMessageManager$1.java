package cn.com.fri.axy.sip.message.session;

import java.util.LinkedHashMap;


class AppMessageManager$1
        extends LinkedHashMap {
    protected boolean removeEldestEntry(Map.Entry paramEntry) {
        return size() > 3;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/session/AppMessageManager$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */