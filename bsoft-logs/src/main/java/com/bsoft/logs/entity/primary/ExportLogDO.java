package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SYS_EXPORTLOG")
public class ExportLogDO {
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
    @Id
    @SequenceGenerator(name="SEQ_SYS_EXPORTLOG",allocationSize=1,sequenceName="SEQ_SYS_EXPORTLOG")
    @GeneratedValue(generator="SEQ_SYS_EXPORTLOG",strategy= GenerationType.SEQUENCE)
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