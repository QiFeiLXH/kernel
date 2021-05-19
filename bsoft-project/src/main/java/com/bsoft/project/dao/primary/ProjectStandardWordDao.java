package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectStandardWordDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/*
 * @author  zhanglf
 * @date  2020/4/14 9:04
 * @description
 */
@Repository
public interface ProjectStandardWordDao extends JpaRepository<ProjectStandardWordDO,Integer>, JpaSpecificationExecutor<ProjectStandardWordDO> {
}
