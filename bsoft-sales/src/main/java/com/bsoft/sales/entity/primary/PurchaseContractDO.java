package com.bsoft.sales.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 10:18
 * @Description: 采购合同信息
 */
@Entity
@Table(name = "bsoftmis.CG_HTXX")
public class PurchaseContractDO {
    @Id
    @Column(name="htid")
    private Integer purchaseContractId;
    @Column(name = "cghth")
    private String purchaseContractNo;
    @Column(name = "qdbm")
    private String signDept;
    @Column(name = "gys")
    private Integer suppliers;
    @Column(name = "zje")
    private Double totalAmount;
    @Column(name = "yht")
    private Integer hasContract;
    @Column(name = "dycg")
    private Integer singlePurchase;
    @Column(name = "qdr")
    private String signer;
    @Column(name = "qdrq")
    private Date signDate;
    @Column(name = "bzxx")
    private String remarks;
    @Column(name = "type")
    private Integer type;
    @Column(name = "flag")
    private Integer flag;
    @Column(name = "cgxz")
    private Integer purchaseNature;
    @Column(name = "cghtyj")
    private Integer originalStatus;
    @Column(name = "wbgdd")
    private String outpoint;
    @Column(name = "gdje")
    private Double excessAmount;
    @Column(name = "wjbz")
    private Integer endMark;
    @Column(name = "htbh")
    private String contractId;
    @Column(name = "htsqid")
    private Integer applyId;
    @Column(name = "htnr")
    private String productName;
    @Column(name = "cgmxid")
    private Integer productId;
    @Column(name = "jsje")
    private Double finalCostAmount;
    @Column(name = "status")
    private Integer status;
    @Column(name = "htmc")
    private String contractName;
    @Column(name = "progress")
    private Double progress;
    @Column(name = "qrrq")
    private Date confirmDate;
    @Column(name = "classification")
    private Integer classification;
    @Column(name = "bcxybz")
    private Integer supplementFlag;
    @Column(name = "yhtid")
    private Integer originalContractId;
    @Column(name = "djr")
    private String registerPersonId;
    @Column(name = "djrq")
    private Date registerDate;
    @Column(name = "bgbz")
    private Integer alterFlag;
    @Column(name = "bgje")
    private Double alterAmount;
    private String auditter;
    private Date auditDate;
    private Integer modifyId;


    public Integer getPurchaseContractId() {
        return purchaseContractId;
    }

    public void setPurchaseContractId(Integer purchaseContractId) {
        this.purchaseContractId = purchaseContractId;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo;
    }

    public String getSignDept() {
        return signDept;
    }

    public void setSignDept(String signDept) {
        this.signDept = signDept;
    }

    public Integer getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Integer suppliers) {
        this.suppliers = suppliers;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getHasContract() {
        return hasContract;
    }

    public void setHasContract(Integer hasContract) {
        this.hasContract = hasContract;
    }

    public Integer getSinglePurchase() {
        return singlePurchase;
    }

    public void setSinglePurchase(Integer singlePurchase) {
        this.singlePurchase = singlePurchase;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getPurchaseNature() {
        return purchaseNature;
    }

    public void setPurchaseNature(Integer purchaseNature) {
        this.purchaseNature = purchaseNature;
    }

    public Integer getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(Integer originalStatus) {
        this.originalStatus = originalStatus;
    }

    public String getOutpoint() {
        return outpoint;
    }

    public void setOutpoint(String outpoint) {
        this.outpoint = outpoint;
    }

    public Double getExcessAmount() {
        return excessAmount;
    }

    public void setExcessAmount(Double excessAmount) {
        this.excessAmount = excessAmount;
    }

    public Integer getEndMark() {
        return endMark;
    }

    public void setEndMark(Integer endMark) {
        this.endMark = endMark;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getFinalCostAmount() {
        return finalCostAmount;
    }

    public void setFinalCostAmount(Double finalCostAmount) {
        this.finalCostAmount = finalCostAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public Integer getSupplementFlag() {
        return supplementFlag;
    }

    public void setSupplementFlag(Integer supplementFlag) {
        this.supplementFlag = supplementFlag;
    }

    public Integer getOriginalContractId() {
        return originalContractId;
    }

    public void setOriginalContractId(Integer originalContractId) {
        this.originalContractId = originalContractId;
    }

    public String getRegisterPersonId() {
        return registerPersonId;
    }

    public void setRegisterPersonId(String registerPersonId) {
        this.registerPersonId = registerPersonId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getAlterFlag() {
        return alterFlag;
    }

    public void setAlterFlag(Integer alterFlag) {
        this.alterFlag = alterFlag;
    }

    public Double getAlterAmount() {
        return alterAmount;
    }

    public void setAlterAmount(Double alterAmount) {
        this.alterAmount = alterAmount;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }
}
