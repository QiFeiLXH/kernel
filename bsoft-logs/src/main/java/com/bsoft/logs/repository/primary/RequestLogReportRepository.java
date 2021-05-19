package com.bsoft.logs.repository.primary;

import com.bsoft.logs.condition.RequestLogReportQueryCnd;
import com.bsoft.logs.entity.primary.RequestLogReportDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
@Mapper
@Repository
public interface RequestLogReportRepository {
    List<RequestLogReportDO> getMenuCount(@Param("menuId") Integer menuId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    List<RequestLogReportDO> getMenuCountTotal(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    List<RequestLogReportDO> getPathCount(@Param("queryCnd")RequestLogReportQueryCnd queryCnd);
    List<RequestLogReportDO> getPathCountTotal(@Param("queryCnd")RequestLogReportQueryCnd queryCnd);
}
