package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.sales.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-06-29 20:23
 * @Description: 合作协议
 */
public class SalesAgreementViewDTO implements Serializable {
    private Integer id;
    /** 协议编号 */
    private String agreementNo;
    /** 合作单位1 */
    private Integer partner1;
    private String partnerOneName;
    /** 合作单位1拼音 */
    private String partnerOneNameCode;
    /** 合作单位2 */
    private Integer partner2;
    private String partnerTwoName;
    /** 合作单位2拼音 */
    private String partnerTwoNameCode;
    /** 签订部门 */
    private String signDep;
    private String signDepText;
    /** 签订人 */
    private String signer;
    private String signerName;
    /** 签订日期 */
    private Date signDate;
    /** 合作开始日期 */
    private Date startDate;
    /** 合作结束日期 */
    private Date endDate;
    /** 合作起止日期 */
    private String  startStopDate;
    /** 合作类别 */
    private Integer cooperateType;
    private String cooperateTypeText;
    /** 原件状态 */
    private Integer originalStatus;
    private String originalStatusText;
    /** 是否公告披露 0否 1是 */
    private Integer notice;
    /** 业务归属 */
    private Integer ownerShip;
    /** 可以立项 0否 1是 */
    private Integer approval;
    /** 合作内容 */
    private String cooperateContent;
    /** 落地部门 */
    private String landingDep;
    private String landingDepText;
    /** 修改人 */
    private String modifier;
    private String modifierName;
    /** 修改日期 */
    private Date modifyDate;
    /** 登记人 */
    private String registerant;
    private String registerantName;
    /** 登记时间 */
    private Date registerDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public Integer getPartner1() {
        return partner1;
    }

    public void setPartner1(Integer partner1) {
        this.partner1 = partner1;
    }

    public Integer getPartner2() {
        return partner2;
    }

    public void setPartner2(Integer partner2) {
        this.partner2 = partner2;
    }

    public String getSignDep() {
        return signDep;
    }

    public void setSignDep(String signDep) {
        this.signDep = signDep;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getStartStopDate() {
        return startStopDate;
    }

    public void setStartStopDate(String startStopDate) {
        this.startStopDate = startStopDate;
    }

    public Integer getCooperateType() {
        return cooperateType;
    }

    public void setCooperateType(Integer cooperateType) {
        this.cooperateType = cooperateType;
    }

    public Integer getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(Integer originalStatus) {
        this.originalStatus = originalStatus;
    }

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    public String getPartnerOneName() {
        return partnerOneName;
    }

    public void setPartnerOneName(String partnerOneName) {
        this.partnerOneName = partnerOneName;
    }

    public String getPartnerTwoName() {
        return partnerTwoName;
    }

    public void setPartnerTwoName(String partnerTwoName) {
        this.partnerTwoName = partnerTwoName;
    }

    public String getSignDepText() {
        return signDepText;
    }

    public void setSignDepText(String signDepText) {
        this.signDepText = signDepText;
    }

    public String getCooperateTypeText() {
        return cooperateTypeText;
    }

    public void setCooperateTypeText(String cooperateTypeText) {
        this.cooperateTypeText = cooperateTypeText;
    }

    public String getOriginalStatusText() {
        return originalStatusText;
    }

    public void setOriginalStatusText(String originalStatusText) {
        this.originalStatusText = originalStatusText;
    }

    public String getPartnerOneNameCode() {
        return partnerOneNameCode;
    }

    public void setPartnerOneNameCode(String partnerOneNameCode) {
        this.partnerOneNameCode = partnerOneNameCode;
    }

    public String getPartnerTwoNameCode() {
        return partnerTwoNameCode;
    }

    public void setPartnerTwoNameCode(String partnerTwoNameCode) {
        this.partnerTwoNameCode = partnerTwoNameCode;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getSignerName() {
        return signerName;
    }

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

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

    public Integer getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(Integer ownerShip) {
        this.ownerShip = ownerShip;
    }

    public Integer getApproval() {
        return approval;
    }

    public void setApproval(Integer approval) {
        this.approval = approval;
    }

    public String getCooperateContent() {
        return cooperateContent;
    }

    public void setCooperateContent(String cooperateContent) {
        this.cooperateContent = cooperateContent;
    }

    public String getLandingDep() {
        return landingDep;
    }

    public void setLandingDep(String landingDep) {
        this.landingDep = landingDep;
    }

    public String getLandingDepText() {
        return landingDepText;
    }

    public void setLandingDepText(String landingDepText) {
        this.landingDepText = landingDepText;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRegisterant() {
        return registerant;
    }

    public void setRegisterant(String registerant) {
        this.registerant = registerant;
    }

    public String getRegisterantName() {
        return registerantName;
    }

    public void setRegisterantName(String registerantName) {
        this.registerantName = registerantName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
