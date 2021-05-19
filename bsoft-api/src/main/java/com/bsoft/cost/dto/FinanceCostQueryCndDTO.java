package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-05-26 9:53
 * @Version 1.0
 * @Description
 */
public class FinanceCostQueryCndDTO implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private Integer signYear;
    private Date signDateStart;
    private Date signDateEnd;
    private Date costDateStart;
    private Date costDateEnd;
    private Integer finishFlag;
    private Integer flag;
    private Integer paymentFlag;
    private String projectName;

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

    public Integer getSignYear() {
        return signYear;
    }

    public void setSignYear(Integer signYear) {
        this.signYear = signYear;
    }

    public Date getSignDateStart() {
        return signDateStart;
    }

    public void setSignDateStart(Date signDateStart) {
        this.signDateStart = signDateStart;
    }

    public Date getSignDateEnd() {
        return signDateEnd;
    }

    public void setSignDateEnd(Date signDateEnd) {
        this.signDateEnd = signDateEnd;
    }

    public Date getCostDateStart() {
        return costDateStart;
    }

    public void setCostDateStart(Date costDateStart) {
        this.costDateStart = costDateStart;
    }

    public Date getCostDateEnd() {
        return costDateEnd;
    }

    public void setCostDateEnd(Date costDateEnd) {
        this.costDateEnd = costDateEnd;
    }

    public Integer getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(Integer finishFlag) {
        this.finishFlag = finishFlag;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(Integer paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
