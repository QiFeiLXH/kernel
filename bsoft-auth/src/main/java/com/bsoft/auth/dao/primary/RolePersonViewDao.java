package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.RolePersonViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/27 16:11
 * @Description:
 */
@Repository
public interface RolePersonViewDao extends JpaRepository<RolePersonViewDO,Integer>, JpaSpecificationExecutor<RolePersonViewDO> {
    List<RolePersonViewDO> findAllByRoleId(Integer roleId);

    List<RolePersonViewDO> findAllByPersonId(String personId);
}
