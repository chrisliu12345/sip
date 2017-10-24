package com.git.wuqf.service.common.def.message.content.configdownload;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ResMessage;

import java.util.Iterator;
import java.util.Vector;


public class CoderAlarmChannelParamConfigDownloadResponse
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


    public CoderAlarmChannelParamConfigDownloadResponse(String paramString) {
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
            int j = (arrayOfString =  ((String) localObject).split("<Item>")).length;
            for (int i = 0; i < j; i++) {
                if (( arrayOfString[i]).indexOf("<Channel>") > -1) {
                    SysLogger.info(localObject);
                    ItemBean localItemBean;
//                    ItemBean.a(localItemBean = new ItemBean(this), ((String) localObject).substring(((String) localObject).indexOf("<Channel>") + "<Channel>".length(), ((String) localObject).indexOf("</Channel>")));
//                    ItemBean.b(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Name>") + "<Name>".length(), ((String) localObject).indexOf("</Name>")));
//                    ItemBean.c(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>")));
//                    ItemBean.d(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Description>") + "<Description>".length(), ((String) localObject).indexOf("</Description>")));
//                    ItemBean.e(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<AlarmLevel>") + "<AlarmLevel>".length(), ((String) localObject).indexOf("</AlarmLevel>")));

//                    this.b.add(localItemBean);
                }
            }
        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><AlarmChannelParam><Item><Channel>输入报警探头号</Channel><Name>设备名称</Name><DeviceID>报警器ID </DeviceID><Description>设备描述</Description><AlarmLevel>报警级别</AlarmLevel></Item><Item><Channel>输入报警探头号2</Channel><Name>设备名称2</Name><DeviceID>报警器ID2 </DeviceID><Description>设备描述2</Description><AlarmLevel>报警级别2</AlarmLevel></Item></AlarmChannelParam></Response>";


        CoderAlarmChannelParamConfigDownloadResponse localCoderAlarmChannelParamConfigDownloadResponse;


        (localCoderAlarmChannelParamConfigDownloadResponse = new CoderAlarmChannelParamConfigDownloadResponse("")).setXmlContent(s);
        localCoderAlarmChannelParamConfigDownloadResponse.genParameters();
        System.out.println(localCoderAlarmChannelParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CoderAlarmChannelParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */