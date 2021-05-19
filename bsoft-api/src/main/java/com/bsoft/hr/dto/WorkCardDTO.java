package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:26
 * @Description
 */
public class WorkCardDTO implements Serializable {
    private Integer id;
    /** 工号 */
    private String personId;
    private String personName;
    /** 部门id */
    private String deptId;
    private String deptName;
    /** 拼音 */
    private String simpleCode;
    /** 报道日期 */
    private String startDate;
    /** 报道日期 */
    private String dutyDate;
    /** 员工类别 */
    private Integer personType;
    /** 卡种类 */
    private Integer cardType;
    private String cardTypeText;
    /** 是否充值到工牌 */
    private Integer recharge;
    /** 充值金额 */
    private Double amount;
    /** 门禁权限 */
    private String accessControl;
    /** 状态 */
    private Integer status;
    /** 核实人 */
    private String verifier;
    /** 核实日期 */
    private Date verifyDate;
    /** 制作人 */
    private String maker;
    /** 制作日期 */
    private Date makeDate;
    /** 门禁开通人 */
    private String opener;
    /** 门禁开通日期 */
    private Date openDate;
    /** 领取标志 */
    private Integer received;
    /** 是否需要办理工牌 */
    private Integer workcardFlag;
    /** 人员归属群 */
    private Integer personnelGroup;
    private String personnelGroupText;
    /** 一寸照*/
    private Integer oneInchPhoto;
    /** 省*/
    private String divisionProvince;
    private String divisionProvinceText;
    /** 市*/
    private String divisionCity;
    private String divisionCityText;
    /** 县*/
    private String divisionCounty;
    private String divisionCountyText;
    /** 岗位*/
    private Integer restype;
    private String restypeText;
    /** 本地化*/
    private Integer localFlag;
    /** 工牌编号*/
    private String workCardNo;
    /** 招聘id*/
    private Integer recruitmentId;
    /** 性别*/
    private Integer gender;
    private String genderText;

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

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(String dutyDate) {
        this.dutyDate = dutyDate;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getRecharge() {
        return recharge;
    }

    public void setRecharge(Integer recharge) {
        this.recharge = recharge;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(String accessControl) {
        this.accessControl = accessControl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public String getOpener() {
        return opener;
    }

    public void setOpener(String opener) {
        this.opener = opener;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    public Integer getWorkcardFlag() {
        return workcardFlag;
    }

    public void setWorkcardFlag(Integer workcardFlag) {
        this.workcardFlag = workcardFlag;
    }

    public Integer getPersonnelGroup() {
        return personnelGroup;
    }

    public void setPersonnelGroup(Integer personnelGroup) {
        this.personnelGroup = personnelGroup;
    }

    public String getPersonnelGroupText() {
        return personnelGroupText;
    }

    public void setPersonnelGroupText(String personnelGroupText) {
        this.personnelGroupText = personnelGroupText;
    }

    public Integer getOneInchPhoto() {
        return oneInchPhoto;
    }

    public void setOneInchPhoto(Integer oneInchPhoto) {
        this.oneInchPhoto = oneInchPhoto;
    }

    public String getDivisionProvince() {
        return divisionProvince;
    }

    public void setDivisionProvince(String divisionProvince) {
        this.divisionProvince = divisionProvince;
    }

    public String getDivisionProvinceText() {
        return divisionProvinceText;
    }

    public void setDivisionProvinceText(String divisionProvinceText) {
        this.divisionProvinceText = divisionProvinceText;
    }

    public String getDivisionCity() {
        return divisionCity;
    }

    public void setDivisionCity(String divisionCity) {
        this.divisionCity = divisionCity;
    }

    public String getDivisionCityText() {
        return divisionCityText;
    }

    public void setDivisionCityText(String divisionCityText) {
        this.divisionCityText = divisionCityText;
    }

    public String getDivisionCounty() {
        return divisionCounty;
    }

    public void setDivisionCounty(String divisionCounty) {
        this.divisionCounty = divisionCounty;
    }

    public String getDivisionCountyText() {
        return divisionCountyText;
    }

    public void setDivisionCountyText(String divisionCountyText) {
        this.divisionCountyText = divisionCountyText;
    }

    public Integer getRestype() {
        return restype;
    }

    public void setRestype(Integer restype) {
        this.restype = restype;
    }

    public String getRestypeText() {
        return restypeText;
    }

    public void setRestypeText(String restypeText) {
        this.restypeText = restypeText;
    }

    public Integer getLocalFlag() {
        return localFlag;
    }

    public void setLocalFlag(Integer localFlag) {
        this.localFlag = localFlag;
    }

    public String getWorkCardNo() {
        return workCardNo;
    }

    public void setWorkCardNo(String workCardNo) {
        this.workCardNo = workCardNo;
    }

    public String getCardTypeText() {
        return cardTypeText;
    }

    public void setCardTypeText(String cardTypeText) {
        this.cardTypeText = cardTypeText;
    }

    public Integer getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Integer recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getGenderText() {
        return genderText;
    }

    public void setGenderText(String genderText) {
        this.genderText = genderText;
    }
}
