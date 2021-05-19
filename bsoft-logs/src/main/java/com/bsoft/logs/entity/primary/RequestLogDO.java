package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Entity
@Table(name = "bsoft_portal.ker_sys_requestlog")
public class RequestLogDO {
    /* 主键 */
    private Integer id;
    /* 请求路径 */
    private String url;
    /* 请求参数 */
    private String params;
    /* 员工工号 */
    private String personId;
    /* 请求时间 */
    private Date requestDate;
    /* IP */
    private String ip;
    /* 菜单ID */
    private Integer menuId;
    /* 系统1：APP 2：门户 */
    private Integer system;
    /* 返回结果 */
    private String results;
    /* 操作类型 */
    private String type;
    /* 操作描述 */
    private String describe;

    @Id
    @SequenceGenerator(name="seq_ker_sys_requestlog",allocationSize=1,sequenceName="seq_ker_sys_requestlog")
    @GeneratedValue(generator="seq_ker_sys_requestlog",strategy= GenerationType.SEQUENCE)
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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
