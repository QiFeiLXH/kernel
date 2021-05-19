package com.bsoft.customer.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.customer.condition.CustomerQueryCnd;
import com.bsoft.customer.dto.CustomerDTO;
import com.bsoft.customer.dto.CustomerQueryCndDTO;
import com.bsoft.customer.entity.primary.CustomerDO;
import com.bsoft.customer.manager.CustomerManager;
import com.bsoft.customer.service.CustomerService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/12/7
 * @description 客户基本信息
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private final static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerManager customerManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<CustomerDTO> getCustomerList(CustomerQueryCndDTO queryCndDTO) {
        CustomerQueryCnd queryCnd = iGenerator.convert(queryCndDTO, CustomerQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<CustomerDO> result = customerManager.getCustomerList(queryCnd);
        long time = timeConsumer.end();
        logger.info("多条件查询客户基本信息列表，耗时：[{}]", time);
        return iGenerator.convert(result, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getCustomerList(List<String> nameList) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CustomerDO> customerList = customerManager.getCustomerList(nameList);
        long time = timeConsumer.end();
        logger.info("按姓名搜索客户基本信息列表，耗时：[{}]", time);
        return iGenerator.convert(customerList, CustomerDTO.class);
    }
}
