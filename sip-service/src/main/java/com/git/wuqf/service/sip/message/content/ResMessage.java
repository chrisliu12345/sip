package com.git.wuqf.service.sip.message.content;


public abstract class ResMessage
        extends ReqResMessage {
    public ResMessage(String paramString1, String paramString2) {
        super(paramString1, paramString2);

        setAppResponse(true);
    }

    public void dealNotify() {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/content/ResMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */