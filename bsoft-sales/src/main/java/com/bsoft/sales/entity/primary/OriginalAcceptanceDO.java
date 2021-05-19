package com.bsoft.sales.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 15:06
 * @Description: 合同原件接收、归档DO
 */
@Entity
@Table(name = "HT_REVIEW_WORDRECEPTION_VIEW")
public class OriginalAcceptanceDO {
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

    /**
     * 记录ID
     * @return
     */
    @Id
    @Column(name = "JLID")
    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * 文档ID
     * @return
     */
    @Column(name = "WDID")
    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    /**
     * 文档名称
     * @return
     */
    @Column(name = "WDMC")
    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * 文档数量
     * @return
     */
    @Column(name = "WDSL")
    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    /**
     * 新文档数量
     * @return
     */
//    @Column(name = "NEWWDSL")
    @Transient
    public Integer getNewDocumentNumber() {
        return newDocumentNumber;
    }

    public void setNewDocumentNumber(Integer newDocumentNumber) {
        this.newDocumentNumber = newDocumentNumber;
    }

    /**
     * 原件接收标志
     * @return
     */
    @Column(name = "YJJS")
    public Integer getReceivingFlag() {
        return receivingFlag;
    }

    public void setReceivingFlag(Integer receivingFlag) {
        this.receivingFlag = receivingFlag;
    }

    /**
     * 原件接收数量
     * @return
     */
    @Column(name = "YJJSSL")
    public Integer getReceivingNumber() {
        return receivingNumber;
    }

    public void setReceivingNumber(Integer receivingNumber) {
        this.receivingNumber = receivingNumber;
    }

    /**
     * 原件接收人员
     * @return
     */
    @Column(name = "YJJSRY")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 原件接收人姓名
     * @return
     */
    @Column(name = "YJJSRYTEXT")
    public String getReceiverText() {
        return receiverText;
    }

    public void setReceiverText(String receiverText) {
        this.receiverText = receiverText;
    }

    /**
     * 原件接收时间
     * @return
     */
    @Column(name = "YJJSSJ")
    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    /**
     * 原件接收备注
     * @return
     */
    @Column(name = "YJJSBZ")
    public String getReceivingRemarks() {
        return receivingRemarks;
    }

    public void setReceivingRemarks(String receivingRemarks) {
        this.receivingRemarks = receivingRemarks;
    }

    /**
     * 归档接收标志
     * @return
     */
    @Column(name = "GDJS")
    public Integer getFilingFlag() {
        return filingFlag;
    }

    public void setFilingFlag(Integer filingFlag) {
        this.filingFlag = filingFlag;
    }

    /**
     * 归档接收数量
     * @return
     */
    @Column(name = "GDJSSL")
    public Integer getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(Integer filingNumber) {
        this.filingNumber = filingNumber;
    }

    /**
     * 归档接收人员
     * @return
     */
    @Column(name = "GDJSRY")
    public String getArchivist() {
        return archivist;
    }

    public void setArchivist(String archivist) {
        this.archivist = archivist;
    }

    /**
     * 归档接收人员姓名
     * @return
     */
    @Column(name = "GDJSRYTEXT")
    public String getArchivistText() {
        return archivistText;
    }

    public void setArchivistText(String archivistText) {
        this.archivistText = archivistText;
    }

    /**
     * 归档接收时间
     * @return
     */
    @Column(name = "GDJSSJ")
    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    /**
     * 归档接收备注
     * @return
     */
    @Column(name = "GDJSBZ")
    public String getFilingRemarks() {
        return filingRemarks;
    }

    public void setFilingRemarks(String filingRemarks) {
        this.filingRemarks = filingRemarks;
    }

    /**
     * 原件审核阶段 1合同评审接收；2财务接收；3财务归档；4法务接收
     * @return
     */
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 合同编号
     * @return
     */
    @Column(name = "CONTRACTNO")
    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    /**
     * 合同名称
     * @return
     */
    @Column(name = "HTMC")
    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    /**
     * 合同额
     * @return
     */
    @Column(name = "HTE")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 签订人
     * @return
     */
    @Column(name = "QDRY")
    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    /**
     * 签订人姓名
     * @return
     */
    @Column(name = "QDRYTEXT")
    public String getSignatoryText() {
        return signatoryText;
    }

    public void setSignatoryText(String signatoryText) {
        this.signatoryText = signatoryText;
    }

    /**
     * 签订日期
     * @return
     */
    @Column(name = "QDRQ")
    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * 合同评审人
     * @return
     */
    @Column(name = "HTPSRY")
    public String getContractReviewer() {
        return contractReviewer;
    }

    public void setContractReviewer(String contractReviewer) {
        this.contractReviewer = contractReviewer;
    }

    /**
     * 合同评审人姓名
     * @return
     */
    @Column(name = "HTPSRYTEXT")
    public String getContractReviewerText() {
        return contractReviewerText;
    }

    public void setContractReviewerText(String contractReviewerText) {
        this.contractReviewerText = contractReviewerText;
    }

    /**
     * 市场区域
     * @return
     */
    @Column(name = "SSQY")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 市场区域名称
     * @return
     */
    @Column(name = "SSQYTEXT")
    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    /**
     * 拼音码
     * @return
     */
    @Column(name = "pym")
    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    /**
     * 客户名称
     * @return
     */
    @Column(name = "khmc")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
