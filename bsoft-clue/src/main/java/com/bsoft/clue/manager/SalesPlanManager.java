package com.bsoft.clue.manager;

import com.bsoft.clue.condition.SalesPlanQueryCnd;
import com.bsoft.clue.entity.primary.*;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.result.Result;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.workflow.condition.TaskQueryCnd;

import java.util.List;
import java.util.Map;

public interface SalesPlanManager {
    Result<SalesPlanDO> getSalesPlan(SalesPlanQueryCnd cnd);

    /**
     * 跟单人是本人的销售线索，已立项且未关闭的。计划签约日期在今年或以后的。
     * @param personId
     * @return
     */
    List<SalesCluesViewDO> getClues(String personId);

    /**
     * 根据搜索条件获取线索列表
     * @param queryCnd
     * @return
     */
    Result<SalesCluesViewDO> getCluesForSearch(SalesPlanQueryCnd queryCnd);

    /**
     * 批量保存销售计划，并发起对应审核流程
     * @param list
     */
    void save(List<SalesPlanDO> list);

    /**
     * 根据查询条件查询出对应的销售计划的总金额
     * @param cnd
     * @return
     */
    SalesPlanAmountDO getSalesPlanAmount(SalesPlanQueryCnd cnd);


    /**
     * 根据查询条件查询出对应销售计划待办列表的总金额
     * @param cnd
     * @return
     */
    SalesPlanAmountDO getSalesPlanAmountWithAudit(TaskQueryCnd cnd);

    /**
     * 根据年份获取当年有数据的月份
     * @param year
     * @return
     */
    List<String> getReportMonthWithYear(String personId, String year);

    /**
     * 根据当前登录人查询出待办任务中的 所有跟单人
     * @return
     */
    List<PersonDO> getTrackPersonsByAuditor(TaskQueryCnd cnd);

    /**
     * 根据当前登录人查询出待办任务中的 所有跟单部门
     * @return
     */
    List<DeptDO> getTrackDeptsByAuditor(TaskQueryCnd cnd);

    /**
     * 根据条件获取待审核计划列表
     * @return
     */
    Result<SalesPlanViewDO> getSalesPlanAuditList(TaskQueryCnd cnd);

    /**
     * 通过-审核
     * @param personId 审核人
     * @param opinion 审核意见
     * @param taskId  待办任务ID
     */
    void successApply(String personId,String taskId,String opinion,Integer system,Integer id,String processInstanceId);

    /**
     * 拒绝-审核
     * @param personId 审核人
     * @param opinion 审核意见
     * @param taskId 待办任务ID
     */
    void failApply(String personId,String taskId,String opinion,Integer system);


    void apply(String taskId, Map<String, Object> map);

    /**
     * 获取销售计划视图列表（不分页）
     * @param queryCnd 查询参数
     * @return
     */
    List<SalesPlanViewDO> getSalesPlanReportViewList(SalesPlanQueryCnd queryCnd);

    /**
     * 获取销售计划视图列表（分页）
     * @param queryCnd 查询参数
     * @return
     */
    Result<SalesPlanViewDO> listSalesPlanReportView(SalesPlanQueryCnd queryCnd);

    /**
     * 获取跟单人列表
     * @return
     */
    List<SalesPlanDO> listTrackPersons(SalesPlanQueryCnd queryCnd);

    /**
     * 获取跟单部门
     * @return
     */
    List<SalesPlanDO> listTrackDepts(SalesPlanQueryCnd queryCnd);

    /**
     * 导入销售计划数据
     * @param saveDOList 导入数据列表
     * @param errorDOList 错误数据列表
     */
    void importSalesPlanData(String personId, List<SalesPlanDO> saveDOList, List<SalesPlanDO> errorDOList);

    /**
     * 导出错误数据
     * @param personId 操作人工号
     * @return 错误数据列表
     */
    List<SalesPlanDO> exportErrorData(String personId);

    /**
     * 保存销售计划信息
     * @param saveDO 要保存的信息
     */
    void saveSalesPlanReport(SalesPlanDO saveDO);

    /**
     * 获取销售计划信息
     * @param processInstanceId 流程实例ID
     * @return
     */
    SalesPlanViewDO getSalesPlanReport(String processInstanceId);

    /**
     * 获取销售计划信息
     * @param id ID
     * @return
     */
    SalesPlanViewDO getSalesPlanInfo(Integer id);


    SalesPlanDetailViewDO getSalesPlanDetail(Integer id);

    /**
     * 审核计划时修改 对应信息
     * @param salesPlanDO
     */
    void updateSalesPlanWithAudit(SalesPlanDO salesPlanDO);
}
