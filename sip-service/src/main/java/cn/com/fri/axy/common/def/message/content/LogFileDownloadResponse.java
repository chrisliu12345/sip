package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;

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
            this = (LogFileDownloadResponse.LogBean) localIterator.next();

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
            String[] arrayOfString;
            int j = (arrayOfString = localObject = ((String) localObject).split("<log ")).length;
            for (int i = 0; i < j; i++) {
                if ((localObject = arrayOfString[i]).indexOf("id=\"") > -1) {
                    LogFileDownloadResponse.LogBean localLogBean;

                    (localLogBean = new LogFileDownloadResponse.LogBean(this)).parse((String) localObject);
                    this.b.add(localLogBean);
                }
            }
        }
    }


    public final void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?>\n<Response>\n<CmdType>LogfileDownload</CmdType>\n<SN>16</SN>\n<DeviceID>13030000002020000001</DeviceID>\n<logfile>\n<log id=\"1\" action=\"full\" originIP=\"192.168.1.1\" date=\"2009-06-18 15:30:30\"/>\n<log id=\"2\" action=\"vlost\" originIP=\"192.168.1.1\" date=\"2009-06-18 15:30:30\"/>\n<log id=\"3\" action=\"play\" date=\"2009-06-26 16:52:57.0\" originIP=\"192.168.3.51\" destIP=\"192.168.3.10\" result=\"0\" />\n</logfile>\n</Response>";


        LogFileDownloadResponse localLogFileDownloadResponse;


        (localLogFileDownloadResponse = new LogFileDownloadResponse(null)).setXmlContent(paramArrayOfString);
        localLogFileDownloadResponse.genParameters();
        SysLogger.info(localLogFileDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/LogFileDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */