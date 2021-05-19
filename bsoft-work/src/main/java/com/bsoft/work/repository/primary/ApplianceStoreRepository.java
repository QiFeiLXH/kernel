package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.ApplianceQueryCnd;
import com.bsoft.work.entity.primary.ApplianceStoreDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/17
 * @description
 */
@Mapper
@Repository
public interface ApplianceStoreRepository {
    List<ApplianceStoreDO> findByCondition(@Param("cnd") ApplianceQueryCnd queryCnd);
}
