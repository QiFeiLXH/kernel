package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

public class PersonDTO implements Serializable {
    private String personId;
    private String personName;
    private String deptId;
    private String deptIdText;
    private String restype;
    private String mobile;
    private String email;
    private String restypeText;
    private Integer sequence;
    private Integer specialRank;
    private Date specialDate;
    private Integer managerRank;
    private Date managerDate;
    private String specialRankText;
    private String sequenceText;
    private String managerRankText;
    private String cardPath;
    private String isValid;
    private Integer company;
    private Integer userId;

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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }


    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptIdText() {
        return deptIdText;
    }

    public void setDeptIdText(String deptIdText) {
        this.deptIdText = deptIdText;
    }

    public String getRestypeText() {
        return restypeText;
    }

    public void setRestypeText(String restypeText) {
        this.restypeText = restypeText;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getSpecialRank() {
        return specialRank;
    }

    public void setSpecialRank(Integer specialRank) {
        this.specialRank = specialRank;
    }

    public Date getSpecialDate() {
        return specialDate;
    }

    public void setSpecialDate(Date specialDate) {
        this.specialDate = specialDate;
    }

    public Integer getManagerRank() {
        return managerRank;
    }

    public void setManagerRank(Integer managerRank) {
        this.managerRank = managerRank;
    }

    public Date getManagerDate() {
        return managerDate;
    }

    public void setManagerDate(Date managerDate) {
        this.managerDate = managerDate;
    }

    public String getSpecialRankText() {
        return specialRankText;
    }

    public void setSpecialRankText(String specialRankText) {
        this.specialRankText = specialRankText;
    }

    public String getSequenceText() {
        return sequenceText;
    }

    public void setSequenceText(String sequenceText) {
        this.sequenceText = sequenceText;
    }

    public String getManagerRankText() {
        return managerRankText;
    }

    public void setManagerRankText(String managerRankText) {
        this.managerRankText = managerRankText;
    }

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
