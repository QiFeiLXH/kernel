package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.UsageLogCountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UsageLogCountDao extends JpaRepository<UsageLogCountDO,Integer>, JpaSpecificationExecutor<UsageLogCountDO> {

    UsageLogCountDO getByCountDateAndMenuId(@Param("countDate")Date countDate, @Param("menuId") Integer menuId);
}
