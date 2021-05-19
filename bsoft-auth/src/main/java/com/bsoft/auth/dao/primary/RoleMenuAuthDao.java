package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.RoleMenuAuthDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMenuAuthDao extends JpaRepository<RoleMenuAuthDO,Integer>, JpaSpecificationExecutor<RoleMenuAuthDO> {
    @Query("SELECT DISTINCT a FROM RoleMenuAuthDO a,RolePersonDO b,MenuDO c WHERE  a.roleId = b.roleId AND c.id = a.menuId AND  b.personId = :userId AND c.system = :system")
    public List<RoleMenuAuthDO> getMenuAuth(@Param("userId") String userId, @Param("system") Integer system);

    @Query("SELECT DISTINCT a.roleId as roleId,a.menuId as menuId,a.authId as authId FROM RoleMenuAuthDO a,MenuDO c WHERE  a.roleId = :roleId AND c.id = a.menuId AND c.system = :system")
    public List<Map> getMenuAuthByRoleId(@Param("roleId") Integer roleId, @Param("system") Integer system);

    @Query("SELECT DISTINCT a FROM RoleMenuAuthDO a,MenuDO c WHERE  a.roleId = :roleId AND c.id = a.menuId AND c.system = :system")
    public List<RoleMenuAuthDO> getMenuAuthDOByRoleId(@Param("roleId") Integer roleId, @Param("system") Integer system);

    @Query("SELECT DISTINCT e.roleName as roleId,a.menuId as menuId,a.authId as authId,d.name as action,c.permisionid as permisionid FROM RoleMenuAuthDO a,RolePersonDO b,MenuDO c,AuthorityDO d,RoleDO e WHERE  a.roleId = b.roleId AND c.id = a.menuId AND  b.personId = :userId AND c.system = :system AND d.id = a.authId AND e.id = b.roleId")
    public List<Map> getOfficeMenuAuth(@Param("userId") String userId, @Param("system") Integer system);

    public void deleteAllByRoleId(Integer roleId);

    public void deleteAllByMenuId(Integer menuId);

    public void deleteAllByRoleIdAndSystem(Integer roleId,Integer system);

    public void deleteAllByAuthIdIn(List<Integer> authIds);

    List<RoleMenuAuthDO> findAllByRoleId(Integer roleId);

}
