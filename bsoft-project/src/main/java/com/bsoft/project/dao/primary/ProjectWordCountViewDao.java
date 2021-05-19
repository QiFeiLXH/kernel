package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectWordCountViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/4/26
 * @description 项目文档统计
 */
@Repository
public interface ProjectWordCountViewDao extends JpaRepository<ProjectWordCountViewDO, String>, JpaSpecificationExecutor<ProjectWordCountViewDO> {
}
