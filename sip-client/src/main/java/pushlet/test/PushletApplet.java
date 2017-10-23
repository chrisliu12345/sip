package pushlet.test;

import pushlet.client.PushletClient;
import pushlet.core.Event;
import pushlet.core.Protocol;
import pushlet.util.PushletException;
import pushlet.client.PushletClientListener;

import java.applet.Applet;
import java.awt.*;


public class PushletApplet
        extends Applet
        implements PushletClientListener, Protocol {
    private TextArea textArea;
    private String host = "localhost";
    private int port = 8080;
    private String subject;
    private PushletClient pushletClient;
    private String VERSION = "15.feb.05 #5";
    private String PUSH_MODE = "pull";


    public void init() {
        this.subject = getParameter("p_subject");

        this.host = getDocumentBase().getHost();
        this.port = getDocumentBase().getPort();


        if (this.port == -1) {
            this.port = 80;
        }

        setLayout(new GridLayout(1, 1));
        this.textArea = new TextArea(15, 40);
        this.textArea.setForeground(Color.yellow);
        this.textArea.setBackground(Color.gray);
        this.textArea.setEditable(false);
        add(this.textArea);
        p("PushletApplet - " + this.VERSION);
    }

    public void start() {
        dbg("start()");
        bailout();
        try {
            this.pushletClient = new PushletClient(this.host, this.port);
            p("Created PushletClient");

            this.pushletClient.join();
            p("Joined server");

            this.pushletClient.listen(this, this.PUSH_MODE);
            p("Listening in mode=" + this.PUSH_MODE);

            this.pushletClient.subscribe(this.subject);
            p("Subscribed to=" + this.subject);
        } catch (PushletException pe) {
            p("Error exception=" + pe);
            bailout();
        }
    }

    public void stop() {
        dbg("stop()");
        bailout();
    }

    public void onAbort(pushlet.core.Event theEvent) {
        p(theEvent.toXML());
        bailout();
    }

    public void onData(pushlet.core.Event theEvent) {
        p(theEvent.toXML());
    }

    public void onHeartbeat(Event theEvent) {
        p(theEvent.toXML());
    }

    public void onError(String message) {
        p(message);
        bailout();
    }

    private void bailout() {
        if (this.pushletClient != null) {
            p("Stopping PushletClient");
            try {
                this.pushletClient.leave();
            } catch (PushletException ignore) {
                p("Error during leave pe=" + ignore);
            }

            this.pushletClient = null;
        }
    }

    private void p(String s) {
        dbg("event: " + s);
        synchronized (this.textArea) {
            this.textArea.append(s + "\n");
        }
    }

    private void dbg(String s) {
        System.out.println("[PushletApplet] " + s);
    }
}


