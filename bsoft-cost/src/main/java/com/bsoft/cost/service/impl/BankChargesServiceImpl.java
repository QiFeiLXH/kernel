package com.bsoft.cost.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.PublicCostCnd;
import com.bsoft.cost.dto.BankChargesNoBillDTO;
import com.bsoft.cost.dto.DeptPublicCostDTO;
import com.bsoft.cost.dto.PublicCostCndDTO;
import com.bsoft.cost.entity.primary.BankChargesNoBillDO;
import com.bsoft.cost.entity.primary.DeptPublicCostDO;
import com.bsoft.cost.manager.BankChargesManager;
import com.bsoft.cost.service.BankChargesService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @Author zhanglf
 * @Date 2020-04-17 16:18
 * @Version 1.0
 * @Description
 */
@Service
public class BankChargesServiceImpl implements BankChargesService {
    private static final Logger logger = LoggerFactory.getLogger(BankChargesServiceImpl.class);
    @Autowired
    private BankChargesManager bankChargesManager;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<BankChargesNoBillDTO> getBillNotReceived(String userId,String context, Integer pageSize, Integer pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<BankChargesNoBillDO> costRecordNeedDealDOS = bankChargesManager.getBillNotReceived(userId,context, pageSize, pageNo);
        Result<BankChargesNoBillDTO> returnDTO = generatorUtil.convert(costRecordNeedDealDOS, BankChargesNoBillDTO.class);
        long times = timeConsumer.end();
        logger.info("工号:{}获取对公费用待办列表耗时:{}",userId,times);
        return returnDTO;
    }

    @Override
    public Result<DeptPublicCostDTO> getPublicCostList(PublicCostCndDTO publicCostCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PublicCostCnd cnd = generatorUtil.convert(publicCostCndDTO, PublicCostCnd.class);
        Page<DeptPublicCostDO> pages = bankChargesManager.getPublicCostList(cnd);
        Result<DeptPublicCostDTO> result = ResultUtils.parseResult(pages, DeptPublicCostDTO.class);
        long times = timeConsumer.end();
        logger.info("登录人员：{}，查看权限：{}， 发票归还标志:{}，获取对公费用（中标服务费）列表耗时:{}",publicCostCndDTO.getUserId(), publicCostCndDTO.getAllPermission(), publicCostCndDTO.getReturnFlag(),times);
        return result;
    }

    @Override
    public DeptPublicCostDTO getDeptPublicCost(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        DeptPublicCostDO deptPublicCostDO = bankChargesManager.getDeptPublicCostById(id);
        DeptPublicCostDTO deptPublicCostDTO = generatorUtil.convert(deptPublicCostDO,DeptPublicCostDTO.class);
        long times = timeConsumer.end();
        logger.info("获取id为:{}银行费用详情耗时:{}",id,times);
        return deptPublicCostDTO;
    }

    @Override
    public Result<DeptPublicCostDTO> getPersonalPublicCostList(PublicCostCndDTO publicCostCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PublicCostCnd cnd = generatorUtil.convert(publicCostCndDTO, PublicCostCnd.class);
        Page<DeptPublicCostDO> pages = bankChargesManager.getPersonalPublicCostList(cnd);
        Result<DeptPublicCostDTO> result = ResultUtils.parseResult(pages, DeptPublicCostDTO.class);
        long times = timeConsumer.end();
        logger.info("登录人员：{}，发票归还标志:{}，获取对公费用（中标服务费）列表耗时:{}",publicCostCndDTO.getUserId(),publicCostCndDTO.getReturnFlag(),times);
        return result;
    }
}
