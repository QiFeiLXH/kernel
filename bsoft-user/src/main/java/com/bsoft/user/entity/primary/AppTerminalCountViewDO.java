package com.bsoft.user.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zy
 * @date: 2020/10/21
 * @description APP用户终端分布情况
 */
@Entity
@Table(name = " bsoft_portal.app_terminal_count_view")
public class AppTerminalCountViewDO {
    /* 终端 */
    @Id
    private String terminal;
    /* 用户数 */
    private Integer userCount;

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
