package com.bsoft.project.report.dto;

import java.io.Serializable;

public class ProjectLevelworkloadAllByDepByMonthDTO extends ProjectLevelworkloadAllDTO implements Serializable {
    private String YEAR;
    private String MONTH;
    private String DEPTYPE;

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

    public String getDEPTYPE() {
        return DEPTYPE;
    }

    public void setDEPTYPE(String DEPTYPE) {
        this.DEPTYPE = DEPTYPE;
    }
}
