package com.git.wuqf.service.sip.event;

import com.git.wuqf.service.sip.call.util.HeaderUtil;
import com.git.wuqf.service.sip.core.MessageContext;
import com.git.wuqf.service.sip.event.type.*;

import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import java.util.HashMap;
import java.util.Map;

public class EventFactory {
    private static final Map a;

    public static Event createEvent(MessageContext paramMessageContext) {
        if (paramMessageContext.isRequest()) return createEvent(paramMessageContext.getRequest());
        return
                createEvent(paramMessageContext.getResponse());
    }


    public static Event createEvent(SipServletRequest paramSipServletRequest) {
        String localObject = paramSipServletRequest.getMethod();

        if (("INVITE".equals(localObject)) && (!paramSipServletRequest.isInitial())) {
            localObject = "REINVITE";
        }


        return a( (Class) a.get(localObject), SipServletRequest.class, paramSipServletRequest);
    }

    public static Event createClientEvent(SipServletRequest paramSipServletRequest) {
        String localObject = paramSipServletRequest.getMethod();


        return a( (Class) a.get(localObject), SipServletRequest.class, paramSipServletRequest);
    }


    public static Event createEvent(SipServletResponse paramSipServletResponse) {
        int i;
        String localObject;

        switch (i = paramSipServletResponse.getStatus()) {


            case 100:
            case 180:
            case 200:
            case 202:
            case 486:
            case 487:
                localObject = String.valueOf(i);
                break;
            case 183:
                if (HeaderUtil.containsRequire100rel(paramSipServletResponse)) {
                    localObject = "183100rel";
                } else {
                    localObject = String.valueOf(i);
                }
                break;
            default:
                if (i < 200) {
                    localObject = "Provision";
                } else if (i < 300) {
                    localObject = "Success";
                } else if (i < 400) {
                    localObject = "Redirect";
                } else {
                    localObject = "Error";
                }


                break;
        }


        return  a( (Class) a.get(localObject), SipServletResponse.class, paramSipServletResponse);
    }


    private static Event a(Class paramClass1, Class paramClass2, Object paramObject) {
        if (paramClass1 == null) {
            return null;
        }

        Event localEvent = null;


        try {
            localEvent = (Event) ( paramClass1.getConstructor(new Class[]{paramClass2})).newInstance(new Object[]{paramObject});
        } catch (Exception localException) {
        }


        return localEvent;
    }

    static {
        (a = new HashMap()).put("INVITE",
                InviteEvent.class);
        a.put("REINVITE",
                ReInviteEvent.class);
        a.put("ACK",
                AckEvent.class);
        a.put("BYE",
                ByeEvent.class);
        a.put("CANCEL",
                CancelEvent.class);
        a.put("INFO",
                InfoEvent.class);
        a.put("MESSAGE",
                MessageEvent.class);
        a.put("PRACK",
                PrackEvent.class);
        a.put("UPDATE",
                UpdateEvent.class);
        a.put("PUBLISH",
                PublishEvent.class);
        a.put("REFER",
                ReferEvent.class);
        a.put("100",
                Response100Event.class);
        a.put("180",
                Response180Event.class);
        a.put("183",
                Response183Event.class);
        a.put("183100rel",
                Response183100RelEvent.class);
        a.put("200",
                Response200Event.class);
        a.put("202",
                Response202Event.class);
        a.put("408",
                Response408Event.class);
        a.put("486",
                Response486Event.class);
        a.put("487",
                Response487Event.class);
        a.put("Provision",
                ProvisionResponseEvent.class);
        a.put("Success",
                SuccessResponseEvent.class);
        a.put("Redirect",
                RedirectResponseEvent.class);
        a.put("Error",
                ErrorResponseEvent.class);
    }
}
