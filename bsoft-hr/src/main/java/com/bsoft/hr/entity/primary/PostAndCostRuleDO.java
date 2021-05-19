package com.bsoft.hr.entity.primary;

import javax.persistence.*;

/**
 * @author: LKH
 * @date: 2020/12/15
 * @description 岗位费用默认规则
 */
@Entity
@Table(name="HR_FEE_RULES")
public class PostAndCostRuleDO {
    @Id
    private  Integer id;
    private  Integer postType;
    private  Integer costType;
    private  Integer financialType;

    @Id
    @SequenceGenerator(name="SEQ_HR_FEE_RULES",allocationSize=1,sequenceName="SEQ_HR_FEE_RULES")
    @GeneratedValue(generator="SEQ_HR_FEE_RULES",strategy=GenerationType.SEQUENCE)
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
