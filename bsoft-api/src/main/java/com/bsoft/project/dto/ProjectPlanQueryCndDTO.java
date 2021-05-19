package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.dto
 * @Author: QiFei
 * @CreateTime: 2020-03-18 16:29
 * @Description:
 */
public class ProjectPlanQueryCndDTO implements Serializable {
    /** 项目计划创建选项 ‘-1’全部 ‘0’未创建 ‘1’已创建 */
    private String optionsValue;
    /** 输入内容 */
    private String inputContent;
    /** 项目经理 */
    private String projectManager;
    /** 大区 */
    private String largeArea;
    /** 工程区域 */
    private String area;
    /** 页码 */
    private Integer pageNo;
    /** 每页数量 */
    private Integer pageSize;
    /** 开始日期 */
    private String startDate;
    /** 结束日期 */
    private String endDate;

    public String getOptionsValue() {
        return optionsValue;
    }

    public void setOptionsValue(String optionsValue) {
        this.optionsValue = optionsValue;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getLargeArea() {
        return largeArea;
    }

    public void setLargeArea(String largeArea) {
        this.largeArea = largeArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
