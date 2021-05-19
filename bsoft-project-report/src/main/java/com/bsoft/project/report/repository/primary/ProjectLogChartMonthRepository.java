package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.condition.ProjectLogChartQueryCnd;
import com.bsoft.project.report.entity.primary.ProjectLogChartMonthViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/9
 * @description
 */
@Mapper
@Repository
public interface ProjectLogChartMonthRepository {
    List<ProjectLogChartMonthViewDO> listLogChartMonthInfos(@Param("startDateStr") String startDateStr, @Param("endDateStr") String endDateStr);
}
