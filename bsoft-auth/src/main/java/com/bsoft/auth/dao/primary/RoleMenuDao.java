package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.RoleMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuDao extends JpaRepository<RoleMenuDO,Integer>, JpaSpecificationExecutor<RoleMenuDO> {

    public void deleteAllByMenuId(Integer menuId);

    public void deleteAllByRoleId(Integer roleId);

    void deleteAllByRoleIdAndSystem(Integer roleId,Integer system);

    List<RoleMenuDO> findAllByRoleId(Integer roleId);
}
