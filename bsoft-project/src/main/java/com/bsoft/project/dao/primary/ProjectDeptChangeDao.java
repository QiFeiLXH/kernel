package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDeptChangeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 11:20
 * @Description:
 */
@Repository
public interface ProjectDeptChangeDao extends JpaRepository<ProjectDeptChangeDO,Integer>, JpaSpecificationExecutor<ProjectDeptChangeDO> {

    List<ProjectDeptChangeDO> findAllByProject(String project);

    @Query("select a from ProjectDeptChangeDO a where a.project =:projectid and a.preStart <= :hsrq and a.preEnd >= :hsrq")
    ProjectDeptChangeDO getByProjectAndPreDate(@Param("projectid") String projectid,@Param("hsrq") Date hsrq);

    @Query(nativeQuery = true,value = "Select b.* From bsoftmis.PROJECT_CHANGEDEPT b, (Select a.project, Min(a.preEnd) AS preEnd From bsoftmis.PROJECT_CHANGEDEPT a Where a.project = :projectid Group By a.project) c Where b.project = c.project And b.preEnd = c.preEnd ")
    ProjectDeptChangeDO getFirstProjectChange(@Param("projectid") String projectid);

    @Query(nativeQuery = true,value = "Select b.* From bsoftmis.PROJECT_CHANGEDEPT b,(Select a.project, Max(a.preEnd) AS preEnd From bsoftmis.PROJECT_CHANGEDEPT a Where a.project = :projectid Group By a.project) c Where b.project = c.project And b.preEnd = c.preEnd ")
    ProjectDeptChangeDO getNewProjectChange(@Param("projectid") String projectid);
}
