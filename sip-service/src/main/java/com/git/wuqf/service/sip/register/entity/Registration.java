package com.git.wuqf.service.sip.register.entity;

import com.git.wuqf.client.commonj.timers.Timer;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.location.LocationService;
import com.git.wuqf.service.sip.register.security.authorizationheader.AuthorizationHeader;
import com.git.wuqf.service.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;
import com.git.wuqf.service.sip.register.security.authorizationheader.DigestAuthorizationHeader;
import com.git.wuqf.service.sip.util.ServletContextHelper;

import javax.servlet.sip.*;
import java.io.Serializable;
import java.util.*;

public class Registration implements Serializable {
    private final SipURI uri;
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
        originalRegister = sipServletRequest.toString();

        uri = createSipURI((SipURI) sipServletRequest.getTo().getURI(), ServletContextHelper.getSipFactory());
        deviceId = uri.getUser();
        callId = sipServletRequest.getCallId();

        String seq = sipServletRequest.getHeader("CSeq");
        int m = seq.indexOf(" ");
        cseq = Integer.parseInt(m == -1 ? seq : seq.substring(0, m));
        contacts = resolveContacts(sipServletRequest);

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

        fullSipURI = (SipURI) ((Address) contacts.get(0)).getURI();
        String authHeader = sipServletRequest.getHeader("Authorization".toUpperCase());
        if (authHeader != null) {
            SysLogger.info(getClass() + "\n" + "authorizationValue=" + authHeader);
            hasAuthorization = true;
            if ((authHeader).indexOf("Capability") > -1) {
                authorizationHeader = new CapabilityAuthorizationHeader(authHeader);
                return;
            }
            if (authHeader.indexOf("Digest") > -1) {
                authorizationHeader = new DigestAuthorizationHeader(authHeader);
                ((DigestAuthorizationHeader) authorizationHeader).setPassword(LocationService.getInstance().getDevicePassword(deviceId));
                return;
            }
            SysLogger.info(getClass() + "\n" + "improper header " + authHeader);
            return;
        }
        hasAuthorization = false;
        authorizationHeader = null;
    }

    private static SipURI createSipURI(SipURI uri, SipFactory sipFactory) {
        SipURI sipURI = sipFactory.createSipURI(uri.getUser(), uri.getHost());
        sipURI.setPort(uri.getPort());
        Iterator<String> it = sipURI.getParameterNames();
        for (; it.hasNext(); ) {
            sipURI.removeParameter(it.next());
        }
        return sipURI;
    }

    public String toString() {
        return "uri=" + getUri() + " contacts=" + getContacts() + " expires=" + new Date(getExpiration());
    }

    public SipURI getUri() {
        return uri;
    }

    public String getCallID() {
        return callId;
    }

    public int getCseq() {
        return cseq;
    }

    public List getContacts() {
        return contacts;
    }

    public void setContacts(List paramList) {
        contacts = paramList;
    }

    public Address getFirstContacts() {
        return (Address) contacts.get(0);
    }

    public SipURI getFullSipURI() {
        return fullSipURI;
    }

    public long getExpiration() {
        return currentDate.getTime() + expire;
    }

    public String getDeviceID() {
        return deviceId;
    }

    public void setDeviceID(String paramString) {
        deviceId = paramString;
    }

    public boolean getHasAuthorization() {
        return hasAuthorization;
    }

    public void setHasAuthorization(boolean hasAuthorization) {
        hasAuthorization = hasAuthorization;
    }

    public AuthorizationHeader getAuthorizationHeader() {
        return authorizationHeader;
    }

    public void setHasAuthorization(AuthorizationHeader authorizationHeader) {
        authorizationHeader = authorizationHeader;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long paramLong) {
        expire = paramLong;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        seed = seed;
    }

    public List resolveContacts(SipServletRequest sipServletRequest) {
        return new ArrayList();
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int paramInt) {
        securityLevel = paramInt;
    }
}
