package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 19:46
 * @Description 项目责任书-项目选择
 */
@Table(name="PRO_DUTY_PROJECT_SELECT_VIEW")
@Entity
public class ProjectDutyProjectSelectViewDO {
    @Id
    /** 合同编号 */
    private String contractNo;
    /** 合同名称 */
    private String contractName;
    /** 项目id */
    private String projectId;
    /** 工程区域 */
    private String area;
    /** 工程区域名称 */
    private String areaName;
    /** 项目经理 */
    private String projectManager;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
}
