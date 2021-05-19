package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.PersonRoleMenuDO;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.ws.rs.DELETE;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 13:42
 * @Description:
 */
@Repository
public interface PersonRoleMenuDao extends JpaRepository<PersonRoleMenuDO,String>, JpaSpecificationExecutor<PersonRoleMenuDO> {

    void deleteAllByMenuId(Integer menuId);

    @Query("select distinct a from PersonRoleMenuDO a,MenuDO b where a.menuId = b.id and b.system = :system and a.personId = :personId")
    List<PersonRoleMenuDO> getByPersonId(@Param("personId") String personId,@Param("system") Integer system);

    void deleteAllByPersonIdAndSystem(String personId,Integer system);

    void deleteAllByPersonId(String personId);

    void deleteAllByPersonIdIn(List<String> personIds);

    void deleteAllByPersonIdInAndMenuIdIn(List<String> personIds,List<Integer> menuIds);

}
