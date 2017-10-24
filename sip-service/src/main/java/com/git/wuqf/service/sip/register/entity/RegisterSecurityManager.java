package com.git.wuqf.service.sip.register.entity;

import com.git.wuqf.service.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class RegisterSecurityManager {
    private static RegisterSecurityManager a = new RegisterSecurityManager();


    private final Map b = Collections.synchronizedMap(new HashMap());


    public static synchronized RegisterSecurityManager getInstance() {
        return a;
    }


    public void saveSecurityParam(String paramString1, Long paramLong, String paramString2, CapabilityAuthorizationHeader paramCapabilityAuthorizationHeader) {
        SecurityBean localSecurityBean;
        (localSecurityBean = new SecurityBean()).setCapability(paramCapabilityAuthorizationHeader);
        localSecurityBean.setDeviceID(paramString1);
        localSecurityBean.setSecurityLevel(paramLong);
        localSecurityBean.setSeed(paramString2);

        this.b.put(paramString1, localSecurityBean);
    }

    public SecurityBean getSecurityParam(String paramString) {
        return (SecurityBean) this.b.get(paramString);
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/register/entity/RegisterSecurityManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */