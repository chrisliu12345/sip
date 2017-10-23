package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.message.content.OnlyReqMessage;

import java.util.Vector;


public class KeepaliveRequest
        extends OnlyReqMessage {
    private String a;
    private String b;
    private Vector c;

    public KeepaliveRequest(String paramString) {
        super(paramString, "Keepalive");
    }


    public void genParameters() {
        Object localObject = getXmlContent();
        this.b = ((String) localObject).substring(((String) localObject).indexOf("<Status>") + "<Status>".length(), ((String) localObject).indexOf("</Status>"));
        this.a = ((String) localObject).substring(((String) localObject).indexOf("<DeviceID>") + "<DeviceID>".length(), ((String) localObject).indexOf("</DeviceID>"));


        if (((String) localObject).indexOf("<Info>") > -1) {
            this.c = new Vector();

            String[] arrayOfString;
//            int j =  (localObject = ((String) localObject).substring(((String) localObject).indexOf("<Info>"))).split("<DeviceID>").length;
//            for (int i = 0; i < j; i++) {
//                if ((arrayOfString[i]).indexOf("</DeviceID>") > -1) {
//
//                    this.c.add(((String) localObject).substring(0, ((String) localObject).indexOf("</DeviceID>")));
//                }
//            }
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

    public Vector getInfos() {
        return this.c;
    }

    public void setInfos(Vector paramVector) {
        this.c = paramVector;
    }

    public String getStatus() {
        return this.b;
    }

    public void setStatus(String paramString) {
        this.b = paramString;
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


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/KeepaliveRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */