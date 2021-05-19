package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * 假期明细情况（加班，年假）
 */
@Entity
@Table(name="hr_work_vacation_detail")
public class WorkVacationDetailDO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 年份 年假存
     */
    private String year;
    /**
     * 员工工号
     */
    private String personId;
    /**
     * 部门id
     */
    private String dept;
    /**
     * 假期类型
     */
    private Integer type;
    /**
     * 加班时长/年假时长
     */
    private Double workTimes;
    /**
     * 生成日期/加班日期
     */
    private Date createDate;
    /**
     * 有效开始日期
     */
    private Date startDate;
    /**
     * 有效期至明年第一季度
     */
    private Date endDate;
    /**
     * 使用标志 1.已用  0.未用 默认为0 当请假单使用假期时设置为1
     */
    private Integer useFlag;
    /**
     * 使用时间 当请假单使用假期时设置时间
     */
    private Date useDate;
    /**
     * 请假表id 当请假单使用假期时设置请假单id
     */
    private Integer leaveId;

    /**
     * 假期加班单主表id
     */
    private Integer workId;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(Double workTimes) {
        this.workTimes = workTimes;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Integer getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Integer useFlag) {
        this.useFlag = useFlag;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }
}
