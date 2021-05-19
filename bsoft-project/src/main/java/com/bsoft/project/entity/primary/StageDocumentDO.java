package com.bsoft.project.entity.primary;

/**
 * @Auther: hy
 * @Date: 2020/5/13
 * @Description:
 */
public class StageDocumentDO {
    private Integer stage;
    private String stageText;
    private String documentName;
    private Integer documentId;
    private String contractNo;
    private Integer recordId;

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getStageText() {
        return stageText;
    }

    public void setStageText(String stageText) {
        this.stageText = stageText;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }
}
