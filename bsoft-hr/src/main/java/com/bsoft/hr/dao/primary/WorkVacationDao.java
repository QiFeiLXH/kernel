package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LeaveDO;
import com.bsoft.hr.entity.primary.WorkVacationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkVacationDao extends JpaRepository<WorkVacationDO, Integer>, JpaSpecificationExecutor<WorkVacationDO> {
    List<WorkVacationDO> findAllByYear(String year);

    @Query("select a from WorkVacationDO a where a.personId = :personId and a.type = :type and to_char(a.createDate,'yyyy') = :year")
    Page<WorkVacationDO> findAllByPersonIdAndTypeAndCreateDate(@Param("personId") String personId,@Param("type")Integer type,@Param("year")String year, Pageable pageable);

    List<WorkVacationDO> findAllByPersonIdIn(List<String> personids);

}
