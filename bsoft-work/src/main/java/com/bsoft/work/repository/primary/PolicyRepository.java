package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/10 16:04
 */
@Repository
@Mapper
public interface PolicyRepository  {
    /**
     * 按照入参进行查询
     * @return
     */
    List<PolicyDO> findByQueryCnd(@Param("queryCnd") PolicyQueryCnd queryCnd);


    /**
     *
     * @param policyQueryCnd
     * @return
     */
    List<PolicyDO> selectReadByQueryCnd(@Param("queryCnd") PolicyQueryCnd policyQueryCnd);
}
