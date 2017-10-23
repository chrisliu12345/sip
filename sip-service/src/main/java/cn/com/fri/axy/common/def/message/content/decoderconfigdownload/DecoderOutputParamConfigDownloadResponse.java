package cn.com.fri.axy.common.def.message.content.decoderconfigdownload;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.ResMessage;

import java.util.Iterator;
import java.util.Vector;


public class DecoderOutputParamConfigDownloadResponse
        extends ResMessage {
    private String a;
    private Vector b;

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
        for (Iterator localIterator = this.b.iterator(); localIterator.hasNext(); ) {
            this = (DecoderOutputParamConfigDownloadResponse.ItemBean) localIterator.next();

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


    public DecoderOutputParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        Object localObject = getXmlContent();
        setSn(((String) localObject).substring(((String) localObject).indexOf("<SN>") + "<SN>".length(), ((String) localObject).indexOf("</SN>")));
        this.a = ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));

        if (((String) localObject).indexOf("<Item>") > -1) {

            this.b = new Vector();

            String[] arrayOfString;
            int j = (arrayOfString = localObject = ((String) localObject).split("<Item>")).length;
            for (int i = 0; i < j; i++) {
                if ((localObject = arrayOfString[i]).indexOf("<Channel>") > -1) {
                    SysLogger.info(localObject);
                    DecoderOutputParamConfigDownloadResponse.ItemBean localItemBean;
                    DecoderOutputParamConfigDownloadResponse.ItemBean.a(localItemBean = new DecoderOutputParamConfigDownloadResponse.ItemBean(this), ((String) localObject).substring(((String) localObject).indexOf("<Channel>") + "<Channel>".length(), ((String) localObject).indexOf("</Channel>")));
                    DecoderOutputParamConfigDownloadResponse.ItemBean.b(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Name>") + "<Name>".length(), ((String) localObject).indexOf("</Name>")));
                    DecoderOutputParamConfigDownloadResponse.ItemBean.c(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>")));
                    DecoderOutputParamConfigDownloadResponse.ItemBean.d(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Description>") + "<Description>".length(), ((String) localObject).indexOf("</Description>")));
                    DecoderOutputParamConfigDownloadResponse.ItemBean.e(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<MediaSecurity>") + "<MediaSecurity>".length(), ((String) localObject).indexOf("</MediaSecurity>")));

                    this.b.add(localItemBean);
                }
            }
        }
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><OutputParam><Item><Channel>输入通道编号</Channel><Name>设备名称</Name><DeviceID>视频输出ID </DeviceID><Description>设备描述</Description><MediaSecurity> 0</MediaSecurity></Item><Item><Channel>输入通道编号2</Channel><Name>设备名称2</Name><DeviceID>视频输出ID2 </DeviceID><Description>设备描述2</Description><MediaSecurity> 02</MediaSecurity></Item></OutputParam></Response>";


        DecoderOutputParamConfigDownloadResponse localDecoderOutputParamConfigDownloadResponse;


        (localDecoderOutputParamConfigDownloadResponse = new DecoderOutputParamConfigDownloadResponse("")).setXmlContent(paramArrayOfString);
        localDecoderOutputParamConfigDownloadResponse.genParameters();
        System.out.println(localDecoderOutputParamConfigDownloadResponse.toString());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderconfigdownload/DecoderOutputParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */