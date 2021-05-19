package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-20 10:29
 * @Version 1.0
 * @Description
 */
public class ProjectPlanDetailDTO implements Serializable {
    private Integer id;//主键ID
    private Integer parentId;//父级ID
    private Integer batch;//批次
    private Integer milepostId;//里程碑ID
    private Date finishDate;//完成时间
    private Integer planId;//计划ID
    private String milepostName;//里程碑名称
    private Integer isAudited;//审核标志
    private Integer milepostLevel;//里程碑层
    private Date actualFinishDate;//实际完成时间
    private Integer logoff;//取消标志 0正常  1取消
    private String icon;//计划图标
    private Integer range;//合同范围 1合同内 2合同外
    private Integer sort;//排序字段
    private Integer finishFlag; //完成标志 0.未完成 1.完成
    private Integer milepostFlag; //是否里程碑标志 0.否 1.是
    private String words;//需要上传的标准文档ID 逗号分隔
    private Integer stage;//所属阶段 1.启动 2.计划 3.实时 4.验收 5.全过程管理
    private Integer milepostDutyId;//责任书里程碑id
    private List<ProjectPlanDetailDTO> children; //子节点

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getMilepostName() {
        return milepostName;
    }

    public void setMilepostName(String milepostName) {
        this.milepostName = milepostName;
    }

    public Integer getIsAudited() {
        return isAudited;
    }

    public void setIsAudited(Integer isAudited) {
        this.isAudited = isAudited;
    }

    public Integer getMilepostLevel() {
        return milepostLevel;
    }

    public void setMilepostLevel(Integer milepostLevel) {
        this.milepostLevel = milepostLevel;
    }

    public Date getActualFinishDate() {
        return actualFinishDate;
    }

    public void setActualFinishDate(Date actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(Integer finishFlag) {
        this.finishFlag = finishFlag;
    }

    public Integer getMilepostFlag() {
        return milepostFlag;
    }

    public void setMilepostFlag(Integer milepostFlag) {
        this.milepostFlag = milepostFlag;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getMilepostDutyId() {
        return milepostDutyId;
    }

    public void setMilepostDutyId(Integer milepostDutyId) {
        this.milepostDutyId = milepostDutyId;
    }

    public List<ProjectPlanDetailDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectPlanDetailDTO> children) {
        this.children = children;
    }
}
