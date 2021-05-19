package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PersonStockViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:02
 * @Description
 */
@Repository
public interface PersonStockViewDao extends JpaRepository<PersonStockViewDO, String>, JpaSpecificationExecutor<PersonStockViewDO> {
}
