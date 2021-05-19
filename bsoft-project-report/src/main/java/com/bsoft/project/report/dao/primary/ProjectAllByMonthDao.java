package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ProjectAllByMonthDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2019-12-18 10:23
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectAllByMonthDao extends JpaRepository<ProjectAllByMonthDO,Integer>, JpaSpecificationExecutor<ProjectAllByMonthDO> {

}
