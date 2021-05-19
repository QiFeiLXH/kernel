package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.Date;


public class ProjectLogNeedAuditDTO implements Serializable {
    private Integer id;//主键ID
    private Integer auditType;//项目日志阶段 0.待组员修改 1.待组长审核 2.项目经理审核 3.小区负责人审核 4.结束
    private String auditter;//待审核人
    private Integer refuse;//拒绝次数
    private String auditTypeText;//项目日志阶段名称
    private Date attendanceDate;//考勤日期
    private String yggh;//提交人员工号
    private Integer workLogId;//工作日志id
    private String workLog;//工作日志
    private Double workLoad;//工时
    private String userName; //提交人员名字
    private String contractNo;//日志归属项目
    private String gsxm;//日志归属项目
    private String projectName;//项目名称
    private String groupName;//组名
    private Integer xmlb;//项目类别
    private String projectType;//项目类别名称
    private Integer auditFlag;//审核标志
    private String auditFlagText;//审核标志
    private String projectManager; //项目经理
    private String fzr; //小区负责人
    private String smallRegion; //小区部门编码
    private String smallRegionText; //小区名称
    private String groupLeader; //组长
    private String userPym; //姓名拼音
    private String projectPym; //项目名称拼音
    private String regionalLeader; //大区负责人
    private String remark;//意见
    private Integer remainingDays;//剩余操作天数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public Integer getRefuse() {
        return refuse;
    }

    public void setRefuse(Integer refuse) {
        this.refuse = refuse;
    }

    public String getAuditTypeText() {
        return auditTypeText;
    }

    public void setAuditTypeText(String auditTypeText) {
        this.auditTypeText = auditTypeText;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getYggh() {
        return yggh;
    }

    public void setYggh(String yggh) {
        this.yggh = yggh;
    }

    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public Double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(Double workLoad) {
        this.workLoad = workLoad;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getGsxm() {
        return gsxm;
    }

    public void setGsxm(String gsxm) {
        this.gsxm = gsxm;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getXmlb() {
        return xmlb;
    }

    public void setXmlb(Integer xmlb) {
        this.xmlb = xmlb;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getAuditFlagText() {
        return auditFlagText;
    }

    public void setAuditFlagText(String auditFlagText) {
        this.auditFlagText = auditFlagText;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getSmallRegion() {
        return smallRegion;
    }

    public void setSmallRegion(String smallRegion) {
        this.smallRegion = smallRegion;
    }

    public String getSmallRegionText() {
        return smallRegionText;
    }

    public void setSmallRegionText(String smallRegionText) {
        this.smallRegionText = smallRegionText;
    }

    public String getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(String groupLeader) {
        this.groupLeader = groupLeader;
    }

    public String getUserPym() {
        return userPym;
    }

    public void setUserPym(String userPym) {
        this.userPym = userPym;
    }

    public String getProjectPym() {
        return projectPym;
    }

    public void setProjectPym(String projectPym) {
        this.projectPym = projectPym;
    }

    public String getRegionalLeader() {
        return regionalLeader;
    }

    public void setRegionalLeader(String regionalLeader) {
        this.regionalLeader = regionalLeader;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }
}
