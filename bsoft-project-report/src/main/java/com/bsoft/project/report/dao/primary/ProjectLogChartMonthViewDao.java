package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ProjectLogChartMonthViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/8/17 13:14
 */
@Repository
public interface ProjectLogChartMonthViewDao extends JpaRepository<ProjectLogChartMonthViewDO, Integer>, JpaSpecificationExecutor<ProjectLogChartMonthViewDO> {
}
