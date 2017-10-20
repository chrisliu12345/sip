package cn.com.fri.axy.sip.register.entity;

import cn.com.fri.axy.comet.pushlet.MessageSender;
import cn.com.fri.axy.common.Const;
import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.MessageContext;
import cn.com.fri.axy.sip.entity.Handler;
import cn.com.fri.axy.sip.location.LocationService;
import cn.com.fri.axy.sip.register.security.authorizationheader.CapabilityAuthorizationHeader;
import cn.com.fri.axy.sip.register.security.wwwauthorizationheader.DigestWWWAuthorizationHeader;

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


public class RegisterHandler
        extends Handler {
    private Long a;
    private String b;
    private String c;
    private CapabilityAuthorizationHeader d;

    public void doRegister(MessageContext paramMessageContext) {
        try {
            localObject1 = paramMessageContext.getRequest();
            SysLogger.info("appSession id is " + paramMessageContext.getApplicationSession().getId());


            paramMessageContext = new Registration((SipServletRequest) localObject1);


            Object localObject3 = (localObject2 = localObject1).getHeader("Authorization".toUpperCase());
            SysLogger.info("isInitialRegister authorizationValue:" + (String) localObject3 + "?");
            if (((localObject3 != null) && (((String) localObject3).indexOf("Capability") <= -1) ? 0 : 1) != 0) {
                SysLogger.info(
                        getClass() + ":\n" + "is Initial request: " + ((SipServletRequest) localObject1).getApplicationSession().getId());


                if (!LocationService.getInstance().isUAExist(paramMessageContext.getDeviceID())) {
                    a((SipServletRequest) localObject1, 403, null, null);
                    return;
                }


                this.a = LocationService.getInstance()
                        .getSecurityLevel(paramMessageContext.getDeviceID());
                SysLogger.info(getClass() + ":\nSecurityLevel:" +
                        this.a);

                if (this.a == null) {
                    this.a = Const.METHOD_OF_REGISTERWAY_SIP3261;
                }
                if (this.a.longValue() !=
                        Const.METHOD_OF_REGISTERWAY_SIP3261.longValue()) {
                    if (this.a.longValue() !=
                            Const.METHOD_OF_REGISTERWAY_DIGITALCERTIFICATE.longValue()) {
                        if (this.a.longValue() !=
                                Const.METHOD_OF_REGISTERWAY_PASSWORD.longValue()) {
                            this.a = Const.METHOD_OF_REGISTERWAY_SIP3261;
                        }
                    }
                }

                if ((paramMessageContext.getAuthorizationHeader() != null) &&
                        ((paramMessageContext.getAuthorizationHeader() instanceof CapabilityAuthorizationHeader))) {
                    this.d = ((CapabilityAuthorizationHeader)
                            paramMessageContext.getAuthorizationHeader());
                }


                if (this.d == null) {
                    if (this.a.longValue() !=
                            Const.METHOD_OF_REGISTERWAY_SIP3261.longValue()) {

                        SysLogger.info(
                                getClass() + ":\ncapability is null and SIP3261 method not config in db.");
                        a((SipServletRequest) localObject1, 403, null, null);
                        return;
                    }

                    this.d = new CapabilityAuthorizationHeader();
                }


                this.b = getSeed();
                this.c = paramMessageContext.getDeviceID();

                a((SipServletRequest) localObject1, 401, null, null);

                RegisterSecurityManager.getInstance().saveSecurityParam(this.c, this.a, this.b, this.d);

                return;
            }


            SysLogger.info(
                    getClass() + ":\n" + "is Second request: " + ((SipServletRequest) localObject1).getApplicationSession().getId());

            Object localObject2 = RegisterSecurityManager.getInstance().getSecurityParam(paramMessageContext.getDeviceID());
            this.a = ((SecurityBean) localObject2).getSecurityLevel();
            this.b = ((SecurityBean) localObject2).getSeed();
            this.c = ((SecurityBean) localObject2).getDeviceID();
            this.d = ((SecurityBean) localObject2).getCapability();


            if ((paramMessageContext.getAuthorizationHeader() == null) || (!paramMessageContext.getAuthorizationHeader().validate(this.d, this.b))) {
                a((SipServletRequest) localObject1, 403, null, null);
                return;
            }


            if ((localObject2 = RegistrationService.getInstance().getByDeviceID(paramMessageContext.getDeviceID())) != null) {
                SysLogger.info(getClass() + "\noldR " + ((Registration) localObject2).getDeviceID() + " is not null.");
                if (!((Registration) localObject2).getCallID().equals(paramMessageContext.getCallID())) {

                    SysLogger.info(getClass() + "\noldR callid:\t" + ((Registration) localObject2).getCallID());
                    SysLogger.info(getClass() + "\nnewR callid:\t" + paramMessageContext.getCallID());


                    RegistrationService.getInstance().deviceOffline((Registration) localObject2);

                    localObject2 = null;
                } else {
                    SysLogger.info(getClass() + "\nregister in same callid");
                }
            } else {
                SysLogger.info(getClass() + "\noldR " + paramMessageContext.getDeviceID() + " is null. online start.");
            }


            if (paramMessageContext.getContacts().size() == 0) {
                SysLogger.info("REGISTER: no contacts. reply contact list");
                a((SipServletRequest) localObject1, 200, paramMessageContext, null);
                return;
            }

            int i;
            if (paramMessageContext.a()) {
                this = (RegisterHandler) localObject1;
                localObject3 = paramMessageContext;
                localObject2 = this;
                if ((((Registration) localObject3).getContacts().size() > 1) || (((Registration) localObject3).getExpiration() > System.currentTimeMillis())) {
                    SysLogger.info(localObject2.getClass() + ":\n" + "REGISTER: illegal request. wildcard is used with other contacts," + " or expires != 0 is specified. aor=[" + ((Registration) localObject3).getUri() + "]");
                    i = 400;
                    localObject1 = this;
                    (paramMessageContext = localObject2).a((SipServletRequest) localObject1, i, null).send();
                    getApplicationSession().invalidate();
                    return;
                }
                if (((paramMessageContext = RegistrationService.getInstance().removeByDeviceID(((Registration) localObject3).getDeviceID())) != null) && (paramMessageContext.getCseq() > ((Registration) localObject3).getCseq())) {
                    RegistrationService.getInstance().save(paramMessageContext);
                    return;
                }
                i.a(this, (Registration) localObject3);
                getApplicationSession().invalidate();
                return;
            }


            if ((i != null) && (i.getCseq() >= paramMessageContext.getCseq())) {
                a((SipServletRequest) localObject1, 200, paramMessageContext, null);
                return;
            }

            if (paramMessageContext.getExpiration() <= System.currentTimeMillis()) {
                a((SipServletRequest) localObject1, 200, paramMessageContext, null);


                if (i != null) {
                    SysLogger.info(
                            getClass() + ":\n" + paramMessageContext.getDeviceID() + " off line normally");
                    RegistrationService.getInstance().deviceOffline(i);
                }

                return;
            }

            paramMessageContext.setSeed(this.b);

            paramMessageContext.setSecurityLevel(this.a.intValue());

            if (i == null) {

                SysLogger.info(
                        getClass() + ":\n" + paramMessageContext.getDeviceID() + " on line");
                RegistrationService.getInstance().deviceOnline(paramMessageContext);
            } else {
                SysLogger.info(
                        getClass() + ":\n" + paramMessageContext.getDeviceID() + " update");
                RegistrationService.getInstance().deviceUpdate(i, paramMessageContext);
            }

            a((SipServletRequest) localObject1, 200, paramMessageContext, null);
            return;
        } catch (Exception localException) {
            Object localObject1;


            SysLogger.printStackTrace(localObject1 = localException);
        }
    }


    private void a(SipServletRequest paramSipServletRequest, int paramInt, Registration paramRegistration, String paramString) {
        if (paramInt == 200) {
            try {
                a(paramSipServletRequest, paramRegistration);
            } catch (IOException localIOException1) {
                SysLogger.printStackTrace(paramInt = localIOException1);
            }

            SysLogger.info(
                    getClass() + ":SIPApplicationSession invalidate.");
            paramSipServletRequest.getApplicationSession().invalidate();
            return;
        }
        if (paramInt == 401) {
            try {
                paramRegistration = paramSipServletRequest;
                paramInt = this;
                SysLogger.info(paramInt.getClass() + ":\n" + "level " + paramInt.a);
                int i = 401;
                paramString = paramRegistration;
                paramRegistration = (paramRegistration = paramInt).a(paramString, i, null);
                paramString = "WWW-Authenticate";
                String str;
                if (paramInt.a.longValue() == Const.METHOD_OF_REGISTERWAY_SIP3261.longValue()) {
                    str = new DigestWWWAuthorizationHeader(paramInt.d, paramInt.b, paramInt.c).toString();
                } else {
                    SysLogger.info(paramInt.getClass() + ":\n" + "imporper level " + paramInt.a);
                    str = "";
                }
                paramRegistration.addHeader(paramString, str);
                SysLogger.info(paramInt.getClass() + ":\n" + "401 response:\n" + paramRegistration.toString());
                (
                        paramInt = paramRegistration).send();


                MessageSender.getInstance().send(paramInt.toString());
                return;
            } catch (Exception localException) {
                a(paramSipServletRequest, 500, null,
                        "interal error when genarate 401.");
                return;
            }
        }
        if ((paramInt == 400) || (paramInt > 401)) {

            try {
                (paramInt = a(paramSipServletRequest, paramInt, paramString)).send();


                MessageSender.getInstance().send(paramInt.toString());
            } catch (IOException localIOException2) {
                SysLogger.printStackTrace(paramInt = localIOException2);
            }

            SysLogger.info(
                    getClass() + ":SIPApplicationSession invalidate.");
            paramSipServletRequest.getApplicationSession().invalidate();
            return;
        }


        SysLogger.info(getClass() + ":\ndonothing for code " + paramInt);
    }


    private void a(SipServletRequest paramSipServletRequest, Registration paramRegistration) {
        int i = 200;
        Object localObject = paramSipServletRequest;
        paramSipServletRequest = this;
        paramSipServletRequest = a((SipServletRequest) localObject, i, null);


        for (Iterator localIterator = (localObject = paramRegistration.getContacts()).iterator(); localIterator.hasNext(); ) {
            localObject = (Address) localIterator.next();

            paramSipServletRequest.addAddressHeader("Contact", (Address) localObject, false);
        }


        paramSipServletRequest.setExpires((int) (paramRegistration.getExpire() / 1000L));


        paramSipServletRequest.setHeader("Date", new DateUtil().XML_DateToString(new Date()));

        paramSipServletRequest
                .setHeader("TimeRevise",
                        new DateUtil().TGS_DateToString(new Date()));
        paramSipServletRequest.send();

        SysLogger.info(getClass() + ":\n" + "send message:\n" +
                paramSipServletRequest.toString());


        MessageSender.getInstance().send(paramSipServletRequest.toString());
    }


    private SipServletResponse a(SipServletRequest paramSipServletRequest, int paramInt, String paramString) {
        SysLogger.info(
                getClass() + ":\n" + "send response " + paramInt + " reason " + paramString);

        if (paramString != null) {
            this = paramSipServletRequest.createResponse(paramInt, paramString);
        } else {
            this = paramSipServletRequest.createResponse(paramInt);
        }


        if ((paramSipServletRequest = paramSipServletRequest.getHeader("Event")) != null) {
            setHeader("Event", paramSipServletRequest);
        }
        return this;
    }


    public String getSeed() {
        int j = 0;


        char[] arrayOfChar =
                {'a', 'b', 'c', 'd', 'e', 'f', '0', '1', '2', '3', '4', '5', '6', '7',
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
        (paramArrayOfString = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z")).setTimeZone(TimeZone.getTimeZone("GMT"));
        String str = paramArrayOfString.format(new Date());
        System.out.println(str);

        try {
            paramArrayOfString = paramArrayOfString.parse(str);
            System.out.println(paramArrayOfString);
            return;
        } catch (ParseException localParseException) {
            (paramArrayOfString = localParseException).printStackTrace();
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/register/entity/RegisterHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */