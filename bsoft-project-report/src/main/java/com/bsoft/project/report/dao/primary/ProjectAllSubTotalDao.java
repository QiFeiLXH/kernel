package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ProjectAllSubTotalDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2019-12-12 15:43
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectAllSubTotalDao extends JpaRepository<ProjectAllSubTotalDO,Integer>, JpaSpecificationExecutor<ProjectAllSubTotalDO> {
}
