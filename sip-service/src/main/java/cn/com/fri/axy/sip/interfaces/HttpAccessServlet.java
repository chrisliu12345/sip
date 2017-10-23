package cn.com.fri.axy.sip.interfaces;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HttpAccessServlet
        extends HttpServlet {
    public void service(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws IOException {
        paramHttpServletResponse.setCharacterEncoding("UTF-8");
        paramHttpServletResponse.setContentType("text/xml");
        paramHttpServletResponse.getWriter();

//        if (paramHttpServletRequest.getMethod().equals("POST")) {
//            try {
//                String localObject = paramHttpServletRequest.getParameter("requestType");
//
//                if ("sendmessage".equalsIgnoreCase((String) localObject)) {
//                    SimpleObserver s = new SimpleObserver();
//
//
//                    paramHttpServletRequest.setCharacterEncoding("UTF-8");
//                    String devicetype = paramHttpServletRequest.getParameter("devicetype");
//                    String str1 = paramHttpServletRequest.getParameter("deviceid");
//                    String str2 = paramHttpServletRequest.getParameter("MessageParam");
//                    String MessageTextAera = paramHttpServletRequest.getParameter("MessageTextAera");
//
//                    SysLogger.info(paramHttpServletResponse);
//
//
//                    String str3 = "消息已发送";
//
//                    if (paramHttpServletRequest.indexOf("\r\n") < 0) {
//                        paramHttpServletRequest = paramHttpServletRequest.replaceAll("\n", "\r\n");
//                    }
//
//                    if ((str2 == null) || (str2.length() == 0)) {
//                        str3 = "未选择发送消息类型。";
//
//                    } else if (!LocationService.getInstance().isLocalDomainDeviceOnline(str1)) {
//                        str3 = "设备 " + str1 + " 未上线，请检查该设备是否注册成功。";
//                    } else {
//                        String str4 = str2;
//                        HttpServletResponse localHttpServletResponse = paramHttpServletResponse;
//                        if (("othersystem".equalsIgnoreCase(localHttpServletResponse) ? 1 : "decoder".equalsIgnoreCase(localHttpServletResponse) ? 0 : ("RealTime".equalsIgnoreCase(str4)) || ("DeviceCatalog".equalsIgnoreCase(str4)) || ("DeviceInfo".equalsIgnoreCase(str4)) || ("DeviceStatus".equalsIgnoreCase(str4)) || ("Boot".equalsIgnoreCase(str4)) ? 1 : "ipc".equalsIgnoreCase(localHttpServletResponse) ? 1 : ("Alarm".equalsIgnoreCase(str4)) || ("Keepalive".equalsIgnoreCase(str4)) ? 0 : "dvr".equalsIgnoreCase(localHttpServletResponse) ? 1 : ("Alarm".equalsIgnoreCase(str4)) || ("Keepalive".equalsIgnoreCase(str4)) ? 0 : 0) == 0) {
//                            str3 = "设备类型" + paramHttpServletResponse + "不支持" + str2 + "消息，请选择其他消息调试。";
//                        } else if (str2.equalsIgnoreCase("RealTime")) {
//                            new InviteHandler().sendInvite(paramHttpServletResponse, str1, paramHttpServletRequest);
//                        } else if (str2.equalsIgnoreCase("History")) {
//                            new InviteHandler().sendInvite(paramHttpServletResponse, str1, paramHttpServletRequest);
//                        } else if (str2.equalsIgnoreCase("Download")) {
//                            new InviteHandler().sendInvite(paramHttpServletResponse, str1, paramHttpServletRequest);
//                        } else if (str2.indexOf("PTZ") > -1) {
//
//                            (paramHttpServletResponse = new PTZDeviceControlRequest(str1)).setXmlContent(paramHttpServletRequest);
//                            new DirectAccessBean().sendPTZMessage(paramHttpServletResponse, null, null, 0);
//                        } else if (str2.indexOf("PlaybackControl") > -1) {
//
//                            if ((paramHttpServletResponse = InviteManager.getInstance().getPlaybackInviteSession()) == null) {
//                                str3 = "未找到回放连接，请先建立一路回放连接再开始回放控制。";
//
//                            } else if (!paramHttpServletResponse.isSessionEstablished()) {
//                                str3 = "回放连接尚未建立，请建立成功回放连接再开始回放控制。";
//                            } else {
//                                paramHttpServletResponse.sendInfo(paramHttpServletRequest);
//                            }
//
//                        } else if (str2.equalsIgnoreCase("StartRecord")) {
//
//                            (paramHttpServletResponse = new RecordRequest(str1, (Observer) localObject)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//                        } else if (str2.equalsIgnoreCase("StopRecord")) {
//
//                            (paramHttpServletResponse = new RecordRequest(str1, (Observer) localObject)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//
//                        } else if (str2.equalsIgnoreCase("FileQuery")) {
//
//
//                            (paramHttpServletResponse = new RecordInfoQuery(str1, null)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//
//                        } else if (str2.equalsIgnoreCase("SetGuard")) {
//
//                            (paramHttpServletResponse = new GuardDeviceControlRequest(str1, null)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//                        } else if (str2.equalsIgnoreCase("ResetGuard")) {
//
//                            (paramHttpServletResponse = new GuardDeviceControlRequest(str1, null)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//                        } else if (str2.equalsIgnoreCase("ResetAlarm")) {
//
//                            (paramHttpServletResponse = new AlarmResetDeviceControlRequest(str1, null)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//                        } else if (str2.equalsIgnoreCase("DeviceCatalog")) {
//
//                            (paramHttpServletResponse = new DeviceCatalogQuery(str1, null)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//
//                        } else if (str2.equalsIgnoreCase("DeviceStatus")) {
//
//                            (paramHttpServletResponse = new DeviceStatusQuery(str1, null)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//
//                        } else if (str2.equalsIgnoreCase("DeviceInfo")) {
//
//                            (paramHttpServletResponse = new DeviceInfoQuery(str1, null)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//
//                        } else if (str2.equalsIgnoreCase("Boot")) {
//
//                            (paramHttpServletResponse = new DeviceConfigTeleBootRequest(str1, (Observer) localObject)).setXmlContent(paramHttpServletRequest);
//                            new MessageHandler().sendMessage(paramHttpServletResponse);
//                        }
//                    }
//
//
//                    SysLogger.info(str3 = "<result>" + str3 + "</result>");
//                    write(str3);
//
//
//                } else if ("sendbye".equalsIgnoreCase((String) localObject)) {
//                    paramHttpServletRequest.setCharacterEncoding("UTF-8");
//
//                    SysLogger.info(localObject = paramHttpServletRequest.getParameter("linkageID"));
//
//                    if ((localObject != null) && (((String) localObject).length() != 0)) {
//                        InviteManager.getInstance().endInviteSession((String) localObject);
//                    } else {
//                        println("some peramter is null");
//                    }
//
//                    paramHttpServletResponse.sendRedirect("/SIPStandardDebug/sip/lookup.jsp");
//                } else {
//                    println("wrong argument.");
//                }
//
//                close();
//                return;
//            } catch (Exception localException) {
//                Object localObject;
//                SysLogger.printStackTrace(localObject = localException);
//                return;
//            }
//    }

//        paramHttpServletResponse.sendRedirect("/SIPStandardDebug/index.jsp");
    }

    public void init(ServletConfig paramServletConfig) {
        init(paramServletConfig);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/interfaces/HttpAccessServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */