package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.OperLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 10:32
 * @Description:
 */
@Repository
public interface OperLogDao extends JpaRepository<OperLogDO,Integer>, JpaSpecificationExecutor<OperLogDO> {
}
