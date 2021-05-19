package com.bsoft.house.dto;


import java.io.Serializable;

public class  HouseDTO implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private String houseMaster;
    private String houseMasterText;
    private Integer isCommon;
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
