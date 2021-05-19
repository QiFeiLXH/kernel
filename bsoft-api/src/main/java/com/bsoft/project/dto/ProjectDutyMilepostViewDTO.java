package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 8:45
 * @Description 项目责任书-里程碑设置
 */
public class ProjectDutyMilepostViewDTO implements Serializable {
    private Integer id;
    /** 责任书id */
    private Integer dutyId;
    /** 合同编号 */
    private String contractNo;
    /** 里程碑id */
    private String name;
    /** 权重 */
    private Double weight;
    /** 需上传文档 */
    private String words;
    /** 需上传文档数量 */
    private Integer wordsNum;
    /** 需上传文档id列表 */
    private List<Integer> wordsList;
    /** 项目计划中是否已选择该里程碑 1已选择 0 未选择 */
    private Integer selectedFlag;

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

    public Integer getWordsNum() {
        return wordsNum;
    }

    public void setWordsNum(Integer wordsNum) {
        this.wordsNum = wordsNum;
    }

    public List<Integer> getWordsList() {
        return wordsList;
    }

    public void setWordsList(List<Integer> wordsList) {
        this.wordsList = wordsList;
    }

    public Integer getSelectedFlag() {
        return selectedFlag;
    }

    public void setSelectedFlag(Integer selectedFlag) {
        this.selectedFlag = selectedFlag;
    }
}
