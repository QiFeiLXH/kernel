package com.bsoft.workflow.condition;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色查询参数
 */
public class GroupRoleQueryCnd {
    /** 输入内容*/
    private String inputContent;
    /** 页码*/
    private Integer pageNo;
    /** 每页条数*/
    private Integer pageSize;

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
}
