package com.bsoft.sales.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.sales.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-06-29 20:23
 * @Description: 合作协议
 */
@Entity
@Table(name="ker_sales_agreement")
public class SalesAgreementUpdateDO {
    @Id
    private Integer id;
    /** 协议编号 */
    private String agreementNo;
    /** 合作单位1 */
    private Integer partner1;
    /** 合作单位2 */
    private Integer partner2;
    /** 签订部门 */
    private String signDep;
    /** 签订人 */
    private String signer;
    /** 签定日期 */
    private Date signDate;
    /** 合作类别 */
    private Integer cooperateType;
    /** 原件状态 */
    private Integer originalStatus;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 业务归属 */
    private Integer ownerShip;
    /** 是否公告披露 0否 1是 */
    private Integer notice;
    /** 可以立项 */
    private Integer approval;
    /** 修改人 */
    private String modifier;
    /** 修改日期 */
    private Date modifyDate;
    /** 合作内容 */
    private String cooperateContent;
    /** 落地部门 */
    private String landingDep;

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

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    public Integer getApproval() {
        return approval;
    }

    public void setApproval(Integer approval) {
        this.approval = approval;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

}
