package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.WorkDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkDao extends JpaRepository<WorkDO,Integer>, JpaSpecificationExecutor<WorkDO> {
    List<WorkDO> findAllByZpidOrderByEndDateDesc(Integer zpid);

    WorkDO getById(Integer id);

    List<WorkDO> findAllByZpidAndIsInternshipIsNotOrderByEndDateDesc(Integer zpid, Integer isInternship);

    List<WorkDO> findByPersonId(String personId);

    @Query("select a from WorkDO a where a.zpid = :zpid and (a.isInternship = 0 or a.isInternship is null) order by a.endDate desc")
    List<WorkDO> findAllWorksNotInternship(Integer zpid);

}
