package com.bsoft.project.report.dto;

import java.io.Serializable;

public class ContractLevelworkloadAllByYearDTO extends ContractLevelworkloadAllDTO implements Serializable {
    private String YEAR;

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }
}
