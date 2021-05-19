package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.RequestLogMenuCountDO;
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
public interface RequestLogMenuCountDao extends JpaRepository<RequestLogMenuCountDO, Integer>, JpaSpecificationExecutor<RequestLogMenuCountDO> {
    RequestLogMenuCountDO getByMenuIdAndCountDate(Integer menuId, Date countDate);
}
