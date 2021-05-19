package com.bsoft.attendance.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BSOFTMIS.T_KQB")
public class AttendanceDO {
    private Integer id; //考勤ID
    private String personId; //员工工号
    private Date attendanceDate; //考勤日期
    private Integer flag; //提交类型
    private String workLog; //工作日志
    private Date submitDate; //日志提交时间
    private Integer rentId; //租房ID
    private Integer evection; //出差标志
    private Integer stay;  //住宿情况
    private String rank;//等级
    private Double wages;//工资
    private Date goWorkTime;//上班时间
    private String goWorkPlace;
    private Date offWorkTime;
    private String offWorkPlace;
    private String goWorkStatus;//上午出勤情况
    private String offWorkStatus;//下午出勤情况
    private String supplement;// 补充说明
    private String dept;//部门代码
    private String goWorkPlaceLon;//上班地点经度
    private String goWorkPlaceLat;//上班地点纬度
    private String offWorkPlaceLon;//下班地点经度
    private String offWorkPlaceLat;//下班地点纬度

    @Column(name="bmdm")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

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

    @Column(name = "dj")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Column(name = "gz")
    public Double getWages() {
        return wages;
    }

    public void setWages(Double wages) {
        this.wages = wages;
    }

    @Column(name = "sbsj")
    public Date getGoWorkTime() {
        return goWorkTime;
    }

    public void setGoWorkTime(Date goWorkTime) {
        this.goWorkTime = goWorkTime;
    }

    @Column(name = "sbdd")
    public String getGoWorkPlace() {
        return goWorkPlace;
    }

    public void setGoWorkPlace(String goWorkPlace) {
        this.goWorkPlace = goWorkPlace;
    }

    @Column(name = "xbsj")
    public Date getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(Date offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    @Column(name = "xbdd")
    public String getOffWorkPlace() {
        return offWorkPlace;
    }

    public void setOffWorkPlace(String offWorkPlace) {
        this.offWorkPlace = offWorkPlace;
    }

    @Column(name = "cqqk")
    public String getGoWorkStatus() {
        return goWorkStatus;
    }

    public void setGoWorkStatus(String goWorkStatus) {
        this.goWorkStatus = goWorkStatus;
    }

    @Column(name = "cqqk2")
    public String getOffWorkStatus() {
        return offWorkStatus;
    }

    public void setOffWorkStatus(String offWorkStatus) {
        this.offWorkStatus = offWorkStatus;
    }

    @Column(name = "bcsm")
    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
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
