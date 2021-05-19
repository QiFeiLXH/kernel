package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.sales.entity
 * @Author: Xuhui Lin
 */
public class SalesPartnerViewDTO implements Serializable {
    private Integer id;
    /** 合作单位名称 */
    private String partnerName;
    /** 地址 */
    private String address;
    /** 联系电话 */
    private String phone;
    /** 登记日期 */
    private Date registerDate;
    /** 联系人 */
    private String contactPerson;
    /** 省 */
    private Integer province;
    private String provinceText;
    /** 市 */
    private Integer city;
    private String cityText;
    /** 县 */
    private Integer county;
    private String countyText;
    /** 省市县+地址 */
    private String stitchingAddress;
    /** 是否已有协议选择该合作单位*/
    private Integer hasAgreement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getProvinceText() {
        return provinceText;
    }

    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getCountyText() {
        return countyText;
    }

    public void setCountyText(String countyText) {
        this.countyText = countyText;
    }

    public String getStitchingAddress() {
        return stitchingAddress;
    }

    public void setStitchingAddress(String stitchingAddress) {
        this.stitchingAddress = stitchingAddress;
    }

    public Integer getHasAgreement() {
        return hasAgreement;
    }

    public void setHasAgreement(Integer hasAgreement) {
        this.hasAgreement = hasAgreement;
    }
}
