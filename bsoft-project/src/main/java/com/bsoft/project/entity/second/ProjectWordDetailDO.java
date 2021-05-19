package com.bsoft.project.entity.second;

import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/30 8:51
 * @description 文档明细
 */
public class ProjectWordDetailDO {
    private Integer id;//jlid 主键
    private Integer fileKey;//wdjl 文档信息ID
    private String fileName;//wjmc 文件名称
    private Double fileSize;//wjdx 文件大小
    private String submitter;//scgh 上传工号
    private Date submitDate;//SCSJ 长传时间
    private byte[] file;//wjnr 文件内容
    private Integer fileStatus;//wdzt 文档状态
    private Integer milepostId;//里程碑ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFileKey() {
        return fileKey;
    }

    public void setFileKey(Integer fileKey) {
        this.fileKey = fileKey;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Integer getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }
}
