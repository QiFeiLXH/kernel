package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ker_person_lastspecial_view")
public class LastSpecialRankDO {
    private Integer id;
    private String personId;
    private Integer sequence;
    private String sequenceText;
    private Integer specialRank;
    private String specialRankText;
    private Date specialDate;
    private Integer managerRank;
    private String managerRankText;
    private Date managerDate;
    private String submitter;
    private Date submitDate;

    @Id
    @Column(name = "id")
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

    @Column(name = "zjxl")
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getSequenceText() {
        return sequenceText;
    }

    public void setSequenceText(String sequenceText) {
        this.sequenceText = sequenceText;
    }

    @Column(name = "zyzj")
    public Integer getSpecialRank() {
        return specialRank;
    }

    public void setSpecialRank(Integer specialRank) {
        this.specialRank = specialRank;
    }

    public String getSpecialRankText() {
        return specialRankText;
    }

    public void setSpecialRankText(String specialRankText) {
        this.specialRankText = specialRankText;
    }

    @Column(name = "zxrq1")
    public Date getSpecialDate() {
        return specialDate;
    }

    public void setSpecialDate(Date specialDate) {
        this.specialDate = specialDate;
    }

    @Column(name = "glzj")
    public Integer getManagerRank() {
        return managerRank;
    }

    public void setManagerRank(Integer managerRank) {
        this.managerRank = managerRank;
    }

    public String getManagerRankText() {
        return managerRankText;
    }

    public void setManagerRankText(String managerRankText) {
        this.managerRankText = managerRankText;
    }

    @Column(name = "zxrq2")
    public Date getManagerDate() {
        return managerDate;
    }

    public void setManagerDate(Date managerDate) {
        this.managerDate = managerDate;
    }

    @Column(name = "djry")
    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    @Column(name = "djrq")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
}
