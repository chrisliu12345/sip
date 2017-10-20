package cn.com.fri.axy.common.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.Properties;


public class SysLogger {
    public static final String SPLIT_STR = " ,";
    private static Logger a = Logger.getLogger("");


    private static String b = "log4j.properties";


    static {
        try {
            Properties localProperties = new Properties();
            InputStream localInputStream =
                    SysLogger.class.getResourceAsStream("/" + b);
            localProperties.load(localInputStream);

            PropertyConfigurator.configure(localProperties);
            return;
        } catch (FileNotFoundException localFileNotFoundException) {
            System.out.println(
                    "FileLogger.java - FileNotFoundException : " + localFileNotFoundException.toString());
            return;
        } catch (IOException localIOException) {
            System.out.println(
                    "FileLogger.java - IOException : " + localIOException.toString());
            return;
        } catch (Exception localException) {
            System.out.println("FileLogger.java - Exception : " + localException.toString());
            localException.printStackTrace();
        }
    }


    public static void debug(Object paramObject) {
        a.debug("\n" + paramObject + "\n");
    }


    public static void info(Object paramObject) {
        a.info("\n" + paramObject + "\n");
    }


    public static void warn(Object paramObject) {
        a.warn("\n" + paramObject + "\n");
    }


    public static void error(Object paramObject) {
        a.error("\n" + paramObject + "\n");
    }


    public static void fatal(Object paramObject) {
        a.fatal("\n" + paramObject + "\n");
    }


    public static void printStackTrace(Throwable paramThrowable) {
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
        String str1 =
                "   ==== Begin Stack Trace for the Exception  ==== \n";
        String str2 =
                "\n =============  End of Stack Trace  =========== \n";
        int i = a.getEffectiveLevel().toInt();


        try {
            paramThrowable.printStackTrace(localPrintWriter);
            paramThrowable = str1 + localStringWriter.toString() + str2;

            switch (i) {
                case 10000:
                    debug(paramThrowable);
                    break;
                case 20000:
                    info(paramThrowable);
                    break;
                case 40000:
                    error(paramThrowable);
                    break;
                case 50000:
                    fatal(paramThrowable);
                    break;
                case -2147483648:
                    debug(paramThrowable);
                    break;
                default:
                    debug(paramThrowable);
            }

            localStringWriter.close();
            localPrintWriter.close();
            return;
        } catch (Exception localException) {
            debug((paramThrowable = localException).toString());
        }
    }


    public static void main(String[] paramArrayOfString) {
        debug("Here is some DEBUG,调试信息");

        info("Here is some INFO，信息提示");

        warn("Here is some WARN，警告信息");


        error(
                SysLogger.class +
                        ".方法名" +
                        " ," +
                        "接收到的参数" +
                        " ," +
                        "具体错误信息");

        fatal(SysLogger.class);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/util/SysLogger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */