package com.bsoft.sales.condition;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 13:08
 * @Description
 */
public class ContractModuleQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    /** 产品部门id */
    private String deptId;
    /** 模块名称 */
    private String moduleName;
    /** 产品模块名称 */
    private String productName;
    /** 合同号 */
    private String contractNo;
    /** 产品模块关联标志 */
    private List<Integer> relationFlag;
    /** 合同模块关联标志 */
    private Integer moduleRelationFlag;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public List<Integer> getRelationFlag() {
        return relationFlag;
    }

    public void setRelationFlag(List<Integer> relationFlag) {
        this.relationFlag = relationFlag;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getModuleRelationFlag() {
        return moduleRelationFlag;
    }

    public void setModuleRelationFlag(Integer moduleRelationFlag) {
        this.moduleRelationFlag = moduleRelationFlag;
    }
}
