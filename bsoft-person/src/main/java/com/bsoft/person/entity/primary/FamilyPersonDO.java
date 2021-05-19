package com.bsoft.person.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bsoftmis.T_JTQK")
public class FamilyPersonDO {
    private Integer id;
    private Integer zpid;
    private Integer appellation;
    @Length(max = 15,message = "姓名长度不能超过15位")
    private String name;
    private Integer age;
    @Length(max = 15,message = "工作单位长度不能超过15位")
    private String company;
    @Length(max = 15,message = "联系电话长度不能超过15位")
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
}
