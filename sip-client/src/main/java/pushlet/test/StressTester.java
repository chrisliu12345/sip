package pushlet.test;

import pushlet.util.PushletException;
import pushlet.client.PushletClient;
import pushlet.client.PushletClientListener;
import pushlet.core.Event;
import pushlet.core.Protocol;
import pushlet.util.Rand;

import java.util.HashMap;
import java.util.Map;

public class StressTester
        implements Protocol {
    private static String host = "localhost";
    private static int port = 8080;
    private static int TESTER_COUNT = 10;
    private static final String SUBJECT = "/test/ping";
    private static final long MIN_PUBLISH_INTERVAL_MILLIS = 200L;
    private static final long MAX_PUBLISH_INTERVAL_MILLIS = 1000L;
    private static final long MIN_SUBSCRIBER_INTERVAL_MILLIS = 500L;
    private static final long MAX_SUBSCRIBER_INTERVAL_MILLIS = 1000L;

    public void run() {
        new EventPublisher().start();
        new EventSubscriber().start();
    }

    public void err(String s) {
        System.out.println("[StressTester] ERROR" + s);
    }

    public void p(String s) {
        System.out.println("[StressTester] " + s);
    }

    private class EventSubscriber
            extends Thread
            implements PushletClientListener {
        private PushletClient pushletClient;

        public void run() {
            try {
                for (; ; ) {
                    this.pushletClient = new PushletClient(StressTester.host, StressTester.port);

                    this.pushletClient.join();
                    this.pushletClient.listen(this, "stream");

                    String subscriptionId = this.pushletClient.subscribe("/test/ping");
                    this.pushletClient.unsubscribe(subscriptionId);

                    subscriptionId = this.pushletClient.subscribe("/test/ping");

                    sleepRandom();

                    this.pushletClient.unsubscribe(subscriptionId);
                    this.pushletClient.leave();
                }
            } catch (Throwable t) {
                StressTester.this.err("Error in EventSubscriber t=" + t);
            }
        }

        public void onData(Event theEvent) {
            long then = Long.parseLong(theEvent.getField("time"));
            long delay = System.currentTimeMillis() - then;
        }

        private void sleepRandom()
                throws InterruptedException {
            Thread.sleep(Rand.randomLong(500L, 1000L));
        }

        public void onError(String message) {
        }

        public void onAbort(Event theEvent) {
        }

        public void onHeartbeat(Event theEvent) {
        }
    }

    private class EventPublisher
            extends Thread {
        private PushletClient pushletClient;


        public void run() {
            try {
                this.pushletClient = new PushletClient(StressTester.host, StressTester.port);
                this.pushletClient.join();
            } catch (PushletException pe) {
                StressTester.this.err("Error in EventPublisher pe=" + pe);
                return;
            }
            Map eventData = new HashMap(2);
            int seqNr = 1;
            try {
                for (; ; ) {
                    eventData.put("seqNr", "" + seqNr++);
                    eventData.put("time", "" + System.currentTimeMillis());

                    this.pushletClient.publish("/test/ping", eventData);

                    Thread.sleep(Rand.randomLong(200L, 1000L));
                }
            } catch (Exception e) {
                StressTester.this.p("EventPublisher exception: " + e);
            }
        }

        private EventPublisher() {
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            TESTER_COUNT = Integer.parseInt(args[0]);
        }
        if (args.length == 3) {
            host = args[1];
            port = Integer.parseInt(args[2]);
        }
        for (int i = 0; i < TESTER_COUNT; i++) {
            new StressTester().run();
        }
    }
}
