package com.bsoft.project.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author  hy
 * @date  2020/3/31 21:27
 * @description 标准文档
 */
@Entity
@Table(name = "BSOFTMIS.WD_BZWD")
public class ReferenceDocumentDO {

    @Id
    @Column(name = "wdid")
    private Integer id;
    @Column(name = "ckwd")
    private String referenceName;
    @Column(name = "wjnr")
    private byte[] referenceContent;
    @Column(name = "tjjs")
    private Integer submitRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public byte[] getReferenceContent() {
        return referenceContent;
    }

    public void setReferenceContent(byte[] referenceContent) {
        this.referenceContent = referenceContent;
    }

    public Integer getSubmitRole() {
        return submitRole;
    }

    public void setSubmitRole(Integer submitRole) {
        this.submitRole = submitRole;
    }
}
