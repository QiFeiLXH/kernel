package com.bsoft.user.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.user.condition.AppBindCountQueryCnd;
import com.bsoft.user.condition.AppDeptCountQueryCnd;
import com.bsoft.user.dto.*;
import com.bsoft.user.entity.primary.*;
import com.bsoft.user.manager.AppUserCountManager;
import com.bsoft.user.service.AppUserCountService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户部门分布情况
 */
@Service
public class AppUserCountServiceImpl implements AppUserCountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserCountServiceImpl.class);

    @Autowired
    private AppUserCountManager appUserCountManager;

    @Override
    public Result<AppDeptCountDTO> getDeptCountList(String userId, AppDeptCountQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AppDeptCountQueryCnd queryCnd = GeneratorUtil.instance().convert(queryCndDTO, AppDeptCountQueryCnd.class);
        Result<AppDeptCountViewDO> resultDO = appUserCountManager.getDeptCountList(queryCnd);
        Result<AppDeptCountDTO> resultDTO = GeneratorUtil.instance().convert(resultDO, AppDeptCountDTO.class);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取APP用户部门分布情况耗时[{}]", userId, times);
        return resultDTO;
    }

    @Override
    public List<AppProvinceCountDTO> getProvinceCountList(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AppProvinceCountDO> resultDO = appUserCountManager.getProvinceCountList();
        List<AppProvinceCountDTO> resultDTO = GeneratorUtil.instance().convert(resultDO, AppProvinceCountDTO.class);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取APP用户省份分布情况耗时[{}]", userId, times);
        return resultDTO;
    }

    @Override
    public List<AppTerminalCountDTO> getTerminalCountList(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AppTerminalCountViewDO> resultDO = appUserCountManager.getTerminalCountList();
        List<AppTerminalCountDTO> resultDTO = GeneratorUtil.instance().convert(resultDO, AppTerminalCountDTO.class);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取APP用户终端分布情况耗时[{}]", userId, times);
        return resultDTO;
    }

    @Override
    public List<AppBindCountDTO> getBindCountList(String userId, AppBindCountQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AppBindCountQueryCnd queryCnd = GeneratorUtil.instance().convert(queryCndDTO, AppBindCountQueryCnd.class);
        List<AppBindCountDO> resultDO = appUserCountManager.getBindCountList(queryCnd);
        List<AppBindCountDTO> resultDTO = GeneratorUtil.instance().convert(resultDO, AppBindCountDTO.class);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取APP用户绑定情况（不分页）耗时[{}]", userId, times);
        return resultDTO;
    }

    @Override
    public Result<AppBindCountDTO> getBindCountListWithPage(String userId, AppBindCountQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AppBindCountQueryCnd queryCnd = GeneratorUtil.instance().convert(queryCndDTO, AppBindCountQueryCnd.class);
        Result<AppBindCountDO> resultDO = appUserCountManager.getBindCountListWithPage(queryCnd);
        Result<AppBindCountDTO> resultDTO = GeneratorUtil.instance().convert(resultDO, AppBindCountDTO.class);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取APP用户绑定情况（分页）耗时[{}]", userId, times);
        return resultDTO;
    }

    @Override
    public Integer getBindTotalCount(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer result = appUserCountManager.getBindTotalCount();
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取APP用户绑定总人数耗时[{}]", userId, times);
        return result;
    }

    @Override
    public AppBoundProportionDTO getBoundProportion(String userId,AppDeptCountQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AppDeptCountQueryCnd queryCnd = GeneratorUtil.instance().convert(queryCndDTO, AppDeptCountQueryCnd.class);
        AppBoundProportionDO result = appUserCountManager.getBoundProportion(queryCnd);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取公司总人数，APP用户绑定总人数耗时[{}]", userId, times);
        return GeneratorUtil.instance().convert(result,AppBoundProportionDTO.class);
    }


}
