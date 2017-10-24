package com.git.wuqf.service.common.def.message.content.decoderconfigdownload;

import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.message.content.ResMessage;

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


    public DecoderOutputParamConfigDownloadResponse(String paramString) {
        super(paramString, "ConfigDownload");
    }


    public void genParameters() {
        Object localObject = getXmlContent();
        setSn(((String) localObject).substring(((String) localObject).indexOf("<SN>") + "<SN>".length(), ((String) localObject).indexOf("</SN>")));
        this.a = ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));

        if (((String) localObject).indexOf("<Item>") > -1) {

            this.b = new Vector();

            String[] arrayOfString = null;
            int j = (((String) localObject).split("<Item>")).length;
            for (int i = 0; i < j; i++) {
                if ((arrayOfString[i]).indexOf("<Channel>") > -1) {
                    SysLogger.info(localObject);
//                    DecoderOutputParamConfigDownloadResponse.ItemBean localItemBean;
//                    DecoderOutputParamConfigDownloadResponse.ItemBean.a(localItemBean = new DecoderOutputParamConfigDownloadResponse.ItemBean(this), ((String) localObject).substring(((String) localObject).indexOf("<Channel>") + "<Channel>".length(), ((String) localObject).indexOf("</Channel>")));
//                    DecoderOutputParamConfigDownloadResponse.ItemBean.b(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Name>") + "<Name>".length(), ((String) localObject).indexOf("</Name>")));
//                    DecoderOutputParamConfigDownloadResponse.ItemBean.c(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>")));
//                    DecoderOutputParamConfigDownloadResponse.ItemBean.d(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<Description>") + "<Description>".length(), ((String) localObject).indexOf("</Description>")));
//                    DecoderOutputParamConfigDownloadResponse.ItemBean.e(localItemBean, ((String) localObject).substring(((String) localObject).indexOf("<MediaSecurity>") + "<MediaSecurity>".length(), ((String) localObject).indexOf("</MediaSecurity>")));

//                    this.b.add(localItemBean);
                }
            }
        }
    }


    public void genXmlContent() {
    }

    class ItemBean {
        private String a;


        private String b;


        private String c;


        private String d;


        private String e;


        public ItemBean(DecoderOutputParamConfigDownloadResponse paramDecoderOutputParamConfigDownloadResponse) {
        }


        public String getChannel() {
            return this.a;
        }

        public void setChannel(String paramString) {
            this.a = paramString;
        }

        public String getName() {
            return this.b;
        }

        public void setName(String paramString) {
            this.b = paramString;
        }

        public String getOutputDeviceID() {
            return this.c;
        }

        public void setOutputDeviceID(String paramString) {
            this.c = paramString;
        }

        public String getDescription() {
            return this.d;
        }

        public void setDescription(String paramString) {
            this.d = paramString;
        }

        public String getMediaSecurity() {
            return this.e;
        }

        public void setMediaSecurity(String paramString) {
            this.e = paramString;
        }

        public String toString() {
            return


                    "Channel\t" + this.a + "\n" + "Name\t" + this.b + "\n" + "OutputDeviceID\t" + this.c + "\n" + "Description\t" + this.d + "\n" + "MediaSecurity\t" + this.e + "\n";
        }
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><OutputParam><Item><Channel>输入通道编号</Channel><Name>设备名称</Name><DeviceID>视频输出ID </DeviceID><Description>设备描述</Description><MediaSecurity> 0</MediaSecurity></Item><Item><Channel>输入通道编号2</Channel><Name>设备名称2</Name><DeviceID>视频输出ID2 </DeviceID><Description>设备描述2</Description><MediaSecurity> 02</MediaSecurity></Item></OutputParam></Response>";


        DecoderOutputParamConfigDownloadResponse localDecoderOutputParamConfigDownloadResponse;


        (localDecoderOutputParamConfigDownloadResponse = new DecoderOutputParamConfigDownloadResponse("")).setXmlContent(s);
        localDecoderOutputParamConfigDownloadResponse.genParameters();
        System.out.println(localDecoderOutputParamConfigDownloadResponse.toString());
    }

}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/decoderconfigdownload/DecoderOutputParamConfigDownloadResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */