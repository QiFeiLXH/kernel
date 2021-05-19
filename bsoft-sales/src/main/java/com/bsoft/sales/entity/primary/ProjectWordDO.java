package com.bsoft.sales.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/30 10:01
 * @Description: 文档信息
 */
@Table(name = "bsoftmis.wd_wdxx")
@Entity
public class ProjectWordDO {
    private Integer id;
    private Integer documentId;
    private String contractId;
    private String projectId;
    private Integer documentCount;
    private Integer receivingFlag;
    private String receiver;
    private Date receivingDate;
    private String receivingRemarks;
    private Integer receivingNumber;
    private Integer filingFlag;
    private String archivist;
    private Date filingDate;
    private Integer filingNumber;
    private String filingRemarks;
    private Integer biddingId;
    private Integer reviewId;
    private Integer status;
    @Id
    @Column(name="jlid")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="wdid")
    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }
    @Column(name="htbh")
    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
    @Column(name="xmid")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    @Column(name="wdsl")
    public Integer getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(Integer documentCount) {
        this.documentCount = documentCount;
    }
    @Column(name = "yjjs")
    public Integer getReceivingFlag() {
        return receivingFlag;
    }

    public void setReceivingFlag(Integer receivingFlag) {
        this.receivingFlag = receivingFlag;
    }
    @Column(name = "yjjsry")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    @Column(name = "yjjssj")
    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }
    @Column(name = "yjjsbz")
    public String getReceivingRemarks() {
        return receivingRemarks;
    }

    public void setReceivingRemarks(String receivingRemarks) {
        this.receivingRemarks = receivingRemarks;
    }
    @Column(name = "yjjssl")
    public Integer getReceivingNumber() {
        return receivingNumber;
    }

    public void setReceivingNumber(Integer receivingNumber) {
        this.receivingNumber = receivingNumber;
    }
    @Column(name = "gdjs")
    public Integer getFilingFlag() {
        return filingFlag;
    }

    public void setFilingFlag(Integer filingFlag) {
        this.filingFlag = filingFlag;
    }
    @Column(name = "gdjsry")
    public String getArchivist() {
        return archivist;
    }

    public void setArchivist(String archivist) {
        this.archivist = archivist;
    }
    @Column(name = "gdjssj")
    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }
    @Column(name = "gdjssl")
    public Integer getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(Integer filingNumber) {
        this.filingNumber = filingNumber;
    }
    @Column(name = "gdjsbz")
    public String getFilingRemarks() {
        return filingRemarks;
    }

    public void setFilingRemarks(String filingRemarks) {
        this.filingRemarks = filingRemarks;
    }
    @Column(name = "tbid")
    public Integer getBiddingId() {
        return biddingId;
    }

    public void setBiddingId(Integer biddingId) {
        this.biddingId = biddingId;
    }
    @Column(name = "psid")
    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
