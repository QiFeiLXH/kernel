package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.hr.condition.LaborContractQueryCnd;
import com.bsoft.hr.dto.*;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.LaborContractRenewalManager;
import com.bsoft.hr.service.LaborContractRenewalService;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dto.TaskAuditDTO;
import com.bsoft.workflow.dto.TaskQueryCndDTO;
import com.bsoft.workflow.entity.primary.TaskAuditDO;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-09 13:18
 * @Version 1.0
 */
@Service
public class LaborContractRenewalServiceImpl implements LaborContractRenewalService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LaborContractRenewalServiceImpl.class);
    @Autowired
    private LaborContractRenewalManager laborContractRenewalManager;
    @Override
    public Result<LaborContractApplyViewDTO> getLaborContractAuditList(String personId,TaskQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd queryCnd = GeneratorUtil.instance().convert(cnd,TaskQueryCnd.class);
        Result<LaborContractApplyViewDO> result;
        if(queryCnd.getFinished() != null && queryCnd.getFinished()){
            queryCnd.setFlag(1);
            result = laborContractRenewalManager.getLaborContractHistoricTaskList(queryCnd);
        }else{
            queryCnd.setFlag(0);
            result = laborContractRenewalManager.getLaborContractTaskList(queryCnd);
        }
        long times = timeConsumer.end();
        LOGGER.info("工号：{},获取获取劳动续签合同待审核列表耗时:{}", personId,times);
        return GeneratorUtil.instance().convert(result,LaborContractApplyViewDTO.class);
    }

    @Override
    public Result<LaborContractApplyViewDTO> getLaborContractTaskList(String personId,Integer flag, TaskQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd queryCnd = GeneratorUtil.instance().convert(cnd,TaskQueryCnd.class);
        Result<LaborContractApplyViewDO> result = laborContractRenewalManager.getLaborContractTaskList(flag,queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},APP端获取劳动续签合同待审核列表耗时:{}", personId,times);
        return GeneratorUtil.instance().convert(result,LaborContractApplyViewDTO.class);
    }

    @Override
    public void deptAudit(String personId, LaborContractApplyDTO dto, TaskAuditDTO taskAuditDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LaborContractApplyDO laborContractApplyDO = GeneratorUtil.instance().convert(dto,LaborContractApplyDO.class);
        TaskAuditDO taskAuditDO = GeneratorUtil.instance().convert(taskAuditDTO,TaskAuditDO.class);
        laborContractRenewalManager.deptAudit(personId,laborContractApplyDO,taskAuditDO);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},部门负责人审核耗时:{}", personId,times);

    }

    @Override
    public void areaAudit(String personId, LaborContractApplyDTO dto, TaskAuditDTO taskAuditDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LaborContractApplyDO laborContractApplyDO = GeneratorUtil.instance().convert(dto,LaborContractApplyDO.class);
        TaskAuditDO taskAuditDO = GeneratorUtil.instance().convert(taskAuditDTO,TaskAuditDO.class);
        laborContractRenewalManager.areaAudit(personId,laborContractApplyDO,taskAuditDO);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},行政总监审核耗时:{}", personId,times);
    }

    @Override
    public void hrAudit(Integer flag, String personId, LaborContractApplyDTO dto, TaskAuditDTO taskAuditDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LaborContractApplyDO laborContractApplyDO = GeneratorUtil.instance().convert(dto,LaborContractApplyDO.class);
        TaskAuditDO taskAuditDO = GeneratorUtil.instance().convert(taskAuditDTO,TaskAuditDO.class);
        laborContractRenewalManager.hrAudit(flag,personId,laborContractApplyDO,taskAuditDO);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},人事专员审核耗时:{}", personId,times);
    }

    @Override
    public Result<LaborContractViewDTO> getLaborContractInfoList(String personId, LaborContractQueryCndDTO queryCndDTO) {
        LaborContractQueryCnd queryCnd = GeneratorUtil.instance().convert(queryCndDTO, LaborContractQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<LaborContractViewDO> result = laborContractRenewalManager.getLaborContractInfoList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},获取劳动合同信息耗时:{}", personId, times);
        return GeneratorUtil.instance().convert(result, LaborContractViewDTO.class);
    }

    @Override
    public LaborContractApplyViewDTO getLaborContractApply(String personId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LaborContractApplyViewDO applyViewDO = laborContractRenewalManager.getLaborContractApply(id);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},获取劳动合同续签详情耗时:{}", personId,times);
        return GeneratorUtil.instance().convert(applyViewDO,LaborContractApplyViewDTO.class);
    }

    @Override
    public List<LaborContractQuitViewDTO> getLaborContractQuitList(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<LaborContractQuitViewDO>  quitList = laborContractRenewalManager.getLaborContractQuitList(personId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},获取员工离职单耗时:{}", personId,times);
        return GeneratorUtil.instance().convert(quitList,LaborContractQuitViewDTO.class);
    }

    @Override
    public LaborContractQuitViewDTO getLaborContractApplyQuit(String personId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LaborContractQuitViewDO  quit = laborContractRenewalManager.getLaborContractApplyQuit(id);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},获取对应离职单耗时:{}", personId,times);
        return GeneratorUtil.instance().convert(quit,LaborContractQuitViewDTO.class);
    }

    @Override
    public List<LaborContractApplyViewDTO> getPersonalLaborContractApplyViewList(String userId, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<LaborContractApplyViewDO> list = laborContractRenewalManager.getPersonalApplyList(personId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},获取员工个人劳动合同申请列表耗时:{}", userId ,times);
        return GeneratorUtil.instance().convert(list, LaborContractApplyViewDTO.class);
    }

    @Override
    public List<LaborContractDetailViewDTO> getLaborContractDetail(String userId, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<LaborContractDetailViewDO> list = laborContractRenewalManager.getLaborContractDetail(personId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},获取员工个人劳动合同详情耗时:{}", userId ,times);
        return GeneratorUtil.instance().convert(list, LaborContractDetailViewDTO.class);
    }

    @Override
    public void setStatusToStop(String userId, String processInstanceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        laborContractRenewalManager.setStatusToStop(processInstanceId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，更改申请流程状态为终止，耗时：{}", userId ,times);
    }

}
