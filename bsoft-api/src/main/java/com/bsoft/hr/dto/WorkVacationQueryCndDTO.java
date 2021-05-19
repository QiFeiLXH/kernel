package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假查询条件DTO
 */
public class WorkVacationQueryCndDTO implements Serializable {
    // 年份
    private String year;
    // 部门ID
    private String deptId;
    // 工号
    private String personId;
    // 姓名或拼音简码（小写）
    private String personName;
    // 自动生成标志
    private Integer autoFlag;
    // 时间区间 开始
    private Date startDate;
    // 时间区间 结束
    private Date endDate;
    // 页码
    private Integer pageNo;
    // 每页条数
    private Integer pageSize;
    //假期类型
    private Integer type;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getAutoFlag() {
        return autoFlag;
    }

    public void setAutoFlag(Integer autoFlag) {
        this.autoFlag = autoFlag;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
