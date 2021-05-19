package com.bsoft.workflow.dao.primary;

import com.bsoft.workflow.entity.primary.GroupRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
@Repository
public interface GroupRoleDao extends JpaRepository<GroupRoleDO, Integer>, JpaSpecificationExecutor<GroupRoleDO> {
}
