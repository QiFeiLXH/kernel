package com.bsoft.word.dto;

import java.io.Serializable;
import java.util.Date;

public class WordFileRecordDTO implements Serializable {
    private Integer id;
    private String fileName;
    private Date uploadDate;
    private Integer fileYear;
    private Integer fileMonth;
    private Double size;
    private Integer menuId;
    private byte[] data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getFileYear() {
        return fileYear;
    }

    public void setFileYear(Integer fileYear) {
        this.fileYear = fileYear;
    }

    public Integer getFileMonth() {
        return fileMonth;
    }

    public void setFileMonth(Integer fileMonth) {
        this.fileMonth = fileMonth;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
