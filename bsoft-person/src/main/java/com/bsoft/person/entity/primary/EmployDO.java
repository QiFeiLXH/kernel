package com.bsoft.person.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2020/5/18
 * @Description:招聘信息
 */
@Entity
@Table(name = "bsoftmis.RS_ZPXX")
public class EmployDO {
    /** id */
    @Id
    @Column(name = "ID")
    private Integer id;

    /** 身份证号 */
    @Column(name = "SFZH")
    @Length(max = 20,message = "身份证号长度不能超过20位")
    private String idCard;

    /** 姓名 */
    @Column(name = "XM")
    @Length(max = 13,message = "姓名长度不能超过13位")
    private String personName;

    /** 性别 */
    @Column(name = "XB")
    @NotNull(message = "性别不能为空")
    private Integer gender;

    /** 出生日期 */
    @Column(name = "CSNY")
    private Date birthDate;

    /** 出生地 */
    @Column(name = "CSD")
    private Integer birthplace;

    /** 籍贯 */
    @Column(name = "JG")
    private Integer nativePlace;

    /** 民族 */
    @Column(name = "MZ")
    private Integer nation;

    /** 身高 */
    @Column(name = "SG")
    private Integer height;

    /** 体重 */
    @Column(name = "TZ")
    private BigDecimal weight;

    /** 血型 */
    @Column(name = "XX")
    private Integer bloodType;

    /** 文化程度 */
    @Column(name = "WHCD")
    private Integer education;

    /** 婚姻状况 */
    @Column(name = "HF")
    private Integer maritalStatus;

    /** 户口详细地址 */
    @Column(name = "HKDZ")
    @Length(max = 100,message = "户口详细地址长度不能超过100位")
    private String registeredAddress;

    /** 手机号码 */
    @Column(name = "LXDH")
    @Length(max = 20,message = "手机号码长度不能超过20位")
    private String phone;

    /** 家庭住址 */
    @Column(name = "JTZZ")
    @Length(max = 100,message = "家庭地址长度不能超过100位")
    private String homeAddress;

    /** 政治面貌 */
    @Column(name = "ZZMM")
    private Integer politicalOutlook;

    /** 应聘岗位 */
    @Column(name = "YPGW")
    @NotNull(message = "应聘岗位不能为空")
    private Integer appliedPosition;

    /** 录用部门 */
    @Column(name = "YPBM")
    private String dept;

    /** 登记时间 */
    @Column(name = "DJSJ")
    private Date registrationTime;

    /** 登记人员 */
    @Column(name = "DJRY")
    private String registrant;

    /** 招聘类型 0普通；1实习；2中层；3领导；4顾问*/
    @Column(name = "SXS")
    @NotNull(message = "招聘类型不能为空")
    private Integer recruitmentType;

    /** 录用备注 boss直聘 前程无忧 智联招聘 其他*/
    @Column(name = "NOTES")
    private Integer employmentNotes;

    /** 录用备注备注*/
    @Column(name = "NOTESINFO")
    @Length(max = 80,message = "录用备注说明长度不能超过80位")
    private String employmentNotesDetail;

    /** 户口性质 */
    @Column(name = "HKXZ")
    private Integer accountNature;

    /** 开户银行 */
    @Column(name = "KHYH")
    private String depositBank;

    /** 银行账号 */
    @Length(max = 20,message = "开户银行长度不能超过20位")
    @Column(name = "YHZH")
    private String bankAccount;

    /** 开户支行 */
    @Column(name = "KHH")
    @Length(max = 50,message = "开户支行长度不能超过50位")
    private String openingBank;

    /** 所属公司 */
    @Column(name = "SSGS")
    private Integer company;

    /** 是否留用 1 是；0否*/
    @Column(name = "SFLY")
    private Integer isUse;

    /** 实习薪资 */
    @Column(name = "SXXZ")
    private Double internshipSalary;

    /** 试用期薪资 */
    @Column(name = "SYXZ")
    private Double trialSalary;

    /** 转正薪资 */
    @Column(name = "ZZXZ")
    private Double regularSalary;

    /** 个人邮箱 */
    @Column(name = "EMAIL")
    @Length(max = 100,message = "个人邮箱长度不能超过100位")
    private String email;

    /** 身份证正面图片ID */
    @Column(name = "SFZF")
    private Integer frontIdCard;

    /** 身份证反面图片ID */
    @Column(name = "SFZB")
    private Integer reverseIdCard;

    /** 试用期 */
    @Column(name = "SYQ")
    private Integer probationPeriod;

