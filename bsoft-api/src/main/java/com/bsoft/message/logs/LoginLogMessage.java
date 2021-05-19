package com.bsoft.message.logs;

import com.bsoft.logs.dto.LoginLogDTO;

public interface LoginLogMessage {
    public void send(LoginLogDTO loginLogDTO);
}
