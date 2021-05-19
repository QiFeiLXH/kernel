package com.bsoft.message.logs;

import com.bsoft.logs.dto.UsageLogDTO;

public interface UsageLogsMessage {
    public void send(UsageLogDTO usageLog);
}
