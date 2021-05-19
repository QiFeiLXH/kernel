package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Entity
@Table(name = "ker_sys_requestlog_pathcount")
public class RequestLogPathCountDO {
    private Integer id;// 主键
    private String url;// 请求路径
    private Date countDate;// 统计日期
    private Integer requestCount;// 请求次数
    private Integer personCount;// 请求人数
    private Integer menuId;// 菜单ID

    @Id
    @SequenceGenerator(name="seq_ker_sys_reqlog_pathcount",allocationSize=1,sequenceName="seq_ker_sys_reqlog_pathcount")
    @GeneratedValue(generator="seq_ker_sys_reqlog_pathcount",strategy= GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
