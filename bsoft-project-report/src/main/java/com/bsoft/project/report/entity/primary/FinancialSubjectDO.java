package com.bsoft.project.report.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 17:29
 * @Description: 财务科目:主要用于报销费用中的费用科目显示
 */
@Entity
@Table(name="bsoftmis.t_cwkm")
public class FinancialSubjectDO {
    @Id
    private Integer id;
    @Column(name="cpmc")
    private String costSubject;    //产品名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCostSubject() {
        return costSubject;
    }

    public void setCostSubject(String costSubject) {
        this.costSubject = costSubject;
    }

}
