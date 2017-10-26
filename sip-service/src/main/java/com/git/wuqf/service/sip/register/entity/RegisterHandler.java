package com.git.wuqf.service.sip.register.entity;


import com.git.wuqf.service.comet.pushlet.MessageSender;
import com.git.wuqf.service.common.Const;
import com.git.wuqf.service.common.util.DateUtil;
import com.git.wuqf.service.common.util.SysLogger;
import com.git.wuqf.service.sip.core.MessageContext;
import com.git.wuqf.service.sip.entity.Handler;
import com.git.wuqf.service.sip.location.LocationService;
import com.git.wuqf.service.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;
import com.git.wuqf.service.sip.register.security.wwwauthorizationheader.DigestWWWAuthorizationHeader;

import javax.servlet.sip.Address;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.TimeZone;

public class RegisterHandler extends Handler {
    private Long secturityValue;
    private String seed;
    private String deviceId;
    private CapabilityAuthorizationHeader capabilityAuthorizationHeader;

    public void doRegister(MessageContext messageContext) {
        try {
            SipServletRequest sipServletRequest = messageContext.getRequest();
            SysLogger.info("appSession id is " + messageContext.getApplicationSession().getId());

            Registration registration = new Registration(sipServletRequest);

            String authHeader = sipServletRequest.getHeader("Authorization".toUpperCase());

            SysLogger.info("isInitialRegister authorizationValue:" + (String) authHeader + "?");
            if (((authHeader != null) && ((authHeader).indexOf("Capability") <= -1) ? 0 : 1) != 0) {
                SysLogger.info(
                        getClass() + ":\n" + "is Initial request: " + ((SipServletRequest) sipServletRequest).getApplicationSession().getId());
                if (!LocationService.getInstance().isUAExist(registration.getDeviceID())) {
                    createResponse((SipServletRequest) sipServletRequest, 403, null, null);
                    return;
                }
                this.secturityValue = LocationService.getInstance()
                        .getSecurityLevel(registration.getDeviceID());
                SysLogger.info(getClass() + ":\nSecurityLevel:" +
                        this.secturityValue);
                if (this.secturityValue == null) {
                    this.secturityValue = Const.METHOD_OF_REGISTERWAY_SIP3261;
                }
                if (this.secturityValue.longValue() !=
                        Const.METHOD_OF_REGISTERWAY_SIP3261.longValue()) {
                    if (this.secturityValue.longValue() !=
                            Const.METHOD_OF_REGISTERWAY_DIGITALCERTIFICATE.longValue()) {
                        if (this.secturityValue.longValue() !=
                                Const.METHOD_OF_REGISTERWAY_PASSWORD.longValue()) {
                            this.secturityValue = Const.METHOD_OF_REGISTERWAY_SIP3261;
                        }
                    }
                }
                if ((registration.getAuthorizationHeader() != null) &&
                        ((registration.getAuthorizationHeader() instanceof CapabilityAuthorizationHeader))) {
                    this.capabilityAuthorizationHeader = ((CapabilityAuthorizationHeader)
                            registration.getAuthorizationHeader());
                }
                if (this.capabilityAuthorizationHeader == null) {
                    if (this.secturityValue.longValue() !=
                            Const.METHOD_OF_REGISTERWAY_SIP3261.longValue()) {
                        SysLogger.info(
                                getClass() + ":\ncapability is null and SIP3261 method not config in db.");
                        createResponse((SipServletRequest) sipServletRequest, 403, null, null);
                        return;
                    }
                    this.capabilityAuthorizationHeader = new CapabilityAuthorizationHeader();
                }
                this.seed = getSeed();
                this.deviceId = registration.getDeviceID();

                createResponse(sipServletRequest, 401, null, null);

                RegisterSecurityManager.getInstance().saveSecurityParam(this.deviceId, this.secturityValue, this.seed, this.capabilityAuthorizationHeader);

                return;
            }
            SysLogger.info(
                    getClass() + ":\n" + "is Second request: " + ((SipServletRequest) sipServletRequest).getApplicationSession().getId());

            SecurityBean securityBean = RegisterSecurityManager.getInstance().getSecurityParam(registration.getDeviceID());
            this.secturityValue = ((SecurityBean) securityBean).getSecurityLevel();
            this.seed = ((SecurityBean) securityBean).getSeed();
            this.deviceId = ((SecurityBean) securityBean).getDeviceID();
            this.capabilityAuthorizationHeader = ((SecurityBean) securityBean).getCapability();
            if ((registration.getAuthorizationHeader() == null) || (!registration.getAuthorizationHeader().validate(this.capabilityAuthorizationHeader, this.seed))) {
                createResponse((SipServletRequest) sipServletRequest, 403, null, null);
                return;
            }
            Registration rg = RegistrationService.getInstance().getByDeviceID(registration.getDeviceID());
            if (rg != null) {
                SysLogger.info(getClass() + "\noldR " + rg.getDeviceID() + " is not null.");
                if (!rg.getCallID().equals(registration.getCallID())) {
                    SysLogger.info(getClass() + "\noldR callid:\t" + rg.getCallID());
                    SysLogger.info(getClass() + "\nnewR callid:\t" + registration.getCallID());

                    RegistrationService.getInstance().deviceOffline(rg);

                    securityBean = null;
                } else {
                    SysLogger.info(getClass() + "\nregister in same callid");
                }
            } else {
                SysLogger.info(getClass() + "\noldR " + registration.getDeviceID() + " is null. online start.");
            }
            if (registration.getContacts().size() == 0) {
                SysLogger.info("REGISTER: no contacts. reply contact list");
                createResponse((SipServletRequest) sipServletRequest, 200, registration, null);
                return;
            }
            int i;
            if (messageContext.a()) {

                if ((rg.getContacts().size() > 1) || rg.getExpiration() > System.currentTimeMillis()) {
                    SysLogger.info(securityBean.getClass() + ":\n" + "REGISTER: illegal request. wildcard is used with other contacts," + " or expires != 0 is specified. aor=[" + ((Registration) authHeader).getUri() + "]");
                    i = 400;
                    sipServletRequest = this;
                    (messageContext = securityBean).a((SipServletRequest) sipServletRequest, i, null).send();
                    getApplicationSession().invalidate();
                    return;
                }
                if (((messageContext = RegistrationService.getInstance().removeByDeviceID(((Registration) authHeader).getDeviceID())) != null) && (messageContext.getCseq() > ((Registration) authHeader).getCseq())) {
                    RegistrationService.getInstance().save(messageContext);
                    return;
                }
                i.a(this, (Registration) authHeader);
                getApplicationSession().invalidate();
                return;
            }
            if ((i != null) && (i.getCseq() >= messageContext.getCseq())) {
                createResponse((SipServletRequest) sipServletRequest, 200, messageContext, null);
                return;
            }
            if (messageContext.getExpiration() <= System.currentTimeMillis()) {
                createResponse((SipServletRequest) sipServletRequest, 200, messageContext, null);
                if (i != null) {
                    SysLogger.info(
                            getClass() + ":\n" + messageContext.getDeviceID() + " off line normally");
                    RegistrationService.getInstance().deviceOffline(i);
                }
                return;
            }
            messageContext.setSeed(this.seed);

            messageContext.setSecurityLevel(this.secturityValue.intValue());
            if (i == null) {
                SysLogger.info(
                        getClass() + ":\n" + messageContext.getDeviceID() + " on line");
                RegistrationService.getInstance().deviceOnline(messageContext);
            } else {
                SysLogger.info(
                        getClass() + ":\n" + messageContext.getDeviceID() + " update");
                RegistrationService.getInstance().deviceUpdate(i, messageContext);
            }
            createResponse((SipServletRequest) sipServletRequest, 200, messageContext, null);
            return;
        } catch (Exception localException) {
            Object localObject1;
            SysLogger.printStackTrace( localException);
        }
    }

    private void createResponse(SipServletRequest sipServletRequest, int status, Registration registration, String paramString) throws IOException {
        if (status == 200) {
           createResponse(sipServletRequest, registration);
            SysLogger.info(
                    getClass() + ":SIPApplicationSession invalidate.");
            sipServletRequest.getApplicationSession().invalidate();
            return;
        }
        if (status == 401) {
            try {

                int i = 401;
                SipServletResponse response=sipServletRequest.createResponse(i);
                String ah = "WWW-Authenticate";
                String str;
                if (status == Const.METHOD_OF_REGISTERWAY_SIP3261.longValue()) {
                    str = new DigestWWWAuthorizationHeader(status.d, status.b, status.c).toString();
                } else {
                    SysLogger.info(status.getClass() + ":\n" + "imporper level " + status.a);
                    str = "";
                }
                sipServletRequest.addHeader(paramString, str);

                MessageSender.getInstance().send(status.toString());
                return;
            } catch (Exception localException) {
                createResponse(sipServletRequest, 500, null,
                        "interal error when genarate 401.");
                return;
            }
        }
        if ((status == 400) || (status > 401)) {
            try {
                (status = createResponse(sipServletRequest, status, paramString)).send();

                MessageSender.getInstance().send(status.toString());
            } catch (IOException localIOException2) {
                SysLogger.printStackTrace(status = localIOException2);
            }
            SysLogger.info(
                    getClass() + ":SIPApplicationSession invalidate.");
            sipServletRequest.getApplicationSession().invalidate();
            return;
        }
        SysLogger.info(getClass() + ":\ndonothing for code " + status);
    }

