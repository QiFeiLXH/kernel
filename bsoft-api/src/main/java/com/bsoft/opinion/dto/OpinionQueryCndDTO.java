package com.bsoft.opinion.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/8/5 15:14
 * @Description: 意见查询条件
 */
public class OpinionQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 每页条数 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 状态 */
    private Integer status;
    /** 系统 */
    private Integer system;

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

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
