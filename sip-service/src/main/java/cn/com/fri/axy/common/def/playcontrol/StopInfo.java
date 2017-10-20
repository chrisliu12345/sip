package cn.com.fri.axy.common.def.playcontrol;


public class StopInfo
        extends Info {
    public String getInfoContent() {
        (this = new StringBuffer()).append("TEARDOWN RTSP/1.0\n");
        append("CSeq: " + Counter.getCount() + "\n");

        return toString();
    }

    public static void main(String[] paramArrayOfString) {
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/playcontrol/StopInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */