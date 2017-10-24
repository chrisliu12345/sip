package com.git.wuqf.service.sip.util;


public class Constants {
    public static final String DIALOG_HANDLER = "dialogHandler";

    public static final String CALLER_SDP = "callerSDP";

    public static final String SDP = "application/sdp";

    public static final String MRF_ANSWER_SDP = "MRF_ANSWER_SDP";
    public static final String MSML_CONTENT_TYPE = "application/msml+xml";
    public static final String MSCMS_CONTENT_TYPE = "application/mediaservercontrol+xml";
    public static final String ctdServer = "sip:pcaas.com";
    public static final String APPLICATION_SDP = "application/sdp";
    public static String FROM_PORTAL = "FROM_PORTAL";
    public static String FROM_TERMINAL = "FROM_TERMINAL";
    public static final String CALL_FAILED = "0";
    public static final String CALL_NO_ANSWER = "1";
    public static final String CALL_SUCCESS = "2";
    public static final String FAKE_SDP = "v=0\no=userX 20000001 20000001 IN IP4 10.130.2.51\ns=-\nc=IN IP4 10.130.2.51\nt=0 0\nm=image 49152 udptl t38\na=T38FaxVersion:0\na=T38MaxBitRate:14400\na=T38FaxRateManagement:transferredTCF\na=T38FaxMaxBuffer:4000\na=T38FaxMaxDatagram:1008\na=T38FaxUdpEC:t38UDPFEC\na=T38FaxUdpEC:t38UDPRedundancy\nm=audio 49152 RTP/AVP 0 8\na=rtpmap:0 PCMU/8000\na=rtpmap:8 PCMA/8000\na=ptime:20\na=silenceSupp:off - - - -\n";
    public static final String FAKE_SDP1 = "v=0\no=- 123456 654321 IN IP4 10.130.1.61\ns=-\nc=IN IP4 10.130.1.61\nt=0 0\nm=audio 10010 RTP/AVP 8 0 18 2 100 99 98 21 97\na=recvonly\na=rtpmap:8 PCMA/8000\na=rtpmap:0 PCMU/8000\na=rtpmap:2 G726/8000\na=rtpmap:100 G726-16/8000\na=rtpmap:99 G726-24/8000\na=rtpmap:98 G726-40/8000\na=rtpmap:97 telephone-event/8000\na=fmtp:97 0-15\n";
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/util/Constants.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */