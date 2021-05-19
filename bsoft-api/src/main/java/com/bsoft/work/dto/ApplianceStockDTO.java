package com.bsoft.work.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
public class ApplianceStockDTO implements Serializable {
    /**主键*/
    private Integer id;
    /**物品类别*/
    private Integer type;
    /**物品名称*/
    private Integer name;
    /**规格*/
    private String standards;
    /**数量*/
    private Integer quantity;
    /**单价*/
    private Double unitPrice;
    /**金额*/
    private Double money;
    /**供应商*/
    private Integer supplier;
    /**入库日期*/
    private Date inDate;
    /**剩余数量*/
    private Integer surplusQuantity;
    /**支付状态*/
    private Integer status;
    /**备注*/
    private String remark;
    /**登记人*/
    private String register;
    /**流水号*/
    private String lshId;
    /**提交标记*/
    private Integer submitFlag;

    /**类型名称*/
    private String typeName;
    /**物品名称*/
    private String nameName;
    /**供应商名称*/
    private String supplierName;
    /**登记人姓名*/
    private String registerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getSurplusQuantity() {
        return surplusQuantity;
    }

    public void setSurplusQuantity(Integer surplusQuantity) {
        this.surplusQuantity = surplusQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNameName() {
        return nameName;
    }

    public void setNameName(String nameName) {
        this.nameName = nameName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getLshId() {
        return lshId;
    }

    public void setLshId(String lshId) {
        this.lshId = lshId;
    }

    public Integer getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(Integer submitFlag) {
        this.submitFlag = submitFlag;
    }
}
