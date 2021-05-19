package com.bsoft.sales.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/16 9:03
 * @Description
 */
@Entity
@Table(name="bsoft_portal.sales_contract_view")
public class SalesContractViewDO {
    @Id
    /** 合同编号 */
    private String contractId;
    /** 合同号 */
    private String contractNo;
    /** 合同名称 */
    private String contractName;
    /** 合同金额 */
    private Double contractAmount;
    /** 跟单人 */
    private String merchandiser;
    /** 跟单人姓名 */
    private String merchandiserName;
    /** 签定人员 */
    private String signer;
    /** 跟单人简拼 */
    private String simpleCode;
    /** 签定日期 */
    private Date signDate;
    /** 考核日期 */
    private Date assessmentDate;
    /** 销售区域 */
    private String saleArea;
    /** 销售区域名称 */
    private String saleAreaName;
    /** 合同金额方式 */
    private Integer completeFlag;
    /** 是否已提交 */
    private Integer committed;
    /** 退回原因 */
    private String backReason;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getMerchandiser() {
        return merchandiser;
    }

    public void setMerchandiser(String merchandiser) {
        this.merchandiser = merchandiser;
    }

    public String getMerchandiserName() {
        return merchandiserName;
    }

    public void setMerchandiserName(String merchandiserName) {
        this.merchandiserName = merchandiserName;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getSaleAreaName() {
        return saleAreaName;
    }

    public void setSaleAreaName(String saleAreaName) {
        this.saleAreaName = saleAreaName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }
}
