package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ProjectLogChartViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/8/7 8:57
 */

@Repository
public interface ProjectLogChartViewDao extends JpaRepository<ProjectLogChartViewDO, Integer>, JpaSpecificationExecutor<ProjectLogChartViewDO> {
}
