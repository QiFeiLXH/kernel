package com.bsoft.project.entity.primary;

import com.bsoft.dictionary.annotation.person.PersonIdDic;

import javax.persistence.*;
import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/26 18:24
 * @description 文档明细（一条文档信息对应多条文档明细）
 */
@Entity
@Table(name = "bsoftmis.wd_wdmx")
public class ProjectWordRecordDO {
    @Id
    @Column(name = "jlid")
    private Integer id;//主键
    @Column(name = "wdjl")
    private Integer fileKey;//文档信息id
    @Column(name = "wjmc")
    private String fileName;//文件名
    @Column(name = "scsj")
    private Date submitDate;//上传时间
    @Column(name = "scgh")
    private String submitter;//上传人员
    @Column(name = "wjdx")
    private Double fileSize;//文件大小
    @Column(name = "wddbjlid")
    private Integer detailId;//文档数据库记录id
    @Column(name = "deptflag")
    private Integer deptFlag;//部门审核标志
    @Column(name = "regionFlag")
    private Integer regionFlag;//区域审核标志
    @Column(name = "leaderFlag")
    private Integer leaderFlag;//营运审核标志
    @Column(name = "milepostId")
    private Integer milepostId;
    @Transient
    private Integer wordsNumber;

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

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDeptFlag() {
        return deptFlag;
    }

    public void setDeptFlag(Integer deptFlag) {
        this.deptFlag = deptFlag;
    }

    public Integer getRegionFlag() {
        return regionFlag;
    }

    public void setRegionFlag(Integer regionFlag) {
        this.regionFlag = regionFlag;
    }

    public Integer getLeaderFlag() {
        return leaderFlag;
    }

    public void setLeaderFlag(Integer leaderFlag) {
        this.leaderFlag = leaderFlag;
    }

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }

    public Integer getWordsNumber() {
        return wordsNumber;
    }

    public void setWordsNumber(Integer wordsNumber) {
        this.wordsNumber = wordsNumber;
    }
}
