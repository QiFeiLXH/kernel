package com.bsoft.person.dto;

import java.io.Serializable;

public class CertificateDTO implements Serializable {
    private Integer id;
    private Integer educationId;
    private Integer certificateID;
    private String certificateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Integer certificateID) {
        this.certificateID = certificateID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
}
