package com.git.wuqf.client.pushlet.test;

import com.git.wuqf.client.pushlet.client.PushletClient;
import com.git.wuqf.client.pushlet.client.PushletClientListener;
import com.git.wuqf.client.pushlet.core.Event;
import com.git.wuqf.client.pushlet.core.Protocol;
import com.git.wuqf.client.pushlet.util.PushletException;

import java.util.HashMap;
import java.util.Map;


public class PushletPingApplication
        extends Thread
        implements PushletClientListener, Protocol {
    private PushletClient pushletClient;
    private String host;
    private int port;
    private static final String SUBJECT = "ping";
    private static final long PUBLISH_INTERVAL_MILLIS = 3000L;

    public PushletPingApplication(String aHost, int aPort) {
        this.host = aHost;
        this.port = aPort;
    }

    public void run() {
        try {
            this.pushletClient = new PushletClient(this.host, this.port);
            this.pushletClient.setDebug(true);
            this.pushletClient.join();
            this.pushletClient.listen(this, "stream");


            String subscriptionId = this.pushletClient.subscribe("ping");
            this.pushletClient.unsubscribe(subscriptionId);


            this.pushletClient.subscribe("ping");
            p("pushletClient started");
        } catch (PushletException pe) {
            p("Error in setting up com.git.wuqf.pushlet session pe=" + pe);
            return;
        }


        Map eventData = new HashMap(2);
        int seqNr = 1;
        try {
            for (; ; ) {
                eventData.put("seqNr", "" + seqNr++);
                eventData.put("time", "" + System.currentTimeMillis());


                this.pushletClient.publish("ping", eventData);

                p("published ping # " + (seqNr - 1) + " - sleeping...");
                Thread.sleep(3000L);
            }
        } catch (Exception e) {
            p("Postlet exception: " + e);
            System.exit(-1);
        }
    }


    public void onError(String message) {
        p(message);
    }

    public void onAbort(Event theEvent) {
        p("onAbort received: " + theEvent);
    }


    public void onData(Event theEvent) {
        long then = Long.parseLong(theEvent.getField("time"));
        long delay = System.currentTimeMillis() - then;
        p("onData: ping #" + theEvent.getField("seqNr") + " in " + delay + " ms");
    }

    public void onHeartbeat(Event theEvent) {
        p("onHeartbeat received: " + theEvent);
    }

    public void p(String s) {
        System.out.println("[PushletPing] " + s);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            if (args.length == 0) {
                new PushletPingApplication("localhost", 8080).start();
            } else {
                new PushletPingApplication(args[0], Integer.parseInt(args[1])).start();
            }
        }
    }
}


