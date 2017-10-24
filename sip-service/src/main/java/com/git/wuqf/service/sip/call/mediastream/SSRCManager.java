package com.git.wuqf.service.sip.call.mediastream;

import com.git.wuqf.service.sip.location.LocationService;


public class SSRCManager {
    public static String defaultSSRC;
    private static int a = 9999;


    private static String b;


    private boolean[] c;


    private int d;


    private boolean[] e;


    private int f;

    private static SSRCManager g = new SSRCManager();

    private SSRCManager() {
        b = LocationService.getInstance().getRegionID().substring(3);


        defaultSSRC = '0' + b + a;
        this.c = new boolean[a];


        this.c[0] = true;

        this.d = 0;
        this.e = new boolean[a];
        this.f = 0;
    }


    public static SSRCManager getInstance() {
        return g;
    }


    public synchronized String getSSRC(boolean paramBoolean) {
        String str;


        if (paramBoolean) {
            paramBoolean = true;
            str = a(this.c, this.d);
            this.d = (Integer.parseInt(str) + 1);
        } else {
            paramBoolean = true;
            str = a(this.e, this.f);
            this.f = (Integer.parseInt(str) + 1);
        }

        return paramBoolean + b + str;
    }


    private static String a(boolean[] paramArrayOfBoolean, int paramInt) {
        for (int i = 0; i < paramArrayOfBoolean.length; i++) {
            int j = (i + paramInt) % paramArrayOfBoolean.length;

//            if (paramArrayOfBoolean[j] == 0) {
//                paramArrayOfBoolean[j] = true;
//                paramArrayOfBoolean = Integer.toString(j);
//                paramInt = 4 - paramArrayOfBoolean.length();
//                for (i = 0; i < paramInt; i++) {
//                    paramArrayOfBoolean = "0" + paramArrayOfBoolean;
//                }
//
//                return paramArrayOfBoolean;
//            }
        }


        return Integer.toString(a);
    }


    public synchronized void releaseSSRC(String paramString) {
        if (paramString.equals(defaultSSRC)) {
            return;
        }

        String str1;

        String str2;
        if ((str2 = (str1 = paramString.substring(1)).substring(0, str1.length() - 4)).equals(b)) {
            int i = Integer.parseInt(str1.substring(b.length()));

            if (paramString.charAt(0) == '0') {
                b(this.c, i);
                return;
            }


            b(this.e, i);
        }
    }


    private static void b(boolean[] paramArrayOfBoolean, int paramInt) {
        if (paramInt >= paramArrayOfBoolean.length) {
            return;
        }


        paramArrayOfBoolean[paramInt] = false;
    }


    public synchronized int lookupSSRC(boolean paramBoolean) {
        if (paramBoolean) {
            return a(this.c);
        }


        return a(this.e);
    }


    private static int a(boolean[] paramArrayOfBoolean) {
        int i = 0;
        for (int j = 0; j < a; j++) {
//            if (paramArrayOfBoolean[j] == 0) {
//                i++;
//            }
        }

        return i;
    }


    public static void main(String[] paramArrayOfString) {
        System.out.println("lookupSSRC:" + getInstance().lookupSSRC(true));
//        for (paramArrayOfString = 0; paramArrayOfString < 1000; paramArrayOfString++) {
//            getInstance().getSSRC(true);
//        }
//
//        paramArrayOfString = getInstance().getSSRC(true);
//
//        for (int i = 0; i < 8998; i++) {
//            getInstance().getSSRC(true);
//        }
//
//        getInstance().releaseSSRC(paramArrayOfString);
        String str = getInstance().getSSRC(true);
        System.out.println("ssrc1:" + paramArrayOfString);
        System.out.println("ssrc2:" + str);
        System.out.println("lookupSSRC:" + getInstance().lookupSSRC(true));
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/call/mediastream/SSRCManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */