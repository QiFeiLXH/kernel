package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 11:55
 * @Description: 采购合同列表DTO
 */
public class PurchaseContractViewDTO implements Serializable {
    /** id */
    private Integer id;
    /** oa流水号 */
    private String oalsh;
    /** 申请人工号 */
    private String applyer;
    /** 申请人姓名 */
    private String applyerText;
    /** 申请日期 */
    private Date applyDate;
    /** 签订人工号 */
    private String signer;
    /** 签订人姓名 */
    private String signerText;
    /** 采购性质 */
    private Integer purchaseNature;
    /** 采购性质文本 */
    private String purchaseNatureText;
    /** 采购合同 */
    private String purchaseContractNo;
    /** 供货商id */
    private Integer suppliers;
    /** 供货商名字 */
    private String suppliersText;
    /** 采购金额 */
    private Double totalAmount;
    /** 完结标志 */
    private Integer endMark;
    /** 产品名称 */
    private String productName;
    /** 合同号 */
    private String contractNo;
    /** 已付金额 */
    private Double payAmount;
    /** 申请部门id */
    private String applyDept;
    /** 申请部门名称 */
    private String applyDeptName;
    /** 项目id */
    private String projectId;
    /** 项目名称 */
    private String projectName;
    /** 核算部门id */
    private String accountDept;
    /** 核算部门名称 */
    private String accountDeptName;
    /** 核算口径归属 */
    private Integer accountCaliber;
    /** 核算口径归属文本 */
    private String accountCaliberText;
    /** 备注信息 */
    private String remarks;
    /** 签订日期 */
    private Date signDate;
    /** 采购合同原件标志 */
    private Integer originalStatus;
    /** 外包过单点 */
    private String outpoint;
    /** 过单金额 */
    private Double excessAmount;
    /** 备案金额 */
    private Double recordAmount;
    /** 备案供货商 */
    private String recordSupplier;
    /** 签定部门 */
    private String signDept;
    /** 签定部门名称 */
    private String signDeptName;
    private String contractName;
    private Integer payee;
    /** 采购合同号 */
    private Integer purchaseContractId;
    /** 采购内容id */
    private Integer productId;
    /** 合同编号 */
    private String contractId;
    /** 决算金额 */
    private Double finalCostAmount;
    /** 审核状态 */
    private Integer status;
    private String statusText;
    /** 合同进度 */
    private Double progress;
    /** 合同确认日期 */
    private Date confirmDate;
    /** 合同分类 */
    private Integer classification;
    /** 有无合同 */
    private Integer hasContract;
    private String hasContractText;
    /** 采购大类 */
    private Integer flag;
    /** 补充协议标志 */
    private Integer supplementFlag;
    /** 原合同id */
    private Integer originalContractId;
    /** 本期发放金额 */
    private Double issueAmount;
    /** 变更标志 */
    private Integer alterFlag;
    /** 变更金额 */
    private Double alterAmount;
    /** 变更记录id */
    private Integer modifyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOalsh() {
        return oalsh;
    }

    public void setOalsh(String oalsh) {
        this.oalsh = oalsh;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplyerText() {
        return applyerText;
    }

    public void setApplyerText(String applyerText) {
        this.applyerText = applyerText;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getSignerText() {
        return signerText;
    }

    public void setSignerText(String signerText) {
        this.signerText = signerText;
    }

    public Integer getPurchaseNature() {
        return purchaseNature;
    }

    public void setPurchaseNature(Integer purchaseNature) {
        this.purchaseNature = purchaseNature;
    }

    public String getPurchaseNatureText() {
        return purchaseNatureText;
    }

    public void setPurchaseNatureText(String purchaseNatureText) {
        this.purchaseNatureText = purchaseNatureText;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo;
    }

    public Integer getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Integer suppliers) {
        this.suppliers = suppliers;
    }

    public String getSuppliersText() {
        return suppliersText;
    }

    public void setSuppliersText(String suppliersText) {
        this.suppliersText = suppliersText;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getEndMark() {
        return endMark;
    }

    public void setEndMark(Integer endMark) {
        this.endMark = endMark;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAccountDept() {
        return accountDept;
    }

    public void setAccountDept(String accountDept) {
        this.accountDept = accountDept;
    }

    public String getAccountDeptName() {
        return accountDeptName;
    }

    public void setAccountDeptName(String accountDeptName) {
        this.accountDeptName = accountDeptName;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public String getAccountCaliberText() {
        return accountCaliberText;
    }

    public void setAccountCaliberText(String accountCaliberText) {
        this.accountCaliberText = accountCaliberText;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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

    public Double getRecordAmount() {
        return recordAmount;
    }

    public void setRecordAmount(Double recordAmount) {
        this.recordAmount = recordAmount;
    }

    public String getRecordSupplier() {
        return recordSupplier;
    }

    public void setRecordSupplier(String recordSupplier) {
        this.recordSupplier = recordSupplier;
    }

    public String getSignDept() {
        return signDept;
    }

    public void setSignDept(String signDept) {
        this.signDept = signDept;
    }

    public String getSignDeptName() {
        return signDeptName;
    }

    public void setSignDeptName(String signDeptName) {
        this.signDeptName = signDeptName;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Integer getPayee() {
        return payee;
    }

    public void setPayee(Integer payee) {
        this.payee = payee;
    }

    public Integer getPurchaseContractId() {
        return purchaseContractId;
    }

    public void setPurchaseContractId(Integer purchaseContractId) {
        this.purchaseContractId = purchaseContractId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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

    public Integer getHasContract() {
        return hasContract;
    }

    public void setHasContract(Integer hasContract) {
        this.hasContract = hasContract;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getHasContractText() {
        return hasContractText;
    }

    public void setHasContractText(String hasContractText) {
        this.hasContractText = hasContractText;
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

    public Double getIssueAmount() {
        return issueAmount;
    }

    public void setIssueAmount(Double issueAmount) {
        this.issueAmount = issueAmount;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }
}
