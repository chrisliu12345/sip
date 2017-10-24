package com.git.wuqf.service.common;


public class Const {
    public static final String WEBAPP_NAME = "PMPlatForm";


    public static final String FLAG_OF_ALARM_RECORD = "报警联动";


    public static final String FLAG_OF_TIMER_RECORD = "定时录像";

    public static final int FLAG_OF_VIDEO_RECORD_NORMAL = 1;

    public static final int FLAG_OF_VIDEO_RECORD_ALARM = 2;

    public static final int FLAG_OF_VIDEO_RECORD_LOCAL = 0;

    public static final int FLAG_OF_VIDEO_RECORD_REPLAY = 4;

    public static final String ONLINE_STATE_OF_USER = "在线";

    public static final String OFFLINE_STATE_OF_USER = "离线";

    public static final String INALARM_STATE_OF_USER = "接警";

    public static final String ONLINE_STATE_OF_DEVICE = "在线";

    public static final String OFFLINE_STATE_OF_DEVICE = "离线";

    public static final String ISOLATE_STATE_OF_DEVICE = "隔离";

    public static final String INALARM_STATE_OF_DEVICE = "报警";

    public static final String EXCEPTION_STATE_OF_DEVICE = "故障";

    public static final String BUFANG_STATE_OF_DEVICE = "布防";

    public static final String INRECORD_STATE_OF_DEVICE = "录像";

    public static final String CHEFANG_STATE_OF_DEVICE = "撤防";

    public static final String INCODE_STATE_OF_DEVICE = "编码";

    public static final String PREVENTBREAK_ALARM_STATE_OF_DEVICE = "防拆报警";

    public static final String EXCEPTION_ALARM_STATE_OF_DEVICE = "设备故障报警";

    public static final String VIDEODROP_ALARM_STATE_OF_DEVICE = "视频丢失报警";

    public static final String DISKCOMPLETE_ALARM_STATE_OF_DEVICE = "磁盘满报警";

    public static final String DEVICEOFFLINE = "离线";

    public static final String DEVICEONLINE = "上线";

    public static final String DEVICEFBUSY = "忙";

    public static final String SCHEDULEDEVICEONLINE = "SCHEDULEDEVICEONLINE";

    public static final String FLAG_OF_UESRPASSWORD = "0";

    public static final String FLAG_OF_AUTHEN = "1";

    public static final String WEEKPATROL = "1";

    public static final String MONTHPATROL = "2";

    public static final String YEARPATROL = "3";

    public static final String ONCEPATROL = "0";

    public static final String SCHEDULEGROUPDEVICEPATROL = "devicepatrol";

    public static final String POLICYID = "POLICYID";

    public static final String POLICYTYPE = "POLICYTYPE";

    public static final String POLICYDAY = "POLICYDAY";

    public static final String POLICYSTARTIME = "POLICYSTARTIME";

    public static final String PATROLIDLIST = "PATROLIDLIST";

    public static final String SCHEMEROUTERNAME = "PatrolScheme";

    public static final String ROUTERDEVICENAME = "PatrolRouter";

    public static final String PATROLTIMERNAME = "PatrolTimer";

    public static final String SHOWPARA = "SHOWPARA";

    public static final String JOBTYPE = "JOBTYPE";

    public static final String JOBNAME = "JOBNAME";

    public static final String CLIENTID = "ClientID";

    public static int ONCE = 0;
    public static int DAY = 1;
    public static int WEEK = 2;
    public static int MONTH = 3;


    public static final String SCHEDULERGROUPROUTER = "SCHEDULERGROUPROUTER";


    public static final String DEVICEGROUPID = "dgroupid";


    public static final int IMMEDIATETAKSNUM = 100000;


    public static final Long METHOD_OF_REGISTERWAY_SIP3261 = Long.valueOf("0");
    public static final Long METHOD_OF_REGISTERWAY_PASSWORD = Long.valueOf("1");
    public static final Long METHOD_OF_REGISTERWAY_DIGITALCERTIFICATE = Long.valueOf("2");


    public static final String TOLERANT_DEVICE_GROUP_TYPE = "0";

    public static final String CUSTOM_DEVICE_GROUP_TYPE = "1";

    public static final Long READ_DEVICE_OPERATION_POPEDOM = Long.valueOf("1");
    public static final Long WRITE_DEVICE_OPERATION_POPEDOM = Long.valueOf("2");
    public static final Long DEPLOY_DEVICE_OPERATION_POPEDOM = Long.valueOf("3");
    public static final Long ALL_DEVICE_OPERATION_POPEDOM = Long.valueOf("4");

    public static final String SUCCESS_CONNECT_MEDIA_RESPONSE = "12";

    public static final String FAIL_CONNECT_MEDIA_RESPONSE = "13";

    public static final String TOLERANT_USER_GROUP_TYPE = "0";

    public static final String CUSTOM_USER_GROUP_TYPE = "1";

    public static final String ALL_BUSINESS_TYPE = "0";

    public static final String JIECHUJING_BUSINESS_TYPE = "1";

    public static final String ALL_JIECHUJING_BUSINESS_TYPE = "0";

    public static final String DIANZIXUNLUO_BUSINESS_TYPE = "2";

    public static final String BUKONGZHUITAO_BUSINESS_TYPE = "3";

    public static final String FUZHUZHIHUI_BUSINESS_TYPE = "4";

    public static final String ZONGHEYANPAN_BUSINESS_TYPE = "5";

    public static final int MAXVALUE = 999999;

    public static final String PREJOBNAME = "ALARMLINKAGE";

    public static final String SCHEDULEALARM = "SCHEDULEALARM";

    public static final String ALARMUSERID = "ALARMUSERID";

    public static final String TASKID = "TASKID";

    public static final String ALARMOP = "ALARMOP";

    public static final String ALARMINFO = "ALARMINFO";

    public static final String CONTENTPARAM = "CONTENTPARAM";

    public static final String ALARM_BASIC_OPERATION_VIDEOCONVERT = "1";

    public static final String ALARM_BASIC_OPERATION_DEVICEPATROL = "2";

    public static final String ALARM_BASIC_OPERATION_VIDEORECORD = "6";

    public static final String ALARM_BASIC_OPERATION_SENDIM = "11";

    public static final String ALARM_BASIC_OPERATION_DEFENCEDEVICE = "4";

    public static final String ALARM_BASIC_OPERATION_SENDALARMMESSAGE = "12";

    public static final String USERID = "USERID";

    public static final String ALARMDEVICEID = "ALARMDEVICEID";

    public static final String SOURCEDEVICEID = "SOURCEDEVICEID";

    public static final String SCREENDEVICEID = "SCREENDEVICEID";

    public static final String SCREENDEVICECODE = "SCREENDEVICECODE";

    public static final String RESOLUTION = "RESOLUTION";

    public static final String STORAGEDEVICEID = "STORAGEDEVICEID";

    public static final String STORAGEPARAM = "STORAGEPARAM";

    public static final String OPPARAM = "OPPARAM";

    public static final String RECORDTIMELENGTH = "RECORDTIMELENGTH";

    public static final String SPLITCHAR = ",";

    public static final int WINDOWID = 1;

    public static final int IRESOLUTION = 4;

    public static final String SETPOSITION = "ConfigPosition";

    public static final String REMOVEPOSITION = "RemovePosition";

    public static final String USEPOSITION = "UsePosition";

    public static final String EXECUTERDEFENCE = "布防";

    public static final String RETRACTDEFENCE = "撤防";

    public static final String ALARMMETHOD_IS_PHONE = "1";

    public static final String ALARMMETHOD_IS_DEVICE = "2";

    public static final String ALARMMETHOD_IS_MESSAGE = "3";

    public static final String ALARMMETHOD_IS_GPS = "4";
    public static final String ALARMMETHOD_IS_VIDEO = "5";
    public static final String ALARMMETHOD_IS_IVTGS = "52";
    public static final String ALARMMETHOD_IS_IVEXCACTION = "51";
    public static final String ALARMMETHOD_IS_IVSYSFAIL = "53";
    public static final String ALARMMETHOD_IS_DEVICEEXCEPTION = "6";
    public static final String ALARMMETHOD_IS_OTHER = "7";
    public static final String ALARMMETHOD_IS_VIDEOLOSE = "71";
    public static final String ALARMMETHOD_IS_PREVENTBACKOUT = "72";
    public static final String ALARMMETHOD_IS_DISKCOMPLETE = "73";
    public static final String ALARMMETHOD_IS_SELFFINDALARM = "74";
    public static final String ALARMLEVEL_IS_FIRST = "1";
    public static final String ALARMLEVEL_IS_SECOND = "2";
    public static final String ALARMLEVEL_IS_THIRD = "3";
    public static final String ALARMLEVEL_IS_FORTH = "4";
    public static final String DEVICEID = "DEVICEID";
    public static final String DTIMERVIDEROGROUP = "DTIMERVIDEROGROUP";
    public static final String RECORDTIMER = "RECORDTIMER";
    public static final String SCHEDULETIMERVIDEOGROUP = "SCHEDULETIMERVIDEOGROUP";
    public static final String STATUS_OF_ALARM_UNPROCESSED = "排队";
    public static final String STATUS_OF_ALARM_INPROCESS = "正在处理";
    public static final String STATUS_OF_ALARM_PROCESSED = "处理结束";
    public static final String CLIENTDEVICETYPE = "CLIENTDEVICETYPE";
    public static final int PATROL_ADDTIME = 1000;
    public static final String ALARMLINKAGE_VIDEOCONVERT_TO_ALARMRECEIVER = "0";
    public static final String DEFAULT_LOCAL_USER_GROUP = "000,001,002,003,004,005,006,007,008,009,";
    public static final String DEFAULT_FOREIGN_USER_GROUP = "100,101,102,103,104,105,106,107,108,109,";
    public static final String UGROUPID_OF_ISWARD = "002";
    public static final String FLAG_OF_CUSTOM_FOREIGN_USER_GROUP = "110";
    public static final String FLAG_OF_DEFAULT_FOREIGN_USER_GROUP = "100";
    public static final Object FORMTMEPLATE_NAME = "FormTemplate_Name";


    public static final String SCHEDULERGROUPFORM = "SchedulerGroupForm";

    public static final String SIPHANDLER = "SIPHANDLER";

    public static long SOCKET_MESSAGE_CURRENT_SN = 0L;


    public static final String FLAG_OF_WIRELESS_GATEWAY = "211";


    public static final String FLAG_OF_DISPLAY_TW = "133";


    public static final String FLAG_OF_START_CENTERUSER = "300";


    public static final String FLAG_OF_END_TERMINALUSER = "499";


    public static final String FLAG_OF_AUTOCONVERTGROUP = "10";


    public static final String FLAG_OF_MANUALSLIPGROUP = "11";


    public static final int DIRECTION_SLIP_DOWN = 0;


    public static final int DIRECTION_SLIP_UP = 1;


    public static final String FLAG_OF_MEDIA_DEVICE = "202";


    public static final String FLAG_OF_CAMERA_DEVICE = "131";


    public static final String FLAG_OF_MONITOR_DEVICE = "133";


    public static final String FLAG_OF_ALARM_DEVICE = "134";


    public static final String PROPERTY_FILE_NAME = "PMPlatFormenv.properties";


    public static final String BUSINESS_FACTORY = "cn.com.fri.axy.business.factory.";


    public static final String BDEFENCELOG_FACTORY = "cn.com.fri.axy.business.factory.BDefencelogFactoryImpl";


    public static final String BDRECORDGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.BDRecordGroupInfoFactoryImpl";


    public static final String USERINFO_FACTORY = "cn.com.fri.axy.business.factory.UserinfoFactoryImpl";


    public static final String USERGROUP_FACTORY = "cn.com.fri.axy.business.factory.UsergroupFactoryImpl";


    public static final String DEVINFO_FACTORY = "cn.com.fri.axy.business.factory.DevinfoFactoryImpl";


    public static final String DEVICEGROUP_FACTORY = "cn.com.fri.axy.business.factory.DeviceGroupFacatoryImpl";


    public static final String ACHECKPOSTINFO_FACTORY = "cn.com.fri.axy.business.factory.ACheckpostinfoFactoryImpl";


    public static final String ACHECKPOSTACTION_FACTORY = "cn.com.fri.axy.business.factory.ACheckpostactionFactoryImpl";


    public static final String SSECURITYINFO_FACTORY = "cn.com.fri.axy.business.factory.SSecurityInfoFactoryImpl";


    public static final String SCENTERINFO_FACTORY = "cn.com.fri.axy.business.factory.CenterinfoFactoryImpl";


    public static final String RECORDVIDEOCONFIG_FACTORY = "cn.com.fri.axy.business.factory.RecordVideoConfigFactoryImpl";


    public static final String SECURITYCONFIG_FACTORY = "cn.com.fri.axy.business.factory.SecurityConfigFactoryImpl";


    public static final String SERVERDEPLOYCONFIG_FACTORY = "cn.com.fri.axy.business.factory.ServerDeployConfigFactoryImpl";


    public static final String SIPROUTER_FACTORY = "cn.com.fri.axy.business.factory.SiprouterFactoryImpl";


    public static final String TIMEOUT_FACTORY = "cn.com.fri.axy.business.factory.TimeoutFactoryImpl";


    public static final String UUDGROUPREL_FACTORY = "cn.com.fri.axy.business.factory.UUdgrouprelFactoryImpl";


    public static final String DRGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.DRgroupinfoFactoryImpl";


    public static final String DRGROUPDEVICE_FACTORY = "cn.com.fri.axy.business.factory.DRgroupdeviceFactoryImpl";


    public static final String TIMERSCHEME_FACTORY = "cn.com.fri.axy.business.factory.TimerSchemeFactoryImpl";


    public static final String SCHEMEROUTER_FACTORY = "cn.com.fri.axy.business.factory.SchemeRouterFactoryImpl";


    public static final String ROUTERDEVICE_FACTORY = "cn.com.fri.axy.business.factory.RouterDeviceFactoryImpl";


    public static final String DEVICE2GROUP_FACTORY = "cn.com.fri.axy.business.factory.DGroupdeviceFactoryImpl";


    public static final String DONLINEINFO_FACTORY = "cn.com.fri.axy.business.factory.DOnlineInfoFactoryImpl";


    public static final String ACOUNTERPLAN_FACTORY = "cn.com.fri.axy.business.factory.ACounterplanFactoryImpl";


    public static final String CENTERINFO_FACTORY = "cn.com.fri.axy.business.factory.CenterinfoFactoryImpl";


    public static final String FILEINDEX_FACTORY = "cn.com.fri.axy.business.factory.FileindexFactoryImpl";


    public static final String ALARMRECORD_FACTORY = "cn.com.fri.axy.business.factory.AlarmRecordFactoryImpl";


    public static final String ALARMEVENT_FACTORY = "cn.com.fri.axy.business.factory.AlarmEventFactoryImpl";


    public static final String ALARMLINKAGE_FACTORY = "cn.com.fri.axy.business.factory.AAlarmlinkageFactoryImpl";


    public static final String LCHECKLOG_FACTORY = "cn.com.fri.axy.business.factory.LChecklogFactoryImpl";


    public static final String LCHECKRES_FACTORY = "cn.com.fri.axy.business.factory.LCheckresFactoryImpl";


    public static final String GROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.GroupinfoFactoryImpl";


    public static final String GROUPTYPE_FACTORY = "cn.com.fri.axy.business.factory.GrouptypeFactoryImpl";


    public static final String GROUPDEVREL_FACTORY = "cn.com.fri.axy.business.factory.GroupdeviceRelFactoryImpl";


    public static final String GROUPPATROL_FACTORY = "cn.com.fri.axy.business.factory.GrouppatrolFactoryImpl";


    public static final String OPERATIONLOG_FACTORY = "cn.com.fri.axy.business.factory.LActionlogFactoryImpl";


    public static final String ONLINEINFO_FACTORY = "cn.com.fri.axy.business.factory.OnlineinfoFactoryImpl";


    public static final String UGROUPLOCALTOOUTER_FACTORY = "cn.com.fri.axy.business.factory.UGrouplocaltoouterFactoryImpl";


    public static final String PROVINCE_FACTORY = "cn.com.fri.axy.business.factory.ProvinceFactoryImpl";


    public static final String DGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.DGroupinfoFactoryImpl";


    public static final String SCREENGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.UScreengroupinfoFactoryImpl";


    public static final String CODECCFG_FACTORY = "cn.com.fri.axy.business.factory.CodeccfgFactoryImpl";


    public static final String CODECCAMERA_FACTORY = "cn.com.fri.axy.business.factory.CodeccameraFactoryImpl";


    public static final String CODECALARM_FACTORY = "cn.com.fri.axy.business.factory.CodecalarmFactoryImpl";


    public static final String ALARMCFG_FACTORY = "cn.com.fri.axy.business.factory.AlarmcfgFactoryImpl";

    public static final String ALARMTCFG_FACTORY = "cn.com.fri.axy.business.factory.AlarmtcfgFactoryImpl";

    public static final String ALARMRCFG_FACTORY = "cn.com.fri.axy.business.factory.AlarmrcfgFactoryImpl";

    public static final String CAMERACFG_FACTORY = "cn.com.fri.axy.business.factory.CameracfgFactoryImpl";

    public static final String CAMERATCFG_FACTORY = "cn.com.fri.axy.business.factory.CameratcfgFactoryImpl";

    public static final String DEVICESECURITY_FACTORY = "cn.com.fri.axy.business.factory.DevicesecurityFactoryImpl";

    public static final String DECODECCFG_FACTORY = "cn.com.fri.axy.business.factory.DecodeccfgFactoryImpl";

    public static final String DECODECOUTPUT_FACTORY = "cn.com.fri.axy.business.factory.DecodecoutputFactoryImpl";

    public static final String BCODECBASICCFG_FACTORY = "cn.com.fri.axy.business.factory.BCodecBasiccfgFactoryImpl";

    public static final String BCODECNETCFG_FACTORY = "cn.com.fri.axy.business.factory.BCodecNetcfgFactoryImpl";

    public static final String BCODECHEARTBEATCFG_FACTORY = "cn.com.fri.axy.business.factory.BCodecHeartBeatcfgFactoryImpl";

    public static final String BCODECTIMECFG_FACTORY = "cn.com.fri.axy.business.factory.BCodecTimecfgFactoryImpl";

    public static final String BCODECSECURITYCFG_FACTORY = "cn.com.fri.axy.business.factory.BCoderSeccfgFactoryImpl";

    public static final String BCODECCAMERACFG_FACTORY = "cn.com.fri.axy.business.factory.BCodecCameracfgFactoryImpl";

    public static final String BCODECALARMCFG_FACTORY = "cn.com.fri.axy.business.factory.BCodecAlarmcfgFactoryImpl";

    public static final String BCAMERAVEDIOCFG_FACTORY = "cn.com.fri.axy.business.factory.BCameraVediocfgFactoryImpl";

    public static final String BCAMERATELCRTLCFG_FACTORY = "cn.com.fri.axy.business.factory.BCameraTelCtrlcfgFactoryImpl";

    public static final String BCAMERARECORDCFG_FACTORY = "cn.com.fri.axy.business.factory.BCameraRecordcfgFactoryImpl";

    public static final String BCAMERAACTIVERECORDTIMECFG_FACTORY = "cn.com.fri.axy.business.factory.BCameraActiveRecordTimecfgFactoryImpl";

    public static final String BCAMERAMEDIASECCFG_FACTORY = "cn.com.fri.axy.business.factory.BCameraMediaSeccfgFactoryImpl";

    public static final String BDECODERBASICCFG_FACTORY = "cn.com.fri.axy.business.factory.BDecoderBasiccfgFactoryImpl";

    public static final String BDECODERNETCFG_FACTORY = "cn.com.fri.axy.business.factory.BDecoderNetcfgFactoryImpl";

    public static final String BDECODERHEARTBEATCFG_FACTORY = "cn.com.fri.axy.business.factory.BDecoderHeartBeatcfgFactoryImpl";

    public static final String BDECODERTIMECFG_FACTORY = "cn.com.fri.axy.business.factory.BDecoderTimecfgFactoryImpl";

    public static final String BDECODERSECURITYCFG_FACTORY = "cn.com.fri.axy.business.factory.BDecoderSeccfgFactoryImpl";

    public static final String BDECODEROUTPUT_FACTORY = "cn.com.fri.axy.business.factory.BDecoderOutputcfgFactoryImpl";

    public static final String BCAMERAADDRESSCODECFG_FACTORY = "cn.com.fri.axy.business.factory.BCameraAddresscodecfgFactoryImpl";

    public static final String LFORMTEMPLATE_FACTORY = "cn.com.fri.axy.business.factory.LFormtemplateFactoryImpl";

    public static final String LFORMINDEX_FACTORY = "cn.com.fri.axy.business.factory.LFormindexFactoryImpl";

    public static final String LFORMSCHEME_FACTORY = "cn.com.fri.axy.business.factory.LFormschemeFactoryImpl";

    public static final String LFORMINFO_FACTORY = "cn.com.fri.axy.business.factory.LForminfoFactoryImpl";

    public static final String CFORMTYPE_FACTORY = "cn.com.fri.axy.business.factory.CFormtypeFactoryImpl";

    public static final String LFORMPARA_FACTORY = "cn.com.fri.axy.business.factory.LFormparaFactoryImpl";

    public static final String LFORMLIST_FACTORY = "cn.com.fri.axy.business.factory.LFormlistFactoryImpl";

    public static final String LCHECKSCHEME_FACTORY = "cn.com.fri.axy.business.factory.LCheckSchemeFactoryImpl";

    public static final String DEVICELOCATION_FACTORY = "cn.com.fri.axy.business.factory.DeviceLocationFactoryImpl";

    public static final String DEVICESWITCH_FACTORY = "cn.com.fri.axy.business.factory.DeviceSwitchFactoryImpl";

    public static final String CSCENECOUNTERPLAN_FACTORY = "cn.com.fri.axy.business.factory.CSceneCounterPlanFactoryImpl";

    public static final String BSCENEETOCOUNTERPLAN_FACTORY = "cn.com.fri.axy.business.factory.BSceneToCounterPlanFactoryImpl";

    public static final String BCAMERAGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.BCameraGroupInfoFactoryImpl";

    public static final String BCAMERATOGROUP_FACTORY = "cn.com.fri.axy.business.factory.BCameraToGroupFactoryImpl";

    public static final String BMONITORGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.BMonitorGroupInfoFactoryImpl";

    public static final String BMONITORTOGROUP_FACTORY = "cn.com.fri.axy.business.factory.BMonitorToGroupFactoryImpl";

    public static final String BCOMMANDINFO_FACTORY = "cn.com.fri.axy.business.factory.BCommandInfoFactoryImpl";

    public static final String BSCREENPARA_FACTORY = "cn.com.fri.axy.business.factory.BScreenParaFactoryImpl";

    public static final String BSCREENINFO_FACTORY = "cn.com.fri.axy.business.factory.BScreenInfoFactoryImpl";

    public static final String BPATROLLOG_FACTORY = "cn.com.fri.axy.business.factory.BPatrolLogFactoryImpl";

    public static final String BBSCENECOUNTERPLANINFO_FACTORY = "cn.com.fri.axy.business.factory.BBSceneCounterPlanInfoFactoryImpl";

    public static final String BBMONITORGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.BBMonitorGroupInfoFactoryImpl";

    public static final String BBCAMERAGROUPINFO_FACTORY = "cn.com.fri.axy.business.factory.BBCameraGroupInfoFactoryImpl";

    public static final String MDISPATCHREGION_FACTORY = "cn.com.fri.axy.business.factory.MDispatchregionFactoryImpl";

    public static final String MSTORAGEREGION_FACTORY = "cn.com.fri.axy.business.factory.MStorageregionFactoryImpl";

    public static final String SDATABACKUP_FACTORY = "cn.com.fri.axy.business.factory.SDatabackupFactoryImpl";

    public static final String BAGUARDWAYINFO_FACTORY = "cn.com.fri.axy.business.factory.BAGuardWayInfoFactoryImpl";

    public static final String BRANKTHEMEINFO_FACTORY = "cn.com.fri.axy.business.factory.BRankThemeInfoFactoryImpl";

    public static final String MRANKTHEMEINFO_FACTORY = "cn.com.fri.axy.business.factory.MRankthemeinfoFactoryImpl";

    public static final String MRANKRECORDS_FACTORY = "cn.com.fri.axy.business.factory.MRankrecordsFactoryImpl";

    public static final String CBLOCK_FACTORY = "cn.com.fri.axy.business.factory.CBlockFactoryImpl";

    public static final String SCHEDULEGROUPDATABASEBACKUP = "databasebackup";

    public static final String DATABASEBACKUPTYPE = "databasebackuptype";

    public static final String SCHEDULEGROUPDATABASECLEAR = "databaseclear";

    public static final Long COMPLETE_BACKUP = Long.valueOf(0L);
    public static final Long CUMULATIVE_BACKUP = Long.valueOf(1L);
    public static final Long INCREMENTTAL_BACKUP = Long.valueOf(2L);
    public static final Long TABLE_BACKUP = Long.valueOf(3L);
    public static final String DATACLEARTYPE = "DATACLEARTYPE__";
    public static final String SCHEMEROUTEROPERATOR = "SCHEMEROUTEROPERATOR";
    public static final long CONTRALDEVICE_RELEASE_INTERVAL = 60000L;
    public static final String CHARSET_NAME = "GB2312";
    public static final String SYSNAME_IVWA = "智能视频系统";
    public static final String SYSNAME_ECSKRX = "三台合一系统";
    public static final String SYSNAME_VCS = "视频指挥系统";
    public static final String SYSNAME_TIPF_YHL = "交警集成平台";
    public static final String SYSNAME_PMPLATFORM = "集成平台";
    public static final String AUDIO_TALKBACK = "语音对讲";
    public static final String VIDEO_TALKBACK = "可视化对讲";
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/Const.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */