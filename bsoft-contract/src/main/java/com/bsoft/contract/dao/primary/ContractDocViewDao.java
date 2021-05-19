package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractDocViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/9 17:40
 * @Description:
 */
@Repository
public interface ContractDocViewDao extends JpaRepository<ContractDocViewDO,String>, JpaSpecificationExecutor<ContractDocViewDO> {

    /**
     * 合同类型为合同，没有上传合同原件
     */
    @Query("select a from ContractDocViewDO a where a.htlx = 1 and a.wdid = 4 and a.wdsl <= 0 and (a.yjyw <> 2 or a.yjyw is null) and a.gdr is not null")
    List<ContractDocViewDO> findNoContractnoOrg();

    /**
     * 取得方式为招投标的，投标会签表里有无中标通知书，没有上传中标通知书
     */
    @Query("select a from ContractDocViewDO a where a.withnotice = 1 and a.zbbz in (1,4,5) and a.wdid = 2 and a.wdsl <= 0 and a.gdr is not null")
    List<ContractDocViewDO> findNoBidWin();

    /**
     * 合同类型：有合同，合同原件：有，没有上传合同原件
     * @return
     */
    @Query("select a from ContractDocViewDO a where a.htlx = 1 and (a.wdid = 4 or a.wdid = 43) and a.wdsl <= 0 and a.yjyw = 2 and a.shr is not null")
    List<ContractDocViewDO> findNoContractOrgAndYjyw();

}
