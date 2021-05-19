package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:26
 * @Description
 */
@Entity
@Table(name="HR_WORKCARD")
public class WorkCardDO {
    private Integer id;
    /** 工号 */
    private String personId;
    /** 卡种类 */
    private Integer cardType;
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
    /** 工牌编号*/
    private String workCardNo;
    /** 是否需要办理工牌 */
    private Integer workcardFlag;

    @Id
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

    public String getWorkCardNo() {
        return workCardNo;
    }

    public void setWorkCardNo(String workCardNo) {
        this.workCardNo = workCardNo;
    }

    public Integer getWorkcardFlag() {
        return workcardFlag;
    }

    public void setWorkcardFlag(Integer workcardFlag) {
        this.workcardFlag = workcardFlag;
    }
}
