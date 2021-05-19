package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyPaymentDO;
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
public interface ProjectDutyPaymentDao extends JpaRepository<ProjectDutyPaymentDO,Integer>, JpaSpecificationExecutor<ProjectDutyPaymentDO> {
    void deleteAllByDutyId(Integer dutyId);

    void deleteAllByIdIn(List<Integer> ids);

    void deleteAllByDutyIdAndContractNoIn(Integer dutyId, List<String> contractNo);
}
