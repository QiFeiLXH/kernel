package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lkh
 * @date: 2020/12/23
 * @description 人员财物维护
 */
public class PersonFinancialViewDTO implements Serializable {

    //工号
    private String personId;
    //部门
    private String dept;
    //部门名称
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    //姓名
    private String xusName;
    //岗位大类
    private Integer postType;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    //岗位大类名字
    private String postName;

    //现财务类别
    private Integer financialTypeNow;

    //现财务类别名称
    private String financialNameNow;

    //调整后财务类别
    private Integer financialTypeAfter;
    //调整年月
    private Date adjustDate;
    //1按部门 2按岗位 3.特殊维护
    private Integer type;

    //传入查询的财务类别
    private Integer financialTypeFind;
    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;
    // 离职标志 1 已离职
    private Integer flag;

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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public Integer getFinancialTypeFind() {
        return financialTypeFind;
    }

    public void setFinancialTypeFind(Integer financialTypeFind) {
        this.financialTypeFind = financialTypeFind;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getFinancialNameNow() {
        return financialNameNow;
    }

    public void setFinancialNameNow(String financialNameNow) {
        this.financialNameNow = financialNameNow;
    }
}
