package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LaborContractApplyViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:19
 * @Version 1.0
 */
@Repository
public interface LaborContractApplyViewDao extends JpaRepository<LaborContractApplyViewDO, Integer>, JpaSpecificationExecutor<LaborContractApplyViewDO> {
    List<LaborContractApplyViewDO> findAllByProcessInstanceIdIn(List<String> processInstanceIds);

    List<LaborContractApplyViewDO> findByPersonIdAndEndDate(String personIdList, Date endDate);

    /**
     * 部门负责人未审核 劳动合同审批催办提醒
     * @return
     */
    @Query("select a from LaborContractApplyViewDO a where a.status=1 and a.deptAudit = 0 and (trunc(a.endDate,'dd') - 30 = trunc(sysdate,'dd') or trunc(a.endDate,'dd') - 60 = trunc(sysdate,'dd'))")
    List<LaborContractApplyViewDO> findRemindDeptAudit();

    /**
     * 办理人未处理 劳动合同审批催办提醒
     * @return
     */
    @Query("select a from LaborContractApplyViewDO a where a.status=1 and a.deptAudit = 1 and a.areaAudit = 0 and trunc(a.endDate,'dd') - 30 = trunc(sysdate,'dd')")
    List<LaborContractApplyViewDO> findRemindAreaAudit();
}
