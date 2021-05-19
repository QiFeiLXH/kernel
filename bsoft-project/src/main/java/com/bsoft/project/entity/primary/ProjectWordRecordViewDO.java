package com.bsoft.project.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/26 18:24
 * @description
 */
@Entity
@Table(name = "bsoft_portal.ker_word_detail_view")
public class ProjectWordRecordViewDO {
    @Id
    private Integer id;//主键
    private Integer fileKey;//文档信息id
    private String fileName;//文件名
    private Date submitDate;//上传时间
    private String submitter;//上传人员
    private String submitterText;
    private Double fileSize;//文件大小
    private Integer detailId;//文档数据库记录id
    private Integer deptFlag;//部门审核标志
    private Integer regionFlag;//区域审核标志
    private Integer leaderFlag;//营运审核标志
    private Integer milepostId;

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

    public String getSubmitterText() {
        return submitterText;
    }

    public void setSubmitterText(String submitterText) {
        this.submitterText = submitterText;
    }

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }
}
