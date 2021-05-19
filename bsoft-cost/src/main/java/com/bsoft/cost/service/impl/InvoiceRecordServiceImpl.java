package com.bsoft.cost.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.InvoiceRecordQueryCnd;
import com.bsoft.cost.dto.InvoiceContentDTO;
import com.bsoft.cost.dto.InvoiceRecordDTO;
import com.bsoft.cost.dto.InvoiceRecordQueryCndDTO;
import com.bsoft.cost.entity.primary.InvoiceContentViewDO;
import com.bsoft.cost.entity.primary.InvoiceRecordViewDO;
import com.bsoft.cost.manager.InvoiceRecordManager;
import com.bsoft.cost.service.InvoiceRecordService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 10:27
 * @Description
 */
@Service
public class InvoiceRecordServiceImpl implements InvoiceRecordService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceRecordServiceImpl.class);

    @Autowired
    private InvoiceRecordManager invoiceRecordManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<InvoiceRecordDTO> getInvoiceRecordList(InvoiceRecordQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        InvoiceRecordQueryCnd cnd = iGenerator.convert(cndDTO, InvoiceRecordQueryCnd.class);
        Page<InvoiceRecordViewDO> pages = invoiceRecordManager.getInvoiceRecordList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("部门:{},输入内容：{},获取开票记录列表耗时:{}",cndDTO.getDeptId(),cndDTO.getInputContent(),times);
        return ResultUtils.parseResult(pages,InvoiceRecordDTO.class);
    }

    @Override
    public List<InvoiceContentDTO> getInvoiceContentList(Integer invoiceRecordId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<InvoiceContentViewDO> list = invoiceRecordManager.getInvoiceContentList(invoiceRecordId);
        long times = timeConsumer.end();
        LOGGER.info("开票记录id:{},获取开票内容列表耗时:{}",invoiceRecordId,times);
        return iGenerator.convert(list,InvoiceContentDTO.class);
    }
}
