package com.git.wuqf.service.sip.location;


import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.init.SSDConfig;
import com.git.wuqf.service.sip.register.entity.Registration;
import com.git.wuqf.service.sip.register.entity.RegistrationService;
import com.git.wuqf.service.sip.util.RegExUtil;
import com.git.wuqf.service.sip.util.ServletContextHelper;

import javax.servlet.sip.Address;
import javax.servlet.sip.ServletParseException;
import javax.servlet.sip.SipFactory;
import javax.servlet.sip.SipURI;
import java.util.Iterator;

public class LocationService {
    private static LocationService a = new LocationService();
    private Address b;
    private String c;
    private String d;
    private SipFactory e;

    public static synchronized LocationService getInstance() {
        return a;
    }

    public void centerinfoInit() {
        this.e = ServletContextHelper.getSipFactory();
        this.c = SSDConfig.getInstance().getDomainName();
        this.d = SSDConfig.getInstance().getSipServerID();
        try {
            this.b = this.e.createAddress("sip:" + this.d + "@" + this.c);
            return;
        } catch (Exception localException) {
            System.exit(0);
        }
    }

    public String getSIPServerID() {
        return this.d;
    }

    public String getRegionID() {
        return this.c;
    }

    public String getDomainURI(String paramString) {
        paramString.substring(0, 8);
        return "sip:" + paramString + "@" + this;
    }

    public SipURI getFullURIByID(String id) {
        Address address = getAddressByID(id);
        if (address == null) {
            return null;
        } else {
            return (SipURI) address.getURI();
        }
    }

    public boolean isLocalDomainDevice(String paramString) {
        if (paramString == null) {
            return true;
        }
        return paramString.matches(this.c + "\\d{12}");
    }

    public boolean isLocalDomainDeviceOnline(String paramString) {
        if (isLocalDomainDevice(paramString)) {
            if (RegExUtil.isUserDevice(paramString)) {
                return true;
            }
            SSDConfig.getInstance().getParentDeviceID(paramString);
            if (RegistrationService.getInstance().getAllRegistrations().containsKey(this)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public Address getAddressByID(String id) {

        Address localAddress = null;
        if (isLocalDomainDevice(id)) {

            SSDConfig.getInstance().getParentDeviceID(id);
            Registration registration=RegistrationService.getInstance().getByDeviceID(id);
            SipURI sipURI = registration.getUri();
            sipURI.setUser(id);
//            localAddress=registration.getUri().get
        } else {
            SysLogger.info(getClass() + "\nisOutBoundDomainDevice");
            try {
                localAddress = ServletContextHelper.getSipFactory().createAddress("sip:" + id + "@" +
                        SSDConfig.getInstance().getOtherSystemIP() + ":" + SSDConfig.getInstance().getOtherSystemPort());
            } catch (ServletParseException localServletParseException) {
                SysLogger.printStackTrace(localServletParseException);
            }
        }
        return localAddress;
    }

    public Address getLocalAddress() {
        return this.b;
    }

    public Address getLocalDomainURI() {
        return this.b;
    }

    public Long getSecurityLevel(String paramString) {
        return SSDConfig.getInstance().getSipDeviceRegisterWay();
    }

    public String getDevicePassword(String paramString) {
        String password = SSDConfig.getInstance().getSipDevicePassword(paramString);
        if (password == null) {
            password = "12345678";
        }
        return password;
    }

    public void deviceOnline(Registration paramRegistration) {
    }

    public void deviceUpdate(Registration paramRegistration) {
    }

    public void deviceOffline(Registration paramRegistration) {
    }

    public boolean isUAExist(String paramString) {
        for (Iterator localIterator = SSDConfig.getInstance().getAllDeviceID().iterator(); localIterator.hasNext(); ) {
            if (((String) localIterator.next()).equalsIgnoreCase(paramString)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] paramArrayOfString) {
    }
}
