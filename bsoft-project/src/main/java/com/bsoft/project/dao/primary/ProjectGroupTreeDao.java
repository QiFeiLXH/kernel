package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectGroupTreeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-19 16:40
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectGroupTreeDao extends JpaRepository<ProjectGroupTreeDO,Integer>, JpaSpecificationExecutor<ProjectGroupTreeDO> {
    List<ProjectGroupTreeDO> findByContractNo(String contractNo);
}
