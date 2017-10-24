package com.git.wuqf.service.common.def.message.content;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ResMessage;

import java.util.Iterator;
import java.util.Vector;


public final class LogFileDownloadResponse
        extends ResMessage {
    private String a;
    private Vector b;

    public final String getDeviceID() {
        return this.a;
    }

    public final void setDeviceID(String paramString) {
        this.a = paramString;
    }


    public final String toString() {
        StringBuilder localStringBuilder;

        (localStringBuilder = new StringBuilder()).append("SN\t" + getSn() + "\n");
        localStringBuilder.append("DeviceID\t" + this.a + "\n");
        for (Iterator localIterator = this.b.iterator(); localIterator.hasNext(); ) {
            localIterator.next();

            localStringBuilder.append(toString());
        }

        return localStringBuilder.toString();
    }


    public LogFileDownloadResponse(String paramString) {
        super(paramString, "LogFileDownload");
    }


    public final void genParameters() {
        Object localObject = getXmlContent();
        this.a = ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));
        setSn(((String) localObject).substring(((String) localObject).indexOf("<SN>") + "<SN>".length(), ((String) localObject).indexOf("</SN>")));

        if (((String) localObject).indexOf("<log ") > -1) {
            this.b = new Vector();
            String[] arrayOfString = ((String) localObject).split("<log ");
            int j = arrayOfString.length;
            for (int i = 0; i < j; i++) {
                if ((arrayOfString[i]).indexOf("id=\"") > -1) {
                    LogFileDownloadResponse.LogBean localLogBean;

                    (localLogBean = new LogFileDownloadResponse.LogBean(this)).parse((String) localObject);
                    this.b.add(localLogBean);
                }
            }
        }
    }


    public final void genXmlContent() {
    }

    class LogBean {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;

        public LogBean(LogFileDownloadResponse paramLogFileDownloadResponse) {
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
            int j = (arrayOfString = paramString.split("\" ")).length;
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


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?>\n<Response>\n<CmdType>LogfileDownload</CmdType>\n<SN>16</SN>\n<DeviceID>13030000002020000001</DeviceID>\n<logfile>\n<log id=\"1\" action=\"full\" originIP=\"192.168.1.1\" date=\"2009-06-18 15:30:30\"/>\n<log id=\"2\" action=\"vlost\" originIP=\"192.168.1.1\" date=\"2009-06-18 15:30:30\"/>\n<log id=\"3\" action=\"play\" date=\"2009-06-26 16:52:57.0\" originIP=\"192.168.3.51\" destIP=\"192.168.3.10\" result=\"0\" />\n</logfile>\n</Response>";


        LogFileDownloadResponse localLogFileDownloadResponse;


        (localLogFileDownloadResponse = new LogFileDownloadResponse(null)).setXmlContent(s);
        localLogFileDownloadResponse.genParameters();
        SysLogger.info(localLogFileDownloadResponse.toString());
    }
}
