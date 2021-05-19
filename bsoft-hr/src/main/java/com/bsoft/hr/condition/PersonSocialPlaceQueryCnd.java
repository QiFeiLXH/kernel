package com.bsoft.hr.condition;

import java.util.List;

/**
 * @author: Xuhui Lin
 * @date: 2020/11/27
 * @description 员工社保缴纳地调整
 */

public class PersonSocialPlaceQueryCnd {
    /** 部门ID */
    private String deptId;
    /** 部门类别 */
    private Integer deptType;
    /** 缴纳地id */
    private Integer socialPlaceId;
    /** 姓名或拼音简码或工号 */
    private String inputContent;
    /** 离职，在职 */
    private List<String> valid;
    private Integer pageNo;
    private Integer pageSize;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getSocialPlaceId() {
        return socialPlaceId;
    }

    public void setSocialPlaceId(Integer socialPlaceId) {
        this.socialPlaceId = socialPlaceId;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public List<String> getValid() {
        return valid;
    }

    public void setValid(List<String> valid) {
        this.valid = valid;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }
}
