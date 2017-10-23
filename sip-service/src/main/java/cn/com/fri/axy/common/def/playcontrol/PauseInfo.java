package cn.com.fri.axy.common.def.playcontrol;

public class PauseInfo
        extends Info {
    private String a;

    public String getInfoContent() {
        StringBuffer localStringBuffer;
        (localStringBuffer = new StringBuffer()).append("PAUSE RTSP/1.0\n");
        localStringBuffer.append("CSeq: " + Counter.getCount() + "\n");
        if ((this.a != null) && (this.a.length() != 0)) {
            localStringBuffer.append("PauseTime: " + this.a + "\n");
        }

        return localStringBuffer.toString();
    }


    public void setPauseTime(int paramInt) {
        this.a = Integer.toString(paramInt);
    }


    public static void main(String[] paramArrayOfString) {
        PauseInfo  s = new PauseInfo();
        s.setPauseTime(100);
        System.out.println(s.getInfoContent());
    }
}

