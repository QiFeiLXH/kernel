package com.bsoft.logs.entity.primary;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
public class RequestLogReportDO {
    /* 主键 */
    private Integer id;
    /* 菜单ID */
    private Integer menuId;
    /* 请求路径 */
    private String url;
    /* 统计日期 */
    private Date countDate;
    /* 请求次数 */
    private Integer requestCount;
    /* 请求人数 */
    private Integer personCount;
    /* 菜单名称 */
    private String menuName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
