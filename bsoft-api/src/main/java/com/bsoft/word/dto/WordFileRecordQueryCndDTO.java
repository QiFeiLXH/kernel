package com.bsoft.word.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/17 18:46
 */
public class WordFileRecordQueryCndDTO implements Serializable {
    private Integer id;
    private String fileName;
    private Integer fileYear;
    private Integer fileMonth;
    private Integer menuId;
    private Date startDate;
    private Date endDate;
    private Integer pageNo;
    private Integer pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileYear() {
        return fileYear;
    }

    public void setFileYear(Integer fileYear) {
        this.fileYear = fileYear;
    }

    public Integer getFileMonth() {
        return fileMonth;
    }

    public void setFileMonth(Integer fileMonth) {
        this.fileMonth = fileMonth;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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
}
