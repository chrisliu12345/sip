package cn.com.fri.axy.sip.register.entity;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.location.LocationService;
import cn.com.fri.axy.sip.register.security.authorizationheader.AuthorizationHeader;
import cn.com.fri.axy.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;
import cn.com.fri.axy.sip.register.security.authorizationheader.DigestAuthorizationHeader;
import cn.com.fri.axy.sip.util.ServletContextHelper;
import commonj.timers.Timer;

import javax.servlet.sip.Address;
import javax.servlet.sip.SipFactory;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipURI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Registration
        implements Serializable {
    private final SipURI a;
    private final SipURI b;
    private final String c;
    private  int d;
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

    Registration(SipServletRequest paramSipServletRequest) {
        this.originalRegister = paramSipServletRequest.toString();


        this.a = a((SipURI) paramSipServletRequest.getTo().getURI(), ServletContextHelper.getSipFactory());
        this.f = this.a.getUser();
        this.c = paramSipServletRequest.getCallId();
        Object localObject1;
        int m;
//        this.d = Integer.parseInt((m = (localObject1 = (localObject1 = paramSipServletRequest).getHeader("CSeq")).indexOf(" ")) == -1 ? localObject1 : ((String) localObject1).substring(0, m));
        this.e = resolveContacts(paramSipServletRequest);

        long l = paramSipServletRequest.getExpires();

//        for (Object localObject2 = paramSipServletRequest.getAddressHeaders("Contact"); ((Iterator) localObject2).hasNext(); ) {
//            Address localAddress = (Address) ((Iterator) localObject2).next();
//
//            getContacts().add(localAddress);
//            l = Math.max(l, localAddress.getExpires());
//        }


        if (l == -1L) {
            l = 60L;
        }


        setExpire(1000L * l);

        this.b = ((SipURI) ((Address) this.e.get(0)).getURI());


//        if ((localObject2 = paramSipServletRequest.getHeader("Authorization".toUpperCase())) != null) {
//            SysLogger.info(getClass() + "\n" + "authorizationValue=" + (String) localObject2);
//            this.g = true;
//
//            if (((String) localObject2).indexOf("Capability") > -1) {
//                this.h = new CapabilityAuthorizationHeader((String) localObject2);
//                return;
//            }
//            if (((String) localObject2).indexOf("Digest") > -1) {
//                this.h = new DigestAuthorizationHeader((String) localObject2);
//                ((DigestAuthorizationHeader) this.h).setPassword(LocationService.getInstance().getDevicePassword(this.f));
//                return;
//            }
//
//
//            SysLogger.info(getClass() + "\n" + "improper header " + (String) localObject2);
//            return;
//        }


        this.g = false;
        this.h = null;
    }


    private static SipURI a(SipURI paramSipURI, SipFactory paramSipFactory) {
        SipURI s = paramSipFactory.createSipURI(paramSipURI.getUser(), paramSipURI.getHost());
                s.setPort(paramSipURI.getPort());
//        for (paramSipURI = paramSipFactory.getParameterNames(); paramSipURI.hasNext(); ) {
//            paramSipFactory.removeParameter((String) paramSipURI.next());
//        }


        return s;
    }

    final boolean a() {
        for (Iterator localIterator = getContacts().iterator(); localIterator.hasNext(); ) {
            if (( (Address) localIterator.next()).isWildcard()) {
                return true;
            }
        }
        return false;
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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/register/entity/Registration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */