package com.bsoft.user.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:32
 * @Description: app已绑定
 */
public class AppBoundDTO implements Serializable {
    private String personId;
    private String personName;
    private String logoff;
    private String logoffText;
    private String appDevice;
    private String head;
    private String deptId;
    private String deptName;
    private String email;
    private String mobileNo;
    private String pinYinCode;
    private String phoneModel;
    private Date appbindDate;
    private String appRegistPlace;
    private String appMobileSystem;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getLogoff() {
        return logoff;
    }

    public void setLogoff(String logoff) {
        this.logoff = logoff;
    }

    public String getLogoffText() {
        return logoffText;
    }

    public void setLogoffText(String logoffText) {
        this.logoffText = logoffText;
    }

    public String getAppDevice() {
        return appDevice;
    }

    public void setAppDevice(String appDevice) {
        this.appDevice = appDevice;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public Date getAppbindDate() {
        return appbindDate;
    }

    public void setAppbindDate(Date appbindDate) {
        this.appbindDate = appbindDate;
    }

    public String getAppRegistPlace() {
        return appRegistPlace;
    }

    public void setAppRegistPlace(String appRegistPlace) {
        this.appRegistPlace = appRegistPlace;
    }

    public String getAppMobileSystem() {
        return appMobileSystem;
    }

    public void setAppMobileSystem(String appMobileSystem) {
        this.appMobileSystem = appMobileSystem;
    }
}
