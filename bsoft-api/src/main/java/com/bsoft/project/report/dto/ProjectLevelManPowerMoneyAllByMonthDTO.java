package com.bsoft.project.report.dto;

import java.io.Serializable;

public class ProjectLevelManPowerMoneyAllByMonthDTO extends ProjectLevelManPowerMoneyAllDTO implements Serializable {
    private String YEAR;
    private String MONTH;

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getMONTH() {
        return MONTH;
    }

    public void setMONTH(String MONTH) {
        this.MONTH = MONTH;
    }
}
