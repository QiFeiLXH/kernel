package com.bsoft.contract.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/27 18:39
 * @Description
 */
public class ContractProductSyncDTO implements Serializable {
    /** 产品id */
    private Integer productId;
    /** 产品编号 */
    private Integer productNumber;
    /** 项目id */
    private String projectId;
    /** 产品名称 */
    private String productName;
    /** 系统id */
    private Integer systemId;
    /** 系统名称 */
    private String systemName;
    /** 合同模块金额 */
    private Double amount;
    /** 模块名称 */
    private String moduleName;
    /** 业务大类 */
    private Integer businessType;
    /** 上报类型 */
    private Integer reportType;
    /** 承建分工 */
    private Integer constructionType;
    /** 承建分工 */
    private String constructionTypeName;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Integer getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(Integer constructionType) {
        this.constructionType = constructionType;
    }

    public String getConstructionTypeName() {
        return constructionTypeName;
    }

    public void setConstructionTypeName(String constructionTypeName) {
        this.constructionTypeName = constructionTypeName;
    }
}
