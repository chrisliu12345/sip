package cn.com.fri.axy.sip.location;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.init.SSDConfig;
import cn.com.fri.axy.sip.register.entity.Registration;
import cn.com.fri.axy.sip.register.entity.RegistrationService;
import cn.com.fri.axy.sip.util.RegExUtil;
import cn.com.fri.axy.sip.util.ServletContextHelper;

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
            SysLogger.printStackTrace(this = localException);
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
        this = paramString.substring(0, 8);
        return "sip:" + paramString + "@" + this;
    }


    public SipURI getFullURIByID(String paramString) {
        SysLogger.info(getClass() + "\ngetFullURIByID DeviceID:" + paramString);


        if ((this = getAddressByID(paramString)) == null) {
            this = null;
        } else {
            this = (SipURI) getURI();
        }
        return this;
    }


    public boolean isLocalDomainDevice(String paramString) {
        if (paramString == null) {
            return true;
        }


        return paramString.matches(this.c + "\\d{12}");
    }


    public boolean isLocalDomainDeviceOnline(String paramString) {
        SysLogger.info(getClass() + "\nisLocalDomainDeviceOnline:" + paramString);
        if (isLocalDomainDevice(paramString)) {
            if (RegExUtil.isUserDevice(paramString)) {


                return true;
            }


            this = SSDConfig.getInstance().getParentDeviceID(paramString);

            if (RegistrationService.getInstance().getAllRegistrations().containsKey(this)) {
                return true;
            }

            return false;
        }


        return true;
    }


    public Address getAddressByID(String paramString) {
        SysLogger.info(getClass() + "\ngetAddressByID DeviceID:" + paramString);

        Address localAddress = null;

        if (isLocalDomainDevice(paramString)) {
            SysLogger.info(getClass() + "\nisLocalDomainDevice");

            this = SSDConfig.getInstance().getParentDeviceID(paramString);


            ((SipURI) (localAddress = (this = RegistrationService.getInstance().getByDeviceID(this)) != null ? (Address) getContacts().get(0) : null).getURI()).setUser(paramString);

        } else {
            SysLogger.info(getClass() + "\nisOutBoundDomainDevice");
            try {
                localAddress = ServletContextHelper.getSipFactory().createAddress("sip:" + paramString + "@" +
                        SSDConfig.getInstance().getOtherSystemIP() + ":" + SSDConfig.getInstance().getOtherSystemPort());
            } catch (ServletParseException localServletParseException) {
                SysLogger.printStackTrace(this = localServletParseException);
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
        if ((this = SSDConfig.getInstance().getSipDevicePassword(paramString)) == null) {
            this = "12345678";
        }

        return this;
    }


    public void deviceOnline(Registration paramRegistration) {
    }


    public void deviceUpdate(Registration paramRegistration) {
    }


    public void deviceOffline(Registration paramRegistration) {
    }


    public boolean isUAExist(String paramString) {
        for (Iterator localIterator = SSDConfig.getInstance().getAllDeviceID().iterator(); localIterator.hasNext(); ) {
            if ((this = (String) localIterator.next()).equalsIgnoreCase(paramString)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/location/LocationService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */