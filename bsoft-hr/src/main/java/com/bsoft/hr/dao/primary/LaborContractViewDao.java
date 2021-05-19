package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LaborContractViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/15
 * @description 劳动合同信息
 */
@Repository
public interface LaborContractViewDao extends JpaRepository<LaborContractViewDO, Integer>, JpaSpecificationExecutor<LaborContractViewDO> {
}
