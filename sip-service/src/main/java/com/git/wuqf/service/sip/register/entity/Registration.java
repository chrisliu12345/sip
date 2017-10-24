package com.git.wuqf.service.sip.register.entity;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.location.LocationService;
import com.git.wuqf.service.sip.register.security.authorizationheader.AuthorizationHeader;
import com.git.wuqf.service.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;
import com.git.wuqf.service.sip.register.security.authorizationheader.DigestAuthorizationHeader;
import com.git.wuqf.service.sip.util.ServletContextHelper;
import com.git.wuqf.client.commonj.timers.Timer;

import javax.servlet.sip.*;
import java.io.Serializable;
import java.util.*;

public class Registration implements Serializable {
    private final SipURI sipURI;
    private final SipURI fullSipURI;
    private final String callId;
    private final int cseq;
    private List contacts;
    private String deviceId;
    private boolean hasAuthorization;
    private AuthorizationHeader authorizationHeader;
    public Timer timer;
    public Date currentDate = new Date();
    public String originalRegister;
    private long expire;
    private String seed;
    private int securityLevel;

    Registration(SipServletRequest sipServletRequest) throws ServletParseException {
        this.originalRegister = sipServletRequest.toString();

        this.sipURI = createSipURI((SipURI) sipServletRequest.getTo().getURI(), ServletContextHelper.getSipFactory());
        this.deviceId = this.sipURI.getUser();
        this.callId = sipServletRequest.getCallId();

        String seq = sipServletRequest.getHeader("CSeq");
        int m = seq.indexOf(" ");
        this.cseq = Integer.parseInt(m == -1 ? seq : seq.substring(0, m));
        this.contacts = resolveContacts(sipServletRequest);

        long l = sipServletRequest.getExpires();
        ListIterator<Address> addresses = sipServletRequest.getAddressHeaders("Contact");
        for (; addresses.hasNext(); ) {
            Address localAddress = addresses.next();
            contacts.add(localAddress);
            l = Math.max(l, localAddress.getExpires());
        }
        if (l == -1L) {
            l = 60L;
        }
        setExpire(1000L * l);

        this.fullSipURI = ((SipURI) ((Address) this.contacts.get(0)).getURI());
        String authHeader = sipServletRequest.getHeader("Authorization".toUpperCase());
        if (authHeader != null) {
            SysLogger.info(getClass() + "\n" + "authorizationValue=" +  authHeader);
            this.hasAuthorization = true;
            if (( authHeader).indexOf("Capability") > -1) {
                this.authorizationHeader = new CapabilityAuthorizationHeader( authHeader);
                return;
            }
            if (authHeader.indexOf("Digest") > -1) {
                this.authorizationHeader = new DigestAuthorizationHeader( authHeader);
                ((DigestAuthorizationHeader) this.authorizationHeader).setPassword(LocationService.getInstance().getDevicePassword(this.deviceId));
                return;
            }
            SysLogger.info(getClass() + "\n" + "improper header " +  authHeader);
            return;
        }
        this.hasAuthorization = false;
        this.authorizationHeader = null;
    }

    private static SipURI createSipURI(SipURI uri, SipFactory sipFactory) {
        SipURI sipURI = sipFactory.createSipURI(uri.getUser(), uri.getHost());
        sipURI.setPort(uri.getPort());
        Iterator<String> it = sipURI.getParameterNames();
        for (; it.hasNext(); ) {
            sipURI.removeParameter( it.next());
        }
        return sipURI;
    }

    public String toString() {
        return "uri=" + getUri() + " contacts=" + getContacts() + " expires=" + new Date(getExpiration());
    }

    public SipURI getUri() {
        return this.sipURI;
    }

    public String getCallID() {
        return this.callId;
    }

    public int getCseq() {
        return this.cseq;
    }

    public List getContacts() {
        return this.contacts;
    }

    public void setContacts(List paramList) {
        this.contacts = paramList;
    }

    public Address getFirstContacts() {
        return (Address) this.contacts.get(0);
    }

    public SipURI getFullSipURI() {
        return this.fullSipURI;
    }

    public long getExpiration() {
        return this.currentDate.getTime() + this.expire;
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public void setDeviceID(String paramString) {
        this.deviceId = paramString;
    }

    public boolean getHasAuthorization() {
        return this.hasAuthorization;
    }

    public void setHasAuthorization(boolean hasAuthorization) {
        this.hasAuthorization = hasAuthorization;
    }

    public AuthorizationHeader getAuthorizationHeader() {
        return this.authorizationHeader;
    }

    public void setHasAuthorization(AuthorizationHeader authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }

    public long getExpire() {
        return this.expire;
    }

    public void setExpire(long paramLong) {
        this.expire = paramLong;
    }

    public Date getCurrentDate() {
        return this.currentDate;
    }

    public String getSeed() {
        return this.seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public List resolveContacts(SipServletRequest sipServletRequest) {
        return new ArrayList();
    }

    public int getSecurityLevel() {
        return this.securityLevel;
    }

    public void setSecurityLevel(int paramInt) {
        this.securityLevel = paramInt;
    }
}
