package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 每月新入职员工信息
 */
@Entity
@Table(name="hr_new_entry_person_view")
public class NewEntryPersonInfoDO {
    /**
     * 工号
     */
    private String personId;
    /**
     * 姓名
     */
    private String personName;
    /**
     * 姓名简拼
     */
    private String pinyin;

    /**
     * 部门
     */
    private String deptName;
    /**
     * 部门编号
     */
    private String deptNo;

    /**
     * 报到日期
     */
    private Date startDate;
    /**
     * 到职日期
     */
    private Date entryDate;
    /**
     * 所属公司
     */
    private Integer company;
    /**
     * 所属公司
     */
    private String companyText;
    /**
     * 社保缴纳地
     */
    private Integer placeId;
    /**
     * 社保缴纳地
     */
    private String place;
    /**
     *社保缴纳基数
     */
    private Double paymentBase;
    /**
     * 实习薪资
     */
    private Double internshipSalary;
    /**
     * 试用期薪资
     */
    private Double probationSalary;
    /**
     * 转正薪资
     */
    private Double regularSalary;
    /**
     * 转正日期
     */
    private Date regularDate;

    /**
     * 0在职  1离职
     * @return
     */
    private Integer flag;




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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getCompanyText() {
        return companyText;
    }

    public void setCompanyText(String companyText) {
        this.companyText = companyText;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getPaymentBase() {
        return paymentBase;
    }

    public void setPaymentBase(Double paymentBase) {
        this.paymentBase = paymentBase;
    }

    public Double getInternshipSalary() {
        return internshipSalary;
    }

    public void setInternshipSalary(Double internshipSalary) {
        this.internshipSalary = internshipSalary;
    }

    public Double getProbationSalary() {
        return probationSalary;
    }

    public void setProbationSalary(Double probationSalary) {
        this.probationSalary = probationSalary;
    }

    public Double getRegularSalary() {
        return regularSalary;
    }

    public void setRegularSalary(Double regularSalary) {
        this.regularSalary = regularSalary;
    }

    public Date getRegularDate() {
        return regularDate;
    }

    public void setRegularDate(Date regularDate) {
        this.regularDate = regularDate;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
