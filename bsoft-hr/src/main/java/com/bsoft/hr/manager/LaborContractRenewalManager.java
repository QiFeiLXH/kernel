package com.bsoft.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.hr.condition.LaborContractQueryCnd;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.entity.primary.TaskAuditDO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:21
 * @Version 1.0
 */
public interface LaborContractRenewalManager {

    /**
     * 获取待办任务
     * 查询每个流程中的每条待办
     * @param cnd 查询参数
     * @return
     */
    Result<LaborContractApplyViewDO> getLaborContractTaskList(TaskQueryCnd cnd);

    /**
     * 获取待办或者知会任务 APP端用
     */
    Result<LaborContractApplyViewDO> getLaborContractTaskList(Integer flag,TaskQueryCnd cnd);

    /**
     * 获取已办任务
     * 一个流程只需一条数据
     * @param cnd 查询参数
     * @return
     */
    Result<LaborContractApplyViewDO> getLaborContractHistoricTaskList(TaskQueryCnd cnd);

    /**
     * 部门审核人处理
     * @param laborContractApplyDO
     */
    void deptAudit(String personId,LaborContractApplyDO laborContractApplyDO, TaskAuditDO taskAuditDO);

    /**
     * 大区行政总监处理
     */
    void areaAudit(String personId,LaborContractApplyDO laborContractApplyDO, TaskAuditDO taskAuditDO);

    /**
     * 人事审核
     * flag分为两种情况
     * 1.为有大区行政总监 人事专员只需人事审核
     * 2.为无大区行政总监 人事专员需处理与大区行政总监相同业务
     * @param flag
     * @param laborContractApplyDO
     */
    void hrAudit(Integer flag,String personId,LaborContractApplyDO laborContractApplyDO, TaskAuditDO taskAuditDO);

    /**
     * 获取劳动合同即将在三个月内到期的人员信息
     * @return
     */
    List<PersonLaborContractViewDO> getRenewalPersonList();

    /**
     * 获取劳动合同信息列表
     * @param queryCnd 查询参数
     * @return
     */
    Result<LaborContractViewDO> getLaborContractInfoList(LaborContractQueryCnd queryCnd);

    /**
     * 获取合同申请详情
     * @return
     */
    LaborContractApplyViewDO getLaborContractApply(Integer id);

    /**
     * 获取离职单
     */
    List<LaborContractQuitViewDO> getLaborContractQuitList(String personId);

    LaborContractQuitViewDO getLaborContractApplyQuit(Integer id);

    /**
     * 发送提醒邮件给部门负责人
     * 合同到期前2个月、前1个月，若部门负责人还未审核，发送邮件至流程当时的待办人（部门负责人），进行提醒审核，抄送大区行政总监 和人事专员（罗涔）
     */
    void sendRemindEmailToDept();

    /**
     * 发送提醒邮件给办理人和员工
     * 合同到期前1个月，若部门负责人已审核通过且大区负责人未审核，分别发送邮件至流程当时的代办人（办理人）和员工，提醒办理续签，抄送人事专员（罗涔）
     */
    void sendRemindEmailToDealPerson();


    /**
     * 发起续签流程
     * @param personList 合同即将到期的员工
     */
    void startAndCompleteProcess(List<PersonLaborContractViewDO> personList);

    /**
     * 获取员工个人劳动合同申请列表
     * @param personId 工号
     * @return
     */
    List<LaborContractApplyViewDO> getPersonalApplyList(String personId);


    /**
     * 获取劳动合同详情（个人所有劳动合同）
     * @param personId 工号
     * @return
     */
    List<LaborContractDetailViewDO> getLaborContractDetail(String personId);

    /**
     * 更改申请流程状态为终止（用于流程任务管理）
     * @param processInstanceId
     */
    void setStatusToStop(String processInstanceId);

}
