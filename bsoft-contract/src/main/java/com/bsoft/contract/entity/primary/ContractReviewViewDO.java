package com.bsoft.contract.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ker_contract_review_vew")
public class ContractReviewViewDO {
    private Integer id; //主键
    private Date applyDate;//申请日期
    private String applicant;//申请人
    private String applyDept;//申请部门
    private String contractNo;//合同编号
    private String customerId;//客户编码
    private String area;//客户所属区域
    private Double amount;//总合同额
    private Integer contractType;//合同分类
    private Integer originalStatus;//原件状态
    private Integer subject;//合同标的

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "sqrq")
    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Column(name = "sqr")
    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    @Column(name = "sqbm")
    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    @Column(name = "htbh")
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Column(name = "khbm")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Column(name = "ssqy")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "zhtje")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "htfl")
    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    @Column(name = "yjzt")
    public Integer getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(Integer originalStatus) {
        this.originalStatus = originalStatus;
    }

    @Column(name = "htbd")
    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }
}
