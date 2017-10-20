package cn.com.fri.axy.sip.message.batchreboot;


public class BatchReboot$DeviceBean {
    public String deviceID;


    public String ip;


    public int port;


    public BatchReboot$DeviceBean(BatchReboot paramBatchReboot) {
    }


    public String getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(String paramString) {
        this.deviceID = paramString;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String paramString) {
        this.ip = paramString;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int paramInt) {
        this.port = paramInt;
    }

    public String toString() {
        return

                "deviceID\t" + this.deviceID + "\n" + "ip\t" + this.ip + "\n" + "port\t" + this.port + "\n";
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/message/batchreboot/BatchReboot$DeviceBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */