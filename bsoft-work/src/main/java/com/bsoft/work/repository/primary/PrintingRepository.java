package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.PrintingQueryCnd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:31
 * @Description
 */
@Mapper
@Repository
public interface PrintingRepository {
    Integer getPrintingUnpaidCount(@Param("cnd") PrintingQueryCnd cnd);

    List<Integer> getPrintingIdList(@Param("cnd") PrintingQueryCnd cnd);

    // 同步更新分摊表金额
    void syncUpdateCostAmount(@Param("lshIds")List<String> lshIds);

    void updateCostAmountByLshid(@Param("lshid")String lshid);
}
