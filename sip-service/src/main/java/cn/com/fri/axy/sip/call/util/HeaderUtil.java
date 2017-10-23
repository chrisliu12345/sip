package cn.com.fri.axy.sip.call.util;

import javax.servlet.sip.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public final class HeaderUtil {
    public static final String PAI = "P-Asserted-Identity";
    public static final String HEADER_CSEQ = "CSeq";
    public static final String HEADER_VIA = "Via";
    public static final String HEADER_RECORD_ROUTE = "Record-Route";
    public static final String HEADER_RSEQ = "RSeq";
    public static final String HEADER_CALL_ID = "Call-ID";
    public static final String HEADER_CONTACT = "Contact";
    public static final String HEADER_ROUTE = "Route";
    public static final String HEADER_REQUIRE = "Require";
    public static final String HEADER_SUPPORTED = "Supported";
    public static final String HEADER_ITEM_100REL = "100rel";
    public static final String HEADER_ITEM_PRECONDITION = "precondition";
    private static final List a;

    public static boolean containsSupported100rel(SipServletMessage paramSipServletMessage) {
        ListIterator<String> s = paramSipServletMessage.getHeaders("Supported");
        while (s.hasNext()) {
            if (((String) s.next()).indexOf("100rel") >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsRequire100rel(SipServletMessage paramSipServletMessage) {
        ListIterator<String> s = paramSipServletMessage.getHeaders("Require");
        while (s.hasNext()) {
            if (((String) s.next()).indexOf("100rel") >= 0) {
                return true;
            }
        }
        return false;
    }


    public static void removeRequirePrecondition(SipServletMessage paramSipServletMessage) {
        removeHeadersItem(paramSipServletMessage, "Require", "precondition");
    }

    public static void remove100relSupported(SipServletMessage paramSipServletMessage) {
        removeHeadersItem(paramSipServletMessage, "Supported", "100rel");
    }


    public static void removeHeadersItem(SipServletMessage paramSipServletMessage, String paramString1, String paramString2) {
        a(paramSipServletMessage.getHeaders(paramString1), paramString2);
    }

    private static void a(ListIterator paramListIterator, String paramString) {
        while (paramListIterator.hasNext()) {
            String str1;
            int i;
            if ((i = (str1 = (String) paramListIterator.next()).indexOf(paramString)) != -1) {
                String str2 = str1.substring(0, i);
                if (str1.indexOf(',') == -1) {
                    paramListIterator.remove();
                } else {
                    i = (str1 = str1.substring(i + paramString.length())).indexOf(",");
                    str1 = str1.substring(i + 1);
                    str1 = str2.trim() + str1;
                    paramListIterator.set(str1);
                }
            }
        }
    }


    public static Address getSipPAIHeader(SipServletMessage paramSipServletMessage) {
        try {
            ListIterator localListIterator = paramSipServletMessage.getAddressHeaders("P-Asserted-Identity");

            while (localListIterator.hasNext()) {
                if (((Address) localListIterator.next()).getURI().isSipURI()) {
                    return ((Address) localListIterator.next());
                }
            }
        } catch (ServletParseException localServletParseException) {
        }

        return null;
    }

    public static String[] getHeaderValues(String paramString1, String paramString2) {
        if (paramString1.indexOf(paramString2) == -1) {

//            (new String[1])[0] = paramString1;
//            return paramString2;
            return null;
        }

        return paramString1.split(paramString2);
    }

    public static void copyHeadersExcept(SipServletRequest paramSipServletRequest1, SipServletRequest paramSipServletRequest2, String paramString1, String paramString2) {
        Iterator localIterator = paramSipServletRequest1.getHeaderNames();

        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();

            if (paramSipServletRequest2.getHeader(str) == null) {
                ListIterator localListIterator;
                if (paramString1.equals(str)) {


                    localListIterator = paramSipServletRequest1.getHeaders(str);
                    while (localListIterator.hasNext()) {
                        if (((String) localListIterator.next()).indexOf(paramString2) < 0) {
                            paramSipServletRequest2.addHeader(str, (String) localListIterator.next());
                        }

                    }


                } else if (!a(str)) {
                    if (b(str)) {


                        a(paramSipServletRequest1, paramSipServletRequest2);
                    } else {
                        localListIterator = paramSipServletRequest1.getHeaders(str);
                        while (localListIterator.hasNext())
                            paramSipServletRequest2.addHeader(str, (String) localListIterator.next());
                    }
                }
            }
        }
    }

    public static void copyHeaders(SipServletRequest paramSipServletRequest1, SipServletRequest paramSipServletRequest2) {
        Iterator localIterator = paramSipServletRequest1.getHeaderNames();

        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();

            if ((paramSipServletRequest2.getHeader(str) == null) &&
                    (!a(str))) {


                if (b(str)) {


                    a(paramSipServletRequest1, paramSipServletRequest2);
                } else {
                    ListIterator localListIterator = paramSipServletRequest1.getHeaders(str);
                    while (localListIterator.hasNext()) {
                        paramSipServletRequest2.addHeader(str, (String) localListIterator.next());
                    }
                }
            }
        }
    }

    public static void copyHeaders(SipServletResponse paramSipServletResponse1, SipServletResponse paramSipServletResponse2) {
        Iterator localIterator = paramSipServletResponse1.getHeaderNames();
        ListIterator localListIterator;
        label76:
        for (; localIterator.hasNext();


             localListIterator.hasNext()) {
            String str = (String) localIterator.next();

            if ((paramSipServletResponse2.getHeader(str) != null) ||
                    (a(str))) {
                break label76;
            }

            localListIterator = paramSipServletResponse1.getHeaders(str);
            continue;
//            paramSipServletResponse2.addHeader(str, (String) localListIterator.next());
        }
    }


    public static void copyHeaders(SipServletMessage paramSipServletMessage1, SipServletMessage paramSipServletMessage2, String paramString) {
        ListIterator<String> s = paramSipServletMessage1.getHeaders(paramString);

        while (s.hasNext()) {
            paramSipServletMessage2.addHeader(paramString, (String) s.next());
        }
    }


    private static void a(SipServletMessage paramSipServletMessage, SipServletRequest paramSipServletRequest) {
        ListIterator localListIterator = null;
        try {
            localListIterator = paramSipServletMessage.getAddressHeaders("Route");
        } catch (ServletParseException localServletParseException) {
        }

        if (localListIterator == null) {
            return;
        }

        while (localListIterator.hasNext()) {
            localListIterator.next();
        }

        while (localListIterator.hasPrevious()) {
            Address s = (Address) localListIterator.previous();
            paramSipServletRequest.pushRoute((SipURI) s.getURI());
        }
    }

    private static boolean a(String paramString) {
        return a.contains(paramString);
    }

    private static boolean b(String paramString) {
        return "Route".equals(paramString);
    }

    static {
        (a = new ArrayList()).add("CSeq");
        a.add("Via");
        a.add("Record-Route");
        a.add("RSeq");
        a.add("Call-ID");
        a.add("Contact");
    }

    public static void main(String[] paramArrayOfString) {
        ArrayList l = new ArrayList();
        l.add(" 100rel ,yy");
        l.add(" 100rel , 200rel, prack");
        a(l.listIterator(), "100rel");
        System.out.println(l.size());
        Iterator i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

//        paramArrayOfString = (paramArrayOfString = ",").substring(1);
        System.out.println("test:" + paramArrayOfString);
    }

    public static void replacesAllPAI(SipServletMessage paramSipServletMessage, String paramString) {
    }
}
