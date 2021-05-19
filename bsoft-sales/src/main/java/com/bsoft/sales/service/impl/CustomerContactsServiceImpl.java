package com.bsoft.sales.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.sales.dto.CustomerContactViewDTO;
import com.bsoft.sales.dto.CustomerContactsDTO;
import com.bsoft.sales.entity.primary.CustomerContactViewDO;
import com.bsoft.sales.entity.primary.CustomerContactsDO;
import com.bsoft.sales.manager.CusotmerContactsManager;
import com.bsoft.sales.service.CustomerContactsService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:39
 * @Description
 */
@Service
public class CustomerContactsServiceImpl implements CustomerContactsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerContactsServiceImpl.class);
    @Autowired
    private CusotmerContactsManager cusotmerContactsManager;

    @Override
    public Result<CustomerContactsDTO> getCustomerContactsList(Integer pageNo, Integer pageSize, String inputContent) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<CustomerContactsDO> pages = cusotmerContactsManager.getCustomerContactsList(pageNo, pageSize,inputContent);
        long times = timeConsumer.end();
        logger.info("查找条件：{},获取客户往来单位列表耗时:{}",inputContent,times);
        return ResultUtils.parseResult(pages, CustomerContactsDTO.class);
    }

    @Override
    public Result<CustomerContactViewDTO> getCustomerContacts(Integer pageNo, Integer pageSize, String inputContent) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<CustomerContactViewDO> pages = cusotmerContactsManager.getCustomerContacts(pageNo, pageSize,inputContent);
        long times = timeConsumer.end();
        logger.info("查找条件：{},获取客户往来单位列表耗时:{}",inputContent,times);
        return ResultUtils.parseResult(pages, CustomerContactViewDTO.class);
    }
}
