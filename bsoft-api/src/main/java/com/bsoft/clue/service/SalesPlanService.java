package com.bsoft.clue.service;

import com.bsoft.clue.dto.*;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.dept.dto.DeptDTO;
import com.bsoft.person.dto.PersonDTO;
import com.bsoft.workflow.dto.TaskQueryCndDTO;

import java.util.List;

public interface SalesPlanService {
    /**
     * 根据条件获取销售计划列表
     * @param personId
     * @param cndDTO
     * @return
     */
    Result<SalesPlanDTO> getSalesPlan(String personId,SalesPlanQueryCndDTO cndDTO);
    /**
     * 跟单人是本人的销售线索，已立项且未关闭的。计划签约日期在今年或以后的。
     * @param personId
     * @return
     */
    List<SalesCluesViewDTO> getClues(String personId);

    /**
     * 根据搜索条件获取线索列表。
     * @param personId
     * @param queryCndDTO
     * @return
     */
    Result<SalesCluesViewDTO> getCluesForSearch(String personId, SalesPlanQueryCndDTO queryCndDTO);

    /**
     * 批量保存销售计划，并发起对应审核流程
     * @param list
     */
    void save(String personId,List<SalesPlanDTO> list);


    /**
     * 根据查询条件查询出对应的销售计划的总金额
     * @param cnd
     * @return
     */
    SalesPlanAmountDTO getSalesPlanAmount(String personId,SalesPlanQueryCndDTO cnd);

    /**
     * 根据查询条件查询出对应的销售计划待办列表的总金额
     * @param cnd
     * @return
     */
    SalesPlanAmountDTO getSalesPlanAmountWithAudit(String personId,TaskQueryCndDTO cnd);

    /**
     * 根据年份获取当年有数据的月份
     * @param year
     * @return
     */
    List<String> getReportMonthWithYear(String personId,String year);

    /**
     * 根据当前登录人查询出待办任务中的 所有跟单人
     * @return
     */
    List<PersonDTO> getTrackPersonsByAuditor(String personId,TaskQueryCndDTO cnd);

    /**
     * 根据当前登录人查询出待办任务中的 所有跟单部门
     * @return
     */
    List<DeptDTO> getTrackDeptsByAuditor(String personId, TaskQueryCndDTO cnd);

    /**
     * 根据条件获取待审核计划列表
     * @return
     */
    Result<SalesPlanViewDTO> getSalesPlanAuditList(String personId,TaskQueryCndDTO cnd);

    /**
     *
     * 通过-审核
     * @param personId  操作人工号
     * @param taskId   待办任务ID
     * @param opinion 审核意见
     * @param system 操作系统
     */
    void successApply(String personId, String taskId,String opinion,Integer system,Integer id,String processInstanceId);

    /**
     * 拒绝-审核
     * @param personId  操作人工号
     * @param taskId 待办任务ID
     * @param opinion 审核意见
     * @param system 操作系统
     */
    void failApply(String personId, String taskId,String opinion,Integer system);

    /**
     * 获取销售计划视图列表
     * @param personId 操作人工号
     * @param queryCndDTO 查询参数
     * @return
     */
    List<SalesPlanViewDTO> getSalesPlanReportViewList( String personId, SalesPlanQueryCndDTO queryCndDTO);

    /**
     * 获取销售计划视图列表
     * @param personId 操作人工号
     * @param queryCndDTO 查询参数
     * @return
     */
    Result<SalesPlanViewDTO> listSalesPlanReportView( String personId, SalesPlanQueryCndDTO queryCndDTO);

    /**
     * 获取跟单人列表
     * @param personId
     * @param queryCndDTO
     * @return
     */
    List<SalesPlanDTO> listTrackPersons(String personId, SalesPlanQueryCndDTO queryCndDTO);

    /**
     * 获取跟单部门
     * @param personId
     * @param queryCndDTO
     * @return
     */
    List<SalesPlanDTO> listTrackDepts(String personId, SalesPlanQueryCndDTO queryCndDTO);

    /**
     * 导入销售计划数据
     * @param personId 操作人工号
     * @param saveDTOList 导入数据列表
     * @param errorDTOList 错误数据列表
     */
    void importSalesPlanData(String personId, List<SalesPlanDTO> saveDTOList, List<SalesPlanDTO> errorDTOList);

    /**
     * 导出错误数据
     * @param personId 操作人工号
     * @return 错误数据列表
     */
    List<SalesPlanDTO> exportErrorData(String personId);

    /**
     * 保存销售计划信息
     * @param personId 操作人工号
     * @param saveDTO 要保存的信息
     */
    void saveSalesPlanReport(String personId, SalesPlanDTO saveDTO);

    /**
     * 获取销售计划信息
     * @param personId 操作人工号
     * @param processInstanceId 流程实例ID
     * @return
     */
    SalesPlanViewDTO getSalesPlanReport(String personId, String processInstanceId);

    /**
     * 获取销售计划信息
     * @param personId 操作人工号
     * @param id ID
     * @return
     */
    SalesPlanViewDTO getSalesPlanInfo(String personId, Integer id);


    /**
     * 根据ID获取销售计划视图信息
     */
    SalesPlanDetailViewDTO getSalesPlanDetail(String personId,Integer id);

    /**
     * 审核计划时修改 对应信息
     * @param salesPlanDTO
     */
    void updateSalesPlanWithAudit(String personId,SalesPlanDTO salesPlanDTO);

}
