package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.ReimbDateControlDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:20
 * @Description:
 */
@Repository
public interface ReimbDateControlDao extends JpaRepository<ReimbDateControlDO,Integer>, JpaSpecificationExecutor<ReimbDateControlDO> {
    @Query("select a from ReimbDateControlDO a where a.year = :year and a.flag = 0")
    List<ReimbDateControlDO> findAllByYear(@Param("year") Integer year);
}
