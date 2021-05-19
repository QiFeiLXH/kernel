package com.bsoft.person.dto;

public class CloudschoolGroupSynDTO {

    /**
     * 关系数据信息（人员账号或部门编号或岗位编号）格式如：["cuim@yunxuetang.cn","user001","user002"]
     */
    private String masterNo;

    /**
     * 关系类型(固定值 部门：Department,岗位：Position,用户：User)
     */
    private String masterType;

    /**
     * 是否包含子部门(仅限部门类型)
     */
    private int isContainSub = 0;

    public String getMasterNo() {
        return masterNo;
    }

    public void setMasterNo(String masterNo) {
        this.masterNo = masterNo;
    }

    public String getMasterType() {
        return masterType;
    }

    public void setMasterType(String masterType) {
        this.masterType = masterType;
    }

    public int getIsContainSub() {
        return isContainSub;
    }

    public void setIsContainSub(int isContainSub) {
        this.isContainSub = isContainSub;
    }
}
