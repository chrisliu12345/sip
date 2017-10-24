package com.git.wuqf.client.pushlet.test;

import com.git.wuqf.client.pushlet.client.PushletClient;
import com.git.wuqf.client.pushlet.core.Event;
import com.git.wuqf.client.pushlet.util.PushletException;
import com.git.wuqf.client.pushlet.client.PushletClientListener;
import com.git.wuqf.client.pushlet.core.Protocol;

public class SimpleListener
        implements PushletClientListener, Protocol {
    private static String SUBJECT = "/temperature";
    private static final String MODE = "stream";

    public SimpleListener(String aHost, int aPort) {
        try {
            PushletClient pushletClient = new PushletClient(aHost, aPort);
            pushletClient.setDebug(false);
            pushletClient.join();
            pushletClient.listen(this, "stream", SUBJECT);
            p("pushletClient started");
        } catch (PushletException pe) {
            p("Error in setting up com.git.wuqf.pushlet session pe=" + pe);
        }
    }

    public void onError(String message) {
        p(message);
    }

    public void onAbort(Event theEvent) {
        p("onAbort received: " + theEvent);
    }

    public void onData(Event theEvent) {
        System.out.println(theEvent.toXML());
    }

    public void onHeartbeat(Event theEvent) {
        p("onHeartbeat received: " + theEvent);
    }

    public void p(String s) {
        System.out.println("[SimpleListener] " + s);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            new SimpleListener("localhost", 8080);
        } else if (args.length == 1) {
            SUBJECT = args[0];
            new SimpleListener("localhost", 8080);
        } else {
            SUBJECT = args[0];

            new SimpleListener(args[1], Integer.parseInt(args[2]));
        }
    }
}
