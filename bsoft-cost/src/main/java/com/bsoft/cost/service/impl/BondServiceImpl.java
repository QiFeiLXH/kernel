package com.bsoft.cost.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.BondInfoQueryCnd;
import com.bsoft.cost.dto.*;
import com.bsoft.cost.entity.primary.BondInfoDO;
import com.bsoft.cost.entity.primary.DeptPublicCostDO;
import com.bsoft.cost.entity.primary.NeedDealCountDO;
import com.bsoft.cost.entity.primary.BondOverdueInfoDO;
import com.bsoft.cost.manager.BondManager;
import com.bsoft.cost.service.BondService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-20 10:34
 * @Version 1.0
 * @Description
 */
@Service
public class BondServiceImpl implements BondService {
    private static final Logger logger = LoggerFactory.getLogger(BondServiceImpl.class);
    @Autowired
    private BondManager bondManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<BondInfoDTO> getBondNotRushAccount(String userId, Integer performanceSymbol,String context, Integer pageSize, Integer pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<BondInfoDO> bondInfoDOResult = bondManager.getBondNotRushAccount(userId, performanceSymbol,context, pageSize, pageNo);
        Result<BondInfoDTO> bondInfoDTOResult = generatorUtil.convert(bondInfoDOResult,BondInfoDTO.class);
        long times = timeConsumer.end();
        logger.info("工号:{}获取保证金，履约保证金未冲账待办列表耗时:{}",userId,times);
        return bondInfoDTOResult;
    }

    @Override
    public NeedDealCountDTO getNeedDealCount(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        NeedDealCountDO needDealCountDO = bondManager.getNeedDealCount(userId);
        long times = timeConsumer.end();
        logger.info("工号:{}获取所有待办数量耗时:{}",userId,times);
        return generatorUtil.convert(needDealCountDO,NeedDealCountDTO.class);
    }

    @Override
    public Result<BondOverdueInfoDTO> getBondOverdueInfoList(BondInfoQueryCndDTO bondInfoQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BondInfoQueryCnd cnd = generatorUtil.convert(bondInfoQueryCndDTO, BondInfoQueryCnd.class);
        Page<BondOverdueInfoDO> pages = bondManager.getBondOverdueInfoList(cnd);
        Result<BondOverdueInfoDTO> result = ResultUtils.parseResult(pages, BondOverdueInfoDTO.class);
        long times = timeConsumer.end();
        logger.info("登录人员：{}，查看权限：{}， 逾期标志:{}，获取保证金逾期情况列表耗时:{}",bondInfoQueryCndDTO.getUserId(),bondInfoQueryCndDTO.getAllPermission(), bondInfoQueryCndDTO.getOverdueFlag(),times);
        return result;
    }

    @Override
    public List<BondOverdueInfoDTO> getAllBondOverdueInfoList(BondInfoQueryCndDTO bondInfoQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BondInfoQueryCnd cnd = generatorUtil.convert(bondInfoQueryCndDTO, BondInfoQueryCnd.class);
        List<BondOverdueInfoDO> list = bondManager.getAllBondOverdueInfoList(cnd);
        List<BondOverdueInfoDTO> result = generatorUtil.convert(list, BondOverdueInfoDTO.class);
        long times = timeConsumer.end();
        logger.info("登录人员：{}，查看权限：{}， 逾期标志:{}，获取所有保证金逾期情况列表耗时:{}",bondInfoQueryCndDTO.getUserId(),bondInfoQueryCndDTO.getAllPermission(), bondInfoQueryCndDTO.getOverdueFlag(),times);
        return result;
    }

    @Override
    public BondOverdueInfoDTO getBondOverdueInfo(String id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BondOverdueInfoDO bondOverdueInfoDO = bondManager.getBondOverdueInfoById(id);
        BondOverdueInfoDTO bondOverdueInfoDTO = generatorUtil.convert(bondOverdueInfoDO,BondOverdueInfoDTO.class);
        long times = timeConsumer.end();
        logger.info("获取id为:{}保证金详情耗时:{}",id,times);
        return bondOverdueInfoDTO;
    }

    @Override
    public Result<BondOverdueInfoDTO> getPersonalBondList(BondInfoQueryCndDTO bondInfoQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BondInfoQueryCnd cnd = generatorUtil.convert(bondInfoQueryCndDTO, BondInfoQueryCnd.class);
        Page<BondOverdueInfoDO> pages = bondManager.getPersonalBondList(cnd);
        Result<BondOverdueInfoDTO> result = ResultUtils.parseResult(pages, BondOverdueInfoDTO.class);
        long times = timeConsumer.end();
        logger.info("登录人员：{}，逾期标志:{}，获取个人保证金逾期情况列表耗时:{}",bondInfoQueryCndDTO.getUserId(),bondInfoQueryCndDTO.getOverdueFlag(),times);
        return result;
    }

    @Override
    public List<BondOverdueInfoDTO> getPersonalAllBondList(BondInfoQueryCndDTO bondInfoQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BondInfoQueryCnd cnd = generatorUtil.convert(bondInfoQueryCndDTO, BondInfoQueryCnd.class);
        List<BondOverdueInfoDO> list = bondManager.getPersonalAllBondList(cnd);
        List<BondOverdueInfoDTO> result = generatorUtil.convert(list, BondOverdueInfoDTO.class);
        long times = timeConsumer.end();
        logger.info("登录人员：{}，逾期标志:{}，获取个人所有保证金逾期情况列表耗时:{}",bondInfoQueryCndDTO.getUserId(),bondInfoQueryCndDTO.getOverdueFlag(),times);
        return result;
    }
}
