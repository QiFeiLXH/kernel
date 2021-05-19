package com.bsoft.sales.manager;

import com.bsoft.sales.entity.primary.CustomerContactViewDO;
import com.bsoft.sales.entity.primary.CustomerContactsDO;
import org.springframework.data.domain.Page;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:32
 * @Description
 */
public interface CusotmerContactsManager {
    Page<CustomerContactsDO> getCustomerContactsList(Integer pageNo, Integer pageSize, String inputContent);
    Page<CustomerContactViewDO> getCustomerContacts(Integer pageNo, Integer pageSize, String inputContent);
}
