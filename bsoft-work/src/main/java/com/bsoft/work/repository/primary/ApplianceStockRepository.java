package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.ApplianceQueryCnd;
import com.bsoft.work.entity.primary.ApplianceStockDO;
import com.bsoft.work.entity.primary.ApplianceStoreDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/6
 * @description
 */
@Mapper
@Repository
public interface ApplianceStockRepository {
    List<ApplianceStockDO> findByQueryCnd(@Param("queryCnd") ApplianceQueryCnd queryCnd);
    Double countUnPayMoney(@Param("type") Integer type);
    List<ApplianceStoreDO> countStore();
}