    private void createResponse(SipServletRequest sipServletRequest, Registration registration) throws IOException {
        int i = 200;

        SipServletResponse response = createResponse(sipServletRequest, i, null);
        Iterator it = registration.getContacts().iterator();
        for (; it.hasNext(); ) {
            Address address = (Address) it.next();

            sipServletRequest.addAddressHeader("Contact", address, false);
        }
        sipServletRequest.setExpires((int) (registration.getExpire() / 1000L));

        sipServletRequest.setHeader("Date", new DateUtil().XML_DateToString(new Date()));

        sipServletRequest
                .setHeader("TimeRevise",
                        new DateUtil().TGS_DateToString(new Date()));
        sipServletRequest.send();

        SysLogger.info(getClass() + ":\n" + "send message:\n" +
                sipServletRequest.toString());

        MessageSender.getInstance().send(sipServletRequest.toString());
    }

    private SipServletResponse createResponse(SipServletRequest sipServletRequest, int status, String reason) {
        SysLogger.info(
                getClass() + ":\n" + "send response " + status + " reason " + reason);
        SipServletResponse response = null;
        if (reason != null) {
            response = sipServletRequest.createResponse(status, reason);
        } else {
            response = sipServletRequest.createResponse(status);
        }
        return response;
    }

    public String getSeed() {
        int j = 0;

        char[] arrayOfChar =
                {'createResponse', 'b', 'c', 'd', 'e', 'f', '0', '1', '2', '3', '4', '5', '6', '7',
                        '8', '9'};

        StringBuffer localStringBuffer = new StringBuffer("");
        Random localRandom = new Random();
        while (j < 16) {
            int i = localRandom.nextInt(16);
            localStringBuffer.append(arrayOfChar[i]);
            j++;
        }
        SysLogger.info(getClass() + "\n" + "seed:" + localStringBuffer.toString());

        return localStringBuffer.toString();
    }

    public static void main(String[] paramArrayOfString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String str = dateFormat.format(new Date());
        System.out.println(str);
        try {
            Date time = dateFormat.parse(str);
            System.out.println(time);
            return;
        } catch (ParseException localParseException) {
            localParseException.printStackTrace();
        }
    }
}
