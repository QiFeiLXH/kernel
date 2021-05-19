package com.bsoft.project.report.dto;

import java.io.Serializable;

public class ProjectLevelworkloadAllByDepDTO extends ProjectLevelworkloadAllDTO implements Serializable {
    private String DEPTYPE;

    public String getDEPTYPE() {
        return DEPTYPE;
    }

    public void setDEPTYPE(String DEPTYPE) {
        this.DEPTYPE = DEPTYPE;
    }
}
