package com.bsoft.logs.service;

import com.bsoft.logs.dto.UsageLogCountDTO;
import com.bsoft.logs.dto.UsageLogCountQueryCndDTO;
import com.bsoft.logs.dto.UsageLogCountWithDateDTO;
import com.bsoft.logs.dto.UsageLogReportDTO;

import java.util.Date;
import java.util.List;

public interface UsageLogReportService {
    List<UsageLogReportDTO> countUsageLog(Date startDate, Date endDate);

    List<UsageLogCountDTO> countUsageLogs(UsageLogCountQueryCndDTO countQueryCndDTO);

    List<UsageLogCountWithDateDTO> countUsageLogGroup(Date startDate,Date endDate);
}
