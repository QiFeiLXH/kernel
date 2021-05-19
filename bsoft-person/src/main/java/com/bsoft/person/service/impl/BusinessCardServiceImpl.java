package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.condition.BusinessCardQueryCnd;
import com.bsoft.person.dto.BusinessCardDTO;
import com.bsoft.person.dto.BusinessCardQueryCndDTO;
import com.bsoft.person.entity.primary.BusinessCardViewDO;
import com.bsoft.person.manager.BusinessCardManager;
import com.bsoft.person.service.BusinessCardService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 15:38
 * @Description
 */
@Service
public class BusinessCardServiceImpl implements BusinessCardService {
    private final static Logger LOGGER = LoggerFactory.getLogger(BusinessCardServiceImpl.class);

    @Autowired
    private BusinessCardManager businessCardManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<BusinessCardDTO> getBusinessCardList(BusinessCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BusinessCardQueryCnd cnd = iGenerator.convert(cndDTO, BusinessCardQueryCnd.class);
        Page<BusinessCardViewDO> result = businessCardManager.getBusinessCardList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询条件为：{}的名片列表耗时[{}]", JSONUtils.toString(cnd), times);
        return ResultUtils.parseResult(result, BusinessCardDTO.class);
    }

    @Override
    public Integer getBusinessCardUnpaidCount(BusinessCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BusinessCardQueryCnd cnd = iGenerator.convert(cndDTO, BusinessCardQueryCnd.class);
        Integer count = businessCardManager.getBusinessCardUnpaidCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询条件为：{}的名片未支付数量耗时[{}]", JSONUtils.toString(cnd), times);
        return count;
    }

    @Override
    public Double getBusinessCardUnpaidAmount() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double amount = businessCardManager.getBusinessCardUnpaidAmount();
        long times = timeConsumer.end();
        LOGGER.info("查询名片未支付金额耗时[{}]", times);
        return amount;
    }

    @Override
    public Double getBusinessCardTotalAmount(List<Integer> businessCardIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double amount = businessCardManager.getBusinessCardTotalAmount(businessCardIds);
        long times = timeConsumer.end();
        LOGGER.info("查询文印总金额耗时[{}]", times);
        return amount;
    }

    @Override
    public List<Integer> getBusinessCardIdList(BusinessCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BusinessCardQueryCnd cnd = iGenerator.convert(cndDTO, BusinessCardQueryCnd.class);
        List<Integer> businessCardIds = businessCardManager.getBusinessCardIdList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询名片id列表耗时[{}]，status: {}", times, cnd.getStatus());
        return businessCardIds;
    }

    @Override
    public List<BusinessCardDTO> updateBusinessCardApplyPay(List<Integer> businessCardIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<BusinessCardViewDO> list = businessCardManager.updateBusinessCardApplyPay(businessCardIds);
        long times = timeConsumer.end();
        LOGGER.info("申请支付名片耗时[{}]", times);
        return iGenerator.convert(list, BusinessCardDTO.class);
    }

    @Override
    public void updateBusinessCardPay(List<Integer> businessCardIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        businessCardManager.updateBusinessCardPay(businessCardIds);
        long times = timeConsumer.end();
        LOGGER.info("批量支付名片耗时[{}]", times);
    }

    @Override
    public FileServerDefinitionDTO showImageByte(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        FileServerDefinitionDTO file = new FileServerDefinitionDTO();
        byte[] imageData = businessCardManager.showImageByte(id);
        file.setData(imageData);
        long times = timeConsumer.end();
        LOGGER.info("显示名片二维码图片耗时[{}]", times);
        return file;
    }
}
