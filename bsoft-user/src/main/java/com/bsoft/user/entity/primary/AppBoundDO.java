package com.bsoft.user.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:29
 * @Description: 已绑定APP用户bean
 */
@Entity
@Table(name = "person_appbound_view")
public class AppBoundDO {
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

    @Id
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
