package com.bsoft.clue.dto;

import java.io.Serializable;
import java.util.Date;

public class TrackLogLookDTO implements Serializable {
    private String projectId; //项目ID
    private String projectName; //项目名称
    private Integer clueNature; //线索性质
    private Integer stage; //目前阶段
    private Double signChance; //签约概率
    private String address; //拜访地址
    private String target; //拜访对象
    private Double software; //预计软件额
    private Double hardware; //预计硬件额
    private Double sysSoftware;//预计系统软件额
    private Double firstAmount; //预计首款额
    private Date signDate; //预计签约时间
    private Date startDate; //跟踪开始时间
    private Date endDate; //跟踪结束时间
    private Double workLoad; //工作量
    private String content; //跟踪情况
    private String detail; //详细信息
    private String customer; //客户名称
    private java.sql.Date attendanceDate; //考勤日期
    private Integer trackId; //跟踪Id
    private Integer workLogId; //日志ID
    private String personId; //员工工号
    private Integer clueId; //线索编号
    private String clueNatureText; //线索性质名称
    private String stageText;//目前阶段名称
    private Integer tracker;//跟单人员
    private Double scale;//项目比例
    private Integer stay;//住宿情况
    private Integer rentId;//宿舍id
    private Integer flag;//提交类型
    private String rentName;//宿舍名称
    private String projectType;//项目类别
    private String projectDept;//项目部门

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

    public Integer getClueNature() {
        return clueNature;
    }

    public void setClueNature(Integer clueNature) {
        this.clueNature = clueNature;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Double getSignChance() {
        return signChance;
    }

    public void setSignChance(Double signChance) {
        this.signChance = signChance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getSoftware() {
        return software;
    }

    public void setSoftware(Double software) {
        this.software = software;
    }

    public Double getHardware() {
        return hardware;
    }

    public void setHardware(Double hardware) {
        this.hardware = hardware;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(Double workLoad) {
        this.workLoad = workLoad;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public java.sql.Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(java.sql.Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }


    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public String getClueNatureText() {
        return clueNatureText;
    }

    public void setClueNatureText(String clueNatureText) {
        this.clueNatureText = clueNatureText;
    }

    public String getStageText() {
        return stageText;
    }

    public void setStageText(String stageText) {
        this.stageText = stageText;
    }

    public Integer getTracker() {
        return tracker;
    }

    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public Integer getStay() {
        return stay;
    }

    public void setStay(Integer stay) {
        this.stay = stay;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectDept() {
        return projectDept;
    }

    public void setProjectDept(String projectDept) {
        this.projectDept = projectDept;
    }

    public Double getSysSoftware() {
        return sysSoftware;
    }

    public void setSysSoftware(Double sysSoftware) {
        this.sysSoftware = sysSoftware;
    }
}
