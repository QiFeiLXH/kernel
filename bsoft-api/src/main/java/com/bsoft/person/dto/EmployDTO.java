package com.bsoft.person.dto;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
public class EmployDTO implements Serializable {

    private Integer id;

    /** 身份证号 */
    private String idCard;

    /** 姓名 */
    private String personName;

    /** 性别 */
    private Integer gender;

    /** 出生日期 */
    private Date birthDate;

    /** 手机号码 */
    private String phone;

    /** 政治面貌 */
    private Integer politicalOutlook;
    private String politicalOutlookText;

    /** 应聘岗位 */
    private Integer appliedPosition;

    private String appliedPositionText;

    /** 录用部门 */
    private String dept;

    private String deptText;

    /** 登记时间 */
    private Date registrationTime;

    /** 登记人员 */
    private String registrant;

    /** 登记人员电话 */
    private String registrantPhone;

    private String registrantName;

    /** 登记人员邮箱 */
    private String registrantEmail;

    /** 招聘类型 0普通；1实习；2中层；3领导；4顾问*/
    private Integer recruitmentType;

    private String recruitmentTypeText;

    /** 录用备注 boss直聘 前程无忧 智联招聘 其他*/
    private Integer employmentNotes;

    private String employmentNotesText;

    /** 录用备注备注*/
    private String employmentNotesDetail;

    /** 文化程度*/
    private Integer education;

    private String educationText;

    /** 是否需办卡 */
    private Integer needApplyCard;
    private String needApplyCardText;
    //银行卡照片
    private Integer backCardPhoto;
    /** 开户银行 */
    private String depositBank;

    /** 银行账号 */
    private String bankAccount;

    /** 开户支行 */
    private String openingBank;

    /** 所属公司 */
    private Integer company;

    private String companyText;

    /** 是否留用 1 是；0否*/
    private Integer isUse;

    /** 实习薪资 */
    private Double internshipSalary;

    /** 试用期薪资 */
    private Double trialSalary;

    /** 转正薪资 */
    private Double regularSalary;

    /** 个人邮箱 */
    private String email;

    /** 试用期 */
    private Integer probationPeriod;

    /** 报到日期 */
    private Date startDate;

    /** 状态 默认0 1：招聘中 2：录用（审核通过） 3：人才库 4: 已发邮件 5：待审核 6：退回待修改*/
    private Integer status;

    private String statusText;

    /** 退回理由 */
    private String  remarks;

    /** 民族 */
    private Integer nation;
    private String nationText;

    /** 出生地 */
    private Integer birthplace;
    private String birthplaceText;

    private Integer birthplaceCity;
    private String birthplaceCityText;

    private Integer birthplaceProvince;
    private String birthplaceProvinceText;

    /** 籍贯 */
    private Integer nativePlace;
    private String nativePlaceText;

    private Integer nativePlaceCity;
    private String nativePlaceCityText;

    private Integer nativePlaceProvince;
    private String nativePlaceProvinceText;

    //身高
    private Integer height;
    //体重
    private BigDecimal weight;
    //血型
    private Integer bloodType;
    private String bloodTypeText;
    //婚姻状况
    private Integer maritalStatus;
    private String maritalStatusText;

    //户口性质
    private Integer accountNature;
    private String accountNatureText;

    //户口地址
    private String registeredAddress;
    //家庭地址
    private String homeAddress;
    //身份证正面
    private Integer frontIdCard;
    //身份证反面
    private Integer reverseIdCard;

    /** 岗位大类 */
    private String jobCategory;

    private String jobCategoryText;

    /** 人员归属群 */
    private Integer personnelGroup;
    private String personnelGroupText;

    /** 岗位信息Id */
    private Integer positionInfoId;

    /** 驻地信息Id */
    private Integer residentInfoId;

    /** 0 保存  1 需发送 */
    private Integer sendStatus;

    private String province;

    private String city;

    private String county;

    private Integer localFlag;
    //毕业时间
    private Date graduateDate;

    //第一次正式工作时间
    private Date firstWork;
    /** 1 身份证  2 护照 */
    private Integer idCardType;

    /** 社保缴纳地*/
    private Integer paymentPlace;
    private String paymentPlaceText;

    /** 社保缴纳基数*/
    private Double paymentBase;

    /** 调后通讯补贴*/
    private Integer communicationSubsidy;
    private String communicationSubsidyText;

    /** 一寸照*/
    private Integer oneInchPhoto;

    private String divisionProvince;

    private String divisionProvinceText;

    private String divisionCity;
    private String divisionCityText;

    private String divisionCounty;
    private String divisionCountyText;

    /** 社保缴纳标志*/
    private Integer paymentFlag;

    /** 入司前工龄*/
    private Double workedYears;

    /** 连续工龄标志*/
    private Integer continuousYearsMark;

    /** 工牌是否办理标志*/
    private Integer workCardFlag;

    /** 餐补充值入工牌*/
    private Integer mealRechargeFlag;

