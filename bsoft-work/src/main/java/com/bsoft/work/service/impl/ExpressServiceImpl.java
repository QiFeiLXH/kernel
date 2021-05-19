package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.work.condition.ExpressQueryCnd;
import com.bsoft.work.dto.ExpressDetailDTO;
import com.bsoft.work.dto.ExpressQueryCndDTO;
import com.bsoft.work.entity.primary.ExpressDetailDO;
import com.bsoft.work.entity.primary.ExpressDetailViewDO;
import com.bsoft.work.manager.ExpressManager;
import com.bsoft.work.service.ExpressService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:08
 * @Description
 */
@Service
public class ExpressServiceImpl implements ExpressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressServiceImpl.class);

    @Autowired
    private ExpressManager expressManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ExpressDetailDTO> getExpressList(ExpressQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ExpressQueryCnd cnd = iGenerator.convert(cndDTO, ExpressQueryCnd.class);
        Page<ExpressDetailViewDO> result = expressManager.getExpressList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询条件为：{}的快递列表耗时[{}]", JSONUtils.toString(cnd), times);
        return ResultUtils.parseResult(result, ExpressDetailDTO.class);
    }

    @Override
    public Integer getExpressUnpaidCount(ExpressQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ExpressQueryCnd cnd = iGenerator.convert(cndDTO, ExpressQueryCnd.class);
        Integer count = expressManager.getExpressUnpaidCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询条件为：{}的快递未支付数量耗时[{}]", JSONUtils.toString(cnd), times);
        return count;
    }

    @Override
    public Double getExpressUnpaidAmount() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double amount = expressManager.getExpressUnpaidAmount();
        long times = timeConsumer.end();
        LOGGER.info("查询快递未支付金额耗时[{}]", times);
        return amount;
    }

    @Override
    public Double getExpressTotalAmount(List<Integer> expressIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double amount = expressManager.getExpressTotalAmount(expressIds);
        long times = timeConsumer.end();
        LOGGER.info("查询快递总金额耗时[{}]", times);
        return amount;
    }

    @Override
    public List<Integer> getExpressIdList(ExpressQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ExpressQueryCnd cnd = iGenerator.convert(cndDTO, ExpressQueryCnd.class);
        List<Integer> expressIds = expressManager.getExpressIdList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询快递id列表耗时[{}]，status: {}", times, cnd.getStatus());
        return expressIds;
    }

    @Override
    public ImportResultDTO saveExpressDetails(List<ExpressDetailDTO> needSaveDataDTO, List<ExpressDetailDTO> errorDataDTO, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ExpressDetailViewDO> needSaveDataViewDO = iGenerator.convert(needSaveDataDTO, ExpressDetailViewDO.class);
        List<ExpressDetailViewDO> errorDataViewDO = iGenerator.convert(errorDataDTO, ExpressDetailViewDO.class);
        ImportResultDO result = expressManager.saveExpressDetails(needSaveDataViewDO, errorDataViewDO, personId);
        long times = timeConsumer.end();
        LOGGER.info("导入快递核准金额列表耗时[{}]", times);
        return iGenerator.convert(result, ImportResultDTO.class);
    }

    @Override
    public List<ExpressDetailDTO> getErrorExpressList(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ExpressDetailViewDO> list = expressManager.getErrorExpressList(personId);
        long times = timeConsumer.end();
        LOGGER.info("获取导入快递核准金额失败列表耗时[{}]", times);
        return iGenerator.convert(list, ExpressDetailDTO.class);
    }

    @Override
    public List<ExpressDetailDTO> updateExpressApplyPay(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ExpressDetailViewDO> list = expressManager.updateExpressApplyPay(ids);
        long times = timeConsumer.end();
        LOGGER.info("申请支付快递耗时[{}]", times);
        return iGenerator.convert(list, ExpressDetailDTO.class);
    }

    @Override
    public void updateExpressPay(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        expressManager.updateExpressPay(ids);
        long times = timeConsumer.end();
        LOGGER.info("批量支付快递耗时[{}]", times);
    }

    @Override
    public List<ExpressDetailDTO> getExpressList(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ExpressDetailViewDO> list = expressManager.getExpressList(ids);
        long times = timeConsumer.end();
        LOGGER.info("获取快递耗时", times);
        return iGenerator.convert(list, ExpressDetailDTO.class);
    }

    @Override
    public void saveExpressDetail(ExpressDetailDTO expressDetailDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ExpressDetailDO detailDO = iGenerator.convert(expressDetailDTO, ExpressDetailDO.class);
        expressManager.saveExpressDetail(detailDO);
        long times = timeConsumer.end();
        LOGGER.info("修改快递id:{}的核准金额并同步分摊表金额耗时", expressDetailDTO.getId(),times);
    }
}
