package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.ApplianceNameDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/12/2
 * @description 行政用品名称
 */
@Repository
public interface ApplianceNameDao extends JpaRepository<ApplianceNameDO, Integer>, JpaSpecificationExecutor<ApplianceNameDO> {
    @Query("select max(a.id) from ApplianceNameDO a where a.type = :type")
    Integer findMaxId(@Param("type") Integer type);
}
