package com.bsoft.payment.condition;

import java.util.Date;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.administration.condition
 * @Author: Qi fei
 * @CreateTime: 2020-07-26 10:12
 * @Description:
 */
public class FlowPaymentQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 每页条数 */
    private Integer pageSize;
    /** 1.流水  2.收益 */
    private Integer flag;
    /** 审核标记 */
    private Integer auditFlag;
    /** 类别 */
    private Integer type;
    /** 业务条线 */
    private Integer businessLine;
    /** 所属区域 */
    private String parentDeptId;
    /** 登记开始日期 */
    private Date startDate;
    /** 登记结束日期 */
    private Date endDate;

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

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(Integer businessLine) {
        this.businessLine = businessLine;
    }

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
