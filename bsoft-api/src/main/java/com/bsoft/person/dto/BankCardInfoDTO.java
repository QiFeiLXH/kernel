package com.bsoft.person.dto;

import java.io.Serializable;

public class BankCardInfoDTO implements Serializable {
    private Integer id;
    /** 是否需办卡 */
    private Integer needApplyCard;
    //银行卡照片
    private Integer backCardPhoto;
    /** 开户银行 */
    private String depositBank;

    /** 银行账号 */
    private String bankAccount;

    /** 开户支行 */
    private String openingBank;
    /** 一寸照 */
    private Integer oneInchPhoto;
    /** 状态*/
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNeedApplyCard() {
        return needApplyCard;
    }

    public void setNeedApplyCard(Integer needApplyCard) {
        this.needApplyCard = needApplyCard;
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

    public Integer getOneInchPhoto() {
        return oneInchPhoto;
    }

    public void setOneInchPhoto(Integer oneInchPhoto) {
        this.oneInchPhoto = oneInchPhoto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
