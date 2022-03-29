package com.example.mymvpnetwork_master.constants;

/**
 * @package: com.example.mymvpnetwork_master.constants
 * 创建人： created by zlj
 * 时间：2022/03/27 16
 */
public class ConstantConfig {
    /**
     * 连接socket的 ip地址
     */
//    public static String REMOTE_IP = "192.168.4.10";//机器同一IP
    public static String REMOTE_IP = "rjb.geoelectron.com";
    /**
     * socket 服务端暴露的端口
     */
    public static String getUpdateUrl="http://"+REMOTE_IP+":15050"+"/version-data/update?versionCode=";

    public static String AppClient="";
    public static final int REMOTE_PORT = 15050;
//    public static final int REMOTE_PORT = 9991;

    public static String BaseUrl = "http://"+REMOTE_IP+":"+REMOTE_PORT;
}
