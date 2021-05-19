package com.bsoft.logs.manager;

import com.bsoft.logs.condition.UsageLogCountQueryCnd;
import com.bsoft.logs.dto.UsageLogReportDTO;
import com.bsoft.logs.entity.primary.UsageLogCountDO;
import com.bsoft.logs.entity.primary.UsageLogCountWithDateDO;

import java.util.Date;
import java.util.List;

public interface UsageLogReportManager {
    List<UsageLogReportDTO> countUsageLog(Date startDate, Date endDate);


    List<UsageLogCountDO> countUsageLogs(UsageLogCountQueryCnd countQueryCnd);

    List<UsageLogCountWithDateDO> countUsageLogGroup(Date strarDate,Date endDate);
}
