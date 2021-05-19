package com.bsoft.hr.dto;

import com.bsoft.common.service.ServerDateService;

import java.io.Serializable;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/14
 * @description 劳动合同查询参数
 */
public class LaborContractQueryCndDTO implements Serializable {
    /** 工号*/
    private String personId;
    /** 部门*/
    private String dept;
    /** 离职标志0未离职1已离职*/
    private String flag;
    /** 页码*/
    private Integer pageNo;
    /** 每页条目*/
    private Integer pageSize;

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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
