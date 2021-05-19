package com.bsoft.contract.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/28 11:26
 * @Description
 */
@Entity
@Table(name="bsoftmis.kh_cpxx")
public class ContractProductDO {
    /** id */
    @Id
    private Integer id;
    /** 合同编号 */
    @Column(name="htbh")
    private String contractId;
    /** t_cpxx.id */
    @Column(name="cpbh")
    private Integer productId;
    /** 产品名称 */
    @Column(name="cpmc")
    private String productName;
    /** 产品大类 */
    @Column(name="cpdl")
    private Integer productCategory;
    /** 备注 */
    @Column(name="bzxx")
    private String remark;
    /** 作废标志 */
    @Column(name="xzzf")
    private Integer abolishFlag;
    /** 虚拟标志 */
    @Column(name="xnbz")
    private Integer virtualFlag;
    /** 业务大类 */
    @Column(name="ywdl")
    private Integer businessCategory;
    /** 产品版本号 */
    @Column(name="bbh")
    private Integer productVersion;
    /** 业务归属 */
    @Column(name="ywgs")
    private Integer businessOwner;
    /** 所属产品线 */
    @Column(name="sscpx")
    private Integer ownerProductLine;
    /** 更新标志 */
    private Integer updateFlag;


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

    public Integer getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Integer productCategory) {
        this.productCategory = productCategory;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAbolishFlag() {
        return abolishFlag;
    }

    public void setAbolishFlag(Integer abolishFlag) {
        this.abolishFlag = abolishFlag;
    }

    public Integer getVirtualFlag() {
        return virtualFlag;
    }

    public void setVirtualFlag(Integer virtualFlag) {
        this.virtualFlag = virtualFlag;
    }

    public Integer getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Integer businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Integer getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(Integer productVersion) {
        this.productVersion = productVersion;
    }

    public Integer getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(Integer businessOwner) {
        this.businessOwner = businessOwner;
    }

    public Integer getOwnerProductLine() {
        return ownerProductLine;
    }

    public void setOwnerProductLine(Integer ownerProductLine) {
        this.ownerProductLine = ownerProductLine;
    }

    public Integer getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(Integer updateFlag) {
        this.updateFlag = updateFlag;
    }
}
