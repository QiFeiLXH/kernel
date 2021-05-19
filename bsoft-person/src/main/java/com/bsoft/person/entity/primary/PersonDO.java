package com.bsoft.person.entity.primary;

import com.bsoft.dictionary.annotation.dept.DeptAllDic;
import com.bsoft.dictionary.annotation.person.ManagerRankDic;
import com.bsoft.dictionary.annotation.person.RankSequenceDic;
import com.bsoft.dictionary.annotation.person.ResTypeDic;
import com.bsoft.dictionary.annotation.person.SpecialRankDic;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BSOFTMIS.XTUSER")
public class PersonDO implements Serializable {
    private String personId;
    private String personName;
    @DeptAllDic
    private String deptId;
    @ResTypeDic
    private String restype;
    private String mobile;
    private String email;
    private Integer userId;
    private String isValid; //1离职
    private Integer company;
    @RankSequenceDic
    private Integer sequence;
    @SpecialRankDic
    private Integer specialRank;
    @ManagerRankDic
    private Integer managerRank;
    private String simpleCode;
    private String evaluationGrade;
    private String evaluationContent;
    private Integer year;
    private Double probationSalary;
    private Double regularSalary;
    private Double paymentBase;
    private Integer paymentPlace;

    private String jobCategory;
    private Integer personnelGroup;//人员归属群
    private Integer transfer;
    private Integer import_flag;
    private Integer importflag;
    private Integer emailflag;
    private String yxrl;
    private String divisionprovince;
    private String divisioncity;
    private String divisioncounty;
    private Integer type;
    private Integer localflag;

    //入职日期
    private Date startDate;
    //离职日期
    private Date  endDate;

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

    /**
     * 用于set去重
     * @param arg0
     * @return
     */
    @Override
    public boolean equals(Object arg0) {
        // TODO Auto-generated method stub
        PersonDO p = (PersonDO) arg0;
        return personId.equals(p.personId);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        String str = personId;
        return str.hashCode();
    }


    @Id
    @Column(name = "xuslgname")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
    @Column(name = "xdno")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    @Column(name = "restype")
    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }
    @Column(name = "mobileno")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "xusname")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Column(name = "id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "flag")
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    @Column(name = "ssgs")
    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    @Column(name = "pym")
    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    @Transient
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    @Transient
    public Integer getSpecialRank() {
        return specialRank;
    }

    public void setSpecialRank(Integer specialRank) {
        this.specialRank = specialRank;
    }

    @Transient
    public Integer getManagerRank() {
        return managerRank;
    }

    public void setManagerRank(Integer managerRank) {
        this.managerRank = managerRank;
    }

    @Column(name = "pjdj")
    public String getEvaluationGrade() {
        return evaluationGrade;
    }

    public void setEvaluationGrade(String evaluationGrade) {
        this.evaluationGrade = evaluationGrade;
    }

    @Column(name = "pjnr")
    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    @Transient
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "syxz")
    public Double getProbationSalary() {
        return probationSalary;
    }

    public void setProbationSalary(Double probationSalary) {
        this.probationSalary = probationSalary;
    }

    @Column(name = "zzxz")
    public Double getRegularSalary() {
        return regularSalary;
    }

    public void setRegularSalary(Double regularSalary) {
        this.regularSalary = regularSalary;
    }

    @Column(name = "sbjrjs")
    public Double getPaymentBase() {
        return paymentBase;
    }

    public void setPaymentBase(Double paymentBase) {
        this.paymentBase = paymentBase;
    }

    @Column(name = "sbjrd")
    public Integer getPaymentPlace() {
        return paymentPlace;
    }

    public void setPaymentPlace(Integer paymentPlace) {
        this.paymentPlace = paymentPlace;
    }


    @Column(name = "GWDL")
    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    @Column(name = "rygsq")
    public Integer getPersonnelGroup() {
        return personnelGroup;
    }

    public void setPersonnelGroup(Integer personnelGroup) {
        this.personnelGroup = personnelGroup;
    }

    public Integer getTransfer() {
        return transfer;
    }

    public void setTransfer(Integer transfer) {
        this.transfer = transfer;
    }

    public Integer getImport_flag() {
        return import_flag;
    }

    public void setImport_flag(Integer import_flag) {
        this.import_flag = import_flag;
    }

    public Integer getImportflag() {
        return importflag;
    }

    public void setImportflag(Integer importflag) {
        this.importflag = importflag;
    }

    public Integer getEmailflag() {
        return emailflag;
    }

    public void setEmailflag(Integer emailflag) {
        this.emailflag = emailflag;
    }

    public String getYxrl() {
        return yxrl;
    }

    public void setYxrl(String yxrl) {
        this.yxrl = yxrl;
    }

    public String getDivisionprovince() {
        return divisionprovince;
    }

    public void setDivisionprovince(String divisionprovince) {
        this.divisionprovince = divisionprovince;
    }

    public String getDivisioncity() {
        return divisioncity;
    }

    public void setDivisioncity(String divisioncity) {
        this.divisioncity = divisioncity;
    }

    public String getDivisioncounty() {
        return divisioncounty;
    }

    public void setDivisioncounty(String divisioncounty) {
        this.divisioncounty = divisioncounty;
    }

    @Column(name = "SXS")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLocalflag() {
        return localflag;
    }

    public void setLocalflag(Integer localflag) {
        this.localflag = localflag;
    }
}
