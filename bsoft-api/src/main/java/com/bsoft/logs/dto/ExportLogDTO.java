package com.bsoft.logs.dto;

import java.io.Serializable;
import java.util.Date;

public class ExportLogDTO implements Serializable {
    /** 主键 */
    private Integer id;
    /** 系统 */
    private Integer system;
    /** 菜单id */
    private String menuId;
    /** 备注 */
    private String context;
    /** 用户id */
    private String personId;
    /** 导出日期 */
    private Date exportDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }
}