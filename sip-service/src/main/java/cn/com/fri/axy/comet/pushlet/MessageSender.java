package cn.com.fri.axy.comet.pushlet;

import cn.com.fri.axy.common.util.SysLogger;
import com.git.wuqf.pushlet.core.Dispatcher;
import com.git.wuqf.pushlet.core.Event;

public class MessageSender {
    public static final String start = "start";
    public static final String stop = "stop";
    private static MessageSender a = new MessageSender();

    public static MessageSender getInstance() {
        return a;
    }


    public synchronized void send(String paramString) {
        try {
            StringBuffer sb = new StringBuffer();
            char[] arrayOfChar;
            int j = (arrayOfChar = paramString.toCharArray()).length;
            for (int i = 0; i < j; i++) {
                //paramString = (byte) (paramString = arrayOfChar[i]);
                sb.append(paramString);
                sb.append("|");
            }


            Event.createDataEvent("/comet/sip").setField("sip_message", toString());
            Dispatcher.getInstance().multicast(null);
            return;
        } catch (Exception localException) {
            SysLogger.info(localException);
        }
    }


    public synchronized void sendPlayNotify(String paramString1, String paramString2, int paramInt) {
        try {
            SysLogger.info("comet:\n" + paramString1 + "," + paramString2 + "," + paramInt);

            Event event = Event.createDataEvent("/comet/play_notify");
            event.setField("play_notify_action", paramString1);
            event.setField("play_notify_ip", paramString2);
            event.setField("play_notify_port", paramInt);
            Dispatcher.getInstance().multicast(event);
            return;
        } catch (Exception localException) {
            SysLogger.info(localException);
        }
    }

    public static void main(String[] paramArrayOfString) {
        String arg = "REGISTER sip:34020000 SIP/2.0\r\nTo: 34020000001110000001 <sip:34020000001110000001@34020000>\r\nAuthorization: Digest username=\"34020000001110000001\",realm=\"34020000\",nonce=\"bb9854df1bbd418e\",uri=\"sip:34020000\",response=\"ead85be574db243a1040bf8a45b65276\",algorithm=MD5\r\nContent-Length: 0\r\nContact: <sip:34020000001110000001@192.168.1.5:62988;rinstance=25518cc3fda1acf3>;expires=0\r\nCSeq: 8 REGISTER\r\nCall-ID: b87c1715356dec10YzU1Mjg0ZmY4YmY0YmU2YzRmZWNjYjVhYTRiNGIyMTg.\r\nUser-Agent: X-Lite release 1002tx stamp 29712\r\nFrom: 34020000001110000001 <sip:34020000001110000001@34020000>;tag=341c3b44\r\nVia: SIP/2.0/UDP 127.0.0.1:62988;branch=z9hG4bK-d87543-773eb856e46ed454-1--d87543-;rport=62988;received=192.168.1.5\r\nAllow: INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, NOTIFY, MESSAGE, SUBSCRIBE, INFO\r\nMax-Forwards: 70\r\n";
        getInstance().send(arg);
    }
}

