package com.bsoft.sales.repository.primary;

import com.bsoft.sales.condition.SalesContractCheckQueryCnd;
import com.bsoft.sales.condition.SalesContractQueryCnd;
import com.bsoft.sales.entity.primary.SalesContractAreaViewDO;
import com.bsoft.sales.entity.primary.SalesContractCheckViewDO;
import com.bsoft.sales.entity.primary.SalesContractModuleViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/12 12:20
 * @Description
 */
@Repository
@Mapper
public interface ContractModuleProductRepository {
    void updateAmountByContractId (@Param("contractId") String contractId);

    void updateModuleAmountByContractId(@Param("contractId") String contractId);

    List<SalesContractModuleViewDO> getSalesContractModuleList(@Param("cnd") SalesContractQueryCnd cnd);

    List<SalesContractAreaViewDO> getSalesContractAreaListWithAll();

    List<SalesContractAreaViewDO> getSalesContractAreaListWithPersonId(@Param("personId") String personId);

    List<SalesContractCheckViewDO> getSalesCheckContractListWithPersonId(@Param("cnd")SalesContractCheckQueryCnd cnd);

    List<SalesContractCheckViewDO> getSalesCheckContractListWithAll(@Param("cnd")SalesContractCheckQueryCnd cnd);

    Integer getUncheckedCountWithAll();
    Integer getUncheckedCountWithPersonId(@Param("personId")String personId);

    List<Integer> getSalesContractModuleCount(@Param("contractId")String contractId, @Param("inputContent")String inputContent, @Param("relationFlag")List<Integer> relationFlag);
}
