package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyRegionDO;
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
public interface ProjectDutyRegionDao extends JpaRepository<ProjectDutyRegionDO,Integer>, JpaSpecificationExecutor<ProjectDutyRegionDO> {
    void deleteByIdIn(List<Integer> ids);
    void deleteAllByDutyId(Integer dutyId);
}
