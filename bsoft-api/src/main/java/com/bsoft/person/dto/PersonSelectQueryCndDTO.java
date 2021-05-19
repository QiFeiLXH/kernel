package com.bsoft.person.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/12/1
 * @description 人员选择器查询参数
 */
public class PersonSelectQueryCndDTO implements Serializable {
    /** 工号*/
    private String personId;
    /** 姓名*/
    private String personName;
    /** 离职状态 0在职1离职*/
    private String isValid;
    /** 拼音码*/
    private String simpleCode;
    /** 输入内容*/
    private String inputContent;

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

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
