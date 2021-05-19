package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.CustomerContactsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:31
 * @Description
 */
@Repository
public interface CustomerContactsDao extends JpaRepository<CustomerContactsDO,Integer>, JpaSpecificationExecutor<CustomerContactsDO> {
}
