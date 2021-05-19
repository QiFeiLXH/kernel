package com.bsoft.hr.dto;

import java.io.Serializable;

public class PersonCompanyDTO implements Serializable {
    private Integer company;
    private String companyText;

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getCompanyText() {
        return companyText;
    }

    public void setCompanyText(String companyText) {
        this.companyText = companyText;
    }
}
