package com.bsoft.account.dao.primary;

import com.bsoft.account.entity.primary.AccountFrozenInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2020-04-24 14:50
 * @Version 1.0
 * @Description
 */
@Repository
public interface AccountFrozenInfoDao extends JpaRepository<AccountFrozenInfoDO,Integer>, JpaSpecificationExecutor<AccountFrozenInfoDO> {

}
