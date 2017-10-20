package cn.com.fri.axy.sip.init;

import cn.com.fri.axy.sip.call.invite.InviteManager;
import cn.com.fri.axy.sip.call.mediastream.SSRCManager;
import cn.com.fri.axy.sip.location.LocationService;
import cn.com.fri.axy.sip.message.session.AppMessageManager;
import cn.com.fri.axy.sip.register.entity.RegistrationService;

import javax.servlet.ServletContext;


public class SIPServerInitialization {
    private static SIPServerInitialization a = new SIPServerInitialization();


    public static synchronized SIPServerInitialization getInstance() {
        return a;
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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/init/SIPServerInitialization - ╕▒▒╛.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */