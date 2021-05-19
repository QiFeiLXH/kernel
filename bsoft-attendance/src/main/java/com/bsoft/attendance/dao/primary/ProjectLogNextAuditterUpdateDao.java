package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectLogNextAuditterUpdateDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/9 14:25
 * @Description
 */
@Repository
public interface ProjectLogNextAuditterUpdateDao extends JpaRepository<ProjectLogNextAuditterUpdateDO,Integer>, JpaSpecificationExecutor<ProjectLogNextAuditterUpdateDO> {
}
