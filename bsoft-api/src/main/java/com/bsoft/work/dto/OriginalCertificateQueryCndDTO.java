package com.bsoft.work.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description
 */
public class OriginalCertificateQueryCndDTO implements Serializable {
    /* 证书名称 */
    private String name;
    /* 证书类别 */
    private Integer type;
    /* 注销标志 */
    private Integer logoff;
    /* 保管员 */
    private String archivist;
    /* 页码 */
    private Integer pageNo;
    /* 条目 */
    private Integer pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public String getArchivist() {
        return archivist;
    }

    public void setArchivist(String archivist) {
        this.archivist = archivist;
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
