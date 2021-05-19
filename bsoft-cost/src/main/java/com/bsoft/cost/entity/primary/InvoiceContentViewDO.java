package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 9:44
 * @Description
 */
@Entity
@Table(name="BSOFT_PORTAL.FIN_COST_INVOICE_CONTENT_VIEW")
public class InvoiceContentViewDO {
    @Id
    private Integer id;
    /** 开票记录id */
    private Integer invoiceRecordId;
    /** 开票内容 */
    private String productContent;
    /** 物品名称 */
    private String goodsName;
    /** 税收分类码 */
    private String taxCode;
    /** 税率 */
    private Double taxRate;
    /** 规格型号 */
    private String model;
    /** 单位 */
    private String unit;
    /** 数量 */
    private Integer count;
    /** 单价 */
    private Double unitPrice;
    /** 金额 */
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceRecordId() {
        return invoiceRecordId;
    }

    public void setInvoiceRecordId(Integer invoiceRecordId) {
        this.invoiceRecordId = invoiceRecordId;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
