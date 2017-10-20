package cn.com.fri.axy.common.def.message.content.configdownload;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;

import java.util.Iterator;
import java.util.Vector;


public class CoderCameraParamConfigDownloadResponse
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
            this = (CoderCameraParamConfigDownloadResponse.ItemBean) localIterator.next();

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


    public CoderCameraParamConfigDownloadResponse(String paramString) {
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
            int j = (arrayOfString = localObject = ((String) localObject).split("<Item>")).length;
            for (int i = 0; i < j; i++) {
                if ((localObject = arrayOfString[i]).indexOf("<Channel>") > -1) {
                    SysLogger.info(localObject);
                    CoderCameraParamConfigDownloadResponse.ItemBean localItemBean;
                    CoderCameraParamConfigDownloadResponse.ItemBean.a(localItemBean = new CoderCameraParamConfigDownloadResponse.ItemBean(this), ((String) localObject).substring(((String) localObject).indexOf("<Channel>") + "<Channel>".length(), ((String) localObject).indexOf("</Channel>")));
                    CoderCameraParamConfigDownloadResponse.ItemBean.b(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Name>") + "<Name>".length(), ((String) localObject).indexOf("</Name>")));
                    CoderCameraParamConfigDownloadResponse.ItemBean.c(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>")));
                    CoderCameraParamConfigDownloadResponse.ItemBean.d(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Description>") + "<Description>".length(), ((String) localObject).indexOf("</Description>")));
                    CoderCameraParamConfigDownloadResponse.ItemBean.e(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Osd>") + "<Osd>".length(), ((String) localObject).indexOf("</Osd>")));

                    this.b.add(localItemBean);
                }
            }
        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><CameraParam><Item><Channel>输入通道编号</Channel><Name>设备名称</Name><DeviceID>摄像机ID </DeviceID><Description>设备描述</Description><Osd>OSD信息选项</Osd></Item><Item><Channel>输入通道编号2</Channel><Name>设备名称2</Name><DeviceID>摄像机ID2 </DeviceID><Description>设备描述2</Description><Osd>OSD信息选项2</Osd></Item></CameraParam></Response>";


        CoderCameraParamConfigDownloadResponse localCoderCameraParamConfigDownloadResponse;


        (localCoderCameraParamConfigDownloadResponse = new CoderCameraParamConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localCoderCameraParamConfigDownloadResponse.genParameters();
        System.out.println(localCoderCameraParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/configdownload/CoderCameraParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */