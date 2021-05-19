package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.ProjectWordDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/7/30 10:12
 * @Description: 文档信息
 */
@Repository
public interface ProjectWordDao extends JpaRepository<ProjectWordDO,Integer>, JpaSpecificationExecutor<ProjectWordDO> {
}