    /** 慧康物联网,同创业工号*/
    private Integer sameBsoft;

    /** 总部审核时间 */
    private Date auditDate;

    /** 总部审核人*/
    private String auditter;

    public Integer getWorkCardFlag() {
        return workCardFlag;
    }

    public void setWorkCardFlag(Integer workCardFlag) {
        this.workCardFlag = workCardFlag;
    }

    public Integer getMealRechargeFlag() {
        return mealRechargeFlag;
    }

    public void setMealRechargeFlag(Integer mealRechargeFlag) {
        this.mealRechargeFlag = mealRechargeFlag;
    }

    public Integer getSameBsoft() {
        return sameBsoft;
    }

    public void setSameBsoft(Integer sameBsoft) {
        this.sameBsoft = sameBsoft;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(Integer politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public String getPoliticalOutlookText() {
        return politicalOutlookText;
    }

    public void setPoliticalOutlookText(String politicalOutlookText) {
        this.politicalOutlookText = politicalOutlookText;
    }

    public Integer getAppliedPosition() {
        return appliedPosition;
    }

    public void setAppliedPosition(Integer appliedPosition) {
        this.appliedPosition = appliedPosition;
    }

    public String getAppliedPositionText() {
        return appliedPositionText;
    }

    public void setAppliedPositionText(String appliedPositionText) {
        this.appliedPositionText = appliedPositionText;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptText() {
        return deptText;
    }

    public void setDeptText(String deptText) {
        this.deptText = deptText;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistrantPhone() {
        return registrantPhone;
    }

    public void setRegistrantPhone(String registrantPhone) {
        this.registrantPhone = registrantPhone;
    }

    public String getRegistrantName() {
        return registrantName;
    }

    public void setRegistrantName(String registrantName) {
        this.registrantName = registrantName;
    }

    public String getRegistrantEmail() {
        return registrantEmail;
    }

    public void setRegistrantEmail(String registrantEmail) {
        this.registrantEmail = registrantEmail;
    }

    public Integer getRecruitmentType() {
        return recruitmentType;
    }

    public void setRecruitmentType(Integer recruitmentType) {
        this.recruitmentType = recruitmentType;
    }

    public String getRecruitmentTypeText() {
        return recruitmentTypeText;
    }

    public void setRecruitmentTypeText(String recruitmentTypeText) {
        this.recruitmentTypeText = recruitmentTypeText;
    }

    public Integer getEmploymentNotes() {
        return employmentNotes;
    }

    public void setEmploymentNotes(Integer employmentNotes) {
        this.employmentNotes = employmentNotes;
    }

    public String getEmploymentNotesText() {
        return employmentNotesText;
    }

    public void setEmploymentNotesText(String employmentNotesText) {
        this.employmentNotesText = employmentNotesText;
    }

    public String getEmploymentNotesDetail() {
        return employmentNotesDetail;
    }

    public void setEmploymentNotesDetail(String employmentNotesDetail) {
        this.employmentNotesDetail = employmentNotesDetail;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getEducationText() {
        return educationText;
    }

    public void setEducationText(String educationText) {
        this.educationText = educationText;
    }

    public Integer getNeedApplyCard() {
        return needApplyCard;
    }

    public void setNeedApplyCard(Integer needApplyCard) {
        this.needApplyCard = needApplyCard;
    }

    public String getNeedApplyCardText() {
        return needApplyCardText;
    }

    public void setNeedApplyCardText(String needApplyCardText) {
        this.needApplyCardText = needApplyCardText;
    }

    public Integer getBackCardPhoto() {
        return backCardPhoto;
    }

    public void setBackCardPhoto(Integer backCardPhoto) {
        this.backCardPhoto = backCardPhoto;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getCompanyText() {
        return companyText;
    }

    public void setCompanyText(String companyText) {
        this.companyText = companyText;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Double getInternshipSalary() {
        return internshipSalary;
    }

    public void setInternshipSalary(Double internshipSalary) {
        this.internshipSalary = internshipSalary;
    }

    public Double getTrialSalary() {
        return trialSalary;
    }

    public void setTrialSalary(Double trialSalary) {
        this.trialSalary = trialSalary;
    }

    public Double getRegularSalary() {
        return regularSalary;
    }

    public void setRegularSalary(Double regularSalary) {
        this.regularSalary = regularSalary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(Integer probationPeriod) {
        this.probationPeriod = probationPeriod;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public String getNationText() {
        return nationText;
    }

    public void setNationText(String nationText) {
        this.nationText = nationText;
    }

    public Integer getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Integer birthplace) {
        this.birthplace = birthplace;
    }

    public String getBirthplaceText() {
        return birthplaceText;
    }

    public void setBirthplaceText(String birthplaceText) {
        this.birthplaceText = birthplaceText;
    }

    public Integer getBirthplaceCity() {
        return birthplaceCity;
    }

    public void setBirthplaceCity(Integer birthplaceCity) {
        this.birthplaceCity = birthplaceCity;
    }

    public String getBirthplaceCityText() {
        return birthplaceCityText;
    }

    public void setBirthplaceCityText(String birthplaceCityText) {
        this.birthplaceCityText = birthplaceCityText;
    }

    public Integer getBirthplaceProvince() {
        return birthplaceProvince;
    }

    public void setBirthplaceProvince(Integer birthplaceProvince) {
        this.birthplaceProvince = birthplaceProvince;
    }

    public String getBirthplaceProvinceText() {
        return birthplaceProvinceText;
    }

    public void setBirthplaceProvinceText(String birthplaceProvinceText) {
        this.birthplaceProvinceText = birthplaceProvinceText;
    }

    public Integer getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(Integer nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlaceText() {
        return nativePlaceText;
    }

    public void setNativePlaceText(String nativePlaceText) {
        this.nativePlaceText = nativePlaceText;
    }

    public Integer getNativePlaceCity() {
        return nativePlaceCity;
    }

    public void setNativePlaceCity(Integer nativePlaceCity) {
        this.nativePlaceCity = nativePlaceCity;
    }

    public String getNativePlaceCityText() {
        return nativePlaceCityText;
    }

    public void setNativePlaceCityText(String nativePlaceCityText) {
        this.nativePlaceCityText = nativePlaceCityText;
    }

    public Integer getNativePlaceProvince() {
        return nativePlaceProvince;
    }

    public void setNativePlaceProvince(Integer nativePlaceProvince) {
        this.nativePlaceProvince = nativePlaceProvince;
    }

    public String getNativePlaceProvinceText() {
        return nativePlaceProvinceText;
    }

    public void setNativePlaceProvinceText(String nativePlaceProvinceText) {
        this.nativePlaceProvinceText = nativePlaceProvinceText;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodTypeText() {
        return bloodTypeText;
    }

    public void setBloodTypeText(String bloodTypeText) {
        this.bloodTypeText = bloodTypeText;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatusText() {
        return maritalStatusText;
    }

    public void setMaritalStatusText(String maritalStatusText) {
        this.maritalStatusText = maritalStatusText;
    }

    public Integer getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(Integer accountNature) {
        this.accountNature = accountNature;
    }

    public String getAccountNatureText() {
        return accountNatureText;
    }

    public void setAccountNatureText(String accountNatureText) {
        this.accountNatureText = accountNatureText;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getFrontIdCard() {
        return frontIdCard;
    }

    public void setFrontIdCard(Integer frontIdCard) {
        this.frontIdCard = frontIdCard;
    }

    public Integer getReverseIdCard() {
        return reverseIdCard;
    }

    public void setReverseIdCard(Integer reverseIdCard) {
        this.reverseIdCard = reverseIdCard;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobCategoryText() {
        return jobCategoryText;
    }

    public void setJobCategoryText(String jobCategoryText) {
        this.jobCategoryText = jobCategoryText;
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

    public Integer getPositionInfoId() {
        return positionInfoId;
    }

    public void setPositionInfoId(Integer positionInfoId) {
        this.positionInfoId = positionInfoId;
    }

    public Integer getResidentInfoId() {
        return residentInfoId;
    }

    public void setResidentInfoId(Integer residentInfoId) {
        this.residentInfoId = residentInfoId;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getLocalFlag() {
        return localFlag;
    }

    public void setLocalFlag(Integer localFlag) {
        this.localFlag = localFlag;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public Date getFirstWork() {
        return firstWork;
    }

    public void setFirstWork(Date firstWork) {
        this.firstWork = firstWork;
    }

    public Integer getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
    }

    public Integer getPaymentPlace() {
        return paymentPlace;
    }

    public void setPaymentPlace(Integer paymentPlace) {
        this.paymentPlace = paymentPlace;
    }

    public String getPaymentPlaceText() {
        return paymentPlaceText;
    }

    public void setPaymentPlaceText(String paymentPlaceText) {
        this.paymentPlaceText = paymentPlaceText;
    }

    public Double getPaymentBase() {
        return paymentBase;
    }

    public void setPaymentBase(Double paymentBase) {
        this.paymentBase = paymentBase;
    }

    public Integer getCommunicationSubsidy() {
        return communicationSubsidy;
    }

    public void setCommunicationSubsidy(Integer communicationSubsidy) {
        this.communicationSubsidy = communicationSubsidy;
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

    public String getCommunicationSubsidyText() {
        return communicationSubsidyText;
    }

    public void setCommunicationSubsidyText(String communicationSubsidyText) {
        this.communicationSubsidyText = communicationSubsidyText;
    }

    public Integer getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(Integer paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public Double getWorkedYears() {
        return workedYears;
    }

    public void setWorkedYears(Double workedYears) {
        this.workedYears = workedYears;
    }

    public Integer getContinuousYearsMark() {
        return continuousYearsMark;
    }

    public void setContinuousYearsMark(Integer continuousYearsMark) {
        this.continuousYearsMark = continuousYearsMark;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }
}
