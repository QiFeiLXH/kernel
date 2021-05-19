package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.ApplianceQueryCnd;
import com.bsoft.work.entity.primary.ApplianceUseDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.ws.rs.PATCH;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/6
 * @description
 */
@Mapper
@Repository
public interface ApplianceUseRepository {
    List<ApplianceUseDO> listByLimits(@Param("queryCnd") ApplianceQueryCnd queryCnd);
}
