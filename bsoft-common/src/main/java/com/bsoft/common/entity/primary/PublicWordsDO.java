package com.bsoft.common.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.sales.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-06-29 20:40
 * @Description:
 */
@Entity
@Table(name="ker_public_words")
public class PublicWordsDO {
    private Integer id;
    /** 主表ID */
    private Integer mainId;
    /** 菜单id */
    private Integer menuId;
    /** 类别 */
    private Integer type;
    /** 文件名称 */
    private String fileName;
    /** 文件大小（单位Mb） */
    private Double fileSize;
    /** 上传人 */
    private String uploader;
    /** 上传日期 */
    private Date uploadDate;
    /** 文件服务器上的文件id */
    private Integer fileId;
    /** 文件内容 */
    private byte[] fileBytes;
    /** 区别不同菜单下的同一份文档查看下载功能 */
    private Integer wordType;

    @Id
    @SequenceGenerator(name="SEQ_KER_PUBLIC_WORDS",allocationSize=1,sequenceName="SEQ_KER_PUBLIC_WORDS")
    @GeneratedValue(generator="SEQ_KER_PUBLIC_WORDS",strategy=GenerationType.SEQUENCE)
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Transient
    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public Integer getWordType() {
        return wordType;
    }

    public void setWordType(Integer wordType) {
        this.wordType = wordType;
    }
}
