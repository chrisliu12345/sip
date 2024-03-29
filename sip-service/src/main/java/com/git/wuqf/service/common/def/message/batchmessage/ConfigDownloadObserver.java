package com.git.wuqf.service.common.def.message.batchmessage;

import com.git.wuqf.service.common.def.message.content.configdownload.CameraVideoParamConfigDownloadResponse;
import com.git.wuqf.service.common.def.message.content.configdownload.ConfigDownloadRequest;
import com.git.wuqf.service.common.def.notify.NotifyObject;
import com.git.wuqf.service.common.util.SysLogger;

import java.util.Observable;
import java.util.Observer;


public class ConfigDownloadObserver
        implements Observer {
    public static final String CONFIG_DIR_NAME = "configupload";

    public void update(Observable paramObservable, Object paramObject) {
        ((NotifyObject) paramObject).getRequset();
        Object o = ((NotifyObject) paramObject).getResponse();

        int i;
        if (((i = ((NotifyObject) paramObject).getCode()) == 212) && ((o instanceof ConfigDownloadRequest)) &&
                (paramObservable != null)) {
            SysLogger.info(((NotifyObject) paramObject).getResponse().toString());
            paramObject = ((ConfigDownloadRequest) o).getDeviceID();
            Object localObject = ((ConfigDownloadRequest) o).getSEQ();
            ((ConfigDownloadRequest) o).getConfigType();
            String str = System.getProperty("file.separator");
            paramObject = System.getProperty("user.home") + str + "configupload" + str + (String) paramObject;


//            if (!(localObject = new File((String) o)).exists()) {
//                ((File) localObject).mkdirs();
//            }

//
//            if (!( new File((String) paramObject, this)).exists()) {
//                try {
//                    createNewFile();
//
//                } catch (IOException localIOException1) {
//                    SysLogger.printStackTrace( localIOException1);
//                    return;
//                }
//            }
//
//            try {
//                 new FileWriter(this, true);
//                paramObject = DateUtil.getInstance().TGS_DateToString(new Date());
//                paramObservable = "\n" + (String) paramObject + "\n" + paramObservable.toString();
//                write(paramObservable);
//                flush();
//                close();
//                return;
//
//            } catch (IOException localIOException2) {
//                SysLogger.printStackTrace( localIOException2);
//                return;
//            }
        }


        SysLogger.info("config upload write file failure.");
    }


    public static void main(String[] paramArrayOfString) {
        ConfigDownloadRequest c = new ConfigDownloadRequest("test", null, "VideoParam");

        Object localObject = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>编码器ID </DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><VideoParam><VideoFormat>视频编码格式</VideoFormat><Resolution>分辨率</Resolution><FrameRate>帧率</FrameRate><BitRateType>码率类型</BitRateType><VideoBitRate>码率</VideoBitRate><AudioFormat>音频编码格式</AudioFormat><AudioBitRate>码率</AudioBitRate><AudioSampleRate>采样率</AudioSampleRate></VideoParam></Response>";

        CameraVideoParamConfigDownloadResponse localCameraVideoParamConfigDownloadResponse;

        (localCameraVideoParamConfigDownloadResponse = new CameraVideoParamConfigDownloadResponse("")).setXmlContent((String) localObject);
        localCameraVideoParamConfigDownloadResponse.genParameters();


        NotifyObject o = new NotifyObject();
        o.setCode(212);
        o.setRequset(paramArrayOfString);
        o.setResponse(localCameraVideoParamConfigDownloadResponse);

//        ConfigDownloadObserver ggg = new ConfigDownloadRequest();
//        ggg.update(null, localObject);
    }
}
