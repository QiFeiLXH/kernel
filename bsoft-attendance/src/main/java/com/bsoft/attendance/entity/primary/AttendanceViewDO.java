package com.bsoft.attendance.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ker_att_attendance_view")
public class AttendanceViewDO {
    private Integer id; //考勤ID
    private String personId; //员工工号
    private Date attendanceDate; //考勤日期
    private Integer flag; //提交类型
    private String workLog; //工作日志
    private Date submitDate; //日志提交时间
    private Integer rentId; //租房ID
    private Integer evection; //出差标志
    private Integer stay;  //住宿情况
    private String rentName; //租房名称
    private String personName;//考勤人员姓名
    private String goWorkPlace;//上班地点
    private String offWorkPlace;//下班地点
    private String postType;//岗位大类
    private String postTypeText;//岗位大类名称
    private String goWorkState;//上班情况
    private String offWorkState;//下班情况
    private String goWorkStateText;//上班情况名称
    private String offWorkStateText;//下班情况名称
    private String flagText;//提交类型名称
    private Date goWorkTime;//上班时间
    private Date offWorkTime;//下班时间
    private String approver;//批复人
    private String approveRemark;//批复信息
    private Date approveDate;//批复时间
    private Integer nonWorkIngFlag;//非工作日标志
    private String goWorkPlaceLon;//上班地点经度
    private String goWorkPlaceLat;//上班地点纬度
    private String offWorkPlaceLon;//下班地点经度
    private String offWorkPlaceLat;//下班地点纬度

    @Id
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "yggh")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "kqrq")
    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "gzrz")
    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    @Column(name = "rztjsj")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Column(name = "zfid")
    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    @Column(name = "ccbz")
    public Integer getEvection() {
        return evection;
    }

    public void setEvection(Integer evection) {
        this.evection = evection;
    }

    @Column(name = "rzqk")
    public Integer getStay() {
        return stay;
    }

    public void setStay(Integer stay) {
        this.stay = stay;
    }

    @Column(name = "rentname")
    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    @Column(name = "xusname")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Column(name = "sbdd")
    public String getGoWorkPlace() {
        return goWorkPlace;
    }

    public void setGoWorkPlace(String goWorkPlace) {
        this.goWorkPlace = goWorkPlace;
    }

    @Column(name = "xbdd")
    public String getOffWorkPlace() {
        return offWorkPlace;
    }

    public void setOffWorkPlace(String offWorkPlace) {
        this.offWorkPlace = offWorkPlace;
    }

    @Column(name = "gwdl")
    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Column(name = "gwdltext")
    public String getPostTypeText() {
        return postTypeText;
    }

    public void setPostTypeText(String postTypeText) {
        this.postTypeText = postTypeText;
    }

    @Column(name = "cqqk")
    public String getGoWorkState() {
        return goWorkState;
    }

    public void setGoWorkState(String goWorkState) {
        this.goWorkState = goWorkState;
    }

    @Column(name = "cqqk2")
    public String getOffWorkState() {
        return offWorkState;
    }

    public void setOffWorkState(String offWorkState) {
        this.offWorkState = offWorkState;
    }

    @Column(name = "cqqktext")
    public String getGoWorkStateText() {
        return goWorkStateText;
    }

    public void setGoWorkStateText(String goWorkStateText) {
        this.goWorkStateText = goWorkStateText;
    }

    @Column(name = "cqqk2text")
    public String getOffWorkStateText() {
        return offWorkStateText;
    }

    public void setOffWorkStateText(String offWorkStateText) {
        this.offWorkStateText = offWorkStateText;
    }

    @Column(name = "flagtext")
    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    @Column(name = "sbsj")
    public Date getGoWorkTime() {
        return goWorkTime;
    }

    public void setGoWorkTime(Date goWorkTime) {
        this.goWorkTime = goWorkTime;
    }

    @Column(name = "xbsj")
    public Date getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(Date offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    @Column(name = "pfry")
    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    @Column(name = "pfxx")
    public String getApproveRemark() {
        return approveRemark;
    }

    public void setApproveRemark(String approveRemark) {
        this.approveRemark = approveRemark;
    }

    @Column(name = "pfsj")
    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    @Column(name = "fgzrbz")
    public Integer getNonWorkIngFlag() {
        return nonWorkIngFlag;
    }

    public void setNonWorkIngFlag(Integer nonWorkIngFlag) {
        this.nonWorkIngFlag = nonWorkIngFlag;
    }
    @Column(name = "sbddjd")
    public String getGoWorkPlaceLon() {
        return goWorkPlaceLon;
    }

    public void setGoWorkPlaceLon(String goWorkPlaceLon) {
        this.goWorkPlaceLon = goWorkPlaceLon;
    }

    @Column(name = "sbddwd")
    public String getGoWorkPlaceLat() {
        return goWorkPlaceLat;
    }

    public void setGoWorkPlaceLat(String goWorkPlaceLat) {
        this.goWorkPlaceLat = goWorkPlaceLat;
    }

    @Column(name = "xbddjd")
    public String getOffWorkPlaceLon() {
        return offWorkPlaceLon;
    }

    public void setOffWorkPlaceLon(String offWorkPlaceLon) {
        this.offWorkPlaceLon = offWorkPlaceLon;
    }

    @Column(name = "xbddwd")
    public String getOffWorkPlaceLat() {
        return offWorkPlaceLat;
    }

    public void setOffWorkPlaceLat(String offWorkPlaceLat) {
        this.offWorkPlaceLat = offWorkPlaceLat;
    }
}
