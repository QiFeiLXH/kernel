package com.bsoft.hr.condition;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:14
 * @Description
 */
public class PersonStockQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    private String flag;
    private String inputContent;

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
