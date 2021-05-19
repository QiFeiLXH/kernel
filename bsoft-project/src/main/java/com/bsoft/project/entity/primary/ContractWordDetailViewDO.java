package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/4/27
 * @description 合同文档明细视图
 */
@Entity
@Table(name = "pro_contract_word_detail_view")
public class ContractWordDetailViewDO {
    /** 文档明细ID*/
    @Id
    private Integer detailId;
    /** 文档信息ID*/
    private Integer infoId;
    /** 文档数据库明细ID*/
    private Integer detailDBId;
    /** 标准文档ID*/
    private Integer standardWordId;
    /** 合同编号*/
    private String contractId;
    /** 项目ID*/
    private String projectId;
    /** 项目名称*/
    private String projectName;
    /** 文档名称*/
    private String fileName;
    /** 上传者*/
    private String uploadPersonId;
    /** 上传者姓名*/
    private String uploadPersonName;
    /** 上传时间*/
    private Date uploadDate;
    /** 文档大小*/
    private Double fileSize;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getDetailDBId() {
        return detailDBId;
    }

    public void setDetailDBId(Integer detailDBId) {
        this.detailDBId = detailDBId;
    }

    public Integer getStandardWordId() {
        return standardWordId;
    }

    public void setStandardWordId(Integer standardWordId) {
        this.standardWordId = standardWordId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadPersonId() {
        return uploadPersonId;
    }

    public void setUploadPersonId(String uploadPersonId) {
        this.uploadPersonId = uploadPersonId;
    }

    public String getUploadPersonName() {
        return uploadPersonName;
    }

    public void setUploadPersonName(String uploadPersonName) {
        this.uploadPersonName = uploadPersonName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }
}
