package com.bsoft.person.repository.primary;

import com.bsoft.person.condition.BusinessCardQueryCnd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 16:01
 * @Description
 */
@Mapper
@Repository
public interface BusinessCardRepository {
    Integer getBusinessCardUnpaidCount(@Param("cnd") BusinessCardQueryCnd cnd);

    List<Integer> getBusinessCardIdList(@Param("cnd") BusinessCardQueryCnd cnd);
}
