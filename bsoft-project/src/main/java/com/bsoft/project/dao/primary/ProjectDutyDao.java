package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 10:33
 * @Description
 */
@Repository
public interface ProjectDutyDao extends JpaRepository<ProjectDutyDO,Integer>, JpaSpecificationExecutor<ProjectDutyDO> {
    @Query("select b.name from ProjectDutyDO b where b.id = (select max(a.id) from ProjectDutyDO a where to_char(a.startDate,'yyyy') = :year and a.customerId = :customerId)")
    String getProjectDutyNameNoByCustomerIdAndYear(@Param("customerId")String customerId, @Param("year")String year);

}
