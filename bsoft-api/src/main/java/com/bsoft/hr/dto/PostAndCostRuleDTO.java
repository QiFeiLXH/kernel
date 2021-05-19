package com.bsoft.hr.dto;

import java.io.Serializable;

/**
 * @author: LKH
 * @date: 2020/12/15
 * @description 岗位费用默认规则
 */
public class PostAndCostRuleDTO implements Serializable {
    private  Integer id;
    private  Integer postType;
    private  String  postName;
    private  Integer costType;
    private  String  costName;
    private  Integer financialType;
    private  String  financialName;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getFinancialName() {
        return financialName;
    }

    public void setFinancialName(String financialName) {
        this.financialName = financialName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getFinancialType() {
        return financialType;
    }

    public void setFinancialType(Integer financialType) {
        this.financialType = financialType;
    }
}
