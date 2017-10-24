package com.git.wuqf.service.sip.event.type;


public class MRFCEvent {
    private String a = null;
    private int b = 0;
    private String c = null;
    private String d = null;
    private String e = null;


    public String getDigits() {
        return this.e;
    }

    public void setDigits(String paramString) {
        this.e = paramString;
    }

    public String getReason() {
        return this.c;
    }

    public void setReason(String paramString) {
        this.c = paramString;
    }

    public String getSdp() {
        return this.d;
    }

    public void setSdp(String paramString) {
        this.d = paramString;
    }

    public int getStatus() {
        return this.b;
    }

    public void setStatus(int paramInt) {
        this.b = paramInt;
    }

    public String getCorrelationID() {
        return this.a;
    }

    public void setCorrelationID(String paramString) {
        this.a = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/event/type/MRFCEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */