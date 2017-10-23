package com.git.wuqf.pushlet.core;

import com.git.wuqf.pushlet.util.PushletException;
import com.git.wuqf.pushlet.util.Log;
import com.git.wuqf.pushlet.util.Sys;

import java.io.File;
import java.util.Properties;


public class Config
        implements ConfigDefs {
    private static final String PROPERTIES_FILE = "com.git.wuqf.pushlet.properties";
    private static Properties properties;

    public static Object createObject(String aClassNameProp, String aDefault)
            throws PushletException {
        Class clazz = getClass(aClassNameProp, aDefault);
        try {
            return clazz.newInstance();
        } catch (Throwable t) {
            throw new PushletException("Cannot instantiate class for " + aClassNameProp + "=" + clazz, t);
        }
    }


    public static Class getClass(String aClassNameProp, String aDefault)
            throws PushletException {
        String clazz = aDefault == null ? getProperty(aClassNameProp) : getProperty(aClassNameProp, aDefault);
        try {
            return Class.forName(clazz);
        } catch (ClassNotFoundException t) {
            throw new PushletException("Cannot find class for " + aClassNameProp + "=" + clazz, t);
        }
    }


    public static void load(String aDirPath) {
        try {
            Log.info("Config: loading com.git.wuqf.pushlet.properties from classpath");
            properties = Sys.loadPropertiesResource("com.git.wuqf.pushlet.properties");
        } catch (Throwable t) {
            String filePath = aDirPath + File.separator + "com.git.wuqf.pushlet.properties";
            Log.info("Config: cannot load com.git.wuqf.pushlet.properties from classpath, will try from " + filePath);
            try {
                properties = Sys.loadPropertiesFile(filePath);
            } catch (Throwable t2) {
                Log.fatal("Config: cannot load properties file from " + filePath, t);


                return;
            }
        }

        Log.info("Config: loaded values=" + properties);
    }

    public static String getProperty(String aName, String aDefault) {
        return properties.getProperty(aName, aDefault);
    }

    public static String getProperty(String aName) {
        String value = properties.getProperty(aName);
        if (value == null) {
            throw new IllegalArgumentException("Unknown property: " + aName);
        }
        return value;
    }

    public static boolean getBoolProperty(String aName) {
        String value = getProperty(aName);
        try {
            return value.equals("true");
        } catch (Throwable t) {
            throw new IllegalArgumentException("Illegal property value: " + aName + " val=" + value);
        }
    }

    public static int getIntProperty(String aName) {
        String value = getProperty(aName);
        try {
            return Integer.parseInt(value);
        } catch (Throwable t) {
            throw new IllegalArgumentException("Illegal property value: " + aName + " val=" + value);
        }
    }

    public static long getLongProperty(String aName) {
        String value = getProperty(aName);
        try {
            return Long.parseLong(value);
        } catch (Throwable t) {
            throw new IllegalArgumentException("Illegal property value: " + aName + " val=" + value);
        }
    }

    public static boolean hasProperty(String aName) {
        return properties.containsKey(aName);
    }
}


