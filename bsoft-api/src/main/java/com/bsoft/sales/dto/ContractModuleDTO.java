package com.bsoft.sales.dto;


import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:38
 * @Description
 */
public class ContractModuleDTO implements Serializable {
    private Integer id;
    /** 模块名称 */
    private String name;
    /** 数量 */
    private Integer count;
    /** 合同编号 */
    private String contractId;
    /** 合同号 */
    private String contractNo;
    /** 业务大类 */
    private Integer type;
    /** 业务大类文本 */
    private String typeText;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}
