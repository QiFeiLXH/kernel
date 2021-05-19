package com.bsoft.project.report.dto;

import java.io.Serializable;

public class ProjectLevelManPowerMoneyAllByDepDTO extends ProjectLevelManPowerMoneyAllDTO implements Serializable {
    private String DEPTYPE;

    public String getDEPTYPE() {
        return DEPTYPE;
    }

    public void setDEPTYPE(String DEPTYPE) {
        this.DEPTYPE = DEPTYPE;
    }
}
