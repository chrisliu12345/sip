package cn.com.fri.axy.sip.util.purview;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.core.MessageContext;


public class PurviewHelper {
    private static PurviewHelper a = new PurviewHelper();

    public static PurviewHelper getInstance() {
        return a;
    }


    public PurviewBean getPurviewBeanFromParam(String paramString1, String paramString2, String paramString3, String paramString4) {
        (this = new PurviewBean()).setUser(paramString1);
        setUsergroup(paramString2);
        setDeviceid(paramString3);
        setOperation(paramString4);
        return this;
    }


    public PurviewBean getPurviewBeanFromParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        (this = new PurviewBean()).setUser(paramString1);
        setUsergroup(paramString2);
        setDeviceid(paramString3);
        setOperation(paramString4);
        setExtparam(paramString5);
        return this;
    }


    public PurviewBean getPurviewBeanFromMsg(MessageContext paramMessageContext) {
        PurviewBean localPurviewBean = new PurviewBean();


        if (((paramMessageContext = paramMessageContext.getHeader("Monitor-User-Identity")) == null) || (paramMessageContext.length() == 0)) {
            return localPurviewBean;
        }

        try {
            String[] arrayOfString;
            int j = (arrayOfString = paramMessageContext = paramMessageContext.split(",")).length;
            for (int i = 0; i < j; i++) {

                if ((paramMessageContext = (paramMessageContext = arrayOfString[i]).split("="))[0].equalsIgnoreCase("user")) {
                    localPurviewBean.setUser(paramMessageContext[1]);
                } else if (paramMessageContext[0].equalsIgnoreCase("usergroup")) {
                    localPurviewBean.setUsergroup(paramMessageContext[1]);
                } else if (paramMessageContext[0].equalsIgnoreCase("deviceid")) {
                    localPurviewBean.setDeviceid(paramMessageContext[1]);
                } else if (paramMessageContext[0].equalsIgnoreCase("operation")) {
                    localPurviewBean.setOperation(paramMessageContext[1]);
                } else if (paramMessageContext[0].equalsIgnoreCase("extparam")) {
                    localPurviewBean.setExtparam(paramMessageContext[1]);
                } else {
                    SysLogger.info(getClass() + "\n" + "wrong name_value");
                }
            }
        } catch (Exception localException) {
            SysLogger.printStackTrace(paramMessageContext = localException);
        }

        return localPurviewBean;
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/purview/PurviewHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */