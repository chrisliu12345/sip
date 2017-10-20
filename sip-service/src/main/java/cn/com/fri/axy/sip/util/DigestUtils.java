package cn.com.fri.axy.sip.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public final class DigestUtils {
    private static final MessageDigest a;

    public static String getHA1(String paramString1, String paramString2, String paramString3) {
        return getHash(paramString1 = paramString1 + ":" + paramString2 + ":" + paramString3);
    }

    public static String getDigest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuffer localStringBuffer = new StringBuffer();
        if ("auth-int".equals(paramString5)) {
            localStringBuffer.append(paramString6).append(":");
            localStringBuffer.append(paramString7).append(":");
            localStringBuffer.append(getHash(paramString8));
        } else {
            localStringBuffer.append(paramString6).append(":");
            localStringBuffer.append(paramString7);
        }
        paramString6 = getHash(localStringBuffer.toString());
        return getDigest(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    }

    public static String getDigest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuffer localStringBuffer;
        (localStringBuffer = new StringBuffer()).append(paramString6).append(":");
        localStringBuffer.append(paramString7);
        paramString6 = getHash(localStringBuffer.toString());
        return getDigest(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    }

    public static String getDigest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuffer localStringBuffer = new StringBuffer();
        if (("auth".equals(paramString5)) || ("auth-int".equals(paramString5))) {
            localStringBuffer.append(paramString1).append(":");
            localStringBuffer.append(paramString2).append(":");
            localStringBuffer.append(paramString3).append(":");
            localStringBuffer.append(paramString4).append(":");
            localStringBuffer.append(paramString5).append(":");
            localStringBuffer.append(paramString6);
        } else {
            localStringBuffer.append(paramString1).append(":");
            localStringBuffer.append(paramString2).append(":");
            localStringBuffer.append(paramString6);
        }
        return getHash(localStringBuffer.toString());
    }


    public static String getHash(String paramString) {
        try {
            localObject = (MessageDigest) a.clone();
        } catch (CloneNotSupportedException paramString) {
            throw new AssertionError(paramString);
        }
        paramString = ((MessageDigest) localObject).digest(a(paramString));
        Object localObject = new char[2 * paramString.length];
        int i = 0;
        for (int m : paramString) {
            localObject[(i++)] = a(m >> 4 & 0xF);
            localObject[(i++)] = a(m & 0xF);
        }
        return new String((char[]) localObject);
    }

    public static HashMap parseDigestChallenge(String paramString) {
        if (paramString.startsWith("Digest ")) {
            paramString = paramString.substring("Digest ".length());
        }
        HashMap localHashMap = new HashMap();
        paramString = new StringTokenizer(paramString, ",");
        while (paramString.hasMoreTokens()) {
            a(localHashMap, paramString.nextToken());
        }
        return localHashMap;
    }

    private static void a(HashMap paramHashMap, String paramString) {
        int i = paramString.length() - 1;
        while (Character.isWhitespace(paramString.charAt(i))) i--;
        int j;
        if ((j = paramString.indexOf("=")) != -1) {
            String str = paramString.substring(0, j).trim();
            j = paramString.charAt(j + 1) == '"' ? j + 2 : j + 1;
            i = paramString.charAt(i) == '"' ? i - 1 : i;
            paramString = paramString.substring(j, i + 1).trim();
            paramHashMap.put(str, paramString);
        }
    }

    public static String createDigestResponseWithHA1(String paramString1, String paramString2, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        String str1 = (String) paramMap.get("realm");
        String str2 = (String) paramMap.get("nonce");
        paramMap = (String) paramMap.get("algorithm");

        paramString2 = getDigest(paramString2, str2, paramString6, paramString7, paramString5, paramString3, paramString4, paramString8);

        paramString1 = new StringBuffer("Digest username=\"").append(paramString1).append("\",realm=\"").append(str1).append("\",");

        if (paramString5 != null) {
            paramString1.append("cnonce=\"").append(paramString7).append("\",nc=").append(paramString6).append(",qop=\"").append(paramString5).append("\",");
        }

        paramString1.append("uri=\"").append(paramString4).append("\",nonce=\"").append(str2).append("\",response=\"").append(paramString2).append("\",algorithm=\"").append(paramMap).append("\"");

        return paramString1.toString();
    }

    public static String createDigestResponseWithPassword(String paramString1, String paramString2, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        String str = (String) paramMap.get("realm");
        paramString2 = getHA1(paramString1, str, paramString2);
        return createDigestResponseWithHA1(paramString1, paramString2, paramMap, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
    }

    private static byte[] a(String paramString) {
        int i;
        byte[] arrayOfByte = new byte[i = paramString.length()];
        paramString.getBytes(0, i, arrayOfByte, 0);
        return arrayOfByte;
    }

    public static String byteToHex(byte paramByte) {
        return new String(new char[]{a(paramByte >> 4 & 0xF), a(paramByte & 0xF)});
    }

    private static char a(int paramInt) {
        return (char) (paramInt < 10 ? paramInt + 48 : paramInt + 87);
    }

    public static String stringToHex(String paramString) {
        StringBuffer localStringBuffer = new StringBuffer();

        int i = (paramString = paramString = a(paramString)).length;
        for (int j = 0; j < i; j++) {
            byte b = paramString[j];
            localStringBuffer.append(byteToHex(b));
        }
        return localStringBuffer.toString();
    }

    static {
        MessageDigest localMessageDigest;
        try {
            localMessageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localMessageDigest = null;
            localNoSuchAlgorithmException.printStackTrace();
        }
        a = localMessageDigest;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/DigestUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */