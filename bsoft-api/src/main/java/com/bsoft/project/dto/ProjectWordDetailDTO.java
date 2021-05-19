package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/27 14:22
 * @description
 */
public class ProjectWordDetailDTO implements Serializable {
    private Integer id;//jlid
    private Integer fileKey;//wdjl
    private String fileName;//wjmc
    private Double fileSize;//wjdx
    private String submitter;//scgh
    private Date submitDate;//SCSJ
    private byte[] file;//wjnr
    private Integer fileStatus;//wdzt

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
}
