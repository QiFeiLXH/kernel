package com.bsoft.project.key;

import java.io.Serializable;

public class ProjectRankKey implements Serializable {
    private String personId;
    private String projectId;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
