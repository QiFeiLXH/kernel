package com.bsoft.project.dto;

import java.io.Serializable;

/*
 * @author  hy
 * @date  2020/3/29 21:46
 * @description
 */
public class ProjectWordBaseUploadDTO implements Serializable {
    private Integer id;//jlid
    private Integer fileKey;//wdjl
    private String path;
    private String OriginalFilename;
    private String newFileName;
    private Integer detailId;
    private String contractId;
    private String userId;
    private Integer milepostId;
    private byte[] fileBytes;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOriginalFilename() {
        return OriginalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        OriginalFilename = originalFilename;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }
}
