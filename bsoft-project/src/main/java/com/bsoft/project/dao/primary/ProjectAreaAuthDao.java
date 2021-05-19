package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectAreaAuthDO;
import com.bsoft.project.entity.primary.ProjectDutyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 10:33
 * @Description
 */
@Repository
public interface ProjectAreaAuthDao extends JpaRepository<ProjectAreaAuthDO,Integer>, JpaSpecificationExecutor<ProjectAreaAuthDO> {

    @Query("select a.area from ProjectAreaAuthDO a where a.type = 6 and a.flag = 1 and a.loginId = :userId ")
    List<String> getProjectAreaAuthList(@Param("userId") String userId);

}
