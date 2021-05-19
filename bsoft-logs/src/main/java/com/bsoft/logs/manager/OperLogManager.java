package com.bsoft.logs.manager;

import com.bsoft.common.result.Result;
import com.bsoft.logs.condition.OperLogQueryCnd;
import com.bsoft.logs.entity.primary.OperLogDO;

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 10:30
 * @Description:
 */
public interface OperLogManager {
    Result<OperLogDO> getLogList(OperLogQueryCnd cnd);
}
