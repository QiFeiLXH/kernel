package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.*;
import com.bsoft.workflow.dto.TaskAuditDTO;
import com.bsoft.workflow.dto.TaskQueryCndDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:21
 * @Version 1.0
 */
public interface LaborContractRenewalService {

    /**
     * 根据条件获取待审核劳动续签合同
     * @return
     */
    Result<LaborContractApplyViewDTO> getLaborContractAuditList(String personId,TaskQueryCndDTO cnd);


    /**
     * 获取待办或者知会任务 APP端用
     * @param  flag 0普通待办 1知会待办
     */
    Result<LaborContractApplyViewDTO> getLaborContractTaskList(String personId,Integer flag,TaskQueryCndDTO cnd);

    /**
     * 部门审核人处理
     * @param dto
     */
    void deptAudit(String personId, LaborContractApplyDTO dto, TaskAuditDTO taskAuditDTO);

    /**
     * 大区行政总监处理
     */
    void areaAudit(String personId, LaborContractApplyDTO dto, TaskAuditDTO taskAuditDTO);

    /**
     * 人事审核
     * flag分为两种情况 1.为有大区行政总监 人事专员只需人事审核
     * 2.为无大区行政总监 人事专员需处理与大区行政总监相同业务
     * @param flag
     * @param dto
     */
    void hrAudit(Integer flag, String personId, LaborContractApplyDTO dto, TaskAuditDTO taskAuditDTO);

    /**
     * 获取合同申请详情
     * @return
     */
    LaborContractApplyViewDTO getLaborContractApply(String personId,Integer id);

    /**
     * 获取劳动合同信息列表
     * @param personId 操作工号
     * @param queryCndDTO 查询参数
     */
    Result<LaborContractViewDTO> getLaborContractInfoList(String personId, LaborContractQueryCndDTO queryCndDTO);

    /**
     * 离职单查询
     * @param personId
     * @return
     */
    List<LaborContractQuitViewDTO> getLaborContractQuitList(String personId);

    LaborContractQuitViewDTO getLaborContractApplyQuit(String personId,Integer id);

    /**
     * 获取员工个人劳动合同申请列表
     * @param userId 操作工号
     * @param personId 用于查询的工号
     * @return
     */
    List<LaborContractApplyViewDTO> getPersonalLaborContractApplyViewList(String userId, String personId);


    /**
     * 获取劳动合同详情（个人所有劳动合同）
     * @param userId 操作工号
     * @param personId 工号
     * @return
     */
    List<LaborContractDetailViewDTO> getLaborContractDetail(String userId, String personId);

    /**
     * 更改申请流程状态为终止（用于流程任务管理）
     * @param userId 操作人工号
     * @param processInstanceId 流程实例ID
     */
    void setStatusToStop(String userId, String processInstanceId);
}
