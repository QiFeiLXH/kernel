package com.bsoft.customer.service;

import com.bsoft.common.result.Result;
import com.bsoft.customer.dto.CustomerDTO;
import com.bsoft.customer.dto.CustomerQueryCndDTO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/12/7
 * @description 客户基本信息
 */
public interface CustomerService {
    /**
     * 多条件查询
     * @param queryCndDTO 查询参数
     * @return
     */
    Result<CustomerDTO> getCustomerList(CustomerQueryCndDTO queryCndDTO);

    /**
     * 按姓名搜索
     * @param nameList
     * @return
     */
    List<CustomerDTO> getCustomerList(List<String> nameList);

}
