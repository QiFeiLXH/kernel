package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:20
 * @Description
 */
public class LactationQueryCndDTO implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String inputContent;
    private List<Integer> status;

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

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }
}
