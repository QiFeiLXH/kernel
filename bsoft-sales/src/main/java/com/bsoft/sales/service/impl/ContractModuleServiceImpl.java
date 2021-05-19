package com.bsoft.sales.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.sales.condition.ContractModuleQueryCnd;
import com.bsoft.sales.condition.SalesContractAuditCnd;
import com.bsoft.sales.condition.SalesContractCheckQueryCnd;
import com.bsoft.sales.condition.SalesContractQueryCnd;
import com.bsoft.sales.dto.*;
import com.bsoft.sales.entity.primary.*;
import com.bsoft.sales.manager.ContractModuleManager;
import com.bsoft.sales.service.ContractModuleService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:56
 * @Description
 */
@Service
public class ContractModuleServiceImpl implements ContractModuleService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ContractModuleServiceImpl.class);

    @Autowired
    private ContractModuleManager contractModuleManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ContractProducDTO> getContractProductList(ContractModuleQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ContractModuleQueryCnd cnd = iGenerator.convert(cndDTO, ContractModuleQueryCnd.class);
        if (StringUtils.isBlank(cnd.getContractNo())) {
            throw new ServiceException("合同号不能为空");
        }
        Page<ContractProducViewDO> pages = contractModuleManager.getContractProductList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取合同产品列表耗时:{}",times);
        return ResultUtils.parseResult(pages, ContractProducDTO.class);
    }

    @Override
    public List<ContractModuleDTO> getContractModuleList(ContractModuleQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ContractModuleQueryCnd cnd = iGenerator.convert(cndDTO, ContractModuleQueryCnd.class);
        if (StringUtils.isBlank(cnd.getContractNo())) {
            throw new ServiceException("合同号不能为空");
        }
        List<ContractModuleViewDO> list = contractModuleManager.getContractModuleList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取合同模块列表耗时:{}",times);
        return iGenerator.convert(list, ContractModuleDTO.class);
    }

    @Override
    public void saveContractProductModuleRelation(List<ContractModuleProductDTO> saves, List<ContractModuleProductDTO> deletes, String contractId, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractModuleProductDO> saveList = iGenerator.convert(saves, ContractModuleProductDO.class);
        List<ContractModuleProductDO> deleteList = iGenerator.convert(deletes, ContractModuleProductDO.class);
        contractModuleManager.saveContractProductModuleRelation(saveList, deleteList, contractId, personId);
        long times = timeConsumer.end();
        LOGGER.info("保存合同模块产品列表耗时:{}",times);
    }

    @Override
    public Integer commitContractProductModuleRelation(List<ContractModuleProductDTO> saves, List<ContractModuleProductDTO> deletes, String contractId, String personId,Integer completeFlag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractModuleProductDO> saveList = iGenerator.convert(saves, ContractModuleProductDO.class);
        List<ContractModuleProductDO> deleteList = iGenerator.convert(deletes, ContractModuleProductDO.class);
        Integer result = contractModuleManager.commitContractProductModuleRelation(saveList, deleteList, contractId, personId, completeFlag);
        long times = timeConsumer.end();
        LOGGER.info("提交合同模块产品列表耗时:{}",times);
        return result;
    }

    @Override
    public Result<SalesContractDTO> getContractList(SalesContractQueryCndDTO salesContractQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesContractQueryCnd cnd = iGenerator.convert(salesContractQueryCndDTO, SalesContractQueryCnd.class);
        Page<SalesContractViewDO> pages = contractModuleManager.getContractList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取销售合同列表耗时:{}",times);
        return ResultUtils.parseResult(pages, SalesContractDTO.class);
    }

    @Override
    public List<Integer> getSalesContractModuleCount(SalesContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesContractQueryCnd cnd = iGenerator.convert(cndDTO, SalesContractQueryCnd.class);
        List<Integer> count = contractModuleManager.getSalesContractModuleCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取销售合同模块数量耗时:{}",times);
        return count;
    }

    @Override
    public List<SalesContractModuleDTO> getSalesContractModuleList(SalesContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesContractQueryCnd cnd = iGenerator.convert(cndDTO, SalesContractQueryCnd.class);
        List<SalesContractModuleViewDO> list = contractModuleManager.getSalesContractModuleList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取销售合同模块数量耗时:{}",times);
        return iGenerator.convert(list, SalesContractModuleDTO.class);
    }

    @Override
    public List<SalesContractAreaDTO> getSalesContractAreaList(SalesContractAuditCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesContractAuditCnd cnd = iGenerator.convert(cndDTO, SalesContractAuditCnd.class);
        List<SalesContractAreaViewDO> list = contractModuleManager.getSalesContractAreaList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取销售合同销售区域列表耗时:{}",times);
        return iGenerator.convert(list, SalesContractAreaDTO.class);
    }

    @Override
    public Result<SalesContractDTO> getSalesContractAuditList(SalesContractAuditCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesContractAuditCnd cnd = iGenerator.convert(cndDTO, SalesContractAuditCnd.class);
        Page<SalesContractViewDO> pages = contractModuleManager.getSalesContractAuditList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取销售合同审核列表耗时:{}",times);
        return ResultUtils.parseResult(pages, SalesContractDTO.class);
    }

    @Override
    public void auditSalesContract(String contractId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        contractModuleManager.auditSalesContract(contractId);
        long times = timeConsumer.end();
        LOGGER.info("审核合同审耗时:{}",times);
    }

    @Override
    public void returnSalesContract(String contractId, String backReason) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        contractModuleManager.returnSalesContract(contractId, backReason);
        long times = timeConsumer.end();
        LOGGER.info("退回合同耗时:{}",times);
    }

    @Override
    public Result<SalesContractCheckDTO> getSalesCheckContractList(SalesContractCheckQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesContractCheckQueryCnd cnd = iGenerator.convert(cndDTO, SalesContractCheckQueryCnd.class);
        PageInfo<SalesContractCheckViewDO> page = contractModuleManager.getSalesCheckContractList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("核对合同列表耗时:{}",times);
        return ResultUtils.parseResult(page, SalesContractCheckDTO.class);
    }

    @Override
    public Result<SalesContractModuleCheckDTO> getSalesCheckContractModuleList(Integer pageNo, Integer pageSize, String contractId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<SalesContractModuleCheckViewDO> page = contractModuleManager.getSalesCheckContractModuleList(pageNo, pageSize, contractId);
        long times = timeConsumer.end();
        LOGGER.info("核对合同模块耗时:{}，合同编号：{}",times,contractId);
        return ResultUtils.parseResult(page, SalesContractModuleCheckDTO.class);
    }

    @Override
    public void checkSalesContract(String contractId, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        contractModuleManager.checkSalesContract(contractId,personId);
        long times = timeConsumer.end();
        LOGGER.info("核对合同耗时:{}, 合同编号：{}, 核对人：{}",times,contractId, personId);
    }

    @Override
    public Integer getUncheckedCount(String personId, Boolean allPermission) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = contractModuleManager.getUncheckedCount(personId, allPermission);
        long times = timeConsumer.end();
        LOGGER.info("未核对合同数量耗时:{},工号：{}，全部权限：{}",times, personId, allPermission);
        return count;
    }

}
