package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.SysLogger;


public class LogFileDownloadResponse$LogBean {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public LogFileDownloadResponse$LogBean(LogFileDownloadResponse paramLogFileDownloadResponse) {
    }

    public String toString() {
        return


                "id\t" + this.a + "\n" + "action\t" + this.b + "\n" + "originIP\t" + this.c + "\n" + "destIP\t" + this.d + "\n" + "date\t" + this.e + "\n" + "result\t" + this.f + "\n";
    }

    public String getId() {
        return this.a;
    }

    public void setId(String paramString) {
        this.a = paramString;
    }

    public String getAction() {
        return this.b;
    }

    public void setAction(String paramString) {
        this.b = paramString;
    }

    public String getOriginIP() {
        return this.c;
    }

    public void setOriginIP(String paramString) {
        this.c = paramString;
    }

    public String getDestIP() {
        return this.d;
    }

    public void setDestIP(String paramString) {
        this.d = paramString;
    }

    public String getDate() {
        return this.e;
    }

    public void setDate(String paramString) {
        this.e = paramString;
    }

    public String getResult() {
        return this.f;
    }

    public void setResult(String paramString) {
        this.f = paramString;
    }

    public void parse(String paramString) {
        SysLogger.info("parse " + paramString);
        String[] arrayOfString;
        int j = (arrayOfString  = paramString.split("\" ")).length;
        for (int i = 0; i < j; i++) {
            if ((paramString = arrayOfString[i]).indexOf("id=\"") > -1) {

                if ((paramString = paramString.substring(paramString.indexOf("id=\"") + "id=\"".length())).indexOf("\"") > -1) {
                    paramString = paramString.substring(0, paramString.indexOf("\""));
                }
                this.a = paramString;
            } else if (paramString.indexOf("action=\"") > -1) {

                if ((paramString = paramString.substring(paramString.indexOf("action=\"") + "action=\"".length())).indexOf("\"") > -1) {
                    paramString = paramString.substring(0, paramString.indexOf("\""));
                }
                this.b = paramString;
            } else if (paramString.indexOf("date=\"") > -1) {

                if ((paramString = paramString.substring(paramString.indexOf("date=\"") + "date=\"".length())).indexOf("\"") > -1) {
                    paramString = paramString.substring(0, paramString.indexOf("\""));
                }
                this.e = paramString;
            } else if (paramString.indexOf("originIP=\"") > -1) {

                if ((paramString = paramString.substring(paramString.indexOf("originIP=\"") + "originIP=\"".length())).indexOf("\"") > -1) {
                    paramString = paramString.substring(0, paramString.indexOf("\""));
                }
                this.c = paramString;
            } else if (paramString.indexOf("destIP=\"") > -1) {

                if ((paramString = paramString.substring(paramString.indexOf("destIP=\"") + "destIP=\"".length())).indexOf("\"") > -1) {
                    paramString = paramString.substring(0, paramString.indexOf("\""));
                }
                this.d = paramString;
            } else if (paramString.indexOf("result=\"") > -1) {

                if ((paramString = paramString.substring(paramString.indexOf("result=\"") + "result=\"".length())).indexOf("\"") > -1) {
                    paramString = paramString.substring(0, paramString.indexOf("\""));
                }
                this.f = paramString;
            } else {
                SysLogger.info("parse nothing");
            }
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/LogFileDownloadResponse$LogBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */