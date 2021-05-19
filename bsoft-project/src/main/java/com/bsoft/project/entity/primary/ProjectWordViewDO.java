package com.bsoft.project.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/20 11:03
 * @description 项目文档视图
 */
@Entity
@Table(name = "BSOFTMIS.PRO_PROJECTWORD_VIEW")
public class ProjectWordViewDO {
    private Integer fileKey;//文档表主键
    private String fileNumber;//编号
    private Integer milestone;//所属里程碑
    private String milestoneText;
    private Integer wordManageType;//管理分类
    private String wordManageTypeText;
    private Integer fileType;//文档类别
    private String fileTypeText;
    private String fileName;//文档名称
    private Integer submitRole;//分工
    private String submitRoleText;
    private Integer scaleLarge;//项目规模大
    private Integer scaleMiddle;//项目规模中
    private Integer scaleSmall;//项目规模小
    private Integer scaleTiny;//项目规模微
    private Integer isRequired;//是否必须
    private Integer signature;//客户确认方式
    private String signatureText;
    private Integer uploadQuantity;//上传数量
    private Integer auditQuantity;//审核数量
    private Date uploadDate;//最新上传日期
    private String referenceTemplate;//参考模板
    private String htbh;//合同编号
    private String projectId;//项目id
    private Integer fileId;//文档id
    private Integer stage;//工程阶段
    private String stageText;

    @Column(name = "wdbh")
    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    @Column(name = "sslcb")
    public Integer getMilestone() {
        return milestone;
    }

    public void setMilestone(Integer milestone) {
        this.milestone = milestone;
    }

    @Column(name = "glfl")
    public Integer getWordManageType() {
        return wordManageType;
    }

    public void setWordManageType(Integer wordManageType) {
        this.wordManageType = wordManageType;
    }

    @Column(name = "wdlb")
    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    @Column(name = "wdmc")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "tjjs")
    public Integer getSubmitRole() {
        return submitRole;
    }

    public void setSubmitRole(Integer submitRole) {
        this.submitRole = submitRole;
    }

    @Column(name = "tjyq_d")
    public Integer getScaleLarge() {
        return scaleLarge;
    }

    public void setScaleLarge(Integer scaleLarge) {
        this.scaleLarge = scaleLarge;
    }

    @Column(name = "tjyq_z")
    public Integer getScaleMiddle() {
        return scaleMiddle;
    }

    public void setScaleMiddle(Integer scaleMiddle) {
        this.scaleMiddle = scaleMiddle;
    }

    @Column(name = "tjyq_x")
    public Integer getScaleSmall() {
        return scaleSmall;
    }

    public void setScaleSmall(Integer scaleSmall) {
        this.scaleSmall = scaleSmall;
    }

    @Column(name = "tjyq_w")
    public Integer getScaleTiny() {
        return scaleTiny;
    }

    public void setScaleTiny(Integer scaleTiny) {
        this.scaleTiny = scaleTiny;
    }

    @Column(name = "tjyq")
    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    @Column(name = "qzyq")
    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }

    @Column(name = "wdsl")
    public Integer getUploadQuantity() {
        return uploadQuantity;
    }

    public void setUploadQuantity(Integer uploadQuantity) {
        this.uploadQuantity = uploadQuantity;
    }

    @Column(name = "shsl")
    public Integer getAuditQuantity() {
        return auditQuantity;
    }

    public void setAuditQuantity(Integer auditQuantity) {
        this.auditQuantity = auditQuantity;
    }

    @Column(name = "zxscsj")
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Column(name = "ckwd")
    public String getReferenceTemplate() {
        return referenceTemplate;
    }

    public void setReferenceTemplate(String referenceTemplate) {
        this.referenceTemplate = referenceTemplate;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    @Column(name = "xmid")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Column(name = "wdid")
    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    @Id
    @Column(name = "jlid")
    public Integer getFileKey() {
        return fileKey;
    }

    public void setFileKey(Integer fileKey) {
        this.fileKey = fileKey;
    }

    @Column(name = "stage")
    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getMilestoneText() {
        return milestoneText;
    }

    public void setMilestoneText(String milestoneText) {
        this.milestoneText = milestoneText;
    }

    public String getWordManageTypeText() {
        return wordManageTypeText;
    }

    public void setWordManageTypeText(String wordManageTypeText) {
        this.wordManageTypeText = wordManageTypeText;
    }

    public String getFileTypeText() {
        return fileTypeText;
    }

    public void setFileTypeText(String fileTypeText) {
        this.fileTypeText = fileTypeText;
    }

    public String getSubmitRoleText() {
        return submitRoleText;
    }

    public void setSubmitRoleText(String submitRoleText) {
        this.submitRoleText = submitRoleText;
    }

    public String getSignatureText() {
        return signatureText;
    }

    public void setSignatureText(String signatureText) {
        this.signatureText = signatureText;
    }

    public String getStageText() {
        return stageText;
    }

    public void setStageText(String stageText) {
        this.stageText = stageText;
    }
}
