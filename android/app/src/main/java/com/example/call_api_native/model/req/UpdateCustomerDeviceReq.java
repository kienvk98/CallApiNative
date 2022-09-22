package com.example.call_api_native.model.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateCustomerDeviceReq {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("DeviceType")
    @Expose
    private Integer deviceType;
    @SerializedName("TokenDevice")
    @Expose
    private String tokenDevice;
    @SerializedName("DeviceInfo")
    @Expose
    private String deviceInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getTokenDevice() {
        return tokenDevice;
    }

    public void setTokenDevice(String tokenDevice) {
        this.tokenDevice = tokenDevice;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
