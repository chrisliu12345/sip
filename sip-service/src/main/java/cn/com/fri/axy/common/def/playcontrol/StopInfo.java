package cn.com.fri.axy.common.def.playcontrol;


public class StopInfo
        extends Info {
    public String getInfoContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("TEARDOWN RTSP/1.0\n");
        sb.append("CSeq: " + Counter.getCount() + "\n");

        return toString();
    }

    public static void main(String[] paramArrayOfString) {
    }
}
