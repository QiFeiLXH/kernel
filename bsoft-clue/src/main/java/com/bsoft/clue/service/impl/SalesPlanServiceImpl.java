package com.bsoft.clue.service.impl;

import com.bsoft.clue.condition.SalesPlanQueryCnd;
import com.bsoft.clue.dto.*;
import com.bsoft.clue.entity.primary.*;
import com.bsoft.clue.manager.SalesPlanManager;
import com.bsoft.clue.service.SalesPlanService;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.dept.dto.DeptDTO;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.person.dto.PersonDTO;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dto.TaskQueryCndDTO;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SalesPlanServiceImpl implements SalesPlanService {
    private final static Logger logger = LoggerFactory.getLogger(SalesPlanServiceImpl.class);
    @Autowired
    private SalesPlanManager salesPlanManager;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<SalesPlanDTO> getSalesPlan(String personId,SalesPlanQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanQueryCnd cnd = GeneratorUtil.instance().convert(cndDTO,SalesPlanQueryCnd.class);
        Result<SalesPlanDO> result = salesPlanManager.getSalesPlan(cnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取销售计划列表成功，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(result,SalesPlanDTO.class);
    }

    @Override
    public List<SalesCluesViewDTO> getClues(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesCluesViewDO> result = salesPlanManager.getClues(personId);
        long time = timeConsumer.end();
        logger.info("工号:{}获取本人销售线索列表成功，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(result,SalesCluesViewDTO.class);
    }

    @Override
    public Result<SalesCluesViewDTO> getCluesForSearch(String personId, SalesPlanQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanQueryCnd queryCnd = iGenerator.convert(queryCndDTO, SalesPlanQueryCnd.class);
        Result<SalesCluesViewDO> result = salesPlanManager.getCluesForSearch(queryCnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取销售线索列表成功，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(result,SalesCluesViewDTO.class);
    }

    @Override
    public void save(String personId,List<SalesPlanDTO> list) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesPlanDO> planDOS = GeneratorUtil.instance().convert(list,SalesPlanDO.class);
        salesPlanManager.save(planDOS);
        long time = timeConsumer.end();
        logger.info("工号:{}保存销售计划并发起审核流程成功，耗时:{}",new Object[]{personId,time});
    }

    @Override
    public SalesPlanAmountDTO getSalesPlanAmount(String personId,SalesPlanQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanQueryCnd cnd = GeneratorUtil.instance().convert(cndDTO,SalesPlanQueryCnd.class);
        SalesPlanAmountDO salesPlanAmountDO = salesPlanManager.getSalesPlanAmount(cnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取本人销售计划总金额成功，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(salesPlanAmountDO,SalesPlanAmountDTO.class);
    }

    @Override
    public SalesPlanAmountDTO getSalesPlanAmountWithAudit(String personId, TaskQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd cnd = GeneratorUtil.instance().convert(cndDTO,TaskQueryCnd.class);
        SalesPlanAmountDO salesPlanAmountDO = salesPlanManager.getSalesPlanAmountWithAudit(cnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取本人待审核销售计划总金额成功，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(salesPlanAmountDO,SalesPlanAmountDTO.class);
    }

    @Override
    public List<String> getReportMonthWithYear(String personId, String year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> list = salesPlanManager.getReportMonthWithYear(personId,year);
        long time = timeConsumer.end();
        logger.info("工号:{}获取{}年有计划的月份，耗时:{}",new Object[]{personId,year,time});
        return list;
    }

    @Override
    public List<PersonDTO> getTrackPersonsByAuditor(String personId,TaskQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd taskQueryCnd = GeneratorUtil.instance().convert(cnd,TaskQueryCnd.class);
        List<PersonDO> personDOS = salesPlanManager.getTrackPersonsByAuditor(taskQueryCnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取待办任务所有跟单人列表，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(personDOS,PersonDTO.class);
    }

    @Override
    public List<DeptDTO> getTrackDeptsByAuditor(String personId, TaskQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd taskQueryCnd = GeneratorUtil.instance().convert(cnd,TaskQueryCnd.class);
        List<DeptDO> deptDOS = salesPlanManager.getTrackDeptsByAuditor(taskQueryCnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取待办任务所有跟单人列表，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(deptDOS,DeptDTO.class);
    }

    @Override
    public Result<SalesPlanViewDTO> getSalesPlanAuditList(String personId,TaskQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd taskQueryCnd = GeneratorUtil.instance().convert(cnd,TaskQueryCnd.class);
        Result<SalesPlanViewDO> result = salesPlanManager.getSalesPlanAuditList(taskQueryCnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取待办任务列表，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(result,SalesPlanViewDTO.class);
    }

    @Override
    public void successApply(String personId, String taskId, String opinion, Integer system,Integer id,String processInstanceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesPlanManager.successApply(personId, taskId, opinion, system,id,processInstanceId);
        long times = timeConsumer.end();
        logger.info("工号：{}同意审核，耗时：{}",new Object[]{personId,times});

    }

    @Override
    public void failApply(String personId, String taskId, String opinion, Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesPlanManager.failApply(personId,taskId,opinion,system);
        long times = timeConsumer.end();
        logger.info("工号：{}不同意审核，耗时：{}",new Object[]{personId,times});
    }

    @Override
    public List<SalesPlanViewDTO> getSalesPlanReportViewList(String personId, SalesPlanQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanQueryCnd cnd = GeneratorUtil.instance().convert(queryCndDTO,SalesPlanQueryCnd.class);
        List<SalesPlanViewDO> list = salesPlanManager.getSalesPlanReportViewList(cnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取销售计划列表，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(list, SalesPlanViewDTO.class);
    }

    @Override
    public Result<SalesPlanViewDTO> listSalesPlanReportView(String personId, SalesPlanQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanQueryCnd cnd = GeneratorUtil.instance().convert(queryCndDTO,SalesPlanQueryCnd.class);
        Result<SalesPlanViewDO> result = salesPlanManager.listSalesPlanReportView(cnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取销售计划列表，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(result,SalesPlanViewDTO.class);
    }

    @Override
    public List<SalesPlanDTO> listTrackPersons(String personId, SalesPlanQueryCndDTO queryCndDTO) {
        SalesPlanQueryCnd queryCnd = iGenerator.convert(queryCndDTO, SalesPlanQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesPlanDO> resultDO = salesPlanManager.listTrackPersons(queryCnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取销售计划跟单人列表，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(resultDO, SalesPlanDTO.class);
    }

    @Override
    public List<SalesPlanDTO> listTrackDepts(String personId, SalesPlanQueryCndDTO queryCndDTO) {
        SalesPlanQueryCnd queryCnd = iGenerator.convert(queryCndDTO, SalesPlanQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesPlanDO> resultDO = salesPlanManager.listTrackDepts(queryCnd);
        long time = timeConsumer.end();
        logger.info("工号:{}获取销售计划跟单部门列表，耗时:{}",new Object[]{personId,time});
        return GeneratorUtil.instance().convert(resultDO, SalesPlanDTO.class);
    }


    @Override
    public void importSalesPlanData(String personId, List<SalesPlanDTO> saveDTOList, List<SalesPlanDTO> errorDTOList) {
        List<SalesPlanDO> saveDOList = iGenerator.convert(saveDTOList, SalesPlanDO.class);
        List<SalesPlanDO> errorDOList = iGenerator.convert(errorDTOList, SalesPlanDO.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesPlanManager.importSalesPlanData(personId, saveDOList, errorDOList);
        long times = timeConsumer.end();
        logger.info("工号：{}导入销售计划数据，耗时：{}",new Object[]{personId, times});
    }

    @Override
    public List<SalesPlanDTO> exportErrorData(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesPlanDO> errorDataDO = salesPlanManager.exportErrorData(personId);
        long times = timeConsumer.end();
        logger.info("工号：{}导出销售计划错误数据，耗时：{}",new Object[]{personId, times});
        return iGenerator.convert(errorDataDO, SalesPlanDTO.class);
    }

    @Override
    public void saveSalesPlanReport(String personId, SalesPlanDTO saveDTO) {
        SalesPlanDO saveDO = iGenerator.convert(saveDTO, SalesPlanDO.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesPlanManager.saveSalesPlanReport(saveDO);
        long times = timeConsumer.end();
        logger.info("工号：{}保存销售计划信息，耗时：{}",new Object[]{personId, times});
    }

    @Override
    public SalesPlanViewDTO getSalesPlanReport(String personId, String processInstanceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanViewDO result = salesPlanManager.getSalesPlanReport(processInstanceId);
        long times = timeConsumer.end();
        logger.info("工号：{}根据流程实例ID获取销售计划，耗时：{}",new Object[]{personId, times});
        return iGenerator.convert(result, SalesPlanViewDTO.class);
    }

    @Override
    public SalesPlanViewDTO getSalesPlanInfo(String personId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanViewDO result = salesPlanManager.getSalesPlanInfo(id);
        long times = timeConsumer.end();
        logger.info("工号：{}根据ID获取销售计划，耗时：{}",new Object[]{personId, times});
        return iGenerator.convert(result, SalesPlanViewDTO.class);
    }

    @Override
    public SalesPlanDetailViewDTO getSalesPlanDetail(String personId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanDetailViewDO result = salesPlanManager.getSalesPlanDetail(id);
        long times = timeConsumer.end();
        logger.info("工号：{}根据ID获取销售计划，耗时：{}",new Object[]{personId, times});
        return iGenerator.convert(result, SalesPlanDetailViewDTO.class);
    }

    @Override
    public void updateSalesPlanWithAudit(String personId, SalesPlanDTO salesPlanDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesPlanDO salesPlanDO = iGenerator.convert(salesPlanDTO,SalesPlanDO.class);
        salesPlanManager.updateSalesPlanWithAudit(salesPlanDO);
        long times = timeConsumer.end();
        logger.info("工号：{}审核计划时修改，耗时：{}",new Object[]{personId, times});
    }
}
