package com.git.wuqf.service.common.def.notify;


public class NotifyObject {
    public static final int MessageSendSuccess = 212;


    public static final int MessageSendFail = 213;


    public static final int CallSuccess = 112;


    public static final int CallFail = 113;


    public static final int CallTimeOut = 100;


    public static final int CallNotAcceptable = 103;


    public static final int CallBusy = 104;


    public static final int CallUnknow = 109;


    public static final int CallVoluntaryClose = 106;


    public static final int CallPassiveClose = 120;


    public static final int CallPassiveClose_StoreEnd = 1201;


    public static final int MediaStatus_DownloadComplete = 121;


    private int a;


    private Object b;


    private Object c;


    public static void main(String[] paramArrayOfString) {
    }


    public int getCode() {
        return this.a;
    }


    public void setCode(int paramInt) {
        this.a = paramInt;
    }


    public Object getRequset() {
        return this.b;
    }


    public void setRequset(Object paramObject) {
        this.b = paramObject;
    }


    public Object getResponse() {
        return this.c;
    }


    public void setResponse(Object paramObject) {
        this.c = paramObject;
    }

    public String toString() {
        return

                "code\t" + this.a + "\n" + this.b.toString() + this.c.toString();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/notify/NotifyObject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */