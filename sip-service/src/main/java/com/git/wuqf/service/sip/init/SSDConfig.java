package com.git.wuqf.service.sip.init;

import com.git.wuqf.service.common.util.DateUtil;
import com.git.wuqf.service.common.util.SysLogger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;


public class SSDConfig {
    public static final String DEF_COMMON_PARA = "SSDConfig.properties";
    private static SSDConfig a = null;
    private static Properties b = new Properties();

    private SSDConfig() {
        try {
            InputStream io = SysLogger.class.getResourceAsStream("/SSDConfig.properties");
            b.load(io);


            for (Iterator localIterator = b.keySet().iterator(); localIterator.hasNext(); ) {
                localIterator.next();

                SysLogger.info(this + ":\t" + b.get(this));
            }
            return;

        } catch (FileNotFoundException e) {

            System.out.println(
                    "FileLogger.java - FileNotFoundException : " + toString());
            return;
        } catch (IOException e) {
            System.out.println(
                    "FileLogger.java - IOException : " + toString());
            return;
        } catch (Exception e) {
            System.out.println("FileLogger.java - Exception : " + toString());
            e.printStackTrace();
        }
    }


    public static synchronized SSDConfig getInstance() {
        if (a == null) {
            a = new SSDConfig();
        }
        return a;
    }


    public String getDomainName() {
        return b.getProperty("sipserver_domainname");
    }

    public String getSipServerID() {
        return b.getProperty("sipserver_id");
    }

    public String getDVRID() {
        return b.getProperty("sipdevice_DVR_id");
    }

    public String getDVRPassword() {
        return b.getProperty("sipdevice_DVR_password");
    }


    public Vector getDVRCameraID() {
        Vector v = new Vector();

        Object localObject;
        String[] arrayOfString = b.getProperty("sipdevice_DVR_camera_id").split(",");
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
            localObject = arrayOfString[i];

            v.add(localObject);
        }

        return v;
    }


    public Vector getDVRAlarmID() {
        Vector v = new Vector();

        Object localObject;
        String[] arrayOfString = b.getProperty("sipdevice_DVR_alarm_id").split(",");
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
            localObject = arrayOfString[i];

            v.add(localObject);
        }

        return v;
    }


    public String getIPCID() {
        return b.getProperty("sipdevice_IPC_id");
    }

    public String getIPCPassword() {
        return b.getProperty("sipdevice_IPC_password");
    }


    public Vector getIPCAlarmID() {
        Vector v = new Vector();

        Object localObject;
        String[] arrayOfString = b.getProperty("sipdevice_IPC_alarm_id").split(",");

        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
            localObject = arrayOfString[i];

            v.add(localObject);
        }

        return v;
    }


    public String getDecoderID() {
        return b.getProperty("sipdevice_decoder_id");
    }

    public String getDecoderPassword() {
        return b.getProperty("sipdevice_decoder_password");
    }


    public Vector getDecoderMonitorID() {
        Vector v = new Vector();

        Object localObject;
        String[] arrayOfString = b.getProperty("sipdevice_decoder_monitor_id").split(",");
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
            localObject = arrayOfString[i];

            v.add(localObject);
        }

        return v;
    }


    public String getOtherSystemID() {
        return b.getProperty("sipdevice_othersystem_id");
    }

    public String getOtherSystemCameraDeviceID() {
        return b.getProperty("sipdevice_othersystem_camera_id");
    }

    public String getOtherSystemAlarmDeviceID() {
        return b.getProperty("sipdevice_othersystem_alarm_id");
    }

    public String getOtherSystemIP() {
        return b.getProperty("sipdevice_othersystem_ip");
    }

    public String getOtherSystemPort() {
        return b.getProperty("sipdevice_othersystem_port");
    }

    public String getSipDevicePassword(String paramString) {
        paramString = getParentDeviceID(paramString);
        if (getDVRID().equalsIgnoreCase(paramString)) {
            return getDVRPassword();
        }
        if (getIPCID().equalsIgnoreCase(paramString)) {
            return getIPCPassword();
        }
        if (getDecoderID().equalsIgnoreCase(paramString)) {
            return getDecoderPassword();
        }


        return getDVRPassword();
    }


    public String getParentDeviceID(String paramString) {
        if ((getDVRID().equalsIgnoreCase(paramString)) || (getDVRCameraID().contains(paramString)) ||
                (getDVRAlarmID().contains(paramString))) {
            return getDVRID();
        }
        if ((getIPCID().equalsIgnoreCase(paramString)) || (getIPCAlarmID().contains(paramString))) {
            return getIPCID();
        }
        if ((getDecoderID().equalsIgnoreCase(paramString)) || (getDecoderMonitorID().contains(paramString))) {
            return getDecoderID();
        }


        return paramString;
    }


    public Vector getAllDeviceID() {
        Vector localVector;


        (localVector = new Vector()).add(getDVRID());
        localVector.addAll(getDVRCameraID());
        localVector.addAll(getDVRAlarmID());
        localVector.add(getIPCID());
        localVector.addAll(getIPCAlarmID());
        localVector.add(getDecoderID());
        localVector.addAll(getDecoderMonitorID());
        localVector.add(getOtherSystemID());
        localVector.add(getOtherSystemCameraDeviceID());
        localVector.add(getOtherSystemAlarmDeviceID());

        return localVector;
    }


    public Long getSipDeviceRegisterWay() {
        return new Long(0L);
    }

    public String getMediaDestID() {
        return b.getProperty("media_dest_id");
    }

    public String getMediaDestIP() {
        return b.getProperty("media_dest_ip");
    }

    public String getMediaDestPort() {
        return b.getProperty("media_dest_port");
    }

    public String getHistoryTime() {
        String s = b.getProperty("history_starttime");
        Date a = DateUtil.getInstance().TGS_StringToDate(s);
        Object localObject = b.getProperty("history_endtime");
        localObject = DateUtil.getInstance().TGS_StringToDate((String) localObject);

        return a.getTime() / 1000L + " " + ((Date) localObject).getTime() / 1000L;
    }


    public String getFilequeryStarttime() {
        return b.getProperty("filequery_starttime");
    }

    public String getFilequeryEndtime() {
        return b.getProperty("filequery_endtime");
    }

    public static void main(String[] paramArrayOfString) {
        getInstance();
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/init/SSDConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */