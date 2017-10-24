package com.git.wuqf.service.common.def.message.content.decoderconfigdownload;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ResMessage;

import java.util.Iterator;
import java.util.Vector;


public class DecoderExtensionParamConfigDownloadResponse
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
//             (DecoderExtensionParamConfigDownloadResponse.ItemBean) localIterator.next();

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


    public DecoderExtensionParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        Object localObject = getXmlContent();
        setSn(((String) localObject).substring(((String) localObject).indexOf("<SN>") + "<SN>".length(), ((String) localObject).indexOf("</SN>")));
        this.a = ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));

        if (((String) localObject).indexOf("<Item>") > -1) {

            this.b = new Vector();

            String[] arrayOfString=null;
            int j = (  ((String) localObject).split("<Item>")).length;
            for (int i = 0; i < j; i++) {
                if (( arrayOfString[i]).indexOf("<ExtensionItem>") > -1) {
                    SysLogger.info(localObject);
//                    DecoderExtensionParamConfigDownloadResponse.ItemBean localItemBean;
//                    DecoderExtensionParamConfigDownloadResponse.ItemBean.a(localItemBean = new DecoderExtensionParamConfigDownloadResponse.ItemBean(this), ((String) localObject).substring(((String) localObject).indexOf("<ExtensionItem>") + "<ExtensionItem>".length(), ((String) localObject).indexOf("</ExtensionItem>")));

//                    this.b.add(localItemBean);
                }
            }
        }
    }


    public void genXmlContent() {
    }

    class ItemBean {
        private String a;
        public ItemBean(DecoderExtensionParamConfigDownloadResponse paramDecoderExtensionParamConfigDownloadResponse) {
        }
        public String toString() {
            return "ExtensionItem\t" + this.a + "\n";
        }
    }

    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ExtensionParam><Item><ExtensionItem>扩展项1 </ExtensionItem></Item><Item><ExtensionItem>扩展项2 </ExtensionItem></Item></ExtensionParam></Response>";


        DecoderExtensionParamConfigDownloadResponse localDecoderExtensionParamConfigDownloadResponse;


        (localDecoderExtensionParamConfigDownloadResponse = new DecoderExtensionParamConfigDownloadResponse("")).setXmlContent(s);
        localDecoderExtensionParamConfigDownloadResponse.genParameters();
        System.out.println(localDecoderExtensionParamConfigDownloadResponse.toString());
    }
}
