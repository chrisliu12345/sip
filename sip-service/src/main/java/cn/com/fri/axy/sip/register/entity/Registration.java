package cn.com.fri.axy.sip.register.entity;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.location.LocationService;
import cn.com.fri.axy.sip.register.security.authorizationheader.AuthorizationHeader;
import cn.com.fri.axy.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;
import cn.com.fri.axy.sip.register.security.authorizationheader.DigestAuthorizationHeader;
import cn.com.fri.axy.sip.util.ServletContextHelper;
import com.git.wuqf.commonj.timers.Timer;

import javax.servlet.sip.*;
import java.io.Serializable;
import java.util.*;

public class Registration implements Serializable {
    private final SipURI a;
    private final SipURI b;
    private final String c;
    private final int d;
    private List e;
    private String f;
    private boolean g;
    private AuthorizationHeader h;
    public Timer timer;
    public Date currentDate = new Date();
    public String originalRegister;
    private long i;
    private String j;
    private int k;

    Registration(SipServletRequest paramSipServletRequest) throws ServletParseException {
        this.originalRegister = paramSipServletRequest.toString();

        this.a = a((SipURI) paramSipServletRequest.getTo().getURI(), ServletContextHelper.getSipFactory());
        this.f = this.a.getUser();
        this.c = paramSipServletRequest.getCallId();


        String seq = paramSipServletRequest.getHeader("CSeq");
        int m = seq.indexOf(" ");
        this.d = Integer.parseInt(m == -1 ? seq : seq.substring(0, m));
        this.e = resolveContacts(paramSipServletRequest);

        long l = paramSipServletRequest.getExpires();
        ListIterator<Address> addresses = paramSipServletRequest.getAddressHeaders("Contact");
        for (; addresses.hasNext(); ) {
            Address localAddress = (Address) (addresses).next();
            getContacts().add(localAddress);
            l = Math.max(l, localAddress.getExpires());
        }
        if (l == -1L) {
            l = 60L;
        }
        setExpire(1000L * l);

        this.b = ((SipURI) ((Address) this.e.get(0)).getURI());
        String authHeader = paramSipServletRequest.getHeader("Authorization".toUpperCase());
        if (authHeader != null) {
            SysLogger.info(getClass() + "\n" + "authorizationValue=" + (String) authHeader);
            this.g = true;
            if (((String) authHeader).indexOf("Capability") > -1) {
                this.h = new CapabilityAuthorizationHeader((String) authHeader);
                return;
            }
            if (((String) authHeader).indexOf("Digest") > -1) {
                this.h = new DigestAuthorizationHeader((String) authHeader);
                ((DigestAuthorizationHeader) this.h).setPassword(LocationService.getInstance().getDevicePassword(this.f));
                return;
            }
            SysLogger.info(getClass() + "\n" + "improper header " + (String) authHeader);
            return;
        }
        this.g = false;
        this.h = null;
    }

    private static SipURI a(SipURI paramSipURI, SipFactory paramSipFactory) {
        SipURI sipURI = paramSipFactory.createSipURI(paramSipURI.getUser(), paramSipURI.getHost());
        sipURI.setPort(paramSipURI.getPort());
        Iterator<String> it = sipURI.getParameterNames();
        for (; it.hasNext(); ) {
            sipURI.removeParameter((String) it.next());
        }
        return sipURI;
    }

    public String toString() {
        return
                "uri=" + getUri() + " contacts=" + getContacts() + " expires=" + new Date(getExpiration());
    }

    public SipURI getUri() {
        return this.a;
    }

    public String getCallID() {
        return this.c;
    }

    public int getCseq() {
        return this.d;
    }

    public List getContacts() {
        return this.e;
    }

    public void setContacts(List paramList) {
        this.e = paramList;
    }

    public Address getFirstContacts() {
        return (Address) this.e.get(0);
    }

    public SipURI getFullSipURI() {
        return this.b;
    }

    public long getExpiration() {
        return this.currentDate.getTime() + this.i;
    }

    public String getDeviceID() {
        return this.f;
    }

    public void setDeviceID(String paramString) {
        this.f = paramString;
    }

    public boolean getHasAuthorization() {
        return this.g;
    }

    public void setHasAuthorization(boolean paramBoolean) {
        this.g = paramBoolean;
    }

    public AuthorizationHeader getAuthorizationHeader() {
        return this.h;
    }

    public void setHasAuthorization(AuthorizationHeader paramAuthorizationHeader) {
        this.h = paramAuthorizationHeader;
    }

    public long getExpire() {
        return this.i;
    }

    public void setExpire(long paramLong) {
        this.i = paramLong;
    }

    public Date getCurrentDate() {
        return this.currentDate;
    }

    public String getSeed() {
        return this.j;
    }

    public void setSeed(String paramString) {
        this.j = paramString;
    }

    public List resolveContacts(SipServletRequest paramSipServletRequest) {
        return new ArrayList();
    }

    public int getSecurityLevel() {
        return this.k;
    }

    public void setSecurityLevel(int paramInt) {
        this.k = paramInt;
    }
}
