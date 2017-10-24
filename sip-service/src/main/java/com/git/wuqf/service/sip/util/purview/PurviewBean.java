package com.git.wuqf.service.sip.util.purview;


public class PurviewBean {
    public static final String PURVIEW_HEADER_NAME = "Monitor-User-Identity";


    public static final String OPERATION_REALTIME = "realtime";


    public static final String OPERATION_STORE = "store";


    public static final String OPERATION_HISTORY = "history";


    public static final String OPERATION_PTZ = "ptz";


    private String a;


    private String b;


    private String c;


    private String d;


    private String e;


    public String getUser() {
        return this.a;
    }

    public void setUser(String paramString) {
        this.a = paramString;
    }

    public String getUsergroup() {
        return this.b;
    }

    public void setUsergroup(String paramString) {
        this.b = paramString;
    }

    public String getDeviceid() {
        return this.c;
    }

    public void setDeviceid(String paramString) {
        this.c = paramString;
    }

    public String getOperation() {
        return this.d;
    }

    public void setOperation(String paramString) {
        this.d = paramString;
    }


    public String getExtparam() {
        return this.e;
    }

    public void setExtparam(String paramString) {
        this.e = paramString;
    }


    public String getPurviewHeader() {
        StringBuilder localStringBuilder = new StringBuilder();


        if ((this.a != null) && (this.a.length() != 0)) {
            localStringBuilder.append("user=" + this.a);
        }
        if ((this.b != null) && (this.b.length() != 0)) {
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append("usergroup=" + this.b);
        }
        if ((this.c != null) && (this.c.length() != 0)) {
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append("deviceid=" + this.c);
        }
        if ((this.d != null) && (this.d.length() != 0)) {
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append("operation=" + this.d);
        }
        if ((this.e != null) && (this.e.length() != 0)) {
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append("extparam=" + this.e);
        }

        return localStringBuilder.toString();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/purview/PurviewBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */