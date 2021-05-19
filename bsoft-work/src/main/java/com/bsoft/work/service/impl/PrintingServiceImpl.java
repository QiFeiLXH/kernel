package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.work.condition.PrintingQueryCnd;
import com.bsoft.work.dto.PrintingDTO;
import com.bsoft.work.dto.PrintingDetailDTO;
import com.bsoft.work.dto.PrintingQueryCndDTO;
import com.bsoft.work.entity.primary.PrintingDO;
import com.bsoft.work.entity.primary.PrintingDetailDO;
import com.bsoft.work.entity.primary.PrintingViewDO;
import com.bsoft.work.manager.PrintingManager;
import com.bsoft.work.service.PrintingService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:07
 * @Description
 */
@Service
public class PrintingServiceImpl implements PrintingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintingServiceImpl.class);
    @Autowired
    private PrintingManager printingManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PrintingDTO> getPrintingList(PrintingQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PrintingQueryCnd cnd = iGenerator.convert(cndDTO, PrintingQueryCnd.class);
        Page<PrintingViewDO> result = printingManager.getPrintingList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询条件为：{}的文印列表耗时[{}]", JSONUtils.toString(cnd), times);
        return ResultUtils.parseResult(result, PrintingDTO.class);
    }

    @Override
    public Integer getPrintingUnpaidCount(PrintingQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PrintingQueryCnd cnd = iGenerator.convert(cndDTO, PrintingQueryCnd.class);
        Integer count = printingManager.getPrintingUnpaidCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询条件为：{}的文印未支付数量耗时[{}]", JSONUtils.toString(cnd), times);
        return count;
    }

    @Override
    public Double getPrintingUnpaidAmount() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double amount = printingManager.getPrintingUnpaidAmount();
        long times = timeConsumer.end();
        LOGGER.info("查询快递未支付金额耗时[{}]", times);
        return amount;
    }

    @Override
    public Double getPrintingTotalAmount(List<Integer> printingIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double amount = printingManager.getPrintingTotalAmount(printingIds);
        long times = timeConsumer.end();
        LOGGER.info("查询文印总金额耗时[{}]", times);
        return amount;
    }

    @Override
    public List<Integer> getPrintingIdList(PrintingQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PrintingQueryCnd cnd = iGenerator.convert(cndDTO, PrintingQueryCnd.class);
        List<Integer> printingIds = printingManager.getPrintingIdList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询文印id列表耗时[{}]，status: {}", times, cnd.getStatus());
        return printingIds;
    }

    @Override
    public ImportResultDTO savePrintings(List<PrintingDTO> needSaveDataDTO, List<PrintingDTO> errorDataDTO, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PrintingViewDO> needSaveDataViewDO = iGenerator.convert(needSaveDataDTO, PrintingViewDO.class);
        List<PrintingViewDO> errorDataViewDO = iGenerator.convert(errorDataDTO, PrintingViewDO.class);
        ImportResultDO result = printingManager.savePrintings(needSaveDataViewDO, errorDataViewDO, personId);
        long times = timeConsumer.end();
        LOGGER.info("导入文印核准金额列表耗时[{}]", times);
        return iGenerator.convert(result, ImportResultDTO.class);
    }

    @Override
    public List<PrintingDTO> getErrorPrintingList(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PrintingViewDO> list = printingManager.getErrorPrintingList(personId);
        long times = timeConsumer.end();
        LOGGER.info("获取导入文印核准金额失败列表耗时[{}]", times);
        return iGenerator.convert(list, PrintingDTO.class);
    }

    @Override
    public List<PrintingDTO> updatePrintingApplyPay(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PrintingViewDO> list = printingManager.updatePrintingApplyPay(ids);
        long times = timeConsumer.end();
        LOGGER.info("申请支付文印耗时[{}]", times);
        return iGenerator.convert(list, PrintingDTO.class);
    }

    @Override
    public void updatePrintingPay(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        printingManager.updatePrintingPay(ids);
        long times = timeConsumer.end();
        LOGGER.info("批量支付文印耗时[{}]", times);
    }

    @Override
    public List<PrintingDetailDTO> getPrintingDetailList(Integer printingId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PrintingDetailDO> list = printingManager.getPrintingDetailList(printingId);
        long times = timeConsumer.end();
        LOGGER.info("获取文印明细耗时", times);
        return iGenerator.convert(list, PrintingDetailDTO.class);
    }

    @Override
    public void savePrinting(PrintingDTO printingDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PrintingDO printingDO = iGenerator.convert(printingDTO, PrintingDO.class);
        printingManager.savePrinting(printingDO);
        long times = timeConsumer.end();
        LOGGER.info("修改文印id:{}的核准金额并同步分摊表金额耗时", printingDTO.getId(),times);
    }
}
