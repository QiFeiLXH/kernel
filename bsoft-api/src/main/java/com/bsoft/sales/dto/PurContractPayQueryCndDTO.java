package com.bsoft.sales.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 14:58
 * @Description: 支付信息查询条件DTO
 */
public class PurContractPayQueryCndDTO implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private Integer htid;

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

    public Integer getHtid() {
        return htid;
    }

    public void setHtid(Integer htid) {
        this.htid = htid;
    }
}
