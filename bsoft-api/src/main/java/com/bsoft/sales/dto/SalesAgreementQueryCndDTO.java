package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/1 13:13
 * @Description
 */
public class SalesAgreementQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 每页条数 */
    private Integer pageSize;
    /** 合作单位名称、拼音 */
    private String partnerName;
    /** 是否披露 */
    private Integer notice;
    /** 合作类别 */
    private Integer cooperateType;
    /** 原件状态 */
    private Integer originalStatus;
    /** 合作开始日期 */
    private Date startDate;
    /** 合作结束日期 */
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

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    public Integer getCooperateType() {
        return cooperateType;
    }

    public void setCooperateType(Integer cooperateType) {
        this.cooperateType = cooperateType;
    }

    public Integer getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(Integer originalStatus) {
        this.originalStatus = originalStatus;
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

}
