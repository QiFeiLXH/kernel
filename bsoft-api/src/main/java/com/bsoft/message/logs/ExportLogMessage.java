package com.bsoft.message.logs;

import com.bsoft.logs.dto.ExportLogDTO;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/15 11:17
 * @Description 系统导出日志消息
 */
public interface ExportLogMessage {
    void send(ExportLogDTO exportLog);
}

