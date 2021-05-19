package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 13:34
 * @Description
 */
@Repository
public interface ProjectDutyViewDao extends JpaRepository<ProjectDutyViewDO,Integer>, JpaSpecificationExecutor<ProjectDutyViewDO> {
}
