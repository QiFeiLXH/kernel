package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectGroupDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.dao
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-07 10:54
 * @Description:
 */
@Repository
public interface ProjectGroupDetailDao extends JpaRepository<ProjectGroupDetailDO,Integer>, JpaSpecificationExecutor<ProjectGroupDetailDO>{
    void deleteByIdIn(List<Integer> ids);

    @Query("select a from ProjectGroupDetailDO a,ProjectGroupDO b where a.groupId = b.id and b.contractNo = :contractNo")
    List<ProjectGroupDetailDO> getProjectGroupAllMembers(@Param("contractNo") String contractNo);

    @Modifying
    @Query("update ProjectGroupDetailDO set leader = 0 where groupId = :groupId and leader = 1")
    void setUnProjectGroupLeader(@Param("groupId") Integer groupId);

    @Query("select count(a.id) from ProjectGroupDetailDO a,ProjectGroupDO b where a.groupId = b.id and a.leader = 1 and b.contractNo = :contractNo and a.personId = :personId")
    Integer isLeader(@Param("personId") String personId, @Param("contractNo") String contractNo);

    @Query("select count(a.id) from ProjectGroupDetailDO a,ProjectGroupDO b where a.groupId = b.id and b.contractNo = :contractNo and a.personId = :personId")
    Integer isGroupMember(@Param("personId") String personId, @Param("contractNo") String contractNo);
}
