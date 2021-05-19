package com.bsoft.cost.repository.primary;

import com.bsoft.cost.entity.primary.FinanceCostViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FinanceCostRepository {
    List<FinanceCostViewDO> getFinanceCostViewList(@Param("data") Map<String, Object> data);
}
