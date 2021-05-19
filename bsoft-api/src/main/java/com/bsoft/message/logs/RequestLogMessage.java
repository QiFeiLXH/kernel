package com.bsoft.message.logs;

import com.bsoft.logs.dto.RequestLogDTO;
import com.bsoft.logs.dto.UsageLogDTO;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
public interface RequestLogMessage {
    void send(RequestLogDTO requestLogDTO);
}
