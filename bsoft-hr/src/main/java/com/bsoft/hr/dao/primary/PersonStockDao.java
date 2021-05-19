package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PersonStockDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:01
 * @Description
 */
@Repository
public interface PersonStockDao extends JpaRepository<PersonStockDO, String>, JpaSpecificationExecutor<PersonStockDO> {
    @Modifying
    @Query("update PersonStockDO a set a.logout = :logout where a.id = :id")
    void updateLogoutById(@Param("id") Integer id, @Param("logout") Integer logout);


    @Modifying
    @Query("update PersonStockDO a set a.logout = :logout where a.id in (:ids)")
    void updateAllLogoutById(@Param("ids") List<Integer> ids, @Param("logout") Integer logout);
}
