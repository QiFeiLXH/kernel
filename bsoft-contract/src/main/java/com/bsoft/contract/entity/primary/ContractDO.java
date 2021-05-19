package com.bsoft.contract.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "bsoftmis.kh_htxx")
public class ContractDO {
    private String id; //合同编号
    private String number; //合同号
    private String name; //合同名称
    private Date registerDate; //登记日期
    private String register; //登记人员
    private String customer;//客户编码
    private String area; //归属区域
    private Double amount;//合同金额
    private Date signDate;//签定日期
    private Integer contractType;//合同分类
    private Integer fileYear;//文档年度

    private Integer bigCustomers;//大客户
    private Double effectiveContractAmount;//有效合同额
    private Integer assignFlag;//分配标志
    private Integer committed;//提交标志
    private String backReason;//退回原因
    private String checkPerson;//核对人
    private Date checkDate;//核对日期
    private Date finalCheckDate;//终验日期
    @Id
    @Column(name = "htbh")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "contractno")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "htmc")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "djrq")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "djry")
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Column(name = "khbm")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Column(name = "ssqy")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "hte")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "qdrq")
    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Column(name = "yjfpbz")
    public Integer getAssignFlag() {
        return assignFlag;
    }

    public void setAssignFlag(Integer assignFlag) {
        this.assignFlag = assignFlag;
    }

    @Column(name = "htfl")
    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    @Column(name = "wdnd")
    public Integer getFileYear() {
        return fileYear;
    }

    public void setFileYear(Integer fileYear) {
        this.fileYear = fileYear;
    }

    @Column(name = "dkh")
    public Integer getBigCustomers() {
        return bigCustomers;
    }

    public void setBigCustomers(Integer bigCustomers) {
        this.bigCustomers = bigCustomers;
    }

    @Column(name = "yxhte")
    public Double getEffectiveContractAmount() {
        return effectiveContractAmount;
    }

    public void setEffectiveContractAmount(Double effectiveContractAmount) {
        this.effectiveContractAmount = effectiveContractAmount;
    }

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Column(name = "ysrq")
    public Date getFinalCheckDate() {
        return finalCheckDate;
    }

    public void setFinalCheckDate(Date finalCheckDate) {
        this.finalCheckDate = finalCheckDate;
    }
}
