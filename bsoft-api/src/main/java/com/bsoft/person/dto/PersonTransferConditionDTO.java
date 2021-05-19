package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lkh
 * @DateTime: 2021/3/4 9:30
 * @Description:
 */
public class PersonTransferConditionDTO implements Serializable {
    private String id;
    private String flag;
    private String personId;
    private String personName;
    private String aheadDept;//调前部门
    private String aheadDeptText;
    private String laterDept;//调后部门
    private String laterDeptText;
    private String aheadJobCategory;//调前岗位大类
    private String aheadJobCategoryText;
    private String laterJobCategory;//调后岗位大类
    private String laterJobCategoryText;
    private String aheadPost;//调前岗位职务
    private String aheadPostText;
    private String laterPost;//调后岗位职务
    private String laterPostText;
    private Date transferDate;//调动日期
    private Integer aheadCommunicationSubsidy;//调前补贴
    private String aheadCommunicationSubsidyText;
    private Integer laterCommunicationSubsidy;//调后补贴
    private String  laterCommunicationSubsidyText;
    private Integer aheadCost;//调前费用类别
    private String  aheadCostText;
    private Integer laterCost;//调后费用类别
    private String  laterCostText;
    private Integer aheadFinancial;//调前财务类别
    private String  aheadFinancialText;
    private Integer laterFinancial;//调后财务类别
    private String  laterFinancialText;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getAheadDept() {
        return aheadDept;
    }

    public void setAheadDept(String aheadDept) {
        this.aheadDept = aheadDept;
    }

    public String getAheadDeptText() {
        return aheadDeptText;
    }

    public void setAheadDeptText(String aheaddeptText) {
        this.aheadDeptText = aheaddeptText;
    }

    public String getLaterDept() {
        return laterDept;
    }

    public void setLaterDept(String laterDept) {
        this.laterDept = laterDept;
    }

    public String getLaterDeptText() {
        return laterDeptText;
    }

    public void setLaterDeptText(String laterDeptText) {
        this.laterDeptText = laterDeptText;
    }

    public String getAheadJobCategory() {
        return aheadJobCategory;
    }

    public void setAheadJobCategory(String aheadJobCategory) {
        this.aheadJobCategory = aheadJobCategory;
    }

    public String getAheadJobCategoryText() {
        return aheadJobCategoryText;
    }

    public void setAheadJobCategoryText(String aheadJobCategoryText) {
        this.aheadJobCategoryText = aheadJobCategoryText;
    }

    public String getLaterJobCategory() {
        return laterJobCategory;
    }

    public void setLaterJobCategory(String laterJobCategory) {
        this.laterJobCategory = laterJobCategory;
    }

    public String getLaterJobCategoryText() {
        return laterJobCategoryText;
    }

    public void setLaterJobCategoryText(String laterJobCategoryText) {
        this.laterJobCategoryText = laterJobCategoryText;
    }

    public String getAheadPost() {
        return aheadPost;
    }

    public void setAheadPost(String aheadPost) {
        this.aheadPost = aheadPost;
    }

    public String getAheadPostText() {
        return aheadPostText;
    }

    public void setAheadPostText(String aheadPostText) {
        this.aheadPostText = aheadPostText;
    }

    public String getLaterPost() {
        return laterPost;
    }

    public void setLaterPost(String laterPost) {
        this.laterPost = laterPost;
    }

    public String getLaterPostText() {
        return laterPostText;
    }

    public void setLaterPostText(String laterPostText) {
        this.laterPostText = laterPostText;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Integer getAheadCommunicationSubsidy() {
        return aheadCommunicationSubsidy;
    }

    public void setAheadCommunicationSubsidy(Integer aheadCommunicationSubsidy) {
        this.aheadCommunicationSubsidy = aheadCommunicationSubsidy;
    }

    public String getAheadCommunicationSubsidyText() {
        return aheadCommunicationSubsidyText;
    }

    public void setAheadCommunicationSubsidyText(String aheadCommunicationSubsidyText) {
        this.aheadCommunicationSubsidyText = aheadCommunicationSubsidyText;
    }

    public Integer getLaterCommunicationSubsidy() {
        return laterCommunicationSubsidy;
    }

    public void setLaterCommunicationSubsidy(Integer laterCommunicationSubsidy) {
        this.laterCommunicationSubsidy = laterCommunicationSubsidy;
    }

    public String getLaterCommunicationSubsidyText() {
        return laterCommunicationSubsidyText;
    }

    public void setLaterCommunicationSubsidyText(String laterCommunicationSubsidyText) {
        this.laterCommunicationSubsidyText = laterCommunicationSubsidyText;
    }

    public Integer getAheadCost() {
        return aheadCost;
    }

    public void setAheadCost(Integer aheadCost) {
        this.aheadCost = aheadCost;
    }

    public String getAheadCostText() {
        return aheadCostText;
    }

    public void setAheadCostText(String aheadCostText) {
        this.aheadCostText = aheadCostText;
    }

    public Integer getLaterCost() {
        return laterCost;
    }

    public void setLaterCost(Integer laterCost) {
        this.laterCost = laterCost;
    }

    public String getLaterCostText() {
        return laterCostText;
    }

    public void setLaterCostText(String laterCostText) {
        this.laterCostText = laterCostText;
    }


    public Integer getAheadFinancial() {
        return aheadFinancial;
    }

    public void setAheadFinancial(Integer aheadFinancial) {
        this.aheadFinancial = aheadFinancial;
    }

    public String getAheadFinancialText() {
        return aheadFinancialText;
    }

    public void setAheadFinancialText(String aheadFinancialText) {
        this.aheadFinancialText = aheadFinancialText;
    }

    public Integer getLaterFinancial() {
        return laterFinancial;
    }

    public void setLaterFinancial(Integer laterFinancial) {
        this.laterFinancial = laterFinancial;
    }

    public String getLaterFinancialText() {
        return laterFinancialText;
    }

    public void setLaterFinancialText(String laterFinancialText) {
        this.laterFinancialText = laterFinancialText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
