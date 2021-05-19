package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 19:51
 * @Description 项目责任书-客户选择
 */
@Entity
@Table(name="pro_duty_customer_project_view")
public class ProjectDutyCustomerAndProjectSelectViewDO {
    @Id
    /** 合同编号 */
    private String contractNo;
    /** 合同号 */
    private String contractCode;
    /** 合同名称 */
    private String contractName;
    /** 项目id */
    private String projectId;
    /** 客户编码 */
    private String customerId;
    /** 客户名称 */
    private String customerName;
    /** 项目经理 */
    private String projectManager;
    /** 工程区域 */
    private String area;
    private String areaText;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
