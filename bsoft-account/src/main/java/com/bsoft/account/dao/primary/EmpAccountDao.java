package com.bsoft.account.dao.primary;

import com.bsoft.account.entity.primary.EmpAccountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2020-04-24 15:07
 * @Version 1.0
 * @Description
 */
@Repository
public interface EmpAccountDao extends JpaRepository<EmpAccountDO,String>, JpaSpecificationExecutor<EmpAccountDO> {

}
