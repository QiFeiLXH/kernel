package com.bsoft.person.dto;

import java.io.Serializable;

public class FamilyPersonInfoViewDTO implements Serializable {
    private Integer id;
    private Integer zpid;
    private Integer appellation;
    private String appellationText;
    private String name;
    private Integer age;
    private String company;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZpid() {
        return zpid;
    }

    public void setZpid(Integer zpid) {
        this.zpid = zpid;
    }

    public Integer getAppellation() {
        return appellation;
    }

    public void setAppellation(Integer appellation) {
        this.appellation = appellation;
    }

    public String getAppellationText() {
        return appellationText;
    }

    public void setAppellationText(String appellationText) {
        this.appellationText = appellationText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
