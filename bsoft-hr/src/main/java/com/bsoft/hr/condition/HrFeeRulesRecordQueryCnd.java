package com.bsoft.hr.condition;

import java.io.Serializable;

/**
 * @author: lkh
 * @date: 2020/12/23
 * @description 人员财物维护
 */
public class HrFeeRulesRecordQueryCnd implements Serializable {

    //工号
    private String personId;
    //部门
    private String dept;

    //姓名
    private String xusName;

    //岗位大类
    private Integer postType;

    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;

//
//    //现财务类别
//    private Integer financialTypeNow;
//
//    //现财务类别名称
//    private String financialNameNow;
//
//    //调整后财务类别
//    private Integer financialTypeAfter;
//    //调整年月
//    private Date adjustDate;
//    //1按部门 2按岗位 3.特殊维护
//    private Integer type;


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
}


