package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectWordInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author hy
 * @Date 2020/6/5 10:33
 * @Description
 */
@Repository
public interface ProjectWordInfoDao extends JpaRepository<ProjectWordInfoDO,Integer>, JpaSpecificationExecutor<ProjectWordInfoDO> {

    List<ProjectWordInfoDO> findAllByContractIdAndProjectId(String contractId,String projectId);
}
