package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.OnlyReqMessage;


public class MediaStatusRequest
        extends OnlyReqMessage {
    private String a;
    private String b;
    private String c;

    public int getNotifyType() {
        return Integer.parseInt(this.b);
    }

    public int getDownloadPercent() {
        return Integer.parseInt(this.c);
    }


    public MediaStatusRequest(String paramString) {
        super(paramString, "MediaStatus");
    }


    public void genParameters() {
        String str = getXmlContent();
        this.b = str.substring(str.indexOf("<NotifyType>") + "<NotifyType>".length(), str.indexOf("</NotifyType>"));
        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));

        if (str.indexOf("<DownLoadPercent>") > -1) {
            this.c = str.substring(str.indexOf("<DownloadPercent>") + "<DownloadPercent>".length(), str.indexOf("</DownloadPercent>"));
        }
    }


    public void genXmlContent() {
    }


    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Notify><CmdType>Keepalive</CmdType><SN>命令序列号</SN>< DeviceID > 设备编码</ DeviceID ><Status> ERROR</Status><Info><DeviceID> 故障设备编码1</DeviceID><DeviceID> 故障设备编码n</DeviceID></Info></Notify>";


        KeepaliveRequest localKeepaliveRequest;


        (localKeepaliveRequest = new KeepaliveRequest(null)).setXmlContent(s);
        localKeepaliveRequest.genParameters();
        SysLogger.info("");
        SysLogger.info(localKeepaliveRequest.getDeviceID());
        SysLogger.info(localKeepaliveRequest.getStatus());
        SysLogger.info(localKeepaliveRequest.getInfos().firstElement());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/MediaStatusRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */