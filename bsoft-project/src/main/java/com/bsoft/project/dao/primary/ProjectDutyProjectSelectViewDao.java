package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyProjectSelectViewDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 10:34
 * @Description
 */
@Repository
public interface ProjectDutyProjectSelectViewDao extends JpaRepository<ProjectDutyProjectSelectViewDO,String>, JpaSpecificationExecutor<ProjectDutyProjectSelectViewDO> {
    Page<ProjectDutyProjectSelectViewDO> findByProjectManager(String userId, Pageable pageable);
}
