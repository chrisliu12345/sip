package cn.com.fri.axy.sip.jsp_taglibs;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.call.invite.InviteHandler;
import cn.com.fri.axy.sip.call.invite.InviteManager;
import cn.com.fri.axy.sip.register.entity.Registration;
import cn.com.fri.axy.sip.register.entity.RegistrationService;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.sip.Address;
import java.io.IOException;
import java.util.Iterator;

public class LookupTag extends TagSupport {
    public int doEndTag() {
        JspWriter localJspWriter = this.pageContext.getOut();
        try {
            localJspWriter.println("<br>");

            localJspWriter.println("<table id=\"register_table\" class=\"lookup_table\" border=\"1\" cellspacing='0' cellpadding='1'>");
            localJspWriter.println("<tr><th>设备URI<th>注册地址<th>注册过期时间</tr>");
            Object localObject1;
            String str;
//            for ( RegistrationService.getInstance().getAllRegistrations().values().iterator(); ((Iterator) localObject2).hasNext(); ) {
//                localObject1 = (Registration) ((Iterator) localObject2).next();
//
//                localJspWriter.println("<tr><td>");
//                localJspWriter.println(((Registration) localObject1).getUri());
//                localJspWriter.println("<td>");
//
//                str = "";
//                for (Address localAddress : ((Registration) localObject1).getContacts()) {
//                    StringBuffer localStringBuffer;
//                    (localStringBuffer = new StringBuffer()).append(str);
//                    if (localAddress.getDisplayName() != null) {
//                        localStringBuffer.append("\"").append(localAddress.getDisplayName()).append("\"");
//                    }
//                    localStringBuffer.append(" &lt ").append(localAddress.getURI());
//                    localStringBuffer.append(" &gt");
//                    localJspWriter.println(localStringBuffer.toString());
//                    str = ", ";
//                }
//                localJspWriter.println("<td>");
//                localJspWriter.println(new java.util.Date(((Registration) localObject1).getExpiration()));
//                localJspWriter.println("</tr>");
//            }

            localJspWriter.println("</table>");

            localJspWriter.println("<br>");

            localJspWriter.println("<table id=\"linkage_table\" class=\"lookup_table\" border=\"1\" cellspacing='0' cellpadding='1'>");
            localJspWriter.println("<tr><th>连接ID<th>设备ID<th>呼叫类型<th>呼叫状态<th>断开连接</tr>");

//
//            for (localObject2 = InviteManager.getInstance().getAllInviteSession().values().iterator(); ((Iterator) localObject2).hasNext(); ) {
//                str = (localObject1 = (InviteHandler) ((Iterator) localObject2).next()).getLinkageID();
//                localJspWriter.println("<tr><td>" + str + "</td><td>" + ((InviteHandler) localObject1).getCalleeID() + "</td><td>" + ((InviteHandler) localObject1).getCallType() + "</td><td>" + ((InviteHandler) localObject1).getState() + "</td>" +
//                        "<td><form method=\"post\" action=\"/SIPStandardDebug/sip/sendBye.jsp\" name=\"sendBye\" id=\"sendBye_" + str + "\">" +
//                        "<input type=\"hidden\" name=\"linkageID\" value=\"" + str + "\">" +
//                        "</form>" +
//                        "<a href=\"#\" onclick=\"delink('" + str + "')\">断开</a>" +
//                        "</td>" +
//                        "</tr>");
//            }

            localJspWriter.println("</table>");

            localJspWriter.println("<br>");
        } catch (Exception localException) {
            try {
                localJspWriter.println(localException);
            } catch (IOException localIOException) {
                Object localObject2;
                SysLogger.printStackTrace( localIOException);
            }
            SysLogger.printStackTrace(localException);
        }
        return doEndTag();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/jsp_taglibs/LookupTag.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */