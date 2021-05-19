package com.bsoft.house.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * @author  hy
 * @date  2020/4/13 10:23
 * @description
 */
@Entity
@Table(name = "bsoft_portal.ker_house_view")
public class HouseViewDO {
    @Id
    private Integer id;
    private String name;
    private String address;
    private String addressPinyin;
    private String houseMaster;
    private String houseMasterText;
    private Integer status;
    private Integer purpose;
    @Transient
    private Integer isCommon;
    @Transient
    private Integer isOwner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressPinyin() {
        return addressPinyin;
    }

    public void setAddressPinyin(String addressPinyin) {
        this.addressPinyin = addressPinyin;
    }

    public String getHouseMaster() {
        return houseMaster;
    }

    public void setHouseMaster(String houseMaster) {
        this.houseMaster = houseMaster;
    }

    public String getHouseMasterText() {
        return houseMasterText;
    }

    public void setHouseMasterText(String houseMasterText) {
        this.houseMasterText = houseMasterText;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public Integer getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(Integer isCommon) {
        this.isCommon = isCommon;
    }

    public Integer getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Integer isOwner) {
        this.isOwner = isOwner;
    }
}
