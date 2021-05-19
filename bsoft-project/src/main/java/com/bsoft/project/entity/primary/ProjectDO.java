package com.bsoft.project.entity.primary;

import com.bsoft.dictionary.annotation.dept.DeptAllDic;
import com.bsoft.dictionary.annotation.person.PersonIdDic;
import com.bsoft.dictionary.annotation.project.ProjectFlagDic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "BSOFTMIS.T_PROJECT")
public class ProjectDO {
    private String projectId;
    /** 合同号*/
    private String contractNo;
    private String projectName;
    @PersonIdDic
    private String projectManager;
    @DeptAllDic
    private String area;
    @ProjectFlagDic
    private String flag;
    private String pinyin;
    private String finshed;
    private Integer clueId;
    private Date signDate;
    private String customerId;
    private String projectNo;
    private Integer projectType;
    private String salesManager;
    private Integer businessCategory;
    /**
     * 备注信息
     */
    private String remark;
    private Date finishDate;

    /** 终验日期*/
    private Date finalCheckDate;
    /** 合同编号、合同ID、htbh*/
    private String contractId;
    /** 更新标志*/
    private Integer updateFlag;
    //项目进度
    private Double progress;
    //进度上报月份
    private Date progressMonth;

    @Id
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Column(name = "pyjm")
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Column(name = "wgbz")
    public String getFinshed() {
        return finshed;
    }

    public void setFinshed(String finshed) {
        this.finshed = finshed;
    }

    @Column(name = "xsbh")
    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Column(name = "khbm")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(String salesManager) {
        this.salesManager = salesManager;
    }

    @Column(name = "bzxx")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Column(name = "ywdl")
    public Integer getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Integer businessCategory) {
        this.businessCategory = businessCategory;
    }

    @Column(name = "actto")
    public Date getFinalCheckDate() {
        return finalCheckDate;
    }

    public void setFinalCheckDate(Date finalCheckDate) {
        this.finalCheckDate = finalCheckDate;
    }

    public Integer getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(Integer updateFlag) {
        this.updateFlag = updateFlag;
    }

    @Column(name = "htbh")
    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    @Column(name = "progress")
    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    @Column(name = "progressmonth")
    public Date getProgressMonth() {
        return progressMonth;
    }

    public void setProgressMonth(Date progressMonth) {
        this.progressMonth = progressMonth;
    }
}