    /** 报到日期 */
    @Column(name = "STARTDATE")
    private Date startDate;

    /** 社保缴纳地 */
    @Column(name = "SBJRD")
    private Integer paymentPlace;

    /** 社保缴纳基数 */
    @Column(name = "SBJRJS")
    private Double paymentBase;

    /** 银行卡照片 */
    @Column(name = "YHKZP")
    private Integer backCardPhoto;

    /** 状态 默认0 1：招聘中 2：录用（审核通过） 3：人才库 4: 已发邮件 5：待审核 6：退回待修改 7: hr已审核（总部未审） 8：总部已核*/
    @Column(name = "LYBZ")
    @NotNull(message = "招聘状态不能为空")
    private Integer status;

    /** 退回理由 */
    @Column(name = "REMARKS")
    @Length(max = 30,message = "退回理由长度不能超过30位")
    private String  remarks;

    /** 第一次正式工作时间 */
    @Column(name = "FIRSTWORK")
    private Date  firstWork;

    /** 毕业时间 */
    @Column(name = "GRADUATEDATE")
    private Date  graduateDate;

    /** 证件类型 */
    @Column(name = "IDCARDTYPE")
    private Integer idCardType;

    /** 是否需办卡*/
    @Column(name = "BKBZ")
    private Integer needApplyCard;

    //专业
    @Column(name = "ZY")
    private Integer major;

    @Column(name = "WORKEDYEARS")
    private Double workedYears;

    /** 一寸照*/
    @Column(name = "ONEINCHPHOTO")
    private Integer oneInchPhoto;

    /** 社保缴纳标志*/
    @Column(name = "SBJNBZ")
    private Integer paymentFlag;

    /** 连续工龄标志*/
    @Column(name = "CONTINUOUSYEARSMARK")
    private Integer continuousYearsMark;

    /** 工牌是否办理标志*/
    @Column(name = "WORKCARDFLAG")
    private Integer workCardFlag;

    /** 餐补充值入工牌*/
    @Column(name = "MEALRECHARGEFLAG")
    private Integer mealRechargeFlag;

    /** 慧康物联网,同创业工号*/
    @Column(name = "SAMEBSOFT")
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

    public Integer getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Integer birthplace) {
        this.birthplace = birthplace;
    }

    public Integer getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(Integer nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
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

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(Integer politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public Integer getAppliedPosition() {
        return appliedPosition;
    }

    public void setAppliedPosition(Integer appliedPosition) {
        this.appliedPosition = appliedPosition;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public Integer getRecruitmentType() {
        return recruitmentType;
    }

    public void setRecruitmentType(Integer recruitmentType) {
        this.recruitmentType = recruitmentType;
    }

    public Integer getEmploymentNotes() {
        return employmentNotes;
    }

    public void setEmploymentNotes(Integer employmentNotes) {
        this.employmentNotes = employmentNotes;
    }

    public Integer getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(Integer accountNature) {
        this.accountNature = accountNature;
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

    public String getEmploymentNotesDetail() {
        return employmentNotesDetail;
    }

    public void setEmploymentNotesDetail(String employmentNotesDetail) {
        this.employmentNotesDetail = employmentNotesDetail;
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

    public Integer getPaymentPlace() {
        return paymentPlace;
    }

    public void setPaymentPlace(Integer paymentPlace) {
        this.paymentPlace = paymentPlace;
    }

    public Double getPaymentBase() {
        return paymentBase;
    }

    public void setPaymentBase(Double paymentBase) {
        this.paymentBase = paymentBase;
    }

    public Integer getBackCardPhoto() {
        return backCardPhoto;
    }

    public void setBackCardPhoto(Integer backCardPhoto) {
        this.backCardPhoto = backCardPhoto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getFirstWork() {
        return firstWork;
    }

    public void setFirstWork(Date firstWork) {
        this.firstWork = firstWork;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public Integer getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
    }

    public Integer getNeedApplyCard() {
        return needApplyCard;
    }

    public void setNeedApplyCard(Integer needApplyCard) {
        this.needApplyCard = needApplyCard;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Double getWorkedYears() {
        return workedYears;
    }

    public void setWorkedYears(Double workedYears) {
        this.workedYears = workedYears;
    }

    public Integer getOneInchPhoto() {
        return oneInchPhoto;
    }

    public void setOneInchPhoto(Integer oneInchPhoto) {
        this.oneInchPhoto = oneInchPhoto;
    }

    public Integer getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(Integer paymentFlag) {
        this.paymentFlag = paymentFlag;
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
