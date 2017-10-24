package com.git.wuqf.service.sip.register.security.wwwauthorizationheader;

import com.git.wuqf.service.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;

public class WWWAuthorizationHeader {
    protected String seed;
    protected String deviceID;
    protected CapabilityAuthorizationHeader capability;

    public WWWAuthorizationHeader(CapabilityAuthorizationHeader paramCapabilityAuthorizationHeader, String paramString1, String paramString2) {
        this.seed = paramString1;
        this.deviceID = paramString2;
        this.capability = paramCapabilityAuthorizationHeader;
    }


    public String toString() {
        return null;
    }

    public CapabilityAuthorizationHeader getCapability() {
        return this.capability;
    }

    public void setCapability(CapabilityAuthorizationHeader paramCapabilityAuthorizationHeader) {
        this.capability = paramCapabilityAuthorizationHeader;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(String paramString) {
        this.deviceID = paramString;
    }

    public String getSeed() {
        return this.seed;
    }

    public void setSeed(String paramString) {
        this.seed = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/register/security/wwwauthorizationheader/WWWAuthorizationHeader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */