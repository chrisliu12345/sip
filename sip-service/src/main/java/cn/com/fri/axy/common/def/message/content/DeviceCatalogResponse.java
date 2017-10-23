package cn.com.fri.axy.common.def.message.content;

import cn.com.fri.axy.sip.message.content.ResMessage;

import java.util.Vector;


public class DeviceCatalogResponse
        extends ResMessage {
    private String a;
    private String b;
    private String c;
    private Vector d;

    public String getDeviceID() {
        return this.a;
    }

    public void setDeviceID(String paramString) {
        this.a = paramString;
    }

    public String getSumNum() {
        return this.b;
    }

    public void setSumNum(String paramString) {
        this.b = paramString;
    }

    public Vector getItems() {
        return this.d;
    }

    public void setItems(Vector paramVector) {
        this.d = paramVector;
    }

    public String getDevicelist_num() {
        return this.c;
    }

    public void setDevicelist_num(String paramString) {
        this.c = paramString;
    }

    public DeviceCatalogResponse(String paramString) {
        super(paramString, "Catalog");
    }


    public void genParameters() {
        String str = getXmlContent();
        setSn(str.substring(str.indexOf("<SN>") + "<SN>".length(), str.indexOf("</SN>")));
        this.a = str.substring(str.indexOf("<DeviceID>") + "<DeviceID>".length(), str.indexOf("</DeviceID>"));
        this.b = str.substring(str.indexOf("<SumNum>") + "<SumNum>".length(), str.indexOf("</SumNum>"));

        str = str.substring(str.indexOf("<DeviceList Num="));
        this.c = str.substring(str.indexOf("<DeviceList Num=") + "<DeviceList Num=".length(), str.indexOf(">"));
    }


    public void genXmlContent() {
    }


    public static void main(String[] paramArrayOfString) {
        String s = new String(
                "<?xml version=\"1.0\"?>\n<Response>\n<CmdType>Catalog</CmdType>\n<SN>17430</SN>\n<DeviceID>64010000001110000001</DeviceID>\n<SumNum>100</SumNum>\n<DeviceList Num=2>\n<Item>\n<DeviceID>64010000001330000001</DeviceID>\n<Name>Camera1</Name>\n<Manufacturer>Manufacturer1</Manufacturer>\n<Model>Model1</Model>\n<Owner>Owner1</Owner>\n<CivilCode>CivilCode1</CivilCode>\n<Block>Block1</Block>\n<Address>Address1</Address>\n<Parental>1</Parental>\n<ParentID>64010000001110000001</ParentID>\n<SafetyWay>0</SafetyWay>\n<RegisterWay>1</RegisterWay>\n<CertNum>CertNum1</CertNum>\n<Certifiable>0</Certifiable>\n<ErrCode>400</ErrCode>\n<EndTime>2010-11-11T19:46:17</EndTime>\n<Secrecy>0</Secrecy>\n<IPAddress>192.168.3.81</IPAddress>\n<Port>5060</Port>\n<Password>Password1</Password>\n<Status>Status1</Status>\n<Longitude>171.3</Longitude>\n<Latitude>34.2</Latitude>\n</Item>\n<Item>\n<DeviceID>64010000001330000002</DeviceID>\n<Name>Camera2</Name>\n<Manufacturer>Manufacturer2</Manufacturer>\n<Model>Model2</Model>\n<Owner>Owner2</Owner>\n<CivilCode>CivilCode2</CivilCode>\n<Block>Block2</Block>\n<Address>Address2</Address>\n<Parental>1</Parental>\n<ParentID>64010000001110000001</ParentID>\n<SafetyWay>0</SafetyWay>\n<RegisterWay>1</RegisterWay>\n<CertNum>CertNum1</CertNum>\n<Certifiable>0</Certifiable>\n<ErrCode>400</ErrCode>\n<EndTime>2010-11-11T19:46:17</EndTime>\n<Secrecy>0</Secrecy>\n<IPAddress>192.168.3.81</IPAddress>\n<Port>5060</Port>\n<Password>Password1</Password>\n<Status>Status1</Status>\n<Longitude>171.4</Longitude>\n<Latitude>34.2</Latitude>\n</Item></DeviceList></Response>");


        DeviceCatalogResponse localDeviceCatalogResponse;


        (localDeviceCatalogResponse = new DeviceCatalogResponse(null)).setXmlContent(s);
        localDeviceCatalogResponse.genParameters();

        System.out.println(localDeviceCatalogResponse.getDevicelist_num());
        System.out.println(localDeviceCatalogResponse.getItems().size());
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/common/def/message/content/DeviceCatalogResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */