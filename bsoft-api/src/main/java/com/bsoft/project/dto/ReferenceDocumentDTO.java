package com.bsoft.project.dto;

import java.io.Serializable;

/*
 * @author  hy
 * @date  2020/3/31 21:27
 * @description
 */
public class ReferenceDocumentDTO implements Serializable {

    private Integer id;
    private String referenceName;
    private byte[] referenceContent;

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
}
