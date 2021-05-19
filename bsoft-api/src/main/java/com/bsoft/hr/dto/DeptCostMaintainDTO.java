package com.bsoft.hr.dto;


import java.io.Serializable;
import java.util.Date;


/**
 * @author: LKH
 * @date: 2020/12/15
 * @description 岗位费用默认规则
 */
public class DeptCostMaintainDTO implements Serializable {
    private  Integer id;
    private  Integer postType;
    private  String  postName;
    private  Integer financialType;
    private  String  financialName;
    private  String  dept;
    private  Integer type;
    private  Date adjustDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getFinancialType() {
        return financialType;
    }

    public void setFinancialType(Integer financialType) {
        this.financialType = financialType;
    }

    public String getFinancialName() {
        return financialName;
    }

    public void setFinancialName(String financialName) {
        this.financialName = financialName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }
}
