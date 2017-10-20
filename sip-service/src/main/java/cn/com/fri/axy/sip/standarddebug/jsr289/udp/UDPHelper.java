package cn.com.fri.axy.sip.standarddebug.jsr289.udp;

import cn.com.fri.axy.comet.pushlet.MessageSender;
import cn.com.fri.axy.common.util.SysLogger;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPHelper {
    public static void sendUDPMessage(String paramString1, int paramInt, String paramString2) {
        try {
            SysLogger.info("\nsend message:\n" + paramString2);
            localObject = paramString2.getBytes();
            paramString1 = InetAddress.getByName(paramString1);
            new DatagramSocket().send(new DatagramPacket((byte[]) localObject, localObject.length, paramString1, paramInt));


            MessageSender.getInstance().send(paramString2);
            return;
        } catch (Exception localException) {
            Object localObject;
            SysLogger.printStackTrace(localObject = localException);
        }
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/standarddebug/jsr289/udp/UDPHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */