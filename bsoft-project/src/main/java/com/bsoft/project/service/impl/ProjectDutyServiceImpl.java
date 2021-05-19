package com.bsoft.project.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.condition.ProjectDutyQueryCnd;
import com.bsoft.project.dto.*;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.manager.ProjectDutyManager;
import com.bsoft.project.service.ProjectDutyService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 9:35
 * @Description
 */
@Service
public class ProjectDutyServiceImpl implements ProjectDutyService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectDutyServiceImpl.class);
    @Autowired
    private ProjectDutyManager projectDutyManager;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ProjectDutyViewDTO> getProjectDutyMaintainList(ProjectDutyQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectDutyQueryCnd params = iGenerator.convert(cnd, ProjectDutyQueryCnd.class);
        Page<ProjectDutyViewDO> pages = projectDutyManager.getProjectDutyMaintainList(params);
        long times = timeConsumer.end();
        logger.info("工号:{},年度:{},审核标志:{},获取项目责任书维护列表耗时:{}",cnd.getUserId(),cnd.getYear(),cnd.getAuditFlag(),times);
        return ResultUtils.parseResult(pages, ProjectDutyViewDTO.class);
    }

    @Override
    public Result<ProjectDutyAuditViewDTO> getProjectDutyAuditList(ProjectDutyQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectDutyQueryCnd params = iGenerator.convert(cnd, ProjectDutyQueryCnd.class);
        Page<ProjectDutyAuditViewDO> pages = projectDutyManager.getProjectDutyAuditList(params);
        long times = timeConsumer.end();
        logger.info("工号:{},获取项目责任书管理列表耗时:{}",cnd.getUserId(),times);
        return ResultUtils.parseResult(pages, ProjectDutyAuditViewDTO.class);
    }

    @Override
    public Integer getProjectDutyAuditCount(String userId) {
        ProjectDutyQueryCnd params = new ProjectDutyQueryCnd();
        params.setUserId(userId);
        params.setAuditFlag(0);
        Integer count = projectDutyManager.getProjectDutyAuditCount(params);
        return count;
    }

    @Override
    public Result<ProjectDutyCustomerAndProjectSelectViewDTO> getProjectDutyCustomerSelectList(Integer pageNo, Integer pageSize, String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDutyCustomerAndProjectSelectViewDO> customers = projectDutyManager.getProjectDutyCustomerSelectList(pageNo, pageSize, userId);
        long times = timeConsumer.end();
        logger.info("工号:{},获取项目责任书-客户选择列表耗时:{}",userId,times);
        return ResultUtils.parseResult(customers, ProjectDutyCustomerAndProjectSelectViewDTO.class);
    }

    @Override
    public List<ProjectDutyRegionViewDTO> getProjectDutyRegionList(Integer dutyId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyRegionViewDO> regions = projectDutyManager.getProjectDutyRegionList(dutyId);
        long times = timeConsumer.end();
        logger.info("责任书id:{},获取项目责任书-项目范围列表耗时:{}",dutyId,times);
        return iGenerator.convert(regions, ProjectDutyRegionViewDTO.class);
    }

    @Override
    public Result<ProjectDutyCustomerAndProjectSelectViewDTO> getProjectDutyProjectSelectList(String userId, String customerId, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDutyCustomerAndProjectSelectViewDO> projects = projectDutyManager.getProjectDutyProjectSelectList(userId, customerId, pageNo, pageSize);
        long times = timeConsumer.end();
        logger.info("工号:{},客户id:{},获取项目责任书-项目选择列表耗时:{}",userId,customerId,times);
        return ResultUtils.parseResult(projects, ProjectDutyCustomerAndProjectSelectViewDTO.class);
    }

    @Override
    public String getProjectDutyNameNo(String customerId, String year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        String dutyName = projectDutyManager.getProjectDutyNameNo(customerId, year);
        long times = timeConsumer.end();
        logger.info("客户id:{},年度:{},获取项目责任书-责任书编号耗时:{}",customerId,year,times);
        return dutyName;
    }

    @Override
    public void deleteProjectDuty(Integer dutyId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        projectDutyManager.deleteProjectDuty(dutyId);
        long times = timeConsumer.end();
        logger.info("责任书id:{},获取项目责任书-删除责任书耗时:{}",dutyId,times);
    }

    @Override
    public List<ProjectDutyMilepostDTO> getProjectDutyMileposts(String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyMilepostDO> milepostList = projectDutyManager.getProjectDutyMilepostList(contractNo);
        long times = timeConsumer.end();
        logger.info("合同编号:{},获取项目里程碑耗时:{}",contractNo,times);
        return iGenerator.convert(milepostList,ProjectDutyMilepostDTO.class);
    }

    @Override
    public List<ProjectDutyMilepostDTO> getDutyMilepostsWithPlan(String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyMilepostDO> milepostList = projectDutyManager.getDutyMilepostWithPlan(contractNo);
        long times = timeConsumer.end();
        logger.info("合同编号:{},获取项目里程碑耗时:{}",contractNo,times);
        return iGenerator.convert(milepostList,ProjectDutyMilepostDTO.class);
    }

    @Override
    public List<ProjectDutyMilepostDTO> getProjectDutyMileposts(String contractNo, Integer dutyId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyMilepostDO> milepostList = projectDutyManager.getProjectDutyMileposts(contractNo, dutyId);
        long times = timeConsumer.end();
        logger.info("合同编号:{},获取项目里程碑耗时:{}",contractNo,times);
        return iGenerator.convert(milepostList,ProjectDutyMilepostDTO.class);
    }

    @Override
    public List<ProjectDutyMilepostDTO> getProjectDutyMileposts(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyMilepostDO> milepostList = projectDutyManager.getProjectDutyMileposts(id);
        long times = timeConsumer.end();
        logger.info("id:{},获取项目里程碑耗时:{}",id,times);
        return iGenerator.convert(milepostList,ProjectDutyMilepostDTO.class);
    }

    @Override
    public Result<ProjectDutyMilepostViewDTO> getProjectDutyMilepostList(String contractNo, Integer dutyId, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDutyMilepostViewDO> milepostList = projectDutyManager.getProjectDutyMilepostList(contractNo, dutyId, pageNo, pageSize);
        long times = timeConsumer.end();
        logger.info("合同编号:{},责任书id: {}, 获取项目里程碑耗时:{}",contractNo,dutyId,times);
        return ResultUtils.parseResult(milepostList,ProjectDutyMilepostViewDTO.class);
    }

    @Override
    public Integer saveProjectDutyAndRegion(ProjectDutyDTO projectDuty, List<ProjectDutyRegionDTO> regions, List<Integer> deleteRegions, String userId, List<String> contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyRegionDO> regionDOs = iGenerator.convert(regions, ProjectDutyRegionDO.class);
        Integer dutyId = null;
        if (projectDuty.getId() == null) {
            ProjectDutyDO dutyDO = iGenerator.convert(projectDuty, ProjectDutyDO.class);
            dutyId = projectDutyManager.saveProjectDutyAndRegion(dutyDO, regionDOs, userId);
        } else {
            ProjectDutyUpdateDO dutyDO = iGenerator.convert(projectDuty, ProjectDutyUpdateDO.class);
            dutyId = projectDutyManager.updateProjectDutyAndRegion(dutyDO, regionDOs, deleteRegions, contractNo);
        }

        long times = timeConsumer.end();
        logger.info("员工id:{},删除范围：{}, 保存范围：{}，保存责任书与项目范围耗时:{}",userId,deleteRegions,regions,times);
        return dutyId;
    }

    @Override
    public void auditProjectDutyList(List<ProjectDutyAuditSaveDTO> auditSaveDTOS,String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyAuditSaveDO> auditSaveDOS = iGenerator.convert(auditSaveDTOS,ProjectDutyAuditSaveDO.class);
        projectDutyManager.auditProjectDutyList(auditSaveDOS,userId);
        long times = timeConsumer.end();
        logger.info("员工id:{},审核责任书耗时:{}",userId,times);
    }

    @Override
    public void saveProjectDutyMilepost(List<ProjectDutyMilepostDTO> projectDutyMilepostDTOS, List<Integer> deletes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyMilepostDO> mileposts = iGenerator.convert(projectDutyMilepostDTOS, ProjectDutyMilepostDO.class);
        projectDutyManager.saveProjectDutyMilepost(mileposts, deletes);
        long times = timeConsumer.end();
        logger.info("删除范围：{}, 保存范围：{}，保存、删除责任书里程碑耗时:{}",deletes,projectDutyMilepostDTOS,times);
    }

    @Override
    public List<ProjectDutyPaymentViewDTO> getProjectDutyPayment(Integer dutyId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyPaymentViewDO> paymentList = projectDutyManager.getProjectDutyPayment(dutyId);
        long times = timeConsumer.end();
        logger.info("责任书id:{},获取计划回款列表耗时:{}",dutyId,times);
        return iGenerator.convert(paymentList,ProjectDutyPaymentViewDTO.class);
    }

    @Override
    public void saveProjectDutyPayment(List<ProjectDutyPaymentDTO> projectDutyPaymentDTOS, List<Integer> deletes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDutyPaymentDO> payments = iGenerator.convert(projectDutyPaymentDTOS, ProjectDutyPaymentDO.class);
        projectDutyManager.saveProjectDutyPayment(payments, deletes);
        long times = timeConsumer.end();
        logger.info("删除范围：{}, 保存范围：{}，保存、删除责任书计划回款耗时:{}",deletes,projectDutyPaymentDTOS,times);
    }

    @Override
    public List<ProjectDutyAuditViewDTO> getAllProjectDutyAuditList(ProjectDutyQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectDutyQueryCnd cnd = iGenerator.convert(cndDTO, ProjectDutyQueryCnd.class);
        List<ProjectDutyAuditViewDO> auditList = projectDutyManager.getAllProjectDutyAuditList(cnd);
        long times = timeConsumer.end();
        logger.info("开始年份：{}, 结束年份：{}，员工： {}, 保存、删除责任书计划回款耗时:{}",cnd.getStartYear(),cnd.getEndYear(),cnd.getUserId(),times);
        return iGenerator.convert(auditList,ProjectDutyAuditViewDTO.class);
    }

    @Override
    public ProjectDutyViewDTO getOneProjectDutyView(Integer dutyId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectDutyViewDO projectDutyViewDO = projectDutyManager.getOneProjectDutyView(dutyId);
        long times = timeConsumer.end();
        logger.info("责任书id: {}, 获取责任书详情耗时:{}",dutyId,times);
        return iGenerator.convert(projectDutyViewDO, ProjectDutyViewDTO.class);
    }

}
