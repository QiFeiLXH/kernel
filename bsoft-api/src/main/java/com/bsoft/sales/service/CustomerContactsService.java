package com.bsoft.sales.service;

import com.bsoft.common.result.Result;
import com.bsoft.sales.dto.CustomerContactViewDTO;
import com.bsoft.sales.dto.CustomerContactsDTO;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:38
 * @Description 客户往来单位
 */
public interface CustomerContactsService {
    /** 客户往来单位列表
     * @Param: inputContent 查找条件
     * @Param: pageNo 页码
     * @Param: pageSize 每页条数
     * @return com.bsoft.common.result.Result<CustomerContactsDTO>
     * @author Xuhui Lin
     */
    Result<CustomerContactsDTO> getCustomerContactsList(Integer pageNo, Integer pageSize,String inputContent);

    /** 客户往来单位列表,携带客户收款单位信息
     * @Param: inputContent 查找条件
     * @Param: pageNo 页码
     * @Param: pageSize 每页条数
     * @return com.bsoft.common.result.Result<CustomerContactViewDTO>
     */
    Result<CustomerContactViewDTO> getCustomerContacts(Integer pageNo, Integer pageSize,String inputContent);
}
