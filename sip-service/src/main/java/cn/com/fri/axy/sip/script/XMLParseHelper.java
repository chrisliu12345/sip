package cn.com.fri.axy.sip.script;

import cn.com.fri.axy.common.util.SysLogger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Observer;
import java.util.Vector;


public class XMLParseHelper {
    public static Vector readXMLFile(String paramString) {
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
            localObject1 = ((DocumentBuilder) localObject2).parse(paramString);

        } catch (SAXException localSAXException) {
            SysLogger.printStackTrace(paramString = localSAXException);
        } catch (DOMException localDOMException1) {
            SysLogger.printStackTrace(paramString = localDOMException1);
        } catch (IOException localIOException) {
            SysLogger.printStackTrace(paramString = localIOException);
        }


        if ((paramString = (paramString = ((Document) localObject1).getDocumentElement()).getElementsByTagName("CallBean")).getLength() == 0) {
            return localVector;
        }

        for (int i = 0; i < paramString.getLength(); i++) {

            localObject2 = (Element) paramString.item(i);
            SysLogger.info("parse " + ((Element) localObject2).getNodeName() + " " + (i + 1));

            Object localObject3 = ((Element) localObject2).getAttribute("type");

            if ("RealTimeCallBean".equalsIgnoreCase((String) localObject3)) {

                SysLogger.info("parse RealTimeCallBean");
                localObject3 = new RealTimeCallBean();


                localObject2 = ((Element) localObject2).getChildNodes();
                for (int j = 0; j < ((NodeList) localObject2).getLength(); j++) {
                    Object localObject4 = ((NodeList) localObject2).item(j);
                    SysLogger.info("NodeValue " + ((Node) localObject4).getTextContent());
                    if ("StartInterval".equalsIgnoreCase(((Node) localObject4).getNodeName())) {
                        ((RealTimeCallBean) localObject3).setStartinterval(Long.parseLong(((Node) localObject4).getTextContent()));
                    } else if ("StopInterval".equalsIgnoreCase(((Node) localObject4).getNodeName())) {
                        ((RealTimeCallBean) localObject3).setStopinterval(Long.parseLong(((Node) localObject4).getTextContent()));
                    } else if ("SourceID".equalsIgnoreCase(((Node) localObject4).getNodeName())) {
                        ((RealTimeCallBean) localObject3).setSourceID(((Node) localObject4).getTextContent());
                    } else if ("Resolution".equalsIgnoreCase(((Node) localObject4).getNodeName())) {
                        ((RealTimeCallBean) localObject3).setResolution(Integer.parseInt(((Node) localObject4).getTextContent()));
                    } else if ("DestID".equalsIgnoreCase(((Node) localObject4).getNodeName())) {
                        ((RealTimeCallBean) localObject3).setDestID(((Node) localObject4).getTextContent());
                    } else if ("WID".equalsIgnoreCase(((Node) localObject4).getNodeName())) {
                        ((RealTimeCallBean) localObject3).setWID(Integer.parseInt(((Node) localObject4).getTextContent()));
                    } else if ("ObserverClass".equalsIgnoreCase(((Node) localObject4).getNodeName())) {
                        Observer localObserver = null;
                        Class localClass = null;
                        try {
                            localClass = Class.forName(((Node) localObject4).getTextContent());

                        } catch (DOMException localDOMException2) {
                            (localObject4 = localDOMException2).printStackTrace();

                        } catch (ClassNotFoundException localClassNotFoundException) {
                            (localObject4 = localClassNotFoundException).printStackTrace();
                        }


                        try {
                            localObserver = (Observer) (localObject4 = localClass.getConstructor(new Class[0])).newInstance(new Object[0]);
                        } catch (Exception localException) {
                        }


                        ((RealTimeCallBean) localObject3).setO(localObserver);
                    } else {
                        SysLogger.info("donothing.");
                    }
                }

                SysLogger.info(((RealTimeCallBean) localObject3).toString());
                localVector.add(localObject3);
            } else {
                SysLogger.error("error when parse");
            }
        }


        return localVector;
    }


    public static void main(String[] paramArrayOfString) {
        readXMLFile("D:\\TestBean.xml");
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/script/XMLParseHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */