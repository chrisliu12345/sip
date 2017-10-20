package cn.com.fri.axy.common.util;

import java.io.*;
import java.util.HashMap;
import java.util.Set;


public class AxyProperties {
    private HashMap a = new HashMap();


    public void load(Reader paramReader) {
        BufferedReader localBufferedReader = new BufferedReader(paramReader);


        while ((paramReader = localBufferedReader.readLine()) != null) {
            if (paramReader.indexOf("#") != 0) {
                if ((paramReader = paramReader.split("=", 2)).length >= 2) {
                    this.a.put(paramReader[0].trim(), paramReader[1].trim());
                }
            }
        }
    }


    public String getProperty(String paramString) {
        return (String) this.a.get(paramString);
    }


    public Set propertyNames() {
        return this.a.keySet();
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = new File("PMPlatFormenv.properties");
        paramArrayOfString = new FileInputStream(paramArrayOfString);

        paramArrayOfString = new InputStreamReader(paramArrayOfString);
        AxyProperties localAxyProperties;
        (localAxyProperties = new AxyProperties()).load(paramArrayOfString);

        for (paramArrayOfString = localAxyProperties.propertyNames().iterator(); paramArrayOfString.hasNext(); ) {
            String str = (String) paramArrayOfString.next();
            System.out.println(str + "=" + localAxyProperties.getProperty(str));
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/util/AxyProperties.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */