package com.bsoft.contract.dto;

import java.io.Serializable;
import java.util.Date;

public class ContractDTO implements Serializable {
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
    private Date finalCheckDate;// 终验日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public Integer getFileYear() {
        return fileYear;
    }

    public void setFileYear(Integer fileYear) {
        this.fileYear = fileYear;
    }

    public Date getFinalCheckDate() {
        return finalCheckDate;
    }

    public void setFinalCheckDate(Date finalCheckDate) {
        this.finalCheckDate = finalCheckDate;
    }
}
