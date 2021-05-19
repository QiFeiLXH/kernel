package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyDO;
import com.bsoft.project.entity.primary.ProjectDutyUpdateDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 10:33
 * @Description
 */
@Repository
public interface ProjectDutyUpdateDao extends JpaRepository<ProjectDutyUpdateDO,Integer>, JpaSpecificationExecutor<ProjectDutyUpdateDO> {
}
