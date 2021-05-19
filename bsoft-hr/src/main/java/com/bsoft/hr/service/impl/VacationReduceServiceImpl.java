package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.manager.PrimaryKeyManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.VacationReduceQueryCnd;
import com.bsoft.hr.dto.VacationReduceDTO;
import com.bsoft.hr.dto.VacationReduceQueryCndDTO;
import com.bsoft.hr.entity.primary.LeaveDO;
import com.bsoft.hr.entity.primary.VacationReduceDO;
import com.bsoft.hr.manager.AnnualVacationManager;
import com.bsoft.hr.manager.VacationReduceManager;
import com.bsoft.hr.service.VacationReduceService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class VacationReduceServiceImpl implements VacationReduceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VacationReduceServiceImpl.class);
    @Autowired
    private VacationReduceManager vacationReduceManager;
    @Autowired
    private PrimaryKeyManager primaryKeyManager;
    @Autowired
    private AnnualVacationManager annualVacationManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Override
    public Result<VacationReduceDTO> getVacationReduceList(String personId,VacationReduceQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        VacationReduceQueryCnd queryCnd = GeneratorUtil.instance().convert(cnd,VacationReduceQueryCnd.class);
        Page<VacationReduceDO> page = vacationReduceManager.getVacationReduceList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号:{}获取历年年假统一扣除情况列表成功，耗时:{}",new Object[]{personId,times});
        return ResultUtils.parseResult(page,VacationReduceDTO.class);
    }

    @Override
    public void save(String personId,VacationReduceDTO vacationReduce) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        VacationReduceDO vacationReduceDO =  GeneratorUtil.instance().convert(vacationReduce,VacationReduceDO.class);
        vacationReduce.setRegistrant(personId);
        vacationReduce.setRegistDate(serverDateManager.getServerDate());
        vacationReduceManager.save(vacationReduceDO);
        long times = timeConsumer.end();
        LOGGER.info("工号:{}保存年假统一扣除情况成功，耗时:{}",new Object[]{personId,times});
    }

    @Override
    public void delete(String personId, VacationReduceDTO vacationReduce) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        VacationReduceDO vacationReduceDO =  GeneratorUtil.instance().convert(vacationReduce,VacationReduceDO.class);
        vacationReduceManager.delete(vacationReduceDO);
        long times = timeConsumer.end();
        LOGGER.info("工号:{}删除年假统一扣除情况成功，耗时:{}",new Object[]{personId,times});
    }

    @Override
    public void reduceAnnualVacationUnified(String personId, String year, Integer days, Integer reduceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<LeaveDO> leaves = annualVacationManager.getReduceAnnualLeaves(year, days);
        Integer leaveKey = primaryKeyManager.increaseWithSize("HR_LEAVE",leaves.size());
        annualVacationManager.reduceAnnualVacationUnified(leaves,leaveKey,reduceId);
        long times = timeConsumer.end();
        LOGGER.info("春节统一扣除年假，耗时:{},操作人员:{}", new Object[]{times,personId});

    }
}
