package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyRegionViewDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 10:33
 * @Description
 */
@Repository
public interface ProjectDutyRegionViewDao extends JpaRepository<ProjectDutyRegionViewDO,Integer>, JpaSpecificationExecutor<ProjectDutyRegionViewDO> {
    List<ProjectDutyRegionViewDO> findAllByDutyId(Integer dutyId);
}
