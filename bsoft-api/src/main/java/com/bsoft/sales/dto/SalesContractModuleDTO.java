package com.bsoft.sales.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/17 13:38
 * @Description
 */
public class SalesContractModuleDTO implements Serializable {
    private Integer id;
    /** 合同编号 */
    private String contractId;
    /** 模块名称 */
    private String name;
    /** 产品id */
    private Integer productId;
    /** 产品清单名称 */
    private String productNameText;
    /** 系统软件 */
    private Integer parentProductId;
    /** 系统软件名称 */
    private String parentProductNameText;
    /** 业务大类 */
    private Integer businessCategory;
    /** 业务大类名称 */
    private String businessCategoryText;
    /** 产品线 */
    private Integer productLine;
    /** 产品线名称 */
    private String productLineText;
    /** 关联标志 */
    private Integer relationFlag;
    /** 产品类别 */
    private String productType;
    /** 产品名称 */
    private String productName;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getParentProductId() {
        return parentProductId;
    }

    public void setParentProductId(Integer parentProductId) {
        this.parentProductId = parentProductId;
    }

    public Integer getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Integer businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getBusinessCategoryText() {
        return businessCategoryText;
    }

    public void setBusinessCategoryText(String businessCategoryText) {
        this.businessCategoryText = businessCategoryText;
    }

    public Integer getProductLine() {
        return productLine;
    }

    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }

    public String getProductLineText() {
        return productLineText;
    }

    public void setProductLineText(String productLineText) {
        this.productLineText = productLineText;
    }

    public Integer getRelationFlag() {
        return relationFlag;
    }

    public void setRelationFlag(Integer relationFlag) {
        this.relationFlag = relationFlag;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getProductNameText() {
        return productNameText;
    }

    public void setProductNameText(String productNameText) {
        this.productNameText = productNameText;
    }

    public String getParentProductNameText() {
        return parentProductNameText;
    }

    public void setParentProductNameText(String parentProductNameText) {
        this.parentProductNameText = parentProductNameText;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
