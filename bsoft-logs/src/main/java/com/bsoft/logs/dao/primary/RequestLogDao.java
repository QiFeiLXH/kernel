package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.RequestLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */

@Repository
public interface RequestLogDao extends JpaRepository<RequestLogDO, Integer>, JpaSpecificationExecutor<RequestLogDO> {
}
