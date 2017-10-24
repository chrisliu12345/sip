package com.git.wuqf.service.common.util;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class AxyProperties {
    private HashMap a = new HashMap();


    public void load(Reader paramReader) throws IOException {
        BufferedReader localBufferedReader = new BufferedReader(paramReader);
        String line = localBufferedReader.readLine();

        while (line != null) {
            if (line.indexOf("#") != 0) {
                String[] contents = line.split("=", 2);
                if (contents.length >= 2) {
                    this.a.put(contents[0].trim(), contents[1].trim());
                }
            }
            line = localBufferedReader.readLine();
        }
    }


    public String getProperty(String paramString) {
        return (String) this.a.get(paramString);
    }


    public Set propertyNames() {
        return this.a.keySet();
    }


    public static void main(String[] paramArrayOfString) throws IOException {
        File file = new File("PMPlatFormenv.properties");
        InputStream ip = new FileInputStream(file);

        InputStreamReader ir = new InputStreamReader(ip);
        AxyProperties localAxyProperties = new AxyProperties();
        localAxyProperties.load(ir);

        Iterator iterator = localAxyProperties.propertyNames().iterator();

        for (; iterator.hasNext(); ) {
            String str = (String) iterator.next();
            System.out.println(str + "=" + localAxyProperties.getProperty(str));
        }
    }
}
