package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/*
 * @author  hy
 * @date  2020/5/24 15:08
 * @description 岗位信息
 */
@Entity
@Table(name = "bsoftmis.T_DDQK")
public class PositionDO {

    @Id
    @Column(name = "id")
    private Integer id;

    /** 招聘id*/
    @Column(name = "zpid")
    private Integer recruitmentId;
    /** 员工工号*/
    @Column(name = "yggh")
    private String personId;
    /** 调后人员归属群*/
    @Column(name = "dhgsq")
    private Integer personnelGroup;
    /** 调前人员归属群*/
    @Column(name = "dqgsq")
    private Integer personnelGroupBefore;
    /** 调动日期*/
    @Column(name = "ddrq")
    private Date TransferDate;
    /** 调后通讯补贴*/
    @Column(name = "dhbt")
    private Integer communicationSubsidy;
    /** 调前通讯补贴*/
    @Column(name = "dqbt")
    private Integer communicationSubsidyBefore;
    /** 登记人员*/
    @Column(name = "djry")
    private String registrant;
    /** 登记时间*/
    @Column(name = "djrq")
    private Date registrationTime;
    /** 调后大类*/
    @Column(name = "dhdl")
    private String jobCategory;

    /** 调前大类*/
    @Column(name = "dqdl")
    private String jobCategoryBefore;

    //调后部门
    @Column(name = "dhbm")
    private String departmentAfter;
    //调前部门
    @Column(name = "dqbm")
    private String departmentDefore;

    //调后岗位
    @Column(name = "dhzw")
    private String postAfter;
    //调前岗位
    @Column(name = "dqzw")
    private String postDefore;

    @Column(name = "flag")
    private Integer flag;

    //调前费用类别
    @Column(name = "dqcost")
    private Integer costTypeBefore;
    //调后费用类别
    @Column(name = "dhcost")
    private Integer costTypeAfter;

    //调前财务类别
    @Column(name = "dqfinancial")
    private Integer financialBefore;
    //调后财务类别
    @Column(name = "dhfinancial")
    private Integer financialAfter;

    //CSBZ为1(该标志用于调配记录传输到工资系统)
    private Integer csbz;

    public Integer getCsbz() {
        return csbz;
    }

    public void setCsbz(Integer csbz) {
        this.csbz = csbz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Integer recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getPersonnelGroup() {
        return personnelGroup;
    }

    public void setPersonnelGroup(Integer personnelGroup) {
        this.personnelGroup = personnelGroup;
    }

    public Date getTransferDate() {
        return TransferDate;
    }

    public void setTransferDate(Date transferDate) {
        TransferDate = transferDate;
    }

    public Integer getCommunicationSubsidy() {
        return communicationSubsidy;
    }

    public void setCommunicationSubsidy(Integer communicationSubsidy) {
        this.communicationSubsidy = communicationSubsidy;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getDepartmentAfter() {
        return departmentAfter;
    }

    public void setDepartmentAfter(String departmentAfter) {
        this.departmentAfter = departmentAfter;
    }

    public String getPostAfter() {
        return postAfter;
    }

    public void setPostAfter(String postAfter) {
        this.postAfter = postAfter;
    }

    public Integer getPersonnelGroupBefore() {
        return personnelGroupBefore;
    }

    public void setPersonnelGroupBefore(Integer personnelGroupBefore) {
        this.personnelGroupBefore = personnelGroupBefore;
    }

    public Integer getCommunicationSubsidyBefore() {
        return communicationSubsidyBefore;
    }

    public void setCommunicationSubsidyBefore(Integer communicationSubsidyBefore) {
        this.communicationSubsidyBefore = communicationSubsidyBefore;
    }

    public String getJobCategoryBefore() {
        return jobCategoryBefore;
    }

    public void setJobCategoryBefore(String jobCategoryBefore) {
        this.jobCategoryBefore = jobCategoryBefore;
    }

    public String getDepartmentDefore() {
        return departmentDefore;
    }

    public void setDepartmentDefore(String departmentDefore) {
        this.departmentDefore = departmentDefore;
    }

    public String getPostDefore() {
        return postDefore;
    }

    public void setPostDefore(String postDefore) {
        this.postDefore = postDefore;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getCostTypeBefore() {
        return costTypeBefore;
    }

    public void setCostTypeBefore(Integer costTypeBefore) {
        this.costTypeBefore = costTypeBefore;
    }

    public Integer getCostTypeAfter() {
        return costTypeAfter;
    }

    public void setCostTypeAfter(Integer costTypeAfter) {
        this.costTypeAfter = costTypeAfter;
    }

    public Integer getFinancialBefore() {
        return financialBefore;
    }

    public void setFinancialBefore(Integer financialBefore) {
        this.financialBefore = financialBefore;
    }

    public Integer getFinancialAfter() {
        return financialAfter;
    }

    public void setFinancialAfter(Integer financialAfter) {
        this.financialAfter = financialAfter;
    }
}
