package com.bsoft.logs.repository.primary;

import com.bsoft.logs.entity.primary.UsageLogReportDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface UsageLogRepository {
    List<UsageLogReportDO> countUsageLogReport(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
