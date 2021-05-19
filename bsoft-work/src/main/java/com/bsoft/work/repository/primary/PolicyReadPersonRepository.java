package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyReadPersonDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 16:27
 */
@Mapper
@Repository
public interface PolicyReadPersonRepository {


    List<PolicyReadPersonDO> selectByQueryCnd(@Param("queryCnd") PolicyQueryCnd policyQueryCnd);

    Integer countPersonalNoRead(@Param("personId") String personId);

}
