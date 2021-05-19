package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LactationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:13
 * @Description
 */
@Repository
public interface LactationDao extends JpaRepository<LactationDO, Integer>, JpaSpecificationExecutor<LactationDO> {
    @Modifying
    @Query("update LactationDO a set a.personId = :#{#lactationDO.personId}, a.duration = :#{#lactationDO.duration}, a.startDate = :#{#lactationDO.startDate}, a.endDate = :#{#lactationDO.endDate} where a.id = :#{#lactationDO.id}")
    void updateLactation(@Param("lactationDO") LactationDO lactationDO);
}
