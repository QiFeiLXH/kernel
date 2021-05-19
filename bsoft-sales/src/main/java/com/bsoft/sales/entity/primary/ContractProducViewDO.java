package com.bsoft.sales.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:37
 * @Description
 */
@Entity
@Table(name="ker_con_product_view")
public class ContractProducViewDO {
    @Id
    private Integer id;
    /** 合同编号 */
    private String contractId;
    /** 合同号 */
    private String contractNo;
    /** 产品部门id */
    private String deptId;
    /** 产品部门名称 */
    private String deptName;
    /** 产品名称 */
    private String productName;
    /** 系统软件 */
    private String parentProductName;
    /** 业务大类 */
    private Integer businessCategory;
    /** 业务大类名称 */
    private String businessCategoryText;
    /** 产品线 */
    private Integer productLine;
    /** 产品线名称 */
    private String productLineText;
    /** 模块id */
    private String moduleIds;
    /** 模块名称 */
    private String moduleNames;
    /** 关联标志 */
    private Integer relationFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(String moduleIds) {
        this.moduleIds = moduleIds;
    }

    public String getModuleNames() {
        return moduleNames;
    }

    public void setModuleNames(String moduleNames) {
        this.moduleNames = moduleNames;
    }

    public Integer getRelationFlag() {
        return relationFlag;
    }

    public void setRelationFlag(Integer relationFlag) {
        this.relationFlag = relationFlag;
    }

    public String getParentProductName() {
        return parentProductName;
    }

    public void setParentProductName(String parentProductName) {
        this.parentProductName = parentProductName;
    }
}
