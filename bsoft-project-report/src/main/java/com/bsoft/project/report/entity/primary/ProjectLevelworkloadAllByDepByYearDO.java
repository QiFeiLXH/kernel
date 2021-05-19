package com.bsoft.project.report.entity.primary;

public class ProjectLevelworkloadAllByDepByYearDO extends ProjectLevelworkloadAllDO{
    private String YEAR;
    private String DEPTYPE;

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getDEPTYPE() {
        return DEPTYPE;
    }

    public void setDEPTYPE(String DEPTYPE) {
        this.DEPTYPE = DEPTYPE;
    }
}
