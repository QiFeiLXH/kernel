package com.bsoft.auth.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/20 17:27
 * @Description
 */
public class AuthorityQueryCndDTO implements Serializable {
    /** 菜单id */
    private Integer menuId;
    /** 权限列表 */
    private List<String> authIds;
    /** 菜单是否公用 */
    private Integer pubFlag;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public List<String> getAuthIds() {
        return authIds;
    }

    public void setAuthIds(List<String> authIds) {
        this.authIds = authIds;
    }

    public Integer getPubFlag() {
        return pubFlag;
    }

    public void setPubFlag(Integer pubFlag) {
        this.pubFlag = pubFlag;
    }
}
