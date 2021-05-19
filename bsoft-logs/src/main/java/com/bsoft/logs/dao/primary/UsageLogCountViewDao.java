package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.UsageLogCountViewDO;
import com.bsoft.logs.entity.primary.UsageLogCountWithDateDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsageLogCountViewDao extends JpaRepository<UsageLogCountViewDO,Integer>, JpaSpecificationExecutor<UsageLogCountViewDO> {

    @Query(value = "select new com.bsoft.logs.entity.primary.UsageLogCountWithDateDO(a.menuId,a.menuName,sum(a.count),sum(a.personCount)) from UsageLogCountViewDO a where a.countDate >= :start and a.countDate <= :end group by a.menuId,a.menuName")
    List<UsageLogCountWithDateDO> count(@Param("start") Date start, @Param("end") Date end);

}
