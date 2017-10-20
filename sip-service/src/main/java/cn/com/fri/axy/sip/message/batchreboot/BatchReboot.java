package cn.com.fri.axy.sip.message.batchreboot;

import cn.com.fri.axy.common.util.SysLogger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.servlet.sip.SipFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;


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
            SysLogger.printStackTrace(localObject1 = localParserConfigurationException);
        }

        localObject1 = null;
        try {
            paramString = SysLogger.class.getResourceAsStream(paramString);
            localObject1 = ((DocumentBuilder) localObject2).parse(paramString);

        } catch (SAXException localSAXException) {
            SysLogger.printStackTrace(paramString = localSAXException);
        } catch (DOMException localDOMException) {
            SysLogger.printStackTrace(paramString = localDOMException);
        } catch (IOException localIOException) {
            SysLogger.printStackTrace(paramString = localIOException);
        }


        if ((paramString = (paramString = ((Document) localObject1).getDocumentElement()).getElementsByTagName("Device")).getLength() == 0) {
            return localVector;
        }

        for (int i = 0; i < paramString.getLength(); i++) {

            localObject2 = (Element) paramString.item(i);
            SysLogger.info("parse " + ((Element) localObject2).getNodeName() + " " + (i + 1));


            SysLogger.info("parse Device");
            BatchReboot.DeviceBean localDeviceBean = new BatchReboot.DeviceBean(this);


            localObject2 = ((Element) localObject2).getChildNodes();
            for (int j = 0; j < ((NodeList) localObject2).getLength(); j++) {
                Node localNode = ((NodeList) localObject2).item(j);
                SysLogger.info("NodeValue " + localNode.getTextContent());
                if ("DeviceID".equalsIgnoreCase(localNode.getNodeName())) {
                    localDeviceBean.setDeviceID(localNode.getTextContent());
                } else if ("IP".equalsIgnoreCase(localNode.getNodeName())) {
                    localDeviceBean.setIp(localNode.getTextContent());
                } else if ("Port".equalsIgnoreCase(localNode.getNodeName())) {
                    localDeviceBean.setPort(Integer.parseInt(localNode.getTextContent()));
                } else {
                    SysLogger.info("donothing.");
                }
            }


            SysLogger.info(localDeviceBean.toString());
            localVector.add(localDeviceBean);
        }


        return localVector;
    }


    public void sendRebootMessage() {
        if (((this = readXMLFile(b)) == null) || (size() == 0)) {
            SysLogger.info("v is empty.");
            return;
        }
        Object localObject1;
        SipFactory localSipFactory;
        Object localObject2;
        for (Iterator localIterator = iterator(); localIterator.hasNext();

                ) {
            this = this = (BatchReboot.DeviceBean) localIterator.next();
        }
    }


    public static void main(String[] paramArrayOfString) {
        getInstance().sendRebootMessage();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/batchreboot/BatchReboot.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */