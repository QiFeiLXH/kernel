package com.bsoft.hr.entity.primary;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="HR_FEE_RULES_RECORD")
public class PersonFinancialMaintainDO {
    //ID
    @Id
    private Integer id;
    //工号
    private String personId;
    //部门
    private String dept;
    //岗位大类
    private Integer postType;
    //现财务类别
    private Integer financialTypeNow;
    //调整后财务类别
    private Integer financialTypeAfter;
    //调整年月
    private Date adjustDate;
    //1按部门 2按岗位 3.特殊维护
    private Integer type;


    //登记日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registrantionDate;

    //登记人
    private String registrant;

    public Date getRegistrantionDate() {
        return registrantionDate;
    }

    public void setRegistrantionDate(Date registrantionDate) {
        this.registrantionDate = registrantionDate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    @Id
    @SequenceGenerator(name="SEQ_HR_FEE_RULES_DEPT",allocationSize=1,sequenceName="SEQ_HR_FEE_RULES_DEPT")
    @GeneratedValue(generator="SEQ_HR_FEE_RULES_DEPT",strategy= GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public Integer getFinancialTypeNow() {
        return financialTypeNow;
    }

    public void setFinancialTypeNow(Integer financialTypeNow) {
        this.financialTypeNow = financialTypeNow;
    }

    public Integer getFinancialTypeAfter() {
        return financialTypeAfter;
    }

    public void setFinancialTypeAfter(Integer financialTypeAfter) {
        this.financialTypeAfter = financialTypeAfter;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
