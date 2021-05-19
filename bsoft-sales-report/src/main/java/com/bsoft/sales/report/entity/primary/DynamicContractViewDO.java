package com.bsoft.sales.report.entity.primary;

import com.bsoft.dictionary.annotation.contract.ContractTypeDic;
import com.bsoft.dictionary.annotation.customer.CustomerDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "ker_sales_report_contract_view")
public class DynamicContractViewDO {
    private Integer id; //主键
    private Integer dynamicId; //销售动态ID
    private String contractId; //内部合同编号
    private String contractName; //合同名称
    private String customerId; //客户编码
    private String customerIdText; //客户编码
    private Date signDate; //签定日期
    private Integer contractType; //合同分类
    private String contractTypeText; //合同分类
    private String contractno; //合同编号
    private Double amount; //合同额
    private String area;//所属区域
    private String areaText;//所属区域

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerIdText() {
        return customerIdText;
    }

    public void setCustomerIdText(String customerIdText) {
        this.customerIdText = customerIdText;
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

    public String getContractTypeText() {
        return contractTypeText;
    }

    public void setContractTypeText(String contractTypeText) {
        this.contractTypeText = contractTypeText;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
}
