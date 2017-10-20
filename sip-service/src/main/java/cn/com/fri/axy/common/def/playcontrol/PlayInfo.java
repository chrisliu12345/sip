package cn.com.fri.axy.common.def.playcontrol;

public class PlayInfo
        extends Info {
    private float a = 0.0F;
    private String b = "0";


    private String c;


    public String getInfoContent() {
        StringBuffer localStringBuffer;


        (localStringBuffer = new StringBuffer()).append("PLAY RTSP/1.0\n");
        localStringBuffer.append("CSeq: " + Counter.getCount() + "\n");
        if (this.a > 0.0F) {
            localStringBuffer.append("Scale: " + this.a + "\n");
        }
        localStringBuffer.append("Range: npt=");
        if ((this.b != null) && (this.b.length() != 0)) {
            localStringBuffer.append(this.b);
        }
        localStringBuffer.append("-");
        if ((this.c != null) && (this.c.length() != 0)) {
            localStringBuffer.append(this.c);
        }
        localStringBuffer.append("\n");

        return localStringBuffer.toString();
    }


    public static void main(String[] paramArrayOfString) {
        (paramArrayOfString = new PlayInfo()).setScale(0.5F);
        paramArrayOfString.setStartRange(100);
        paramArrayOfString.setStopRange(200);
        System.out.println(paramArrayOfString.getInfoContent());
    }

    public void setScale(float paramFloat) {
        this.a = paramFloat;
    }

    public void setStartRange(int paramInt) {
        this.b = Integer.toString(paramInt);
    }

    public void setStopRange(int paramInt) {
        this.c = Integer.toString(paramInt);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/playcontrol/PlayInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */