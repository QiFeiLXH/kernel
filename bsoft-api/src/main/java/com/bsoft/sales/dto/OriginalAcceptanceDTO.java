package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 15:55
 * @Description: 合同原件接归档DTO
 */
public class OriginalAcceptanceDTO implements Serializable {
    private Integer recordId;
    private Integer documentId;
    private String documentName;
    private Integer documentNumber;
    private Integer newDocumentNumber;
    private Integer receivingFlag;
    private Integer receivingNumber;
    private String receiver;
    private String receiverText;
    private Date receivingDate;
    private String receivingRemarks;
    private Integer filingFlag;
    private Integer filingNumber;
    private String archivist;
    private String archivistText;
    private Date filingDate;
    private String filingRemarks;
    private Integer status;
    private String contractno;
    private String contractName;
    private Double money;
    private String signatory;
    private String signatoryText;
    private Date signDate;
    private String contractReviewer;
    private String contractReviewerText;
    private String area;
    private String areaText;
    private String pinYinCode;
    private String customerName;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getReceivingFlag() {
        return receivingFlag;
    }

    public void setReceivingFlag(Integer receivingFlag) {
        this.receivingFlag = receivingFlag;
    }

    public Integer getReceivingNumber() {
        return receivingNumber;
    }

    public void setReceivingNumber(Integer receivingNumber) {
        this.receivingNumber = receivingNumber;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverText() {
        return receiverText;
    }

    public void setReceiverText(String receiverText) {
        this.receiverText = receiverText;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getReceivingRemarks() {
        return receivingRemarks;
    }

    public void setReceivingRemarks(String receivingRemarks) {
        this.receivingRemarks = receivingRemarks;
    }

    public Integer getFilingFlag() {
        return filingFlag;
    }

    public void setFilingFlag(Integer filingFlag) {
        this.filingFlag = filingFlag;
    }

    public Integer getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(Integer filingNumber) {
        this.filingNumber = filingNumber;
    }

    public String getArchivist() {
        return archivist;
    }

    public void setArchivist(String archivist) {
        this.archivist = archivist;
    }

    public String getArchivistText() {
        return archivistText;
    }

    public void setArchivistText(String archivistText) {
        this.archivistText = archivistText;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public String getFilingRemarks() {
        return filingRemarks;
    }

    public void setFilingRemarks(String filingRemarks) {
        this.filingRemarks = filingRemarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public String getSignatoryText() {
        return signatoryText;
    }

    public void setSignatoryText(String signatoryText) {
        this.signatoryText = signatoryText;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getContractReviewer() {
        return contractReviewer;
    }

    public void setContractReviewer(String contractReviewer) {
        this.contractReviewer = contractReviewer;
    }

    public String getContractReviewerText() {
        return contractReviewerText;
    }

    public void setContractReviewerText(String contractReviewerText) {
        this.contractReviewerText = contractReviewerText;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getNewDocumentNumber() {
        return newDocumentNumber;
    }

    public void setNewDocumentNumber(Integer newDocumentNumber) {
        this.newDocumentNumber = newDocumentNumber;
    }
}
