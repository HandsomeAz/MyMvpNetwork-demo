package com.example.mymvpnetwork_master.bean;

/**
 * @package: com.example.mymvpnetwork_master.bean
 * 创建人： created by zlj
 * 时间：2022/03/27 21
 */
public class TestBean {

    /**
     * code : 2000
     * message : 发现新版本
     * dataType : VersionUpdate
     * data : http://rjb.geoelectron.com:15050/task/downloadGeoApk
     */

    private int code;
    private String message;
    private String dataType;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", dataType='" + dataType + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
