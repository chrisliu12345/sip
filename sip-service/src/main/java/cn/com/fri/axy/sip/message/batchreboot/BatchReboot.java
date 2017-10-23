package cn.com.fri.axy.sip.message.batchreboot;

import cn.com.fri.axy.common.util.SysLogger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.servlet.sip.SipFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;
import static sun.plugin2.os.windows.OSVERSIONINFOA.size;


public class BatchReboot {
    private static BatchReboot a = new BatchReboot();

    public static BatchReboot getInstance() {
        return a;
    }


    private static String b = "/cn/com/fri/axy/sip/message/batchreboot/rebootdevice.xml";


    public Vector readXMLFile(String paramString) {
        Vector localVector = new Vector();


        Object localObject1 = DocumentBuilderFactory.newInstance();
        Object localObject2 = null;
        try {
            localObject2 = ((DocumentBuilderFactory) localObject1).newDocumentBuilder();
        } catch (ParserConfigurationException localParserConfigurationException) {
            SysLogger.printStackTrace(localParserConfigurationException);
        }

        localObject1 = null;
        try {
            InputStream ip = SysLogger.class.getResourceAsStream(paramString);
            localObject1 = ((DocumentBuilder) localObject2).parse(paramString);

        } catch (SAXException localSAXException) {
            SysLogger.printStackTrace(localSAXException);
        } catch (DOMException localDOMException) {
            SysLogger.printStackTrace(localDOMException);
        } catch (IOException localIOException) {
            SysLogger.printStackTrace(localIOException);
        }

        if (((((Document) localObject1).getDocumentElement()).getElementsByTagName("Device")).getLength() == 0) {
            return localVector;
        }
//
//        for (int i = 0; i < paramString.getLength(); i++) {
//
//            localObject2 = (Element) paramString.item(i);
//            SysLogger.info("parse " + ((Element) localObject2).getNodeName() + " " + (i + 1));
//
//
//            SysLogger.info("parse Device");
//            BatchReboot.DeviceBean localDeviceBean = new BatchReboot.DeviceBean(this);
//
//
//            localObject2 = ((Element) localObject2).getChildNodes();
//            for (int j = 0; j < ((NodeList) localObject2).getLength(); j++) {
//                Node localNode = ((NodeList) localObject2).item(j);
//                SysLogger.info("NodeValue " + localNode.getTextContent());
//                if ("DeviceID".equalsIgnoreCase(localNode.getNodeName())) {
//                    localDeviceBean.setDeviceID(localNode.getTextContent());
//                } else if ("IP".equalsIgnoreCase(localNode.getNodeName())) {
//                    localDeviceBean.setIp(localNode.getTextContent());
//                } else if ("Port".equalsIgnoreCase(localNode.getNodeName())) {
//                    localDeviceBean.setPort(Integer.parseInt(localNode.getTextContent()));
//                } else {
//                    SysLogger.info("donothing.");
//                }
//            }

//
//            SysLogger.info(localDeviceBean.toString());
//            localVector.add(localDeviceBean);
//        }


        return localVector;
    }


    public void sendRebootMessage() {
        if (((readXMLFile(b)) == null) || (size() == 0)) {
            SysLogger.info("v is empty.");
            return;
        }
        Object localObject1;
        SipFactory localSipFactory;
        Object localObject2;
        for (Iterator localIterator = iterator(); localIterator.hasNext(); ) {
            localIterator.next();
        }
    }

    class DeviceBean {
        public String deviceID;


        public String ip;


        public int port;


        public DeviceBean(BatchReboot paramBatchReboot) {
        }


        public String getDeviceID() {
            return this.deviceID;
        }

        public void setDeviceID(String paramString) {
            this.deviceID = paramString;
        }

        public String getIp() {
            return this.ip;
        }

        public void setIp(String paramString) {
            this.ip = paramString;
        }

        public int getPort() {
            return this.port;
        }

        public void setPort(int paramInt) {
            this.port = paramInt;
        }

        public String toString() {
            return "deviceID\t" + this.deviceID + "\n" + "ip\t" + this.ip + "\n" + "port\t" + this.port + "\n";
        }
    }

    public static void main(String[] paramArrayOfString) {
        getInstance().sendRebootMessage();
    }
}
