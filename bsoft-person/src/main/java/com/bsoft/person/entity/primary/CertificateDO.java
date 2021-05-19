package com.bsoft.person.entity.primary;

import javax.persistence.*;

/**
 * 学习证书
 */
@Entity
@Table(name = "bsoftmis.rs_education_certificate")
public class CertificateDO {
    private Integer id;
    private Integer educationId;
    private Integer certificateID;
    private String certificateName;

    @Id
    @SequenceGenerator(name="bsoftmis.seq_rs_education_certificate",allocationSize=1,sequenceName="bsoftmis.seq_rs_education_certificate")
    @GeneratedValue(generator="bsoftmis.seq_rs_education_certificate",strategy=GenerationType.SEQUENCE)
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
