package com.bsoft.cost.condition;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 10:31
 * @Description
 */
public class InvoiceRecordQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 部门id */
    private String deptId;
    /** 开票标志 */
    private Integer invoiceFlag;
    /** 输入内容 */
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getInvoiceFlag() {
        return invoiceFlag;
    }

    public void setInvoiceFlag(Integer invoiceFlag) {
        this.invoiceFlag = invoiceFlag;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
