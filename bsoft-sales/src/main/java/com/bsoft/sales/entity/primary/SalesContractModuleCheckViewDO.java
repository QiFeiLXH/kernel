package com.bsoft.sales.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/19 11:00
 * @Description
 */
@Entity
@Table(name = "bsoft_portal.sales_con_module_check_view")
public class SalesContractModuleCheckViewDO {
    @Id
    private Integer id;
    /** 模块名称 */
    private String name;
    /** 业务大类 */
    private Integer type;
    /** 业务大类名称 */
    private String typeText;
    /** 产品类别 */
    private String productType;
    /** 产品名称 */
    private String productName;
    /** 金额 */
    private Double amount;
    /** 性质 */
    private Integer nature;
    /** 性质文本 */
    private String natureName;
    /** 合同编号 */
    private String contractId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
}
