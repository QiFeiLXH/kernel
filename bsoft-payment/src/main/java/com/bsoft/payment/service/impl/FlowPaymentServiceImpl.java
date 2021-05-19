package com.bsoft.payment.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.payment.condition.FlowPaymentQueryCnd;
import com.bsoft.payment.dto.FlowPaymentDTO;
import com.bsoft.payment.dto.FlowPaymentQueryCndDTO;
import com.bsoft.payment.entity.primary.FlowPaymentDO;
import com.bsoft.payment.entity.primary.FlowPaymentViewDO;
import com.bsoft.payment.manager.FlowPaymentManager;
import com.bsoft.payment.service.FlowPaymentService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.service.impl
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:27
 * @Description:
 */
@Service
public class FlowPaymentServiceImpl implements FlowPaymentService {
    private final static Logger logger = LoggerFactory.getLogger(FlowPaymentServiceImpl.class);
    @Autowired
    private FlowPaymentManager flowPaymentManager;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<FlowPaymentDTO> getFinancialPaymentList(FlowPaymentQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        FlowPaymentQueryCnd cnd = iGenerator.convert(cndDTO, FlowPaymentQueryCnd.class);
        Page<FlowPaymentViewDO> pages = flowPaymentManager.getFinancialPaymentList(cnd);
        long times = timeConsumer.end();
        logger.info("数据类型：{}，所属区域:{},类别：{}，业务条线：{}， 审核标记：{}，获取运营流水、收益列表耗时:{}",cndDTO.getFlag(),cndDTO.getParentDeptId(),cndDTO.getType(),cndDTO.getBusinessLine(),cndDTO.getAuditFlag(),times);
        return ResultUtils.parseResult(pages, FlowPaymentDTO.class);
    }

    @Override
    public void deleteFinancialPayments(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        flowPaymentManager.deleteFinancialPayments(ids);
        long times = timeConsumer.end();
        logger.info("删除运营流水、收益耗时:{}",times);
    }


    @Override
    public void auditFinancialPayments(List<FlowPaymentDTO> flowPaymentDTOS, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<FlowPaymentDO> flowPaymentDOS = iGenerator.convert(flowPaymentDTOS, FlowPaymentDO.class);
        flowPaymentManager.auditFinancialPayments(flowPaymentDOS, personId);
        long times = timeConsumer.end();
        logger.info("审核运营流水、收益列表耗时:{}",times);
    }

    @Override
    public ImportResultDTO saveFinancialPayments(List<FlowPaymentDTO> needSaveDTOS, List<FlowPaymentDTO> errorDTOS, String personId, Integer flag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<FlowPaymentViewDO> savesData = iGenerator.convert(needSaveDTOS, FlowPaymentViewDO.class);
        List<FlowPaymentViewDO> errorData = iGenerator.convert(errorDTOS, FlowPaymentViewDO.class);
        ImportResultDO result = flowPaymentManager.saveFinancialPayments(savesData, errorData,personId,flag);
        long times = timeConsumer.end();
        logger.info("工号：{}， 保存运营流水、收益列表耗时:{}",personId,times);
        return iGenerator.convert(result, ImportResultDTO.class);
    }

    @Override
    public List<FlowPaymentDTO> getErrorFinancialPayments(String personId, Integer flag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<FlowPaymentViewDO> list = flowPaymentManager.getErrorFinancialPayments(personId, flag);
        long times = timeConsumer.end();
        logger.info("工号:{}，数据类型：{}，获取导入运营流水、收益错误列表耗时:{}", personId,flag,times);
        return iGenerator.convert(list, FlowPaymentDTO.class);
    }
}
