package cn.com.fri.axy.sip.interfaces;

import cn.com.fri.axy.common.util.SysLogger;

import java.util.regex.Pattern;


public class MediaParameterBean {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public String toString() {
        return


                "V_EnCodingFormat\t" + this.a + "\n" + "V_Resolution\t" + this.b + "\n" + "V_FrameRate\t" + this.c + "\n" + "V_StreamType\t" + this.d + "\n" + "V_StreamAmount\t" + this.e + "\n" + "A_EnCodingFormat\t" + this.f + "\n" + "A_StreamAmount\t" + this.g + "\n" + "A_SamplingRate\t" + this.h + "\n";
    }


    public void setV_EnCodingFormat(int paramInt) {
        this.a = paramInt;
    }


    public void setV_Resolution(int paramInt) {
        this.b = paramInt;
    }


    public void setV_FrameRate(int paramInt) {
        this.c = paramInt;
    }


    public void setV_StreamType(int paramInt) {
        this.d = paramInt;
    }


    public void setV_StreamAmount(int paramInt) {
        this.e = paramInt;
    }


    public void setA_EnCodingFormat(int paramInt) {
        this.f = paramInt;
    }


    public void setA_StreamAmount(int paramInt) {
        this.g = paramInt;
    }


    public void setA_SamplingRate(int paramInt) {
        this.h = paramInt;
    }


    public String getMediaParameter() {
        StringBuilder localStringBuilder;


        (localStringBuilder = new StringBuilder()).append("v/");
        if (this.a > 0) {
            localStringBuilder.append(this.a);
        }
        localStringBuilder.append("/");
        if (this.b > 0) {
            localStringBuilder.append(this.b);
        }
        localStringBuilder.append("/");
        if (this.c > 0) {
            localStringBuilder.append(this.c);
        }
        localStringBuilder.append("/");
        if (this.d > 0) {
            localStringBuilder.append(this.d);
        }
        localStringBuilder.append("/");
        if (this.e > 0) {
            localStringBuilder.append(this.e);
        }
        localStringBuilder.append("a/");
        if (this.f > 0) {
            localStringBuilder.append(this.f);
        }
        localStringBuilder.append("/");
        if (this.g > 0) {
            localStringBuilder.append(this.g);
        }
        localStringBuilder.append("/");
        if (this.h > 0) {
            localStringBuilder.append(this.h);
        }

        return localStringBuilder.toString();
    }


    public void parseMediaParameter(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            return;
        }

        if (!Pattern.matches("v/\\d*/\\d*/\\d*/\\d*/\\d*a/\\d*/\\d*/\\d*", paramString)) {
            SysLogger.info("the string " + paramString + " is invalid.");
            return;
        }

        if (Pattern.matches("v/////a///", paramString)) {
            SysLogger.info("the value of string " + paramString + " is default.");
            return;
        }


        (paramString = new StringBuilder(paramString)).insert(paramString.indexOf("a"), "/");
        paramString.append("/");
        while (paramString.indexOf("//") > -1) {
            paramString.insert(paramString.indexOf("//") + 1, '0');
        }

        SysLogger.info(paramString.toString());
        paramString = paramString.toString().split("[/]");


        this.a = Integer.parseInt(paramString[1]);
        this.b = Integer.parseInt(paramString[2]);
        this.c = Integer.parseInt(paramString[3]);
        this.d = Integer.parseInt(paramString[4]);
        this.e = Integer.parseInt(paramString[5]);

        this.f = Integer.parseInt(paramString[7]);
        this.g = Integer.parseInt(paramString[8]);
        this.h = Integer.parseInt(paramString[9]);
    }


    public static void main2(String[] paramArrayOfString) {
        (paramArrayOfString = new MediaParameterBean()).setA_EnCodingFormat(1);
        paramArrayOfString.setA_SamplingRate(2);
        paramArrayOfString.setA_StreamAmount(3);
        paramArrayOfString.setV_EnCodingFormat(4);
        paramArrayOfString.setV_FrameRate(5);
        paramArrayOfString.setV_Resolution(6);
        paramArrayOfString.setV_StreamAmount(7);
        paramArrayOfString.setV_StreamType(8);

        paramArrayOfString = paramArrayOfString.getMediaParameter();
        System.out.println(paramArrayOfString);
        System.out.println(Pattern.matches("v/\\d*/\\d*/\\d*/\\d*/\\d*a/\\d*/\\d*/\\d*", paramArrayOfString));

        paramArrayOfString = paramArrayOfString.split("[va/]");
        System.out.println(paramArrayOfString.length);
        String[] arrayOfString = paramArrayOfString;
        int j = paramArrayOfString.length;
        for (int i = 0; i < j; i++) {
            paramArrayOfString = arrayOfString[i];

            System.out.println(paramArrayOfString);
        }
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "v/1/2/3/4/5a/6/7/8";
        MediaParameterBean localMediaParameterBean;
        (localMediaParameterBean = new MediaParameterBean()).parseMediaParameter(paramArrayOfString);
        SysLogger.info(localMediaParameterBean.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/interfaces/MediaParameterBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */