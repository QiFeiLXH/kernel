package com.bsoft.sales.repository.primary;

import com.bsoft.sales.condition.SalesCommisQueryCnd;
import com.bsoft.sales.entity.primary.SalesCommisViewDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 14:02
 * @Description:
 */
@Mapper
@Repository
public interface SalesCommisRepository {
    List<SalesCommisViewDO> getSalesCommis(@Param("cnd") SalesCommisQueryCnd cnd);
}
