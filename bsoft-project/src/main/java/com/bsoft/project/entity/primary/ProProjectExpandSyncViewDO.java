package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/27 14:18
 * @Description 项目与项目扩展表同步bean
 */
@Entity
@Table(name="bsoft_portal.pro_project_ex_sync_view")
public class ProProjectExpandSyncViewDO {
    @Id
    /** 项目id */
    private String projectId;
    /** 项目名称 */
    private String projectName;
    /** 合同号 */
    private String contractNo;
    /** 合同名称 */
    private String contractName;
    /** 工程区域一级部门 */
    private Integer areaParent;
    /** 工程区域一级部门名称 */
    private String areaParentName;
    /** 工程区域 */
    private String area;
    /** 工程区域名称 */
    private String areaName;
    /** 项目id */
    private Integer collDeptParent;
    /** 项目id */
    private String collDeptParentName;
    /** 回款业绩部门 */
    private String collectionDept;
    /** 回款业绩部门名称 */
    private String collectionDeptName;
    /** 项目类别 */
    private Integer projectType;
    /** 项目类别名称 */
    private String projectTypeName;
    /** 业务大类 */
    private Integer businessType;
    /** 业务大类名称 */
    private String businessTypeName;
    /** 业务归属 */
    private Integer businessOwner;
    /** 业务归属名称 */
    private String businessOwnerName;
    /** 立项日期 */
    private Date proApplyDate;
    /** 项目经理 */
    private String projectManager;
    /** 项目经理姓名 */
    private String projectManagerName;
    /** 开始时间 */
    private Date startDate;
    /** 结束时间 */
    private Date endDate;
    /** 验收日期 */
    private Date checkDate;
    /** 项目金额 */
    private Double amount;
    /** 合同金额 */
    private Double contractAmount;
    /** 预完结标志 */
    private Integer prefinished;
    /** 应收款金额 */
    private Double receivableAmount;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

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

    public Integer getAreaParent() {
        return areaParent;
    }

    public void setAreaParent(Integer areaParent) {
        this.areaParent = areaParent;
    }

    public String getAreaParentName() {
        return areaParentName;
    }

    public void setAreaParentName(String areaParentName) {
        this.areaParentName = areaParentName;
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

    public Integer getCollDeptParent() {
        return collDeptParent;
    }

    public void setCollDeptParent(Integer collDeptParent) {
        this.collDeptParent = collDeptParent;
    }

    public String getCollDeptParentName() {
        return collDeptParentName;
    }

    public void setCollDeptParentName(String collDeptParentName) {
        this.collDeptParentName = collDeptParentName;
    }

    public String getCollectionDept() {
        return collectionDept;
    }

    public void setCollectionDept(String collectionDept) {
        this.collectionDept = collectionDept;
    }

    public String getCollectionDeptName() {
        return collectionDeptName;
    }

    public void setCollectionDeptName(String collectionDeptName) {
        this.collectionDeptName = collectionDeptName;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public Integer getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(Integer businessOwner) {
        this.businessOwner = businessOwner;
    }

    public String getBusinessOwnerName() {
        return businessOwnerName;
    }

    public void setBusinessOwnerName(String businessOwnerName) {
        this.businessOwnerName = businessOwnerName;
    }

    public Date getProApplyDate() {
        return proApplyDate;
    }

    public void setProApplyDate(Date proApplyDate) {
        this.proApplyDate = proApplyDate;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPrefinished() {
        return prefinished;
    }

    public void setPrefinished(Integer prefinished) {
        this.prefinished = prefinished;
    }

    public Double getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(Double receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }
}
