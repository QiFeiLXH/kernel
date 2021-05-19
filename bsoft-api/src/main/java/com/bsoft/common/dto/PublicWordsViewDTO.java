package com.bsoft.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/2 10:28
 * @Description
 */
public class PublicWordsViewDTO implements Serializable {
    private Integer id;
    /** 主表id */
    private Integer mainId;
    /** 菜单id */
    private Integer menuId;
    /** 文件名 */
    private String fileName;
    /** 文件大小 */
    private Double fileSize;
    private String uploader;
    /** 上传人 */
    private String uploaderName;
    /** 类型 默认1 表征同一菜单下不同地方使用上传功能 */
    private Integer type;
    /** 上传时间 */
    private Date uploadDate;
    /** 文件服务器上的文件id */
    private Integer fileId;
    /** 区别不同菜单下的同一份文档查看下载功能 */
    private Integer wordType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getWordType() {
        return wordType;
    }

    public void setWordType(Integer wordType) {
        this.wordType = wordType;
    }
}
