package com.bsoft.hr.entity.primary;

import com.bsoft.hr.key.WorkVacationTotalViewKey;

import javax.persistence.*;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假（总览）视图
 */
@Entity
@Table(name = "hr_work_vacation_total_view")
@IdClass(WorkVacationTotalViewKey.class)
public class WorkVacationTotalViewDO {
    // 年份
    @Id
    @Column(name = "year")
    private String year;

    // 员工工号
    @Id
    @Column(name = "personid")
    private String personId;

    // 员工姓名
    @Column(name = "personname")
    private String personName;

    // 名字拼音简码
    @Column(name = "namecode")
    private String nameCode;

    // 部门编号
    @Column(name = "deptid")
    private String deptId;

    // 部门名称
    @Column(name = "deptname")
    private String deptName;

    // 总调休假
    @Column(name = "worktimes")
    private Double workTimes;

    // 已用调休假
    @Column(name = "usetimes")
    private Double useTimes;

    // 未用调休假
    @Column(name = "resttimes")
    private Double restTimes;

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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
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

    public Double getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(Double workTimes) {
        this.workTimes = workTimes;
    }

    public Double getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Double useTimes) {
        this.useTimes = useTimes;
    }

    public Double getRestTimes() {
        return restTimes;
    }

    public void setRestTimes(Double restTimes) {
        this.restTimes = restTimes;
    }
}
