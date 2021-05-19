package com.bsoft.sales.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.sales.condition.SalesCommisQueryCnd;
import com.bsoft.sales.dto.SalesCommisImportDTO;
import com.bsoft.sales.dto.SalesCommisQueryCndDTO;
import com.bsoft.sales.dto.SalesCommisViewDTO;
import com.bsoft.sales.entity.primary.SalesCommisImportDO;
import com.bsoft.sales.entity.primary.SalesCommisViewDO;
import com.bsoft.sales.manager.SalesCommisManager;
import com.bsoft.sales.service.SalesCommisService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 13:49
 * @Description:
 */
@Service
public class SalesCommisServiceImpl implements SalesCommisService {
    private static Logger logger = LoggerFactory.getLogger(SalesCommisServiceImpl.class);
    @Autowired
    private SalesCommisManager salesCommisManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<SalesCommisViewDTO> getSalesCommis(SalesCommisQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesCommisQueryCnd cnd = generatorUtil.convert(cndDTO, SalesCommisQueryCnd.class);
        PageInfo<SalesCommisViewDO> pages = salesCommisManager.getSalesCommis(cnd);
        Result<SalesCommisViewDTO> result = ResultUtils.parseResult(pages,SalesCommisViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取销售提成列表信息耗时:[{}]",times);
        return result;
    }

    @Override
    public void deleteSalesCommis(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesCommisManager.deleteSalesCommis(ids);
        long times = timeConsumer.end();
        logger.info("删除销售提成列表信息耗时:[{}]",times);
    }

    @Override
    public void aduitSalesCommis(List<Integer> ids, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesCommisManager.aduitSalesCommis(ids,personId);
        long times = timeConsumer.end();
        logger.info("审核销售提成列表信息耗时:[{}]",times);
    }

    @Override
    public ImportResultDTO importSalesCommis(List<SalesCommisImportDTO> list, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesCommisImportDO> salesCommisImportDOS = generatorUtil.convert(list,SalesCommisImportDO.class);
        ImportResultDO importResultDO = salesCommisManager.importSalesCommis(salesCommisImportDOS,personId);
        long times = timeConsumer.end();
        logger.info("导入销售提成列表信息耗时:[{}]",times);
        return generatorUtil.convert(importResultDO,ImportResultDTO.class);
    }

    @Override
    public List<SalesCommisImportDTO> getImportError(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesCommisImportDO> list = salesCommisManager.getImportError(personId);
        long times = timeConsumer.end();
        logger.info("获取销售提成导入失败数据耗时:[{}]",times);
        return generatorUtil.convert(list,SalesCommisImportDTO.class);
    }
}
