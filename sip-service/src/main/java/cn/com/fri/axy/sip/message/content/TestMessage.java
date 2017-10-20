package cn.com.fri.axy.sip.message.content;


public class TestMessage
        extends OnlyReqMessage {
    private String a;


    public TestMessage(String paramString) {
        super(paramString, "Test");
    }


    public void genParameters() {
    }


    public void genXmlContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append(getInfo());
        setXmlContent(localStringBuffer.toString());
    }

    public String getInfo() {
        return this.a;
    }

    public void setInfo(String paramString) {
        this.a = paramString;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/content/TestMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */