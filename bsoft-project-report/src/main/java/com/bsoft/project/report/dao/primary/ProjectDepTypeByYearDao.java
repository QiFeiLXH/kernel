package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ProjectDepTypeByYearDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2019-12-19 9:58
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectDepTypeByYearDao extends JpaRepository<ProjectDepTypeByYearDO,Integer>, JpaSpecificationExecutor<ProjectDepTypeByYearDO> {

}
