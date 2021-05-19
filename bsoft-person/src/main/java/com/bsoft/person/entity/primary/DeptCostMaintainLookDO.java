package com.bsoft.person.entity.primary;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/3/16 14:52
 * @Description:
 */
public class DeptCostMaintainLookDO {
    private  String personId;
    /**岗位大类*/
    private  Integer postType;
    /**财务大类*/
    private  Integer financialTypeAfter;
    /**部门*/
    private  String dept;
    /**类型*/
    private  Integer type;
    /**調整時間*/
    private Date adjustDate;

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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
}
