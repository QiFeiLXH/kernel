package com.bsoft.user.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/10/21
 * @description APP用户终端分布情况
 */
public class AppTerminalCountDTO implements Serializable {
    /* 终端 */
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
