package cn.com.fri.axy.sip.register.security.authorizationheader;

import cn.com.fri.axy.common.util.SysLogger;

import java.util.Random;
import java.util.Vector;


public class CapabilityAuthorizationHeader
        extends AuthorizationHeader {
    public static final String AsymmetricName = "A:";
    public static final String SymmetricName = "S:";
    public static final String DigestName = "H:";
    public static final String AsymmetricSignedArithmetic_SHA1 = "SHA1withRSA";
    public static final String AsymmetricSignedArithmetic_MD5 = "MD5withRSA";
    private Vector a = new Vector();
    private Vector b = new Vector();
    private Vector c = new Vector();


    private String d;


    public CapabilityAuthorizationHeader() {
    }


    public CapabilityAuthorizationHeader(String paramString) {
        this.d = null;
        parse(paramString.trim());
    }


    public CapabilityAuthorizationHeader(String paramString1, String paramString2) {
        this(paramString2);
    }


    public void parse(String paramString) {
        String[] arrayOfString;


        int j = (arrayOfString = paramString = paramString.split("[;\"]")).length;
        for (int i = 0; i < j; i++) {

            SysLogger.info(paramString = (paramString = arrayOfString[i]).trim());
            if (paramString.startsWith("A:")) {
                a(this.a, paramString.substring("A:".length()).split("[,]"));
            } else if (paramString.startsWith("S:")) {
                a(this.b, paramString.substring("S:".length()).split("[,]"));
            } else if (paramString.startsWith("H:")) {
                a(this.c, paramString.substring("H:".length()).split("[,]"));
            }
        }
    }


    public boolean validate() {
        return false;
    }

    private static void a(Vector paramVector, String[] paramArrayOfString) {
        String[] arrayOfString;
        int j = (arrayOfString = paramArrayOfString).length;
        for (int i = 0; i < j; i++) {

            SysLogger.info(paramArrayOfString = (paramArrayOfString = arrayOfString[i]).trim());
            paramVector.add(paramArrayOfString);
        }
    }


    public String getAsymmetricEncodeArithmetic() {
        return (String) this.a.firstElement();
    }


    public String getAsymmetricSignedArithmetic() {
        if (((String) this.c.firstElement()).indexOf("SHA1") > -1) {
            return "SHA1withRSA";
        }
        if (((String) this.c.firstElement()).indexOf("MD5") > -1) {
            return "MD5withRSA";
        }


        return "MD5withRSA";
    }


    public String getSymmetricEncodeArithmetic() {
        String str;


        if ((str = (String) this.b.firstElement()).indexOf("CBC") > -1) {
            if (this.d == null) {
                this.d = getNumber();
                str = str + "/" + this.d;
                this.b.remove(0);
                this.b.insertElementAt(str, 0);
            }
        }

        return (String) this.b.firstElement();
    }


    public String getSymmetricDigestArithmetic() {
        return (String) this.c.firstElement();
    }


    public String getRegisterDigestArithmetic() {
        return (String) this.c.firstElement();
    }


    public String getNumber() {
        int i = 0;


        char[] arrayOfChar;


        int j = (arrayOfChar = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}).length;

        StringBuffer localStringBuffer = new StringBuffer("");
        Random localRandom = new Random();
        while (i < 8) {
            this = localRandom.nextInt(j);
            localStringBuffer.append(arrayOfChar[this]);
            i++;
        }

        return localStringBuffer.toString();
    }

    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = " Capability algorithm=\"A:RSA/ECB/PKCS1, RSA/CBC/PKCS1;H:SHA1,MD5,SHA256;S:DES/ECB/PKCS5,DES/CBC/PKCS5,3DES/ECB/PKCS5,3DES/CBC/PKCS5,SCB2\"";
        new CapabilityAuthorizationHeader(paramArrayOfString);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/register/security/authorizationheader/CapabilityAuthorizationHeader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */