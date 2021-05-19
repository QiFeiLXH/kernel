package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bsoftmis.T_JTQK_VIEW")
public class FamilyPersonViewDO {
    private Integer id;
    private Integer zpid;
    private Integer appellation;
    private String appellationText;
    private String name;
    private Integer age;
    private String company;
    private String phone;

    @Id
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

    @Column(name = "jtcw")
    public Integer getAppellation() {
        return appellation;
    }

    public void setAppellation(Integer appellation) {
        this.appellation = appellation;
    }

    @Column(name = "xm")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "nl")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "gzdw")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "lxdh")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "jtcwText")
    public String getAppellationText() {
        return appellationText;
    }

    public void setAppellationText(String appellationText) {
        this.appellationText = appellationText;
    }
}
