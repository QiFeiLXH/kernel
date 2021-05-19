package com.bsoft.person.entity.primary;

/**
 * @Author: xucl
 * @DateTime: 2021/3/10 9:16
 * @Description: 只用于查询
 */
public class PostAndCostLookDO {
    private  Integer id;
    private  Integer postType;
    private  Integer costType;
    private  Integer financialType;

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
