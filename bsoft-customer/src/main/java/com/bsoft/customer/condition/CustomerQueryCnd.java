package com.bsoft.customer.condition;

/**
 * @author: zy
 * @date: 2020/12/7
 * @description 客户基本信息查询参数
 */
public class CustomerQueryCnd {
    private String inputContent;
    private Integer pageNo;
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
