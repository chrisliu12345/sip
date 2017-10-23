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


    public CoderCameraParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        String localObject = getXmlContent();
        setSn(( localObject).substring(( localObject).indexOf("<SN>") + "<SN>".length(), ( localObject).indexOf("</SN>")));
        this.a = ( localObject).substring(( localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ( localObject).indexOf("</DeviceID>"));
        this.c = ( localObject).substring(( localObject).indexOf("<ConfigType>") + "<ConfigType>".length(), ( localObject).indexOf("</ConfigType>"));
        this.d = ( localObject).substring(( localObject).indexOf("<SEQ>") + "<SEQ>".length(), ( localObject).indexOf("</SEQ>"));

        if (( localObject).indexOf("<Item>") > -1) {

            this.b = new Vector();

            String[] arrayOfString;
            arrayOfString= ( localObject).split("<Item>");
            int j =arrayOfString.length;
//            for (int i = 0; i < j; i++) {
//                if ((localObject = arrayOfString[i]).indexOf("<Channel>") > -1) {
//                    SysLogger.info(localObject);
//                    CoderCameraParamConfigDownloadResponse.ItemBean localItemBean;
//                    CoderCameraParamConfigDownloadResponse.ItemBean.a(localItemBean = new CoderCameraParamConfigDownloadResponse.ItemBean(this), ((String) localObject).substring(((String) localObject).indexOf("<Channel>") + "<Channel>".length(), ((String) localObject).indexOf("</Channel>")));
//                    CoderCameraParamConfigDownloadResponse.ItemBean.b(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Name>") + "<Name>".length(), ((String) localObject).indexOf("</Name>")));
//                    CoderCameraParamConfigDownloadResponse.ItemBean.c(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>")));
//                    CoderCameraParamConfigDownloadResponse.ItemBean.d(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Description>") + "<Description>".length(), ((String) localObject).indexOf("</Description>")));
//                    CoderCameraParamConfigDownloadResponse.ItemBean.e(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Osd>") + "<Osd>".length(), ((String) localObject).indexOf("</Osd>")));
//
//                    this.b.add(localItemBean);
//                }
//            }
        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><CameraParam><Item><Channel>输入通道编号</Channel><Name>设备名称</Name><DeviceID>摄像机ID </DeviceID><Description>设备描述</Description><Osd>OSD信息选项</Osd></Item><Item><Channel>输入通道编号2</Channel><Name>设备名称2</Name><DeviceID>摄像机ID2 </DeviceID><Description>设备描述2</Description><Osd>OSD信息选项2</Osd></Item></CameraParam></Response>";


        CoderCameraParamConfigDownloadResponse localCoderCameraParamConfigDownloadResponse;


        (localCoderCameraParamConfigDownloadResponse = new CoderCameraParamConfigDownloadResponse("")).setXmlContent(s);
        localCoderCameraParamConfigDownloadResponse.genParameters();
        System.out.println(localCoderCameraParamConfigDownloadResponse.toString());
    }
}
