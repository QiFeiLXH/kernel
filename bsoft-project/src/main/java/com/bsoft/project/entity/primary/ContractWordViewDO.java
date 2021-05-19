package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: zy
 * @date: 2021/4/27
 * @description 合同标准文档视图
 */
@Entity
@Table(name = "pro_contract_word_view")
public class ContractWordViewDO {
    @Id
    /** 文档id*/
    private Integer fileId;
    /** 编号*/
    private String fileNo;
    /** 分工*/
    private Integer submitRole;
    /** 分工*/
    private String submitRoleText;
    /** 文档类别*/
    private Integer fileType;
    /** 文档类别*/
    private String fileTypeText;
    /** 文档名称*/
    private String fileName;
    /**
     * 项目规模大
     */
    private Integer scaleLarge;
    /**
     * 项目规模中
     */
    private Integer scaleMiddle;
    /**
     * 项目规模小
     */
    private Integer scaleSmall;
    /**
     * 项目规模微
     */
    private Integer scaleTiny;
    /**
     * 是否必须
     */
    private Integer isRequired;
    /**
     * 签章要求、客户确认方式
     */
    private Integer signature;
    /**
     * 签章要求、客户确认方式
     */
    private String signatureText;
    /**
     * 上传数量
     */
    private Integer uploadQuantity;
    /**
     * 最新上传日期
     */
    private Date uploadDate;
    /**
     * 合同编号
     */
    private String contractId;
    /**
     * 示例文档ID
     */
    private Integer exampleFileId;

    public Integer getExampleFileId() {
        return exampleFileId;
    }

    public void setExampleFileId(Integer exampleFileId) {
        this.exampleFileId = exampleFileId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public Integer getSubmitRole() {
        return submitRole;
    }

    public void setSubmitRole(Integer submitRole) {
        this.submitRole = submitRole;
    }

    public String getSubmitRoleText() {
        return submitRoleText;
    }

    public void setSubmitRoleText(String submitRoleText) {
        this.submitRoleText = submitRoleText;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileTypeText() {
        return fileTypeText;
    }

    public void setFileTypeText(String fileTypeText) {
        this.fileTypeText = fileTypeText;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getScaleLarge() {
        return scaleLarge;
    }

    public void setScaleLarge(Integer scaleLarge) {
        this.scaleLarge = scaleLarge;
    }

    public Integer getScaleMiddle() {
        return scaleMiddle;
    }

    public void setScaleMiddle(Integer scaleMiddle) {
        this.scaleMiddle = scaleMiddle;
    }

    public Integer getScaleSmall() {
        return scaleSmall;
    }

    public void setScaleSmall(Integer scaleSmall) {
        this.scaleSmall = scaleSmall;
    }

    public Integer getScaleTiny() {
        return scaleTiny;
    }

    public void setScaleTiny(Integer scaleTiny) {
        this.scaleTiny = scaleTiny;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }

    public String getSignatureText() {
        return signatureText;
    }

    public void setSignatureText(String signatureText) {
        this.signatureText = signatureText;
    }

    public Integer getUploadQuantity() {
        return uploadQuantity;
    }

    public void setUploadQuantity(Integer uploadQuantity) {
        this.uploadQuantity = uploadQuantity;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
}
