package com.bsoft.common.dto;

import java.io.Serializable;
import java.util.Date;

public class PublicDicDTO implements Serializable {
    private Integer type;
    private Integer id;
    private String name;
    private String pinyin;
    /* 状态 */
    private Integer personflag;
    /* 登记日期 */
    private Date registerDate;
    /* 登记人 */
    private Integer Registrant;

    public Integer getPersonflag() {
        return personflag;
    }

    public void setPersonflag(Integer personflag) {
        this.personflag = personflag;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getRegistrant() {
        return Registrant;
    }

    public void setRegistrant(Integer registrant) {
        Registrant = registrant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
