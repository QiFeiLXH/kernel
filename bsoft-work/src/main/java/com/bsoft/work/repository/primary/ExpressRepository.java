package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.ExpressQueryCnd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 16:37
 * @Description
 */
@Mapper
@Repository
public interface ExpressRepository {
    Integer getExpressUnpaidCount(@Param("cnd") ExpressQueryCnd cnd);

    List<Integer> getExpressIdList(@Param("cnd") ExpressQueryCnd cnd);

    // 同步更新分摊表金额
    void syncUpdateCostAmount(@Param("lshIds")List<String> lshIds);

    void updateCostAmountByLshid(@Param("lshid")String lshid);
}
