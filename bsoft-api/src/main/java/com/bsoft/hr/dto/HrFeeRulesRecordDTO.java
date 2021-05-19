package com.bsoft.hr.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * @author: lkh
 * @date: 2020/12/23
 * @description 人员财物维护
 */
public class HrFeeRulesRecordDTO implements Serializable {

    //主键
    private String Id;
    //工号
    private String personId;
    //部门
    private String dept;
    //部门名称
    private String deptName;

    //姓名
    private String xusName;

    //岗位大类
    private Integer postType;

    //现财务类别
    private Integer financialTypeNow;

    //现财务类别名称
    private String financialNameNow;

    //调整后财务类别
    private Integer financialTypeAfter;

    //调整后财务类别名称
    private String financialNameAfter;

    //调整年月
    private Date adjustDate;
    //1按部门 2按岗位 3.特殊维护
    private Integer type;

    //登记日期
    private Date registrantionDate;

    //登记人
    private String registrant;

    //登记人姓名
    private String registrantName;

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

    public String getRegistrantName() {
        return registrantName;
    }

    public void setRegistrantName(String registrantName) {
        this.registrantName = registrantName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFinancialNameAfter() {
        return financialNameAfter;
    }

    public void setFinancialNameAfter(String financialNameAfter) {
        this.financialNameAfter = financialNameAfter;
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

    public String getXusName() {
        return xusName;
    }

    public void setXusName(String xusName) {
        this.xusName = xusName;
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


    public String getFinancialNameNow() {
        return financialNameNow;
    }

    public void setFinancialNameNow(String financialNameNow) {
        this.financialNameNow = financialNameNow;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
