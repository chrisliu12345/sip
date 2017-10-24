package com.git.wuqf.service.sip.message.content;

public abstract class ReqResMessage extends Message {
    private boolean a;
    private boolean b;
    private String c;

    public ReqResMessage(String paramString1, String paramString2) {
        super(paramString1, 2, paramString2);
    }


    public boolean isAppRequest() {
        return this.a;
    }

    public boolean isAppResponse() {
        return this.b;
    }

    protected void setAppRequest(boolean paramBoolean) {
        this.a = paramBoolean;
    }

    protected void setAppResponse(boolean paramBoolean) {
        this.b = paramBoolean;
    }


    public String getKey() {
        return this.c;
    }

    public void setKey(String paramString) {
        this.c = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/content/ReqResMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */