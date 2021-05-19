package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyReadStatusDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 16:31
 */
@Mapper
@Repository
public interface PolicyReadStatusRepository {

    List<PolicyReadStatusDO> selectByQueryCnd(@Param("queryCnd") PolicyQueryCnd policyQueryCnd);
}
