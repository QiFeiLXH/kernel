package com.bsoft.user.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/8/6 18:36
 * @Description: 人员联系信息bean
 */
@Entity
@Table(name = "bsoftmis.PERSON_CONTACT")
public class PersonContactDO {
    private String personid;
    private String email;
    private String mobileno;
    private String officePhone;
    private String phoneModel;//最新App绑定手机型号
    private Date appbindDate;//最新App绑定时间
    private String appRegistPlace;//最新App绑定位置
    private String appMobileSystem;//最新App绑定手机系统
    private String appRegistLongitude;//最新App绑定位置经度
    private String appRegistLatitude;//最新App绑定位置纬度

    @Id
    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
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

    public String getAppRegistLongitude() {
        return appRegistLongitude;
    }

    public void setAppRegistLongitude(String appRegistLongitude) {
        this.appRegistLongitude = appRegistLongitude;
    }

    public String getAppRegistLatitude() {
        return appRegistLatitude;
    }

    public void setAppRegistLatitude(String appRegistLatitude) {
        this.appRegistLatitude = appRegistLatitude;
    }
}
