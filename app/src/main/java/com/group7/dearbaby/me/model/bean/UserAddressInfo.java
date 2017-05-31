package com.group7.dearbaby.me.model.bean;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-28.
 */

public class UserAddressInfo {
    private String receiveName;
    private String receivePhone;
    private String receiveAddress;
    private String pickAddress;

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getPickAddress() {
        return pickAddress;
    }

    public void setPickAddress(String pickAddress) {
        this.pickAddress = pickAddress;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    private String addressInfo;

    public UserAddressInfo(String receiveName, String receivePhone, String receiveAddress, String pickAddress, String addressInfo) {
        this.receiveName = receiveName;
        this.receivePhone = receivePhone;
        this.receiveAddress = receiveAddress;
        this.pickAddress = pickAddress;
        this.addressInfo = addressInfo;
    }
}
