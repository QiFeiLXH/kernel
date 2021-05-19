package com.bsoft.customer.manager;

import com.bsoft.common.result.Result;
import com.bsoft.customer.condition.CustomerQueryCnd;
import com.bsoft.customer.dto.CustomerDTO;
import com.bsoft.customer.entity.primary.CustomerDO;

import java.util.List;

/**
 * 客户基本信息
 */
public interface CustomerManager {
    /**
     * 按id搜索
     * @param id
     * @return
     */
    CustomerDO getCustomer(String id);

    /**
     * 按姓名搜索
     * @param nameList
     * @return
     */
    List<CustomerDO> getCustomerList(List<String> nameList);

    /**
     * 多条件查询
     * @param queryCnd 查询参数
     * @return
     */
    Result<CustomerDO> getCustomerList(CustomerQueryCnd queryCnd);

}
