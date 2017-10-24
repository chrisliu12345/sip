package com.git.wuqf.client.pushlet.core;

public abstract interface Protocol {
    public static final String DEFAULT_SERVLET_URI = "com.git.wuqf.pushlet.srv";
    public static final String P_EVENT = "p_event";
    public static final String P_TIME = "p_time";
    public static final String P_SEQ = "p_seq";
    public static final String P_SUBJECT = "p_subject";
    public static final String P_FROM = "p_from";
    public static final String P_TO = "p_to";
    public static final String P_ID = "p_id";
    public static final String P_SUBSCRIPTION_ID = "p_sid";
    public static final String P_FORMAT = "p_format";
    public static final String P_MODE = "p_mode";
    public static final String P_REASON = "p_reason";
    public static final String P_URL = "p_url";
    public static final String P_WAIT = "p_wait";
    public static final String P_SUBSCRIPTION_LABEL = "p_label";
    public static final String E_JOIN = "join";
    public static final String E_JOIN_ACK = "join-ack";
    public static final String E_JOIN_LISTEN = "join-listen";
    public static final String E_JOIN_LISTEN_ACK = "join-listen-ack";
    public static final String E_LISTEN = "listen";
    public static final String E_LISTEN_ACK = "listen-ack";
    public static final String E_LEAVE = "leave";
    public static final String E_LEAVE_ACK = "leave-ack";
    public static final String E_PUBLISH = "publish";
    public static final String E_PUBLISH_ACK = "publish-ack";
    public static final String E_SUBSCRIBE = "subscribe";
    public static final String E_SUBSCRIBE_ACK = "subscribe-ack";
    public static final String E_UNSUBSCRIBE = "unsubscribe";
    public static final String E_UNSUBSCRIBE_ACK = "unsubscribe-ack";
    public static final String E_NACK = "nack";
    public static final String E_ABORT = "abort";
    public static final String E_DATA = "data";
    public static final String E_HEARTBEAT = "hb";
    public static final String E_HEARTBEAT_ACK = "hb-ack";
    public static final String E_REFRESH = "refresh";
    public static final String E_REFRESH_ACK = "refresh-ack";
    public static final String FORMAT_JAVASCRIPT = "js";
    public static final String FORMAT_SERIALIZED_JAVA_OBJECT = "ser";
    public static final String FORMAT_XML = "xml";
    public static final String FORMAT_XML_STRICT = "xml-strict";
    public static final String MODE_STREAM = "stream";
    public static final String MODE_PULL = "pull";
    public static final String MODE_POLL = "poll";
}