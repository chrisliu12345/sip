package cn.com.fri.axy.sip.register.security.wwwauthorizationheader;

import cn.com.fri.axy.sip.location.LocationService;
import cn.com.fri.axy.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;

import javax.servlet.sip.SipURI;


public class DigestWWWAuthorizationHeader
        extends WWWAuthorizationHeader {
    public DigestWWWAuthorizationHeader(CapabilityAuthorizationHeader paramCapabilityAuthorizationHeader, String paramString1, String paramString2) {
        super(paramCapabilityAuthorizationHeader, paramString1, paramString2);
    }


    public String toString() {
        String str = ((SipURI) LocationService.getInstance().getLocalAddress().getURI()).getHost();
        this = getSeed();

        return this = "Digest realm=\"" + str + "\",nonce=\"" + this + "\"";
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/register/security/wwwauthorizationheader/DigestWWWAuthorizationHeader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */