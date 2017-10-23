package cn.com.fri.axy.common.def.message.content.configdownload;

import java.util.Iterator;
import java.util.Vector;


public class OndutyTimeBean {
    public static final int OndutyTimeType_Day = 1;
    public static final int OndutyTimeType_Week = 2;
    public static final int OndutyTimeType_Month = 3;
    public static final int OndutyTimeType_SpecialDate = 4;
    private int a;
    private String b;
    private String c;
    private Vector d;

    public String toString() {
        StringBuilder localStringBuilder;
        (localStringBuilder = new StringBuilder()).append("OndutyTimeType\t" + this.a + "\n");
        localStringBuilder.append("Seq\t" + this.b + "\n");
        localStringBuilder.append("Time\t" + this.c + "\n");
        for (Iterator localIterator = this.d.iterator(); localIterator.hasNext(); ) {
            localIterator.next();

            localStringBuilder.append(toString());
        }

        return localStringBuilder.toString();
    }


    public static OndutyTimeBean newInstance(String paramString) {
        OndutyTimeBean localOndutyTimeBean;


//        Object localObject1 = paramString;
//        localOndutyTimeBean = new OndutyTimeBean();
//        if (((String) localObject1).indexOf("<Day>") > -1) paramString.a = 1;
//        else if (((String) localObject1).indexOf("<Week>") > -1) paramString.a = 2;
//        else if (((String) localObject1).indexOf("<Month>") > -1) paramString.a = 3;
//        else if (((String) localObject1).indexOf("<SpecialDate>") > -1) paramString.a = 4;
//        else throw new AssertionError();
//        localObject1 = ((String) localObject1).substring(((String) localObject1).indexOf("<Seq Num=\""), ((String) localObject1).indexOf("</Seq>"));
//        paramString.b = ((String) localObject1).substring(((String) localObject1).indexOf("<Seq Num=\"") + "<Seq Num=\"".length(), ((String) localObject1).indexOf("\">"));
//        String str = ((String) localObject1).substring(((String) localObject1).indexOf("\">") + "\">".length());
//        if (((String) localObject1).indexOf("<Time") > -1) if (paramString.a == 4)
//            paramString.c = str.substring(str.indexOf("<Time Date=\"") + "<Time Date=\"".length(), str.indexOf("\">"));
//        else paramString.c = str.substring(str.indexOf("<Time Day=\"") + "<Time Day=\"".length(), str.indexOf("\">"));
//        if ((localObject1 = str.split("<Item>")).length > 0) {
//            paramString.d = new Vector();
//            Object localObject2;
//            int j = (localObject2 = localObject1).length;
//            for (int i = 0; i < j; i++)
//                if ((localObject1 = localObject2[i]).indexOf("<Begin>") > -1) {
//                    OndutyTimeBean.ItemBean localItemBean;
//                    OndutyTimeBean.ItemBean.a(localItemBean = new OndutyTimeBean.ItemBean(paramString), ((String) localObject1).substring(((String) localObject1).indexOf("<Begin>") + "<Begin>".length(), ((String) localObject1).indexOf("</Begin>")));
//                    OndutyTimeBean.ItemBean.b(localItemBean, ((String) localObject1).substring(((String) localObject1).indexOf("<End>") + "<End>".length(), ((String) localObject1).indexOf("</End>")));
//                    paramString.d.add(localItemBean);
//                }
//        }
        return null;
    }


    public static void main(String[] paramArrayOfString) {
        String s = "<?xml version=\"1.0\"?><Response><CmdType>ConfigDownload</CmdType><SN>命令序列号</SN><DeviceID>摄像机ID</DeviceID><ConfigType> 配置参数类型 </ConfigType><SEQ>配置项序号 </SEQ><RecordTimeParam><Month><Seq Num=\"9\"><Time Day=\"31\"><Item><Begin>开始时间1</Begin><End>结束时间1</End></Item><Item><Begin>开始时间2</Begin><End>结束时间2</End></Item><Item><Begin>开始时间3</Begin><End>结束时间3</End></Item><Item><Begin>开始时间4</Begin><End>结束时间4</End></Item></Time></Seq></Month></RecordTimeParam></Response>";

        CameraRecordTimeParamConfigDownloadResponse localCameraRecordTimeParamConfigDownloadResponse;
        (localCameraRecordTimeParamConfigDownloadResponse = new CameraRecordTimeParamConfigDownloadResponse("")).setXmlContent(s);
        localCameraRecordTimeParamConfigDownloadResponse.genParameters();
        System.out.println(localCameraRecordTimeParamConfigDownloadResponse.toString());
    }
}
