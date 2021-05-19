package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/*
 * @author  hy
 * @date  2020/5/24 22:33
 * @description 驻地信息
 */
@Entity
@Table(name = "bsoftmis.employee_transferlocation")
public class ResidentDO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "zpid")
    private Integer recruitmentId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "localflag")
    private Integer localFlag;

    @Column(name = "transferdate")
    private Date transferDate;

    @Column(name = "recorduser")
    private String registrant;

    @Column(name = "recorddate")
    private Date registrationTime;

    @Column(name = "divisionProvince")
    private String divisionProvince;

    @Column(name = "divisionCity")
    private String divisionCity;

    @Column(name = "divisionCounty")
    private String divisionCounty;

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

    public Integer getLocalFlag() {
        return localFlag;
    }

    public void setLocalFlag(Integer localFlag) {
        this.localFlag = localFlag;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDivisionProvince() {
        return divisionProvince;
    }

    public void setDivisionProvince(String divisionProvince) {
        this.divisionProvince = divisionProvince;
    }

    public String getDivisionCity() {
        return divisionCity;
    }

    public void setDivisionCity(String divisionCity) {
        this.divisionCity = divisionCity;
    }

    public String getDivisionCounty() {
        return divisionCounty;
    }

    public void setDivisionCounty(String divisionCounty) {
        this.divisionCounty = divisionCounty;
    }
}
