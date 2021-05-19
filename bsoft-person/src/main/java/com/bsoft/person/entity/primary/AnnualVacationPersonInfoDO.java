package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "hr_work_annual_needcreate_view")
public class AnnualVacationPersonInfoDO {
    /**
     * 员工工号
     */
    private String personId;
    /**
     * 部门
     */
    private String dept;
    /**
     * 注销标志
     */
    private Integer logoff;
    /**
     * 入职日期
     */
    private Date jioningDate;
    /**
     * 入司前累计工龄
     */
    private Double beforeStanding;
    /**
     * 是否连续工龄标志
     */
    private Integer continuityFlag;
    /**
     * 试用开始日期
     */
    private Date probationStartDate;
    /**
     * 试用结束日期
     */
    private Date probationEndDate;

    /**
     * 员工类型  0普通  1实习  2中层 3领导
     */
    private Integer personType;
    /**
     * 生成类型  1.第一次生成的年假数据 0.每月1号有变化的需要生成的年假数据
     */
    private Integer type;

    @Id
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

    @Column(name = "flag")
    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public Date getJioningDate() {
        return jioningDate;
    }

    public void setJioningDate(Date jioningDate) {
        this.jioningDate = jioningDate;
    }

    public Double getBeforeStanding() {
        return beforeStanding;
    }

    public void setBeforeStanding(Double beforeStanding) {
        this.beforeStanding = beforeStanding;
    }

    public Integer getContinuityFlag() {
        return continuityFlag;
    }

    public void setContinuityFlag(Integer continuityFlag) {
        this.continuityFlag = continuityFlag;
    }

    public Date getProbationStartDate() {
        return probationStartDate;
    }

    public void setProbationStartDate(Date probationStartDate) {
        this.probationStartDate = probationStartDate;
    }

    public Date getProbationEndDate() {
        return probationEndDate;
    }

    public void setProbationEndDate(Date probationEndDate) {
        this.probationEndDate = probationEndDate;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
