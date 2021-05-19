package com.bsoft.sales.repository.primary;

import com.bsoft.sales.condition.OwnPurchaseContractQueryCnd;
import com.bsoft.sales.entity.primary.OwnPurchaseContractViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/20 10:51
 * @Description
 */
@Mapper
@Repository
public interface PurchaseContractRepository {
    Integer getOwnUnfinishedCountByYearAndContent(@Param("signYear")String signYear, @Param("inputContent")String inputContent, @Param("personId")String personId);

    Integer getOwnUnreviewedCountByYearAndContent(@Param("signYear")String signYear, @Param("inputContent")String inputContent);

    List<OwnPurchaseContractViewDO> getOwnPurchaseContractList(@Param("cnd")OwnPurchaseContractQueryCnd cnd);

    Integer getContractNumberBySimilarContractNo(@Param("purchaseContractNo")String purchaseContractNo);

    List<OwnPurchaseContractViewDO> getOwnPurchaseContractWithProgressList(@Param("cnd")OwnPurchaseContractQueryCnd cnd);
}
