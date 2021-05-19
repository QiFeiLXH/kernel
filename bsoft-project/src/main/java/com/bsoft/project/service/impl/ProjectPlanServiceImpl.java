package com.bsoft.project.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.condition.ProjectPlanQueryCnd;
import com.bsoft.project.dto.*;
import com.bsoft.project.entity.primary.ProjectLogPlanDetailDO;
import com.bsoft.project.entity.primary.ProjectPlanDO;
import com.bsoft.project.entity.primary.ProjectPlanDetailDO;
import com.bsoft.project.entity.primary.ProjectWithPlanDO;
import com.bsoft.project.manager.ProjectPlanManager;
import com.bsoft.project.service.ProjectPlanService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.*;

/**
 * @Author zhanglf
 * @Date 2020-01-19 10:37
 * @Version 1.0
 * @Description
 */
@Service
public class ProjectPlanServiceImpl implements ProjectPlanService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectPlanServiceImpl.class);
    @Autowired
    private GeneratorUtil generator;
    @Autowired
    private ProjectPlanManager projectPlanManager;
    @Override
    public List<ProjectPlanDetailDTO> getProjectPlanDetailTree(Integer planId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectPlanDetailDO> tree;
        if(planId == null){
            tree = projectPlanManager.getProjectPlanTemplate();
        }else{
            tree = projectPlanManager.getProjectPlanDetailTree(planId);
        }

        long times = timeConsumer.end();
        logger.info("项目计划详细-计划ID: {},耗时:{}",new Object[]{planId,times});
        return generator.convert(tree,ProjectPlanDetailDTO.class);
    }

    @Override
    public void saveProjectPlanDetailList(List<ProjectPlanDetailDTO> projectPlanDetailDTOS) {
        List<ProjectPlanDetailDO> list = generator.convert(projectPlanDetailDTOS,ProjectPlanDetailDO.class);
        projectPlanManager.saveProjectPlanDetails(list);
    }

    @Override
    public void deleteProjectPlanDetail(Integer id) {
        projectPlanManager.deleteProjectPlanDetail(id);
    }


    @Override
    public ProjectPlanDTO saveProjectPlanAndDetail(ProjectPlanDTO plan, List<ProjectPlanDetailDTO> details, List<Integer> deletes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectPlanDO projectPlan = generator.convert(plan,ProjectPlanDO.class);
        List<ProjectPlanDetailDO> tree = generator.convert(details,ProjectPlanDetailDO.class);
        List<ProjectPlanDetailDO> projectPlanDetails = projectPlanManager.detailTreeToList(tree);
        ProjectPlanDO projectPlanDO = projectPlanManager.savePlanAndDetail(projectPlan,projectPlanDetails,deletes);
        long times = timeConsumer.end();
        logger.info("计划维护保存-计划ID: {},耗时:{}",new Object[]{projectPlanDO.getId(),times});
        return generator.convert(projectPlanDO,ProjectPlanDTO.class);
    }

    @Override
    public Result<ProjectWithPlanDTO> getProjectWithPlans(String projectManager, String context, Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectWithPlanDO> projectPage = projectPlanManager.getProjectWithPlans(projectManager,context,page,size);
        long times = timeConsumer.end();
        logger.info("项目计划列表-项目经理: {}，条数：{}，页数：{}耗时:{}",new Object[]{projectManager,size,page,times});
        return ResultUtils.parseResult(projectPage, ProjectWithPlanDTO.class);
    }

    @Override
    public ProjectPlanDetailDTO getProjectPlanDetail(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectPlanDetailDO detail = projectPlanManager.getProjectPlanDetail(id);
        long times = timeConsumer.end();
        logger.info("获取计划维护详情-计划ID: {},耗时:{}",new Object[]{id,times});
        return generator.convert(detail,ProjectPlanDetailDTO.class);
    }

    @Override
    public List<ProjectLogPlanDetailDTO> getProjectLogPlanDetailTree(String projectId, String personId, Date attendanceDate,Integer part) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLogPlanDetailDO> result = projectPlanManager.getProjectLogPlanDetailTree(projectId,personId,attendanceDate,part);
        long times = timeConsumer.end();
        logger.info("日志录入计划树查询-项目经理: {}，项目Id：{},耗时:{}",new Object[]{personId,projectId,times});
        return generator.convert(result,ProjectLogPlanDetailDTO.class);
    }

    @Override
    public List<ProjectLogPlanDetailDTO> getProjectLogPlanDetailQueryTree(String contractNo, Integer part) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLogPlanDetailDO> result = projectPlanManager.getProjectLogPlanDetailQueryTree(contractNo, part);
        long times = timeConsumer.end();
        logger.info("项目计划查询-计划树耗时: {}，合同号：{}, 计划筛选条件：{}",new Object[]{times,contractNo, part});
        return generator.convert(result,ProjectLogPlanDetailDTO.class);
    }

    @Override
    public Result<ProjectWithPlanDTO> getProjectWithPlansAndAuth(String personId, ProjectPlanQueryCndDTO paramsCnd, Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectPlanQueryCnd cnds = generator.convert(paramsCnd, ProjectPlanQueryCnd.class);
        PageInfo<ProjectWithPlanDO> result = projectPlanManager.getProjectWithPlansAndAuth(personId, cnds,page,size);
        long times = timeConsumer.end();
        logger.info("项目计划查询列表耗时: {}，登录工号：{}",new Object[]{times,personId});
        return ResultUtils.parseResult(result,ProjectWithPlanDTO.class);
    }

    @Override
    public Boolean milepostPlanIsFinished(String contractId,Integer dutyId){
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean b = projectPlanManager.milepostPlanIsFinished(contractId, dutyId);
        long times = timeConsumer.end();
        logger.info("合同编号：{}，责任书id:{},查询里程碑计划是否全部完成耗时:{}",contractId,dutyId,times);
        return b;
    }

    @Override
    public Integer getProjectLogPlanCount(String projectId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = projectPlanManager.getProjectLogPlanCount(projectId);
        long times = timeConsumer.end();
        logger.info("项目id：{}，查询项目日志计划数目耗时:{}",projectId,times);
        return count;
    }

}
