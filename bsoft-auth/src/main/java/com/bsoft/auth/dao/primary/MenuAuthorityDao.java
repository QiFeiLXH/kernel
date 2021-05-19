package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.RoleMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuAuthorityDao extends JpaRepository<RoleMenuDO,Integer>, JpaSpecificationExecutor<RoleMenuDO> {
    @Query("SELECT DISTINCT b.menuId FROM MenuDO a,RoleMenuDO b, RolePersonDO c WHERE  c.roleId = b.roleId AND c.personId = :userId AND a.system = :system AND a.pubFlag = 0 AND a.id = b.menuId AND a.active = 1")
    List<Integer> getAuthMenu(@Param("userId") String userId, @Param("system") Integer system);

    @Query("SELECT DISTINCT b.menuId FROM MenuDO a,RoleMenuDO b WHERE a.system = :system AND a.pubFlag = 0 AND a.id = b.menuId AND b.roleId = :roleId")
    List<Integer> getAuthMenuByRoleId(@Param("roleId") Integer roleId, @Param("system") Integer system);

    @Query("SELECT DISTINCT b FROM MenuDO a,RoleMenuDO b WHERE a.system = :system AND a.id = b.menuId AND b.roleId = :roleId")
    List<RoleMenuDO> getMenuDOByRoleId(@Param("roleId") Integer roleId, @Param("system") Integer system);

    void deleteAllByRoleIdAndSystem(Integer roleId,Integer system);
}
