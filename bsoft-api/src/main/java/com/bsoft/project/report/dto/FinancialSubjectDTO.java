package com.bsoft.project.report.dto;

import java.io.Serializable;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.dto
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 17:37
 * @Description:
 */
public class FinancialSubjectDTO implements Serializable {
    private Integer id;
    private String costSubject;

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
