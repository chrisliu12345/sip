package cn.com.fri.axy.common.def.message.batchmessage;

import cn.com.fri.axy.common.def.message.content.configdownload.CameraVideoParamConfigDownloadResponse;
import cn.com.fri.axy.common.def.message.content.configdownload.ConfigDownloadRequest;
import cn.com.fri.axy.common.def.notify.NotifyObject;
import cn.com.fri.axy.common.util.DateUtil;
import cn.com.fri.axy.common.util.SysLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;


public class ConfigDownloadObserver
        implements Observer {
    public static final String CONFIG_DIR_NAME = "configupload";

    public void update(Observable paramObservable, Object paramObject) {
        this = ((NotifyObject) paramObject).getRequset();
        paramObservable = ((NotifyObject) paramObject).getResponse();

        int i;
        if (((i = ((NotifyObject) paramObject).getCode()) == 212) && ((this instanceof ConfigDownloadRequest)) &&
                (paramObservable != null)) {
            SysLogger.info(((NotifyObject) paramObject).getResponse().toString());
            paramObject = ((ConfigDownloadRequest) this).getDeviceID();
            Object localObject = ((ConfigDownloadRequest) this).getSEQ();
            this = ((ConfigDownloadRequest) this).getConfigType();
            String str = System.getProperty("file.separator");
            paramObject = System.getProperty("user.home") + str + "configupload" + str + (String) paramObject;
            this = this + "_" + (String) localObject;


            if (!(localObject = new File((String) paramObject)).exists()) {
                ((File) localObject).mkdirs();
            }


            if (!(this = new File((String) paramObject, this)).exists()) {
                try {
                    createNewFile();

                } catch (IOException localIOException1) {
                    SysLogger.printStackTrace(this = localIOException1);
                    return;
                }
            }

            try {
                this = new FileWriter(this, true);
                paramObject = DateUtil.getInstance().TGS_DateToString(new Date());
                paramObservable = "\n" + (String) paramObject + "\n" + paramObservable.toString();
                write(paramObservable);
                flush();
                close();
                return;

            } catch (IOException localIOException2) {
                SysLogger.printStackTrace(this = localIOException2);
                return;
            }
        }


        SysLogger.info("config upload write file failure.");
    }


    public static void main(String[] paramArrayOfString) {
        paramArrayOfString = new ConfigDownloadRequest("test", null, "VideoParam");

        Object localObject = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><VideoParam><VideoFormat>视频编码格式</VideoFormat><Resolution>分辨率</Resolution><FrameRate>帧率</FrameRate><BitRateType>码率类型</BitRateType><VideoBitRate>码率</VideoBitRate><AudioFormat>音频编码格式</AudioFormat><AudioBitRate>码率</AudioBitRate><AudioSampleRate>采样率</AudioSampleRate></VideoParam></Response>";


        CameraVideoParamConfigDownloadResponse localCameraVideoParamConfigDownloadResponse;


        (localCameraVideoParamConfigDownloadResponse = new CameraVideoParamConfigDownloadResponse("")).setXmlContent((String) localObject);
        localCameraVideoParamConfigDownloadResponse.genParameters();

        (
                localObject = new NotifyObject()).setCode(212);
        ((NotifyObject) localObject).setRequset(paramArrayOfString);
        ((NotifyObject) localObject).setResponse(localCameraVideoParamConfigDownloadResponse);

        (
                paramArrayOfString = new ConfigDownloadObserver()).update(null, localObject);
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/batchmessage/ConfigDownloadObserver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */