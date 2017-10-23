package cn.com.fri.axy.sip.register.security.authorizationheader;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.util.DigestUtils;

public class DigestAuthorizationHeader
        extends AuthorizationHeader {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public DigestAuthorizationHeader(String paramString) {
        parse(paramString.trim());
    }


    public void parse(String paramString) {
        String[] s = paramString.split("[ ,]");
        for (int i = 0; i < s.length; i++) {
            Object localObject;
            SysLogger.info(localObject = s[i]);
            int j;
            if (((String) localObject).indexOf("username") != -1) {
                j = ((String) localObject).indexOf("\"") + 1;
                setUsername(((String) localObject)
                        .substring(j, ((String) localObject).indexOf("\"", j)));
            } else if (((String) localObject).indexOf("realm") != -1) {
                j = ((String) localObject).indexOf("\"") + 1;
                setRealm(((String) localObject)
                        .substring(j, ((String) localObject).indexOf("\"", j)));
            } else if (((String) localObject).indexOf("nonce") != -1) {
                j = ((String) localObject).indexOf("\"") + 1;
                setNonce(((String) localObject)
                        .substring(j, ((String) localObject).indexOf("\"", j)));
            } else if (((String) localObject).indexOf("uri") != -1) {
                j = ((String) localObject).indexOf("\"") + 1;
                setUri(((String) localObject)
                        .substring(j, ((String) localObject).indexOf("\"", j)));
            } else if (((String) localObject).indexOf("response") != -1) {
                j = ((String) localObject).indexOf("\"") + 1;
                setResponse(((String) localObject)
                        .substring(j, ((String) localObject).indexOf("\"", j)));
            } else if (((String) localObject).indexOf("algorithm") != -1) {
                j = ((String) localObject).indexOf("=") + 1;
                setAlgorithm(((String) localObject).substring(j));
            }
        }
    }


    public boolean validate(CapabilityAuthorizationHeader paramCapabilityAuthorizationHeader, String paramString) {
        if (getPassword() == null) {
            setPassword("12345678");
        }

        DigestUtils.getDigest(DigestUtils.getHA1(getUsername(), getRealm(), getPassword()),
                getNonce(), null, null, null, "REGISTER", getUri());

        SysLogger.info(getClass() + "\nresult=" + paramCapabilityAuthorizationHeader);

        return paramCapabilityAuthorizationHeader.equals(getResponse());
    }

    public String getAlgorithm() {
        return this.f;
    }

    public void setAlgorithm(String paramString) {
        this.f = paramString;
    }

    public String getNonce() {
        return this.c;
    }

    public void setNonce(String paramString) {
        this.c = paramString;
    }

    public String getRealm() {
        return this.b;
    }

    public void setRealm(String paramString) {
        this.b = paramString;
    }

    public String getResponse() {
        return this.e;
    }

    public void setResponse(String paramString) {
        this.e = paramString;
    }

    public String getUri() {
        return this.d;
    }

    public void setUri(String paramString) {
        this.d = paramString;
    }

    public String getUsername() {
        return this.a;
    }

    public void setUsername(String paramString) {
        this.a = paramString;
    }

    public String getPassword() {
        return this.g;
    }

    public void setPassword(String paramString) {
        this.g = paramString;
    }

    public static void main(String[] paramArrayOfString) {
        String s = "Digest username=\"xlite22\",realm=\"192.168.3.215\",nonce=\"24f4d7b39ef64c0db42739ba903248e0ad\",uri=\"sip:192.168.3.215\",response=\"3374a7c897f8c51dc23f53580295d0ab\",algorithm=MD5";
        new DigestAuthorizationHeader(s).validate();
    }
}
