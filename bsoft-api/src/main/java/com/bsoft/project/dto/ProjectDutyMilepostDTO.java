package com.bsoft.project.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 8:45
 * @Description 项目责任书-里程碑设置
 */
public class ProjectDutyMilepostDTO implements Serializable {
    private Integer id;
    /** 责任书id */
    private Integer dutyId;
    /** 合同编号 */
    private String contractNo;
    /** 里程碑名称 */
    private String name;
    /** 权重 */
    private Double weight;
    /** 需上传文档 */
    private String words;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

}
