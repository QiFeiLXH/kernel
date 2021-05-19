package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectWordRecordDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/*
 * @author  hy
 * @date  2020/3/26 18:35
 * @description
 */
@Repository
public interface ProjectWordDetailDao extends JpaRepository<ProjectWordRecordDO,Integer>, JpaSpecificationExecutor<ProjectWordRecordDO> {
}
