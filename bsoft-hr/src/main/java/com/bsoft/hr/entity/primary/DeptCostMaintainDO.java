package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: LKH
 * @date: 2020/12/17
 * @description 岗位费用部门岗位
 */
@Entity
@Table(name="HR_FEE_RULES_DEPT")
public class DeptCostMaintainDO {
    @Id
    private  Integer id;
    /**岗位大类*/
    private  Integer postType;
    /**财务大类*/
    private  Integer financialType;
    /**部门*/
    private  String dept;
    /**类型*/
    private  Integer type;
    /**調整時間*/
    private Date adjustDate;

    @Id
    @SequenceGenerator(name="SEQ_HR_FEE_RULES_DEPT",allocationSize=1,sequenceName="SEQ_HR_FEE_RULES_DEPT")
    @GeneratedValue(generator="SEQ_HR_FEE_RULES_DEPT",strategy=GenerationType.SEQUENCE)
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

    public Integer getFinancialType() {
        return financialType;
    }

    public void setFinancialType(Integer financialType) {
        this.financialType = financialType;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }
}
