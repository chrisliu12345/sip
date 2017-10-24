package com.git.wuqf.service.sip.standarddebug.jsr289.udp;

import com.git.wuqf.service.comet.pushlet.MessageSender;
import com.git.wuqf.service.common.util.SysLogger;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPHelper {
    public static void sendUDPMessage(String paramString1, int paramInt, String paramString2) {
        try {
            SysLogger.info("\nsend message:\n" + paramString2);
            byte[] bytes = paramString2.getBytes();
            InetAddress ip = InetAddress.getByName(paramString1);
            new DatagramSocket().send(new DatagramPacket(bytes, bytes.length, paramInt));


            MessageSender.getInstance().send(paramString2);
            return;
        } catch (Exception localException) {
            Object localObject;
            SysLogger.printStackTrace( localException);
        }
    }

    public static void main(String[] paramArrayOfString) {
    }
}
