package cn.com.fri.axy.sip.script;

import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.script.invite.ScriptInviteHandler;

import java.util.Observer;


public class RealTimeCallBean
        extends CallBean {
    public String sourceID;
    public int resolution;
    public String destID;
    public int wID;
    public Observer o;

    public String toString() {
        return


                "startinterval\t" + this.startinterval + "\n" + "stopinterval\t" + this.stopinterval + "\n" + "linkageID\t" + this.linkageID + "\n" + "sourceID\t" + this.sourceID + "\n" + "resolution\t" + this.resolution + "\n" + "destID\t" + this.destID + "\n" + "wID\t" + this.wID + "\n" + "o\t" + this.o + "\n";
    }


    public String startLink() {
        try {
            return new ScriptInviteHandler().sendInvite(this.sourceID, this.resolution, this.destID, this.wID);
        } catch (Exception localException) {
            SysLogger.printStackTrace(this = localException);
        }
        return null;
    }


    public String getSourceID() {
        return this.sourceID;
    }

    public void setSourceID(String paramString) {
        this.sourceID = paramString;
    }

    public int getResolution() {
        return this.resolution;
    }

    public void setResolution(int paramInt) {
        this.resolution = paramInt;
    }

    public String getDestID() {
        return this.destID;
    }

    public void setDestID(String paramString) {
        this.destID = paramString;
    }

    public int getWID() {
        return this.wID;
    }

    public void setWID(int paramInt) {
        this.wID = paramInt;
    }

    public Observer getO() {
        return this.o;
    }

    public void setO(Observer paramObserver) {
        this.o = paramObserver;
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/script/RealTimeCallBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */