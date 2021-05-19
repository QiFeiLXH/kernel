package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.AuthorityDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityDao extends JpaRepository<AuthorityDO,Integer>, JpaSpecificationExecutor<AuthorityDO> {

    @Query("SELECT DISTINCT a FROM AuthorityDO a,MenuDO c WHERE c.system = :system order by a.key asc")
    public List<AuthorityDO> getMenuAuth(@Param("system") Integer system);

    public List<AuthorityDO> findAllByMenuIdOrderByKeyAsc(Integer menuId);

    public void deleteAllByMenuId(Integer menuId);
}
