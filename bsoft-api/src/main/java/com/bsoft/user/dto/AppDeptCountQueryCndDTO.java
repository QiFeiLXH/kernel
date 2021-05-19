package com.bsoft.user.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户部门分布情况查询条件
 */
public class AppDeptCountQueryCndDTO implements Serializable {
    // 部门类别
    private Integer deptType;
    // 分页参数
    private Integer pageNo;
    // 分页参数
    private Integer pageSize;

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
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
