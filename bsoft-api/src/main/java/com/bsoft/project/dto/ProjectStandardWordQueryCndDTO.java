package com.bsoft.project.dto;

import java.io.Serializable;

/**
 * @Author zhanglf
 * @Date 2020-04-14 11:26
 * @Version 1.0
 * @Description
 */
public class ProjectStandardWordQueryCndDTO implements Serializable{
    private Integer pageNo;
    private Integer pageSize;
    private Integer stage;

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

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }
}
