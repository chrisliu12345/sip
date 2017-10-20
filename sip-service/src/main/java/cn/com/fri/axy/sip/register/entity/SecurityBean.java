package cn.com.fri.axy.sip.register.entity;

import cn.com.fri.axy.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;


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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/register/entity/SecurityBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */