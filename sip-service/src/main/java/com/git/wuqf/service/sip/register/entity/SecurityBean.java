package com.git.wuqf.service.sip.register.entity;

import com.git.wuqf.service.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;


public class SecurityBean {
    private Long a;
    private String b;
    private String c;
    private CapabilityAuthorizationHeader d;

    public Long getSecurityLevel() {
        return this.a;
    }

    public void setSecurityLevel(Long paramLong) {
        this.a = paramLong;
    }

    public String getSeed() {
        return this.b;
    }

    public void setSeed(String paramString) {
        this.b = paramString;
    }

    public String getDeviceID() {
        return this.c;
    }

    public void setDeviceID(String paramString) {
        this.c = paramString;
    }

    public CapabilityAuthorizationHeader getCapability() {
        return this.d;
    }

    public void setCapability(CapabilityAuthorizationHeader paramCapabilityAuthorizationHeader) {
        this.d = paramCapabilityAuthorizationHeader;
    }
}
