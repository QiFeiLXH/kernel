package com.bsoft.project.report.entity.primary;

public class ProjectLevelManPowerMoneyAllByDepByYearDO  extends ProjectLevelManPowerMoneyAllDO{
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
