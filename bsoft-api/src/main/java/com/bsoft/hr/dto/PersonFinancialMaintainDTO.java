package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/12/23
 * @description 人员财物维护
 */
public class PersonFinancialMaintainDTO implements Serializable {
    //ID
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

    //传入查询的财务类别
    private Integer financialTypeFind;
    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;

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
}
