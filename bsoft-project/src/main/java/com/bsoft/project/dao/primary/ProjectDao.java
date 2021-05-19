package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectDao extends JpaRepository<ProjectDO,String>, JpaSpecificationExecutor<ProjectDO> {
    List<ProjectDO> findByProjectIdIn(List<String> projectIdList);
    Page<ProjectDO> findByContractNoLikeOrProjectNameLikeOrPinyinLike(String contractno,String projectName,String pinyin, Pageable pageable);
    List<ProjectDO> findByClueId(Integer clueId);
    List<ProjectDO> findByContractId(String contractId);
    @Query("select a.projectId from ProjectDO a where a.finshed = 0")
    public List<String> getAllProjectId();

    Page<ProjectDO> findAllByContractNo(String contractNo, Pageable pageable);

    @Modifying
    @Query("update ProjectDO a set a.projectManager = :projectManagerId where a.projectId = :projectId")
    void updateProjectManagerByProjectId(@Param("projectId") String projectId, @Param("projectManagerId") String projectManagerId);

    @Modifying
    @Query("update ProjectDO a set a.updateFlag = :updateFlag where a.projectId = :projectId")
    void updateProjectUpdateFlag(@Param("projectId") String projectId, @Param("updateFlag") Integer updateFlag);

    @Modifying
    @Query("update ProjectDO a set a.progress =:progress ,a.progressMonth =:progressMonth where a.projectId =:projectId")
    void updateProjectProgress(@Param("projectId") String projectId, @Param("progress") Double progress, @Param("progressMonth") Date progressMonth);
}
