package com.bsoft.common.constant;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/11 15:50
 * @Description 募投基建合同分类编号  按项目名称区分
 */
public enum ProjectContractEnum {
    BSOFT(1, "CY");

    private Integer index;
    private String name;


    ProjectContractEnum() {
    }

    ProjectContractEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
