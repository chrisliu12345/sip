package cn.com.fri.axy.sip.util;

import java.util.Properties;

public class Config {
    public static final String DEF_COMMON_PARA = "sip_config.properties";
    /*  9 */   private static Config a = null;
    private static Properties b = new Properties();

    private Config() {
        this =
                getClass().getResourceAsStream("/sip_config.properties");


        try {
            b.load(this);
            return;

        } catch (Exception localException) {
            System.err.println(
                    "不能读取属性文件. 请确保sip_config.properties在CLASSPATH指定的路径中");
        }
    }


    public static synchronized Config getInstance() {
        if (a == null) {
            a = new Config();
        }
        return a;
    }


    public String getPara(String paramString) {
        return b.getProperty(paramString);
    }

    public static void main(String[] paramArrayOfString) {
        System.out.println("URL:" + getInstance().getPara("S_CSCF"));
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/Config.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */