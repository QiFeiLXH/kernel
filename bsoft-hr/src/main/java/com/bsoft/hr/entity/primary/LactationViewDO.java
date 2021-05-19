package com.bsoft.hr.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:04
 * @Description
 */
@Entity
@Table(name="BSOFT_PORTAL.HR_VACATION_LACTATION_VIEW")
public class LactationViewDO {
    @Id
    private Integer id;
    /** 工号 */
    private String personId;
    /** 姓名 */
    private String personName;
    /** 拼音简码 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 哺乳假时长 */
    private Double duration;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 状态  1未生效  2有效  3失效 */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
