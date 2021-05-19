package com.bsoft.work.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
public class OriginalCertificateDTO implements Serializable {
    /* id */
    private String id;
    /* 证书名称 */
    private String name;
    /* 证书类别 */
    private Integer type;
    /* 类别名称 */
    private String typeName;
    /* 注销标志 */
    private Integer logoff;
    /* 保管员id */
    private String archivist;
    /* 保管员姓名 */
    private String archivistName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getArchivistName() {
        return archivistName;
    }

    public void setArchivistName(String archivistName) {
        this.archivistName = archivistName;
    }
}
