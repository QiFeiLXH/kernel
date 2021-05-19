package com.bsoft.cost.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/11/23 11:55
 * @Description:
 */
public class SubsidyStandardQueryCndDTO implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String inputContent;
    private Integer flag;
    private Integer state;

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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
