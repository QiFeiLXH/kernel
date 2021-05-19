package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.RequestLogMenuCountDO;
import com.bsoft.logs.entity.primary.RequestLogPathCountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Repository
public interface RequestLogPathCountDao extends JpaRepository<RequestLogPathCountDO, Integer>, JpaSpecificationExecutor<RequestLogPathCountDO> {
    RequestLogPathCountDO getByUrlAndCountDate(String url, Date countDate);
}
