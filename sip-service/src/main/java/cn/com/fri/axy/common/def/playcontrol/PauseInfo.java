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
        (paramArrayOfString = new PauseInfo()).setPauseTime(100);
        System.out.println(paramArrayOfString.getInfoContent());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/playcontrol/PauseInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */