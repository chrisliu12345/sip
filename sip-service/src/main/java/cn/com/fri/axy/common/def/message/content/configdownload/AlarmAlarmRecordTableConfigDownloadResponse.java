package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;

import java.util.Iterator;
import java.util.Vector;


public class AlarmAlarmRecordTableConfigDownloadResponse
        extends ResMessage {
    private String a;
    private Vector b;
    private String c;
    private String d;

    public String getConfigType() {
        return this.c;
    }

    public void setConfigType(String paramString) {
        this.c = paramString;
    }

    public String getSEQ() {
        return this.d;
    }

    public void setSEQ(String paramString) {
        this.d = paramString;
    }

    public Vector getItems() {
        return this.b;
    }

    public void setItems(Vector paramVector) {
        this.b = paramVector;
    }


    public String toString() {
        StringBuilder localStringBuilder;

        (localStringBuilder = new StringBuilder()).append("SN\t" + getSn() + "\n");
        localStringBuilder.append("DeviceID\t" + this.a + "\n");
        localStringBuilder.append("ConfigType\t" + this.c + "\n");
        localStringBuilder.append("SEQ\t" + this.d + "\n");
        for (Iterator localIterator = this.b.iterator(); localIterator.hasNext(); ) {
            localIterator.next();

            localStringBuilder.append(toString());
        }

        return localStringBuilder.toString();
    }

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }


    public AlarmAlarmRecordTableConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        Object localObject = getXmlContent();
        setSn(((String) localObject).substring(((String) localObject).indexOf("<SN>") + "<SN>".length(), ((String) localObject).indexOf("</SN>")));
        this.a = ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));
        this.c = ((String) localObject).substring(((String) localObject).indexOf("<ConfigType>") + "<ConfigType>".length(), ((String) localObject).indexOf("</ConfigType>"));
        this.d = ((String) localObject).substring(((String) localObject).indexOf("<SEQ>") + "<SEQ>".length(), ((String) localObject).indexOf("</SEQ>"));

        if (((String) localObject).indexOf("<Item>") > -1) {

            this.b = new Vector();

            String[] arrayOfString;
            arrayOfString = ((String) localObject).split("<Item>");
            int j = arrayOfString.length;
            for (int i = 0; i < j; i++) {
                if ((arrayOfString[i]).indexOf("<PreNum>") > -1) {
                    SysLogger.info(localObject);
//                    ItemBean localItemBean = new ItemBean(this), ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));
//                    localItemBean(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<PreNum>") + "<PreNum>".length(), ((String) localObject).indexOf("</PreNum>")));
//
//                    this.b.add(localItemBean);
                }
            }
        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>报警器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><AlarmRecordTable><Item><DeviceID>摄像机ID1</DeviceID><PreNum>预置位号1</PreNum></Item><Item><DeviceID>摄像机ID2</DeviceID><PreNum>预置位号2</PreNum></Item></AlarmRecordTable></Response>";


        AlarmAlarmRecordTableConfigDownloadResponse localAlarmAlarmRecordTableConfigDownloadResponse;


        (localAlarmAlarmRecordTableConfigDownloadResponse = new AlarmAlarmRecordTableConfigDownloadResponse("")).setXmlContent(s);
        localAlarmAlarmRecordTableConfigDownloadResponse.genParameters();
        System.out.println(localAlarmAlarmRecordTableConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/AlarmAlarmRecordTableConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */