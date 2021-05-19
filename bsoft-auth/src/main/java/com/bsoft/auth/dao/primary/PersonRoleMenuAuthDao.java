package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.PersonRoleMenuAuthDO;
import com.bsoft.auth.entity.primary.RoleMenuAuthDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 13:43
 * @Description:
 */
@Repository
public interface PersonRoleMenuAuthDao extends JpaRepository<PersonRoleMenuAuthDO,String>, JpaSpecificationExecutor<PersonRoleMenuAuthDO> {
    void deleteAllByMenuId(Integer menuId);

    void deleteAllByAuthIdIn(List<Integer> authIds);

    @Query("SELECT DISTINCT a FROM PersonRoleMenuAuthDO a,MenuDO c WHERE  a.personId = :personId AND c.id = a.menuId AND c.system = :system")
    public List<PersonRoleMenuAuthDO> getMenuAuthDOByRoleId(@Param("personId") String personId, @Param("system") Integer system);

    void deleteAllByPersonIdAndSystem(String personId,Integer system);

    void deleteAllByPersonId(String personId);

    void deleteAllByPersonIdIn(List<String> personIds);

    void deleteAllByPersonIdInAndAuthIdIn(List<String> personIds,List<Integer> authIds);

}
