package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.LeaveQueryCnd;
import com.bsoft.hr.dto.*;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.LeaveManager;
import com.bsoft.hr.service.LeaveService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/17 14:54
 * @Description
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    private final static Logger LOGGER = LoggerFactory.getLogger(LeaveServiceImpl.class);

    @Autowired
    private LeaveManager leaveManager;
    @Autowired
    private IGenerator generator;


    @Override
    public Result<WorkLeaveVacationDTO> getWorkLeaveVacationList(LeaveQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LeaveQueryCnd cnd = generator.convert(cndDTO, LeaveQueryCnd.class);
        PageInfo<WorkLeaveVacationDO> pageInfo = leaveManager.getWorkLeaveVacationList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取假期记录列表耗时:{}", times);
        return ResultUtils.parseResult(pageInfo, WorkLeaveVacationDTO.class);
    }

    @Override
    public Result<LeaveInfoDTO> getLeaveList(Integer pageNo, Integer pageSize, String personId, Integer type, String year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<LeaveInfoDO> pages = leaveManager.getLeaveList(pageNo, pageSize, personId, type, year);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},type:{},获取调、年休明细情况列表耗时:{}", personId, type,times);
        return ResultUtils.parseResult(pages, LeaveInfoDTO.class);
    }

    @Override
    public Result<WorkVacationTotalDTO> getWorkVacationTotalList(Integer pageNo, Integer pageSize, String personId, Integer type, String year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<WorkVacationTotalDO> pageInfos = leaveManager.getWorkVacationTotalList(pageNo, pageSize, personId, type, year);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},type:{},year:{},获取调、年休总天数情况列表耗时:{}", personId, type,year,times);
        return ResultUtils.parseResult(pageInfos, WorkVacationTotalDTO.class);
    }

    @Override
    public Result<PersonalWorkLeaveVacationDTO> getPersonalVacationList(Integer pageNo, Integer pageSize, String personId, String year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<PersonalWorkLeaveVacationDO> pageInfos = leaveManager.getPersonalVacationList(pageNo, pageSize, personId, year);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},year:{},获取个人调、年休情况列表耗时:{}", personId, year,times);
        return ResultUtils.parseResult(pageInfos, PersonalWorkLeaveVacationDTO.class);
    }

    @Override
    public Result<WorkVacationTotalDTO> getPersonalTotalVacationList(Integer pageNo, Integer pageSize, String personId, String year, Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<WorkVacationTotalDO> pageInfos = leaveManager.getPersonalTotalVacationList(pageNo,pageSize,personId,year,type);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},year:{},type:{},,获取个人调、年休总天数情况列表耗时:{}", personId, year,type,times);
        return ResultUtils.parseResult(pageInfos, WorkVacationTotalDTO.class);
    }

    @Override
    public Result<LeaveInfoDTO> getPersonalVacationUsedList(Integer pageNo, Integer pageSize, String personId, String year,Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<LeaveInfoDO> pages = leaveManager.getPersonalVacationUsedList(pageNo, pageSize,personId, year,type);
        long times = timeConsumer.end();
        LOGGER.info("工号：{},year:{},type:{},获取个人调、年休总天数情况列表耗时:{}", personId, year,type,times);
        return ResultUtils.parseResult(pages, LeaveInfoDTO.class);
    }
}
