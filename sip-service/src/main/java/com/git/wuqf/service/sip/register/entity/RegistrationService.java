package com.git.wuqf.service.sip.register.entity;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.call.invite.InviteManager;
import com.git.wuqf.service.sip.listener.RegistrationTimerListener;
import com.git.wuqf.service.sip.listener.SIPTimerService;
import com.git.wuqf.service.sip.location.LocationService;
import com.git.wuqf.service.sip.register.security.authorizationheader.AuthorizationHeader;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class RegistrationService {
    private static RegistrationService a = new RegistrationService();


    private final Map b = Collections.synchronizedMap(new HashMap());


    public static synchronized RegistrationService getInstance() {
        return a;
    }


    public Map getAllRegistrations() {
        return this.b;
    }

    public void init() {
        SysLogger.info(getClass() + ":\n" + "do RegistrationService init...");
    }


    public void save(Registration paramRegistration) {
        this.b.put(paramRegistration.getDeviceID(), paramRegistration);
    }

    public Registration getByDeviceID(String paramString) {
        return (Registration) this.b.get(paramString);
    }


    public Registration removeByDeviceID(String paramString) {
        return (Registration) this.b.remove(paramString);
    }


    public boolean verifyDevicePassword(AuthorizationHeader paramAuthorizationHeader) {
        if (paramAuthorizationHeader == null) return false;
        return paramAuthorizationHeader.validate();
    }


    public void deviceOffline(Registration paramRegistration) {
        InviteManager.getInstance().endAllInvite();

        deviceOfflineNotCallUpLayer(paramRegistration);


        LocationService.getInstance().deviceOffline(paramRegistration);
    }


    public void deviceOfflineNotCallUpLayer(Registration paramRegistration) {
        if (paramRegistration.timer != null) {
            try {
                paramRegistration.timer.cancel();
            } catch (Exception localException2) {
                Exception localException1;
                SysLogger.printStackTrace(localException1 = localException2);
            }
        }

        removeByDeviceID(paramRegistration.getDeviceID());
    }


    public void deviceOnline(Registration paramRegistration) {
        save(paramRegistration);


        SIPTimerService.getInstance().getTimerManager().schedule(new RegistrationTimerListener(paramRegistration), paramRegistration.getExpire());
//        paramRegistration.timer = this;


        LocationService.getInstance().deviceOnline(paramRegistration);
    }


    public void deviceUpdate(Registration paramRegistration1, Registration paramRegistration2) {
        save(paramRegistration2);


        LocationService.getInstance().deviceUpdate(paramRegistration2);


        try {
            paramRegistration1.timer.cancel();

            SIPTimerService.getInstance().getTimerManager().schedule(new RegistrationTimerListener(paramRegistration2), paramRegistration2.getExpire());
//            paramRegistration2.timer = this;
            return;
        } catch (Exception localException) {
            SysLogger.printStackTrace(localException);
        }
    }
}

