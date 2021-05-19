package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyAuditSaveDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 10:33
 * @Description
 */
@Repository
public interface ProjectDutyAuditSaveDao extends JpaRepository<ProjectDutyAuditSaveDO,Integer>, JpaSpecificationExecutor<ProjectDutyAuditSaveDO> {


}
