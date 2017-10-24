package com.git.wuqf.service.sip.util;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DEF_COMMON_PARA = "sip_config.properties";
    /*  9 */   private static Config a = null;
    private static Properties b = new Properties();

    private Config() {
       InputStream ip=getClass().getResourceAsStream("/sip_config.properties");


        try {
            b.load(ip);
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

