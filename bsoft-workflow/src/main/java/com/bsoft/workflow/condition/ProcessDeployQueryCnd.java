package com.bsoft.workflow.condition;

public class ProcessDeployQueryCnd {
    /** 输入内容 */
    private String inputContent;
    /** 页码 */
    private Integer pageNo;
    /** 每页数量 */
    private Integer pageSize;
    /** 部署状态*/
    private Integer status;
    /* 流程类别*/
    private Integer type;

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
