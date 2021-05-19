package com.bsoft.hr.manager;

import com.bsoft.hr.condition.WorkVacationQueryCnd;
import com.bsoft.hr.entity.primary.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 年假生成
 */
public interface AnnualVacationManager {

    /**
     * 根据假期主表处理关联表数据
     * @param workVacationDOS
     * @param workVacationKey
     * @param workVacationDetailKey
     * @return
     */
    List<WorkVacationDO> getWorkVacations(List<WorkVacationDO> workVacationDOS, Integer workVacationKey, Integer workVacationDetailKey);

    /**
     * 获取假期主表信息
     * @return
     */
    List<WorkVacationDO> getWorkVacations();

    /**
     * 获取假期明细
     * @param workVacationDOS
     * @return
     */
    List<WorkVacationDetailDO> getWorkVacationDetails(List<WorkVacationDO> workVacationDOS);

    /**
     * 获取需要删除年假的人员
     * 1-10年 请病假2个月以上
     * 10-20请病假3个月以上
     * 20年以上 请病假4个月以上
     * @return
     */
    List<WorkVacationDO> getWorkVacationsNeedDelete();

    /**
     * 需要删除的明细
     * @param workVacationDOS
     * @return
     */
    List<WorkVacationDetailDO> getWorkVacationDetailsNeedDelete(List<WorkVacationDO> workVacationDOS);

    /**
     * 存储数据
     * @param workVacationDOS
     */
    void save(List<WorkVacationDO> workVacationDOS,List<WorkVacationDO> workVacationsDelete,List<WorkVacationDetailDO> workVacationDetailsDelete);

    /**
     * 获取年假信息
     * @return
     */
    Page<AnnualVacationInfoDO> getAnnualVacationInfo(WorkVacationQueryCnd cnd);

    /**
     * 处理假期库数据（生成id及明细）（用于hr新增）
     * @param workVacationDO
     * @return
     */
    WorkVacationDO processWorkVacationForSave(WorkVacationDO workVacationDO);

    /**
     * 处理假期库数据（修改时间）（用于hr修改）
     * @param workVacationDO
     * @return
     */
    WorkVacationDO processWorkVacationForUpdate(WorkVacationDO workVacationDO);

    /**
     * 保存年假信息（hr）
     * @param workVacationDO
     */
    void saveFromHr(WorkVacationDO workVacationDO);

    /**
     * 修改年假信息（hr）
     */
    void updateFromHr(WorkVacationDO workVacationDO, List<WorkVacationDetailDO> needDeleteList);


    /**
     * 获取需要统一扣除年假时 生成的默认请假单信息
     * @param year
     * @param days
     * @return
     */
    List<LeaveDO> getReduceAnnualLeaves(String year,Integer days);

    /**
     * 统一扣除年假
     */
    void reduceAnnualVacationUnified(List<LeaveDO> leaveDOS,Integer leaveKey,Integer reduceId);

}
