package com.bsoft.contract.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bsoft_portal.ker_contract_view")
public class ContractViewDO {
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
    private String group;

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

    @Column(name = "ywgs")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
