package com.bsoft.person.dto;

import java.io.Serializable;

public class RankRoleDTO implements Serializable {
    private String personId;
    private Integer isFirstManager;
    private Integer isSecondManager;
    private Integer isHr;
    private Integer isLeader;
    private Integer isExpert;
    private Integer type;

    public RankRoleDTO(){
        this.isFirstManager = 0;
        this.isSecondManager = 0;
        this.isHr = 0;
        this.isLeader = 0;
        this.isExpert = 0;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getIsFirstManager() {
        return isFirstManager;
    }

    public void setIsFirstManager(Integer isFirstManager) {
        this.isFirstManager = isFirstManager;
    }

    public Integer getIsSecondManager() {
        return isSecondManager;
    }

    public void setIsSecondManager(Integer isSecondManager) {
        this.isSecondManager = isSecondManager;
    }

    public Integer getIsHr() {
        return isHr;
    }

    public void setIsHr(Integer isHr) {
        this.isHr = isHr;
    }

    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }

    public Integer getIsExpert() {
        return isExpert;
    }

    public void setIsExpert(Integer isExpert) {
        this.isExpert = isExpert;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
