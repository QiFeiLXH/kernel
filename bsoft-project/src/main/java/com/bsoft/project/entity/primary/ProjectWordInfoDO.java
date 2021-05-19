package com.bsoft.project.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: hy
 * @Date: 2020/6/5
 * @Description: 文档信息（一条文档信息对应多条文档明细）
 */
@Table(name = "bsoftmis.wd_wdxx")
@Entity
public class ProjectWordInfoDO {

    @Id
    @Column(name="jlid")
    private Integer id;// 主键

    @Column(name="wdid")
    private Integer documentId;// 标准文档ID

    @Column(name="htbh")
    private String contractId;// 合同编号

    @Column(name="xmid")
    private String projectId;// 项目ID

    @Column(name="wdsl")
    private Integer documentCount;// 文档数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(Integer documentCount) {
        this.documentCount = documentCount;
    }

}
