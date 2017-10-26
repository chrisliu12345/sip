package com.git.wuqf.service.sip.init;

import com.git.wuqf.service.sip.call.invite.InviteManager;
import com.git.wuqf.service.sip.call.mediastream.SSRCManager;
import com.git.wuqf.service.sip.location.LocationService;
import com.git.wuqf.service.sip.message.session.AppMessageManager;
import com.git.wuqf.service.sip.register.entity.RegistrationService;

import javax.servlet.ServletContext;


public class SIPServerInitialization {
    private static SIPServerInitialization sipServerInitialization = new SIPServerInitialization();


    public static synchronized SIPServerInitialization getInstance() {
        return sipServerInitialization;
    }


    public void sipServerInit(ServletContext paramServletContext) {
        RegistrationService.getInstance().init();


        LocationService.getInstance().centerinfoInit();


        AppMessageManager.getInstance().init();


        InviteManager.getInstance().init();


        SSRCManager.getInstance();
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/init/SIPServerInitialization.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */