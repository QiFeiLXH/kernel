package com.bsoft.project.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author zhanglf
 * @Date 2020-04-14 10:46
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name="BSOFTMIS.PRO_WD_BZWD_VIEW")
public class ProjectStandardWordDO {
    private Integer fileKey; //文档ID wdid
    private Integer stage; //工程阶段stage
    private Integer wordManageType; //管理分类 glfl
    private Integer milestone; //所属里程碑 sslcb
    private String fileNumber; //文档编号 wdbh
    private Integer submitRole; //分工 tjjs
    private Integer fileType; //类别 wdlb
    private String fileName; //文档名称 wdmc
    private Integer scaleLarge; //提交要求 大 tjyq_d
    private Integer scaleMiddle; //提交要求 中 tjyq_z
    private Integer scaleSmall; //提交要求 小 tjyq_x
    private Integer scaleTiny; //提交要求 微 tjyq_w
    private Integer signature; //签章要求 客户确认方式 qzyq
    private Integer isRequired; //提交要求 是否必须 tjyq
    private String referenceTemplate; //参考文档 ckwd
    private Integer logoff; //注销标志 logoff
    private String path; //文档路径 path
    private Integer no; //序号 xh

    @Id
    @Column(name="wdid")
    public Integer getFileKey() {
        return fileKey;
    }

    public void setFileKey(Integer fileKey) {
        this.fileKey = fileKey;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    @Column(name="sslcb")
    public Integer getWordManageType() {
        return wordManageType;
    }

    public void setWordManageType(Integer wordManageType) {
        this.wordManageType = wordManageType;
    }

    @Column(name="glfl")
    public Integer getMilestone() {
        return milestone;
    }

    public void setMilestone(Integer milestone) {
        this.milestone = milestone;
    }

    @Column(name="wdbh")
    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    @Column(name="tjjs")
    public Integer getSubmitRole() {
        return submitRole;
    }

    public void setSubmitRole(Integer submitRole) {
        this.submitRole = submitRole;
    }

    @Column(name="wdlb")
    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    @Column(name="wdmc")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name="tjyq_d")
    public Integer getScaleLarge() {
        return scaleLarge;
    }

    public void setScaleLarge(Integer scaleLarge) {
        this.scaleLarge = scaleLarge;
    }

    @Column(name="tjyq_z")
    public Integer getScaleMiddle() {
        return scaleMiddle;
    }

    public void setScaleMiddle(Integer scaleMiddle) {
        this.scaleMiddle = scaleMiddle;
    }

    @Column(name="tjyq_x")
    public Integer getScaleSmall() {
        return scaleSmall;
    }

    public void setScaleSmall(Integer scaleSmall) {
        this.scaleSmall = scaleSmall;
    }

    @Column(name="tjyq_w")
    public Integer getScaleTiny() {
        return scaleTiny;
    }

    public void setScaleTiny(Integer scaleTiny) {
        this.scaleTiny = scaleTiny;
    }

    @Column(name="qzyq")
    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }

    @Column(name="tjyq")
    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    @Column(name="ckwd")
    public String getReferenceTemplate() {
        return referenceTemplate;
    }

    public void setReferenceTemplate(String referenceTemplate) {
        this.referenceTemplate = referenceTemplate;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name="xh")
    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}
