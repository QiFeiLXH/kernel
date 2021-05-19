package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HR_PERSON_FINANCIALTYPE_VIEW")
public class PersonFinancialViewDO {

    //工号
    @Id
    private String personId;
    //部门
    @Column(name="xdno")
    private String dept;
    //姓名
    @Column(name="xusName")
    private String xusName;
    //岗位大类
    @Column(name="gwdl")
    private Integer postType;
    //现财务类别
    @Column(name="financialTypeNow")
    private Integer financialTypeNow;
//    //调整后财务类别
//    @Column(name="financialTypeAfter")
//    private Integer financialTypeAfter;
//    //调整年月
//    @Column(name="adjustDate")
//    private Date adjustDate;
    //离职状态   1 已离职
    @Column(name="flag")
    private Integer flag;

    //部门名称
    @Column(name="bmmc")
    private String deptName;
//    //1按部门 2按岗位 3.特殊维护
//    @Column(name="type")
//    private Integer type;


    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
//
//    public Integer getFinancialTypeAfter() {
//        return financialTypeAfter;
//    }
//
//    public void setFinancialTypeAfter(Integer financialTypeAfter) {
//        this.financialTypeAfter = financialTypeAfter;
//    }
//
//    public Date getAdjustDate() {
//        return adjustDate;
//    }
//
//    public void setAdjustDate(Date adjustDate) {
//        this.adjustDate = adjustDate;
//    }
}
